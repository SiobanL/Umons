package esi.atl.fx.layout;

//import ...

public class HBoxSample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("My First JavaFX App");
        HBox root = new HBox(10);
        root.setAlignment(Pos.CENTER);
        
        CheckBox checkBox1 = new CheckBox();
        checkBox1.setText("First");
        checkBox1.setSelected(true);
        
        CheckBox checkBox2 = new CheckBox("Second");
        checkBox2.setIndeterminate(true);
        
        CheckBox checkBox3 = new CheckBox("Third");

        checkBox3.setAllowIndeterminate(true);
        
        root.getChildren().add(checkBox1);
        root.getChildren().add(checkBox2);
        root.getChildren().add(checkBox3);
        
        Scene scene = new Scene(root, 250, 100);
        primaryStage.setScene(scene);
        primaryStage.show();        
    }

}
