open module org.example.bd {
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.sql;
    requires java.xml.bind;

    exports proj2.bd.entity;
    exports proj2.bd.BLL;
}