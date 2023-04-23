public class Led extends Parent {
    private final BooleanProperty on;
    private final ObjectProperty<Color> color;           
    private final Circle circle;

    public Led() {
	on = new SimpleBooleanProperty(true);
	color = new ObjectPropertyBase<Color>() {
                @Override
                public Object getBean() {
                    return this;
                }
                @Override
                public String getName() {
                    return "Color";
                }
            };
        circle = new Circle(50);
        circle.setStroke(Color.BLACK);
        getChildren().add(circle);
        setColor(Color.RED);
    }
    public final void setOn(boolean on) {
        this.on.set(on);
        circle.setFill(on?color.get():Color.TRANSPARENT);
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
    public final void setColor(Color color) {
        this.color.set(color);
        circle.setFill(isOn()?getColor():Color.TRANSPARENT);
    }
    public final ObjectProperty<Color> colorProperty() {
        return color;
    }
}
