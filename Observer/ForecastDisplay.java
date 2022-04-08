
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
