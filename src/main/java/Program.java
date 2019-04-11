import Helpers.Database;
import Helpers.SerializeHelper;
import Devices.*;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.*;

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

        //DeviceStatistics.showStat(devices.get(0));
        // создаем список объектов
        ObservableList<Device> people = FXCollections.observableArrayList(devices);
        Label lbl = new Label();
        TableView<Device> table = new TableView<Device>(people);
        table.setPrefWidth(250);
        table.setPrefHeight(200);

        // столбец для вывода имени
        TableColumn<Device, String> nameColumn = new TableColumn<Device, String>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<Device, String>("name"));
        table.getColumns().add(nameColumn);

        // столбец для вывода возраста
        TableColumn<Device, Boolean> ageColumn = new TableColumn<Device, Boolean>("Enabled");
        ageColumn.setCellValueFactory(new PropertyValueFactory<Device, Boolean>("enabled"));
        table.getColumns().add(ageColumn);

        /*TableView.TableViewSelectionModel<Device> selectionModel = table.getSelectionModel();
        selectionModel.selectedItemProperty().addListener(new ChangeListener<Device>(){
            public void changed(ObservableValue<? extends Device& val, Device oldVal, Device newVal){
                if(newVal != null) lbl.setText("Selected: " + newVal.getName());
            }
        });*/

        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10, lbl, table);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setScene(scene);
        primaryStage.setTitle("TableView in JavaFX");
        primaryStage.show();
    }
}
