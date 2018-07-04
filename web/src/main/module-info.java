module kotlinddd.web {
    exports kotlinddd.web.controllers;

    opens kotlinddd.web to spring.core, spring.beans, spring.context;

    //requires kotlinddd.application;
    requires kotlin.stdlib;
    requires spring.core;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.web;
    requires java.sql;
}