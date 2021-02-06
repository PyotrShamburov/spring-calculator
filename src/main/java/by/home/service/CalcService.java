package by.home.service;

import by.home.storage.HistoryStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalcService {

    @Autowired
    private HistoryStorage storage ;

    public String doCalc(double num1, double num2, String sign){
        double result = 0.0;
        String operator = "";
        String historyStep = "";
        switch (sign){
            case "sum":
                result = sum(num1, num2);
                operator = " + ";
                break;
            case "div":
                operator = " / ";
                if (num2!=0){
                    result = div(num1, num2);
                    break;
                }else{
                    historyStep = num1+operator+num2+" =\"Division by zero!\"";
                    storage.addToHistory(historyStep);
                    return "Division by zero!";
                }
            case "dif":
                result = dif(num1, num2);
                operator = " - ";
                break;
            case "mul":
                result = mul(num1, num2);
                operator = " * ";
                break;
            default:
                historyStep = "Wrong type of arithmetic operation!";
                storage.addToHistory(historyStep);
                return historyStep;
        }
        historyStep = num1+operator+num2+" = "+result+";";
        storage.addToHistory(historyStep);
        return String.valueOf(result);
    }


    private double sum(double num1, double num2 ){
        return num1+num2;
    }

    private double div(double num1, double num2 ){
        return num1/num2;
    }

    private double dif(double num1, double num2 ){
        return num1-num2;
    }

    private double mul(double num1, double num2 ){
        return num1*num2;
    }

    public List<String> getHistory() {
        return new ArrayList<>(storage.getHistory());
    }

    public void clearHistory() {
        storage.clearHistory();
    }
}
