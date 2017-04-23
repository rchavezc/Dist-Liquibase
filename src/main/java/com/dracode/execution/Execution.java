package com.dracode.execution;

import com.dracode.data.DatabaseData;
import com.dracode.data.DatabaseDataJAXBS;
import com.dracode.data.DbEngine;
import com.dracode.export.LiquibasePropertiesExport;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafalex on 22/04/17.
 */
public class Execution {

    private List<DatabaseData> databaseData;
    private DatabaseDataJAXBS databaseDataJAXBS;

    public void executeXML(String xmlFile) throws IOException {

        LiquibasePropertiesExport liquibasePropertiesExport = new LiquibasePropertiesExport();
        Integer indx = 0;

        fillDatabaseDataJAXB(xmlFile);
        for (DatabaseData dbd : databaseDataJAXBS.getDatabaseData()){
            liquibasePropertiesExport.export(dbd, indx++);
        }
    }

    public void executeCSV(String csvFile) throws IOException {
        LiquibasePropertiesExport liquibasePropertiesExport = new LiquibasePropertiesExport();
        List<String[]> lines = readCSV(csvFile);
        Integer indx = 0;

        fillDatabaseData(lines);
        for (DatabaseData dbd : databaseData){
            liquibasePropertiesExport.export(dbd, indx++);
        }
    }

    private List<String[]> readCSV (String path) {
        BufferedReader br = null;
        String line = "";
        List<String[]> list = new ArrayList<String[]>();

        try {
            br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null) {
                String[] lineSplit = line.split(",");
                list.add(lineSplit);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return list;
    }

    private void fillDatabaseData(List<String[]> lines){

        databaseData = new ArrayList<DatabaseData>();

        for (String[] line : lines) {
            DatabaseData dbd = new DatabaseData();
            dbd.setDbName(line[0]);
            dbd.setDbServer(line[1]);
            dbd.setDbPort(line[2]);
            dbd.setDbUser(line[3]);
            dbd.setDbPass(line[4]);
            dbd.setEngine(DbEngine.valueOf(line[5]));
            databaseData.add(dbd);
        }
    }

    private void fillDatabaseDataJAXB(String xmlFile){
        try {

            File file = new File(xmlFile);
            JAXBContext jaxbContext = JAXBContext.newInstance(DatabaseDataJAXBS.class);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            databaseDataJAXBS = (DatabaseDataJAXBS) unmarshaller.unmarshal(file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
