package lecture2.weather;
import java.util.LinkedList;
import java.util.List;


public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

public interface Observer {
    void updater(float temperature, float humididty, float pressure);
}

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

public class StatisticsDisplay implements Observer {
    private float temperature;
    private float humidity;
    private float pressure;
    
    private float temperature_avarage;
    private float humidity_avarage;
    private float pressure_avarage;
    
    public void setAvarage(float temperature, float humidity, float pressure) {
        this.temperature_avarage = temperature;
        this.humidity_avarage = humidity;
        this.pressure_avarage = pressure;
    }
    
    @Override
    public void updater(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
    
    public void display() {
        if (temperature - temperature_avarage >= 0) {
            System.out.println("Temeprature is above normal by " + (temperature - temperature_avarage));
        }
        else {
            System.out.println("Temeprature is below normal by " + (temperature_avarage - temperature));
        }
        if (humidity - humidity_avarage >= 0) {
            System.out.println("Humidity is above normal by " + (humidity - humidity_avarage));
        }
        else {
            System.out.println("Humidity is below normal by " + (humidity_avarage - humidity));
        }
        if (pressure - pressure_avarage >= 0) {
            System.out.println("Pressure is above normal by " + (pressure - pressure_avarage));
        }
        else {
            System.out.println("Pressure is below normal by " + (pressure_avarage - pressure));
        } 
    }
}

public class ForecastDisplay implements Observer{
    private float temperature;
    private float humidity;
    private float pressure;
    
    @Override
    public void updater(float temperature, float humidity, float pressure ) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
    public void display() {
        System.out.println("Temperature will be " + (temperature + ((temperature % 10 + temperature / 10) / 2)) + " degrees Celcius");
        System.out.println("Humidity will be " + (humidity + ((humidity % 10 + humidity / 10) / 2)) + " percent");
        System.out.println("Pressure will be " + (pressure + ((pressure % 10 + pressure / 10) / 2)) + " millimeters of mercury");
    }
}

public class CurrentConditionsDisplay implements Observer{
    private float temperature;
    private float humidity;
    private float pressure;
    
    public CurrentConditionsDisplay(Subject subject) {
        subject.registerObserver(this);
    }
    
    @Override
    public void updater(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
    
    public void display() {
        System.out.println("Temperature: " + temperature);
        System.out.println("Humidity: " + humidity);
        System.out.println("Pressure: " + pressure);
    }
}

public class Main {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay();
        statisticsDisplay.setAvarage(22, 75, 760);
        ForecastDisplay forecastDisplay = new ForecastDisplay();
        
        weatherData.registerObserver(statisticsDisplay);
        weatherData.registerObserver(forecastDisplay);
        weatherData.measurementsChanged();
    }
}



