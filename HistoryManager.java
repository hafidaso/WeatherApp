import java.util.ArrayList;
import java.util.List;

public class HistoryManager {
    private List<String> history = new ArrayList<>();

    public void addHistory(String location, long timestamp) {
        String entry = String.format("[%s] %s", new java.util.Date(timestamp), location);
        history.add(entry);
    }

    public List<String> getHistory() {
        return history;
    }
}