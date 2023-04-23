public class Led extends Region {
    private static final double   BORDER_RSIZE = 0.02;
    private double size;
	...
    public Led() {
		...
        addListeners();
    }
    private void addListeners() {
        widthProperty().addListener(o -> resizeCanvas());
        heightProperty().addListener(o -> resizeCanvas());
    }
    public final void setOn(boolean on) {
        this.on.set(on);
        repaint();
    }
	...
    public final void setColor(Color color) {
        this.color.set(color);
        repaint();
    }
	...
    private void resizeCanvas() {
        double width = getWidth();
        double height = getHeight();

        // resizing the canvas to the biggest possible square in the parent (region)
        size = width < height ? width : height;
        canvas.setWidth(size);
        canvas.setHeight(size);

        // centering the canvas in the parent (region)
        if (width > height) {
            canvas.relocate((width - size)*0.5, 0);
        } else if (height > width) {
            canvas.relocate(0, (height - size)*0.5);
        }
        repaint();
    }
    private void repaint() {
        double ulc = BORDER_RSIZE * size;       	// canvas's upper left corner
        double brc = (1-2*BORDER_RSIZE) * size; 	// canvas's bottom right corner
        
        context.clearRect(0, 0, size, size);        // clean the canvas        
        context.strokeOval(ulc, ulc, brc, brc);     // draw the led's border

        if (isOn()) {       // fill the led with the color property value if is is on
            context.setFill(color.get());    
            context.fillOval(ulc, ulc, brc, brc);
        }
    }
}