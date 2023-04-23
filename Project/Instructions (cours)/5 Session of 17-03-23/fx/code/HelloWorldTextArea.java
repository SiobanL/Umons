package esi.atl.fx.hello;

//import ...

public class HelloWorldTextArea
        extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("My First JavaFX App");
        BorderPane root = new BorderPane();

        TextArea txaUserName = new TextArea();
        txaUserName.setPrefColumnCount(12);
        txaUserName.setPrefRowCount(5);
        txaUserName.setWrapText(true);

        Button btnPrint = new Button("Print");
        btnPrint.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println(txaUserName.getText());
            }
        });

        //Alignment
        root.setTop(txaUserName);
        BorderPane.setAlignment(txaUserName, Pos.CENTER);
        root.setCenter(btnPrint);

        Scene scene = new Scene(root, 250, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
