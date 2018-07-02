module kotlinddd.web {
    exports kotlinddd.web.controllers;

    opens kotlinddd.web to spring.core, spring.beans, spring.context;

    requires spring.core;
    requires kotlin.stdlib;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.web;
    requires java.sql;
}