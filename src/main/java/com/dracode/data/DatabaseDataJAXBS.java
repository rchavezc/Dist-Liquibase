package com.dracode.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

/**
 * Created by rafalex on 22/04/17.
 */
@XmlRootElement(name = "DatabaseDataJAXBS")
@XmlAccessorType(XmlAccessType.FIELD)
public class DatabaseDataJAXBS {

    @XmlElement(name = "DatabaseData")
    private DatabaseData[] databaseData;

    public DatabaseData[] getDatabaseDataJAXBS() {
        return databaseData;
    }

    public void setDatabaseDataJAXBS(DatabaseData[] databaseDataJAXBS) {
        this.databaseData = databaseDataJAXBS;
    }

    @Override
    public String toString() {
        return "DatabaseDataJAXBS{" +
                "databaseDataJAXBS=" + Arrays.toString(databaseData) +
                '}';
    }
}
