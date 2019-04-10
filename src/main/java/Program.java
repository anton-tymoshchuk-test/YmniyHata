import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Program {
    static List<Device> devices = new ArrayList<Device>() {{
        add(new Fridge());
        add(new Alarm());
        add(new CoffeeMaker());
    }};

    public static void main(String[] args) {
        Database.create();
        /*for (Device device: devices){
            //serializing tests
            System.out.println(device.getClass().getSimpleName()+" => " + SerializeHelper.deserializeDevice(SerializeHelper.serializeDevice(device)).getClass().getSimpleName());
        }*/
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Database.connect();

                Long unixtime = System.currentTimeMillis() / 1000L;
                for (Device device : devices) {
                    device.updateHistory();
                    System.out.println(device.name + " " + unixtime.toString());
                    //Перетворюємо наш об'єкт в массив байтів, та підгружаємо його в "облако"
                    Database.putSerializedDevice(SerializeHelper.serializeDevice(device), unixtime.toString());
                }
                //Видаляємо старі данні
                Database.clearOldContent(unixtime.toString());
                Database.close();

                Database.connect();
                devices = Database.getDevices();
                Database.close();
            }
        }, 5000, 5000);


    }
}
