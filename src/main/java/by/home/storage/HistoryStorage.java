package by.home.storage;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HistoryStorage {
    private List<String> history = new ArrayList<>();

    public  List<String> getHistory() {
        return new ArrayList<>(history);
    }
    public void addToHistory(String operation){
        history.add(operation);
    }
    public void clearHistory() {
        history.clear();
    }
}
