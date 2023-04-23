public class InsertButtonHandler
        implements EventHandler<ActionEvent> {

    private final TextArea tArea;
    private final TextField tfdText;
    //--- Constructeur ---------------------------------
    public InsertButtonHandler(TextArea tArea, TextField tfdText) {
        this.tArea = tArea;
        this.tfdText = tfdText;
    }
    
    //--- Code exécuté lorsque l'événement survient ----
    @Override
    public void handle(ActionEvent event) {
        tArea.appendText(tfdText.getText());
    }
}
