package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author serra
 */
public class App1_Hello extends Application
{
    @Override
    public void start(Stage stage)
    {                
        stage.setTitle("Application title");
        
        BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane, 250, 100);
        stage.setScene(scene);
        
        
        Text txt = new Text("Hello world !");
        pane.setCenter(txt);
        
        stage.initStyle(StageStyle.DECORATED); //default
        //stage.initStyle(StageStyle.TRANSPARENT);
        //stage.initStyle(StageStyle.UNDECORATED);
        //stage.initStyle(StageStyle.UNIFIED);
        //stage.initStyle(StageStyle.UTILITY);
        
        stage.show();
    }
    
    @Override
    public void init()
    {
        System.out.println("Starting application");
    }
    
    @Override
    public void stop()
    {
        System.out.println("Closing application");
    }
}
