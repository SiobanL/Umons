package esi.atl.fx.hello;
//import ...
public class HelloWorldTextField extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("My First JavaFX App");
        BorderPane root = new BorderPane();

        Label userName = new Label("User Name");
        
        TextField tfdUserName = new TextField();
        tfdUserName.setPrefColumnCount(12);
        tfdUserName.setAlignment(Pos.CENTER_LEFT);
        
        //Alignment
        root.setTop(userName);
        BorderPane.setAlignment(userName, Pos.CENTER);
        root.setCenter(tfdUserName);
        
        Scene scene = new Scene(root, 250, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}