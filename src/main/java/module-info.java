module com.learnkorealanguage.app {
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
    requires org.kordamp.ikonli.fontawesome6;
    requires java.net.http;
    requires jdk.jfr;
    requires jakarta.persistence;
    requires static lombok;
    requires org.hibernate.orm.core;
    requires java.naming;

    opens com.learnkorealanguage.app to javafx.fxml;
    opens com.learnkorealanguage.app.view to javafx.fxml;
    opens com.learnkorealanguage.app.model to org.hibernate.orm.core;
    exports com.learnkorealanguage.app;
}