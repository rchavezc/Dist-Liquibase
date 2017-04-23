package com.dracode.export;

/**
 * Created by rafalex on 22/04/17.
 */
public class LiquibaseProperties {
    private String driver;
    private String classpath;
    private String url;
    private String username;
    private String password;
    private String changeLogFile;
    private String logLevel;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getClasspath() {
        return classpath;
    }

    public void setClasspath(String classpath) {
        this.classpath = classpath;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getChangeLogFile() {
        return changeLogFile;
    }

    public void setChangeLogFile(String changeLogFile) {
        this.changeLogFile = changeLogFile;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    @Override
    public String toString() {
        return  "driver: " + driver + '\n' +
                "classpath: " + classpath + '\n' +
                "url: " + url + '\n' +
                "username: " + username + '\n' +
                "password: " + password + '\n' +
                "changeLogFile: " + changeLogFile + '\n' +
                "logLevel: " + logLevel;
    }
}
