import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void Main(String[] args) {
        List<Device> devices = new ArrayList<Device>(){{ add(new Fridge()); }};



        //timer
        //{
        devices.get(0).updateHistory();
        //}
    }
}
