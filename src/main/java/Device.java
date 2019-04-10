import java.io.Serializable;
import java.util.List;

public abstract class Device implements Serializable {
    float usingElecticity;

    List<Float> history;
    void updateHistory()
    {
        history.add(usingElecticity);
    }
}
