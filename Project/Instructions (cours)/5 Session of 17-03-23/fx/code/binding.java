    private void doBindings() {
        circle.centerXProperty().bind(widthProperty().divide(2));
        circle.centerYProperty().bind(heightProperty().divide(2));
        circle.radiusProperty().bind(
                Bindings.subtract(Bindings.min(widthProperty().divide(2),                
                                               heightProperty().divide(2)),
                                  10));        
    }
