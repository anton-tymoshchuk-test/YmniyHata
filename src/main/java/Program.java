import Helpers.Database;
import Helpers.SerializeHelper;
import Devices.*;
import com.jfoenix.controls.JFXButton;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.*;
import java.util.List;

public class Program extends Application {
    static List<Device> devices = new ArrayList<Device>() {{
        add(new Fridge("612616124"));
        add(new Alarm("89125125"));
        add(new CoffeeMaker("12512567"));
        add(new Conditioner("438583954"));
        add(new Stove("487384823"));
        add(new Washer("38294842"));
    }};
    static Random random = new Random();

    static ObservableList<Device> devicesObserb;
    static TableView<Device> table;

    public static void main(String[] args) {
        for (Device device : devices) {
            device.toggleEnabled();
        }
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                //Database.connect();

                Long unixtime = System.currentTimeMillis() / 1000L;
                for (Device device : devices) {
                    device.randomizeData();
                    device.setLatestCloudUpdate(unixtime);
                    System.out.println(device.getName() + " " + unixtime.toString() + " " + device.getIdentificator());
                    //Перетворюємо наш об'єкт в массив байтів, та підгружаємо його в "облако"
                    Database.putSerializedDevice(SerializeHelper.serializeDevice(device), unixtime.toString(), device.getIdentificator());

                    devicesObserb = FXCollections.observableArrayList(devices);
                    table.setItems(devicesObserb);
                    table.refresh();
                }
            }
        }, 5000, 5000);
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        table = createTable();
        JFXButton button = new JFXButton("Вимкнути світло");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Database.connect();
                devices = Database.getLatestSaves(devices);
                devicesObserb = FXCollections.observableArrayList(devices);
                table.setItems(devicesObserb);
                table.refresh();
                //Database.close();
            }
        });
        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10, button, table);

        Scene scene = new Scene(root, 600, 250);

        primaryStage.setScene(scene);
        primaryStage.setTitle("YmniyHata v13.37");
        primaryStage.show();
    }
    public static TableView<Device> createTable()
    {
        TableView<Device> table = new TableView<Device>();
        devicesObserb = FXCollections.observableArrayList(devices);
        table = new TableView<Device>(devicesObserb);
        table.setPrefWidth(600);
        table.setPrefHeight(206);

        TableColumn<Device, String> identificator = new TableColumn<Device, String>("ID");
        identificator.setCellValueFactory(new PropertyValueFactory<Device, String>("identificator"));
        table.getColumns().add(identificator);

        TableColumn<Device, String> deviceName = new TableColumn<Device, String>("Name");
        deviceName.setCellValueFactory(new PropertyValueFactory<Device, String>("name"));
        table.getColumns().add(deviceName);

        TableColumn<Device, Boolean> ageColumn = new TableColumn<Device, Boolean>("Enabled");
        ageColumn.setCellValueFactory(new PropertyValueFactory<Device, Boolean>("enabled"));
        table.getColumns().add(ageColumn);

        TableColumn<Device, Long> LastUpdate = new TableColumn<Device, Long>("Latest Cloud Update");
        LastUpdate.setCellValueFactory(new PropertyValueFactory<Device, Long>("latestCloudUpdate"));
        table.getColumns().add(LastUpdate);

        TableColumn<Device, Float> UsingElectricity = new TableColumn<Device, Float>("Use Electricity");
        UsingElectricity.setCellValueFactory(new PropertyValueFactory<Device, Float>("usingElectricity"));
        table.getColumns().add(UsingElectricity);

        table.setRowFactory(tv -> {
            TableRow<Device> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Device rowData = row.getItem();
                    if (rowData != null)
                        DeviceStatistics.showStat(rowData);
                }
            });
            return row;
        });
        return table;
    }
}
