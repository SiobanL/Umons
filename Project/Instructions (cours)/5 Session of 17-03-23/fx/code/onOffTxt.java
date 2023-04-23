        final Label onOffTxt = new Label();
        led.onProperty().addListener(
                (ObservableValue<? extends Boolean> observable,
                        Boolean oldValue, Boolean newValue) -> {
                    onOffTxt.setText("avant clic : " + oldValue + ", après : " + newValue);
                });
        box.getChildren().add(onOffTxt);
