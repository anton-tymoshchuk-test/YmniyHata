import Helpers.Database;
import Helpers.SerializeHelper;
import Devices.*;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Program extends Application {
    static List<Device> devices = new ArrayList<Device>() {{
        add(new Fridge());
        add(new Alarm());
        add(new CoffeeMaker());
    }};

    public static void main(String[] args) {
        Database.create();
        /*for (Devices.Device device: devices){
            //serializing tests
            System.out.println(device.getClass().getSimpleName()+" => " + Helpers.SerializeHelper.deserializeDevice(Helpers.SerializeHelper.serializeDevice(device)).getClass().getSimpleName());
        }*/
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Database.connect();

                Long unixtime = System.currentTimeMillis() / 1000L;
                for (Device device : devices) {
                    device.updateHistory(unixtime.toString());
                    System.out.println(device.getName() + " " + unixtime.toString());
                    //Перетворюємо наш об'єкт в массив байтів, та підгружаємо його в "облако"
                    Database.putSerializedDevice(SerializeHelper.serializeDevice(device), unixtime.toString());
                }
                //Видаляємо старі данні
                Database.clearOldContent(unixtime.toString());
                Database.close();

                /*Helpers.Database.connect();
                devices = Helpers.Database.getDevices();
                Helpers.Database.close();*/
            }
        }, 5000, 5000);

        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {

        DeviceStatistics.showStat(devices.get(0));

    }
}
