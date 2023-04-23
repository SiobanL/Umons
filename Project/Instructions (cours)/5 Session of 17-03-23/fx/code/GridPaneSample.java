package esi.atl.fx.layout;

//import ...

public class GridPaneSample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("My First JavaFX App");
        GridPane root = new GridPane();
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(5);

        Label lblTitle = new Label("JavaFX Course Login");
        lblTitle.setFont(Font.font("System", FontWeight.BOLD, 20));
        lblTitle.setTextFill(Color.RED);
        root.add(lblTitle, 0, 0, 2, 1);
        GridPane.setHalignment(lblTitle, HPos.CENTER);
        GridPane.setMargin(lblTitle, new Insets(0, 0, 10, 0));

        Label lblUserName = new Label("User Name or email");
        GridPane.setHalignment(lblUserName, HPos.RIGHT);
        root.add(lblUserName, 0, 1);

        TextField tfdUserName = new TextField();
        tfdUserName.setPrefColumnCount(20);
        root.add(tfdUserName, 1, 1);

        Label lblPassword = new Label("Password");
        root.add(lblPassword, 0, 2);

        TextField tfdPassword = new TextField();
        tfdPassword.setPrefColumnCount(12);
        root.add(tfdPassword, 1, 2);

        GridPane.setHalignment(lblPassword, HPos.RIGHT);
        GridPane.setFillWidth(tfdPassword, false);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
