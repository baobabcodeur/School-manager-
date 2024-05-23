module com.app.school_manager {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;

    opens com.app.school_manager to javafx.fxml;
    exports com.app.school_manager;

    opens com.app.school_manager.models to java.base;
    exports  com.app.school_manager.models;


    opens com.app.school_manager.controllers to javafx.fxml;
    exports com.app.school_manager.controllers;

}
