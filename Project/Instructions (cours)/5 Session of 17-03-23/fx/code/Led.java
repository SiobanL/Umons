import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

public class Led extends Region {

    private static final double   BORDER_RSIZE = 0.02;

    private final BooleanProperty on;
    private final ObjectProperty<Color> color;

    private final Canvas canvas;
    private final GraphicsContext context;

    public Led() {
        on = new SimpleBooleanProperty(this, "On property", true);
        color = new ObjectPropertyBase<Color>(Color.RED) {

            @Override
            public Object getBean() {
                return this;
            }

            @Override
            public String getName() {
                return "Color property";
            }
        };
        canvas = new Canvas();
        context = canvas.getGraphicsContext2D();
        context.setStroke(Color.BLACK);
        getChildren().add(canvas);

        widthProperty().addListener(o -> repaint());
        heightProperty().addListener(o -> repaint());
    }

    public final void setOn(boolean aon) {
        on.set(aon);
        repaint();
    }

    public final boolean isOn() {
        return on.get();
    }

    public final BooleanProperty onProperty() {
        return on;
    }

    public final Color getColor() {
        return color.get();
    }

    public final void setColor(Color c) {
        color.set(c);
        repaint();
    }

    public final ObjectProperty<Color> colorProperty() {
        return color;
    }

    private double resizeCanvas() {
        double width = getWidth();
        double height = getHeight();

        double size = width < height ? width : height;

        canvas.setWidth(size);
        canvas.setHeight(size);
        if (width > height) {
            canvas.relocate((width - size)*0.5, 0);
        } else if (height > width) {
            canvas.relocate(0, (height - size)*0.5);
        }
        return size;
    }

    private void repaint() {
        double size = resizeCanvas();
        double ulc = BORDER_RSIZE * size;
        double brc = (1-2*BORDER_RSIZE) * size;
 
        context.clearRect(0, 0, size, size);
        context.strokeOval(ulc, ulc, brc, brc);

        if (isOn()) {
            context.setFill(color.get());
            context.fillOval(ulc, ulc, brc, brc);
        }
    }
}
