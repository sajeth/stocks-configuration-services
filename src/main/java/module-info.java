module stocks.configuration.services {
    // requires transitive stocks.entities;
    requires transitive stocks.commons;
    requires spring.context;
    requires spring.web;
    requires spring.beans;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.tx;
    requires spring.data.jpa;
    requires spring.core;
    requires java.sql;
    requires com.zaxxer.hikari;
    // requires springfox.swagger2;
    requires spring.orm;
    requires java.persistence;
    opens com.saji.configuration.entities to org.hibernate.orm.core, spring.core;
    exports com.saji.configuration.entities to org.hibernate.orm.core;
    opens com.saji.configuration to spring.core, spring.context;
    exports com.saji.configuration to spring.beans;
    opens com.saji.configuration.config to spring.core;
    exports com.saji.configuration.config to spring.beans, spring.context;
    opens com.saji.configuration.services to spring.core;
    exports com.saji.configuration.services to spring.beans, spring.context;
    opens com.saji.configuration.controller to spring.core;
    exports com.saji.configuration.controller to spring.beans, spring.context;
}