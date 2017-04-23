package sample;

import com.dracode.execution.Execution;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;

public class Controller {

    private File file;

    @FXML
    void importFile(){
        FileChooser fileChooser = new FileChooser();
        final FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("XML or CSV","*.csv","*.xml");
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().add(extensionFilter);
        file = fileChooser.showOpenDialog(new Stage());
    }

    @FXML
    void executor() throws IOException {
        Execution execution = new Execution();

        if (FilenameUtils.getExtension(file.getAbsolutePath()).equals("csv"))
            execution.executeCSV(file.getAbsolutePath());
        else
            execution.executeXML(file.getAbsolutePath());
    }
}
