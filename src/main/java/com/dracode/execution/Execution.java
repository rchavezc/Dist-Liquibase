package com.dracode.execution;

import com.dracode.data.DatabaseData;
import com.dracode.data.DatabaseDataJAXBS;
import com.dracode.data.DbEngine;

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

    public void executeXML(String xmlFile){
        fillDatabaseDataJAXB(xmlFile);
        //for (DatabaseDataJAXB databaseDataJAXB : databaseDataJAXBS){
            System.out.println(databaseDataJAXBS.toString());
        //}
    }

    public void executeCSV(String csvFile){
        List<String[]> lines = readCSV(csvFile);
        fillDatabaseData(lines);
        if (databaseData.get(0) != null)
            System.out.println(databaseData.toString());
        else
            System.out.println("Null asjiasjn");
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
            dbd.setDbUser(line[2]);
            dbd.setDbPass(line[3]);
            dbd.setEngine(DbEngine.valueOf(line[4]));
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
