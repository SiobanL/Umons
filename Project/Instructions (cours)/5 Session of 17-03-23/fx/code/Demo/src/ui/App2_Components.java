/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author serra
 */
public class App2_Components extends Application
{
    @Override
    public void start(Stage stage)
    {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25)); //top, right, bottom, left

        Scene scene = new Scene(grid, 300, 275);
        stage.setScene(scene);
        
        Text title = new Text("Welcome");
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(title, 0, 0, 2, 1);//pos : (0,0), on two cols and one row

        Label userName = new Label("Login:");
        grid.add(userName, 0, 1);//pos (0,1)

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);//pos (1,1)

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);//pos (0,2)

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);//pos (1,2)
        
        Button btn = new Button("Sign in");
        HBox box = new HBox(10);
        box.setAlignment(Pos.BOTTOM_RIGHT);
        box.getChildren().add(btn);                
        grid.add(box, 1, 4);
        
        stage.show();
    }
}
