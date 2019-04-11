package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class HataTableViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> TableViewId;

    @FXML
    private Button StatButtonId;

    @FXML
    private Button DeEnergizeId;

    @FXML
    void initialize() {
        assert TableViewId != null : "fx:id=\"TableViewId\" was not injected: check your FXML file 'Untitled'.";
        assert StatButtonId != null : "fx:id=\"StatButtonId\" was not injected: check your FXML file 'Untitled'.";
        assert DeEnergizeId != null : "fx:id=\"DeEnergizeId\" was not injected: check your FXML file 'Untitled'.";

    }
}
