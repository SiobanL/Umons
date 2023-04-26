package project.main.Exo1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("./Exo1/form.fxml"));
        //Scene scene = new Scene(fxmlLoader.load());
        Group root = new Group();
        Scene scene = new Scene(root);
        Image icon = new Image("project/main/logo.jpg");
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("Pac Man");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
