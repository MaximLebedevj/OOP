
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
