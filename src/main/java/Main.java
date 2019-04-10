import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    static List<Device> devices = new ArrayList<Device>()
    {{
        add(new Fridge());
        add(new Alarm());
        add(new CoffeeMaker());
    }};
    
    public static void Main(String[] args){
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                for (Device device: devices){
                    device.updateHistory();
                    //super secret function -> writeData(device)
                }

            }
        }, 5000, 5000);
    }
}
