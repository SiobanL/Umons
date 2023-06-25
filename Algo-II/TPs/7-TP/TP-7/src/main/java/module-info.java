module project.main {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens project.main to javafx.fxml;
    exports project.main;
    exports project.main.Exo1;
    opens project.main.Exo1 to javafx.fxml;
}