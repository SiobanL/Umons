        //--- Button Events Handling
        btnInsert.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                txaMsg.appendText(tfdCharacter.getText());
            }
        });
