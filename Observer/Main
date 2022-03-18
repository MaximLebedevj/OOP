
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
