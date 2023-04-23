        //--- Button Events Handling
        btnInsert.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                txaMsg.appendText(tfdCharacter.getText());
            }
        });
