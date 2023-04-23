
package ui;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author serra
 */
public class App4_Handler_Detail extends Application
{
    @Override
    public void start(Stage stage)
    {
        BorderPane root = new BorderPane();
        
        stage.setTitle("Event Handling");
        root.setPadding(new Insets(10));
        
        //Title
        Label title = new Label();
        title .setFont(Font.font("System", FontWeight.BOLD, 20));
        title . setTextFill (Color.DARKGREEN);
        BorderPane.setAlignment(title, Pos.CENTER);
        BorderPane.setMargin(title, new Insets(0, 0, 10, 0));
        root.setTop(title );
        
        //Text−Area
        TextArea area = new TextArea();
        area.setWrapText(true);
        area.setPrefColumnCount(15);
        area.setPrefRowCount(10);
        root.setCenter(area);
        
        //Button Panel
        HBox hBox = new HBox();
        Button insert = new Button("Insert");
        insert.setDisable(true);
        
        TextField txt = new TextField();
        txt.setText("");
        
        Button quit = new Button("Quit");
        hBox.getChildren().add(insert);
        hBox.getChildren().add(txt);
        hBox.getChildren().add(quit);
        hBox.setAlignment(Pos.CENTER_RIGHT);
        hBox.setPadding(new Insets(10, 0, 0, 0));
        root.setBottom(hBox);
                
        //disables insert button when text is empty
        insert.disableProperty().bind(Bindings.isEmpty(txt.textProperty()));
        
        //insert handler
        insert.setOnAction((ActionEvent event) -> 
        {
            area.appendText(txt.getText() + "\n");
            txt.setText("");
        });
        
        txt.addEventFilter(KeyEvent.KEY_TYPED, (KeyEvent event) -> 
        {
            event.consume();
        });
        
        //Stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        //prints event chains
        stage.addEventFilter(MouseEvent.MOUSE_CLICKED, new GraphDisplayHandler("Stage filter"));
        stage.addEventHandler(MouseEvent.MOUSE_CLICKED, new GraphDisplayHandler("Stage handler"));
        scene.addEventFilter(MouseEvent.MOUSE_CLICKED, new GraphDisplayHandler("Scene filter"));
        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, new GraphDisplayHandler("Scene handler"));
        root.addEventFilter(MouseEvent.MOUSE_CLICKED, new GraphDisplayHandler("BorderPane filter"));
        root.addEventHandler(MouseEvent.MOUSE_CLICKED, new GraphDisplayHandler("BorderPane handler"));
        insert.addEventFilter(MouseEvent.MOUSE_CLICKED, new GraphDisplayHandler("Insert filter"));
        insert.addEventHandler(MouseEvent.MOUSE_CLICKED, new GraphDisplayHandler("Insert handler"));
        hBox.addEventFilter(MouseEvent.MOUSE_CLICKED, new GraphDisplayHandler("hBox filter"));
        hBox.addEventHandler(MouseEvent.MOUSE_CLICKED, new GraphDisplayHandler("hBox handler"));
        
        stage.show();
    }

    class GraphDisplayHandler implements EventHandler<MouseEvent>
    {
        private String txt;
        
        public GraphDisplayHandler(String component)
        {
            this.txt = component;
        }
        
        @Override
        public void handle(MouseEvent event) 
        {
            System.out.println(txt);
        }
        
    }
}
