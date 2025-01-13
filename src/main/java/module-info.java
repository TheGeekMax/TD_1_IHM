module ensisa.birds {
    requires transitive javafx.controls;
    requires javafx.fxml;

    requires com.fasterxml.jackson.databind;
    requires jdk.compiler;
    requires java.sql.rowset;

    opens ensisa.birds to javafx.fxml, com.fasterxml.jackson.databind;
    exports ensisa.birds;
    exports ensisa.birds.model;
}