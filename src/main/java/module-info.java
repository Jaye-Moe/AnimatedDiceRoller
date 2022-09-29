module com.example.diceroller {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.diceroller to javafx.fxml;
    exports com.diceroller;
}