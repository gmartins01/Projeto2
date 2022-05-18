module org.example.fx {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.example.bd;
    requires java.persistence;

    exports org.example.fx;

    opens org.example.fx to javafx.fxml;
}