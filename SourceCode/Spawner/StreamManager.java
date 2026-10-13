import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class StreamManager {
    public final List<T> items = new ArrayList<>;
    private final Random rand;

    public StreamManager(Random rand){
        this.rand = rand;
    }

    public void add(T item){
        items.add(item);
    }
}