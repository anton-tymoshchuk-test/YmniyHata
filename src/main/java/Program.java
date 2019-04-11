import Helpers.Database;
import Helpers.SerializeHelper;
import Devices.*;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Program extends Application {
    static List<Device> devices = new ArrayList<Device>() {{
        add(new Fridge("612616124"));
        add(new Alarm("89125125"));
        add(new CoffeeMaker("12512567"));
    }};
    static Random random = new Random();



    public static void main(String[] args) {
        Database.create();
        /*for (Devices.Device device: devices){
            //serializing tests
            System.out.println(device.getClass().getSimpleName()+" => " + Helpers.SerializeHelper.deserializeDevice(Helpers.SerializeHelper.serializeDevice(device)).getClass().getSimpleName());
        }*/
        /*Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Database.connect();

                Long unixtime = System.currentTimeMillis() / 1000L;
                //System.out.println("UPDATING IN " + unixtime);
                for (Device device : devices) {
                    //device.updateHistory(unixtime.toString());
                    device.setUsingElectricity(random.nextFloat() * 250);
                    device.setLatestCloudUpdate(unixtime);
                    System.out.println(device.getName() + " " + unixtime.toString() + " " + device.getID());
                    //Перетворюємо наш об'єкт в массив байтів, та підгружаємо його в "облако"
                    Database.putSerializedDevice(SerializeHelper.serializeDevice(device), unixtime.toString(),device.getID());
                }
                //Видаляємо старі данні
                //Database.clearOldContent(unixtime.toString());
                Database.close();
                /*System.out.println("RESTORED VALUES");
                Helpers.Database.connect();
                devices = Helpers.Database.getLatestSaves(devices);
                Helpers.Database.close();
                for (Device device : devices)
                    System.out.println(device.getName() + " " + unixtime.toString() + " " + device.getID());*/
            /*}
        }, 5000, 5000);*/

        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {

        ObservableList<Device> people = FXCollections.observableArrayList(devices);
        TableView<Device> table = new TableView<Device>(people);
        table.setPrefWidth(600);
        table.setPrefHeight(200);

        javafx.scene.control.Button  DeEnergize = new Button("De-Energize");
        DeEnergize.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                Helpers.Database.connect();
                devices = Helpers.Database.getLatestSaves(devices);
                Helpers.Database.close();
                System.out.println("asdas");
            }
        });

        TableColumn<Device, String> ID = new TableColumn<Device, String>("ID");
        ID.setCellValueFactory(new PropertyValueFactory<Device, String>("identificator"));
        table.getColumns().add(ID);

        TableColumn<Device, String> DeviceName = new TableColumn<Device, String>("Name");
        DeviceName.setCellValueFactory(new PropertyValueFactory<Device, String>("name"));
        table.getColumns().add(DeviceName);

        TableColumn<Device, Boolean> ageColumn = new TableColumn<Device, Boolean>("Enabled");
        ageColumn.setCellValueFactory(new PropertyValueFactory<Device, Boolean>("enabled"));
        table.getColumns().add(ageColumn);

        TableColumn<Device, Long> LastUpdate = new TableColumn<Device, Long>("Latest Cloud Update");
        LastUpdate.setCellValueFactory(new PropertyValueFactory<Device, Long>("latestCloudUpdate"));
        table.getColumns().add(LastUpdate);

        TableColumn<Device, Float> UsingElectricity = new TableColumn<Device, Float>("Use Electricity");
        UsingElectricity.setCellValueFactory(new PropertyValueFactory<Device, Float>("usingElectricity"));
        table.getColumns().add(UsingElectricity);


        /*TableView.TableViewSelectionModel<Device> selectionModel = table.getSelectionModel();
        selectionModel.selectedItemProperty().addListener(new ChangeListener<Device>(){
            public void changed(ObservableValue<? extends Device& val, Device oldVal, Device newVal){
                if(newVal != null) lbl.setText("Selected: " + newVal.getName());
            }
        });*/

        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10,DeEnergize, table);

        Scene scene = new Scene(root, 600, 250);

        primaryStage.setScene(scene);
        primaryStage.setTitle("TableView in JavaFX");
        primaryStage.show();
    }
}
