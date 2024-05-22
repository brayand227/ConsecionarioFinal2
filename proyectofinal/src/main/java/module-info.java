module co.uniquindio.co {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.uniquindio.co to javafx.fxml;
    exports co.uniquindio.co;
}
