package Controllers;

import java.net.URL;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Devices.Alarm;
import Devices.CoffeeMaker;
import Devices.Device;
import Devices.Fridge;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class HataTableViewController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Device> TableViewId;

    @FXML
    private TableColumn<Device,String> DeviceName;

    @FXML
    private TableColumn<Device,Boolean> DeviceStatus;

    @FXML
    private TableColumn<Device,Float> DeviceElictricity;

    @FXML
    private Button StatButtonId;

    @FXML
    private Button DeEnergizeId;

    @FXML
    void initialize() {
        List<Device> devices = new ArrayList<Device>() {{
            add(new Fridge("612616124"));
            add(new Alarm("89125125"));
            add(new CoffeeMaker("12512567"));}};
        assert TableViewId != null : "fx:id=\"TableViewId\" was not injected: check your FXML file 'Untitled'.";
        assert StatButtonId != null : "fx:id=\"StatButtonId\" was not injected: check your FXML file 'Untitled'.";
        assert DeEnergizeId != null : "fx:id=\"DeEnergizeId\" was not injected: check your FXML file 'Untitled'.";
        TableViewId = new TableView<Device>(FXCollections.observableList(devices));
        DeviceName = new TableColumn<Device,String>("Device Name");
        DeviceStatus = new TableColumn<Device,Boolean>("Status");
        DeviceElictricity = new TableColumn<Device,Float>("Using Electricity");
        DeviceName.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableViewId.getColumns().add(DeviceName);
    }
}