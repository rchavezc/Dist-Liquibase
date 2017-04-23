package com.dracode.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by PekosoG on 02-Jan-17.
 *
 * Class that represent the basic DB Data required to perform a connection on XML files
 *
 * Modified by rafalex on 22-Apr-17
 *
 * Pascal case notation used for elements and camel case for attributes
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DatabaseData {

    private String
                DbName,
                DbServer,
                DbUser,
                DbPass;

    private DbEngine Engine;

    public String getDbName() {
        return DbName;
    }

    @XmlElement(name = "DbName")
    public void setDbName(String dbName) {
        DbName = dbName;
    }

    public String getDbServer() {
        return DbServer;
    }

    @XmlElement(name = "DbServer")
    public void setDbServer(String dbServer) {
        DbServer = dbServer;
    }

    public String getDbUser() {
        return DbUser;
    }

    @XmlElement(name = "DbUser")
    public void setDbUser(String dbUser) {
        DbUser = dbUser;
    }

    public String getDbPass() {
        return DbPass;
    }

    @XmlElement(name = "DbPass")
    public void setDbPass(String dbPass) {
        DbPass = dbPass;
    }

    public DbEngine getEngine() {
        return Engine;
    }

    @XmlElement(name = "Engine")
    public void setEngine(DbEngine engine) {
        this.Engine = engine;
    }

    @Override
    public String toString() {
        return "DatabaseDataJAXB{" +
                "DbName='" + DbName + '\'' +
                ", DbServer='" + DbServer + '\'' +
                ", DbUser='" + DbUser + '\'' +
                ", DbPass='" + DbPass + '\'' +
                ", engine=" + Engine +
                '}';
    }
}
