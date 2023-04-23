// ajout de circle.fillProperty().bind(new FillShapeBinding(color, on)); dans doBindings()

public class FillShapeBinding extends ObjectBinding<Color> {

    private final ObjectProperty<Color> color;
    private final BooleanProperty on;

    public FillShapeBinding(final ObjectProperty<Color> color, final BooleanProperty on) {
        super();
        this.color = color;
        this.on = on;
        bind(color, on);
    }

    @Override
    protected Color computeValue() {
        return on.get()?color.get():Color.TRANSPARENT;
    }

}
	