package com.dracode.execution;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by rafalex on 23/04/17.
 */
class ExecutionTest {
    @org.junit.jupiter.api.Test
    void executeXML() throws IOException {
        Execution execution = new Execution();
        execution.executeXML("/Users/rafalex/git/Dist-Liquidbase-Exec/src/test/resources/example.xml");
    }

    @org.junit.jupiter.api.Test
    void executeCSV() {
        Execution execution = new Execution();
    }

}