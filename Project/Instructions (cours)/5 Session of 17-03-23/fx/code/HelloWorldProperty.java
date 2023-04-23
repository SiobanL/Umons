package esi.atl.fx.hello;

//import ...

public class HelloWorldProperty
        extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("My First JavaFX App");
        BorderPane root = new BorderPane();
        Label helloText = new Label("Hello World");
        helloText.setTextFill(Color.RED);
        helloText.setFont(Font.font("Verdana", 20));
        
        System.out.println("Le message du Libellé est " + helloText.getText());
        System.out.println("La police du Libellé est " + helloText.getFont());
        System.out.println("La couleur du Libellé est " + helloText.getTextFill());
        
        root.setCenter(helloText);
        Scene scene = new Scene(root, 250, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
