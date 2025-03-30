module backend.es.materancode.gestion.salon {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires javafx.graphics;
    requires java.xml;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires java.sql;

    opens backend.es.materancode.gestion.salon to javafx.fxml;
    exports backend.es.materancode.gestion.salon;
    exports backend.es.materancode.gestion.salon.controller;
    exports backend.es.materancode.gestion.salon.model;
    opens backend.es.materancode.gestion.salon.controller to javafx.fxml;
}
