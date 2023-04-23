package esi.atl.fx.layout;

//import ...

import static javafx.application.Application.launch;


public class FlowPaneSample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("My First JavaFX App");
        FlowPane root = new FlowPane();
        root.setAlignment(Pos.CENTER_LEFT);
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(5);
        
        List <Label> node = new ArrayList<>() ;
        for (int i = 0; i < 10; i++) {
            node.add(new Label("Label Num "+i));
        }
        
        root.getChildren().addAll(node);
        
        Scene scene = new Scene(root, 250, 100);
        primaryStage.setScene(scene);
        primaryStage.show();        
    }

}
