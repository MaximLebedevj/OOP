
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
