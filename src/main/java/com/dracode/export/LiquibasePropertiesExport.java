package com.dracode.export;

import com.dracode.data.DatabaseData;
import com.dracode.data.DbEngine;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * Created by rafalex on 22/04/17.
 */
public class LiquibasePropertiesExport {

    Properties prop = new Properties();

    public void export(DatabaseData databaseData, Integer indx) throws IOException {
        prop.load(new FileInputStream(this.getClass().getClassLoader().getResource("config.properties").getFile()));

        LiquibaseProperties liquibaseProperties = new LiquibaseProperties();

        PrintWriter writer = new PrintWriter("liquibase.properties." + indx + ".txt", "UTF-8");

        liquibaseProperties.setDriver(getDriver(databaseData.getEngine()));
        liquibaseProperties.setClasspath(getClasspath(databaseData.getEngine()));
        liquibaseProperties.setUrl(getCompleteUrl(databaseData));
        liquibaseProperties.setUsername(databaseData.getDbUser());
        liquibaseProperties.setPassword(databaseData.getDbPass());
        liquibaseProperties.setChangeLogFile("some");
        liquibaseProperties.setLogLevel("finest");

        writer.write(liquibaseProperties.toString());
        writer.close();
    }

    private String getDriver(DbEngine dbEngine){
        if (dbEngine.equals(DbEngine.MySql))
            return "com.mysql.jdbc.Driver";
        else if (dbEngine.equals(DbEngine.MsSql))
            return "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        else if (dbEngine.equals(DbEngine.PostgreSql))
            return "org.postgresql.Driver";
        else if (dbEngine.equals(DbEngine.Oracle))
            return "oracle.jdbc.driver.OracleDriver";
        else
            return "Not defined";
    }

    private String getClasspath(DbEngine dbEngine){
        if (dbEngine.equals(DbEngine.MySql))
            return "lib/mysql-connector-java-6.0.6.jar";
        else if (dbEngine.equals(DbEngine.MsSql))
            return "lib/mssql-jdbc-6.1.0.jre8.jar";
        else if (dbEngine.equals(DbEngine.PostgreSql))
            return "lib/postgresql-42.0.0.jar";
        else if (dbEngine.equals(DbEngine.Oracle))
            return "Not defined";
        else
            return "Not defined";
    }

    private String getCompleteUrl(DatabaseData databaseData){
        String baseUrl = prop.getProperty(databaseData.getEngine().toString() + "Jdbc");
        String finalUrl = null;

        finalUrl = baseUrl.replaceAll("<host>", databaseData.getDbServer());
        finalUrl = finalUrl.replaceAll("<port>", databaseData.getDbPort());
        finalUrl = finalUrl.replaceAll("<db>", databaseData.getDbName());
        finalUrl = finalUrl.replaceAll("<user>", databaseData.getDbUser());
        finalUrl = finalUrl.replaceAll("<password>", databaseData.getDbPass());

        return finalUrl;
    }
}
