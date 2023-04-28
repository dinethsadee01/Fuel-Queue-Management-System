module com.example.task4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.classVersion to javafx.fxml;
    exports com.example.classVersion;
}