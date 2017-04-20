package com.dracode.data;

/**
 * Created by PekosoG on 02-Jan-17.
 *
 * Class that represent the basic DB Data required to perform a connection
 */
public class DatabaseData {

    private String
                db_name,
                db_server,
                db_user,
                db_pass;

    private DbEngine engine;

    public String getDb_name() {
        return db_name;
    }

    public void setDb_name(String db_name) {
        this.db_name = db_name;
    }

    public String getDb_server() {
        return db_server;
    }

    public void setDb_server(String db_server) {
        this.db_server = db_server;
    }

    public String getDb_user() {
        return db_user;
    }

    public void setDb_user(String db_user) {
        this.db_user = db_user;
    }

    public String getDb_pass() {
        return db_pass;
    }

    public void setDb_pass(String db_pass) {
        this.db_pass = db_pass;
    }

    public DbEngine getEngine() {
        return engine;
    }

    public void setEngine(DbEngine engine) {
        this.engine = engine;
    }
}
