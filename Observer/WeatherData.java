import java.util.LinkedList;
import java.util.List;

public class WeatherData implements Subject{
    private List<Observer> observers = new LinkedList<>();
    
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    
    @Override
    public void removeObserver(Observer observer) {
        int index = observers.indexOf(observer);
        if (index >= 0) {
            observers.remove(index);
        }
    }
    @Override 
    public void notifyObservers() {
        for (Observer observer : observers) {
        observer.updater(getTemperature(), getHumidity(), getPressure());
        }
    }
    
    float getTemperature() {
        return 30;
    }
    
    float getHumidity() {
        return 75;
    }
    
    float getPressure() {
        return 740;
    }
    
    void measurementsChanged() {
        notifyObservers();
    }
}
