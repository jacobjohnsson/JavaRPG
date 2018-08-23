package weather;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class WeatherSimulation {
  Map<Weather,Map<Weather, Double>> weatherChain;
  Weather currentWeather;

  public WeatherSimulation(){
    weatherChain = new HashMap<Weather,Map<Weather, Double>>();
    init();
  }

  private void init() {
    Weather sunny = new Weather("Sunny");
    Weather cloudy = new Weather("Cloudy");
    Weather rainy = new Weather("Rainy");

    Map<Weather,Double> sunnyMap = new HashMap<Weather,Double>();
    sunnyMap.put(sunny, 0.75);
    sunnyMap.put(cloudy, 0.25);

    Map<Weather,Double> cloudyMap = new HashMap<Weather,Double>();
    cloudyMap.put(cloudy, 0.50);
    cloudyMap.put(sunny, 0.25);
    cloudyMap.put(rainy, 0.25);

    Map<Weather,Double> rainyMap = new HashMap<Weather,Double>();
    rainyMap.put(rainy, 0.75);
    rainyMap.put(cloudy, 0.25);

    weatherChain.put(sunny, sunnyMap);
    weatherChain.put(cloudy, cloudyMap);
    weatherChain.put(rainy, rainyMap);

    currentWeather = sunny;
  }

  private void step(){
    Random random = new Random();
    Double randomDouble = random.nextDouble();

    for (Map.Entry<Weather, Double> mapEntry : weatherChain.get(currentWeather).entrySet()) {
      randomDouble = randomDouble - mapEntry.getValue();
      if (randomDouble < 0) {
        currentWeather = mapEntry.getKey();
        break;
      }
    }
  }

  public String nextWeather(){
    step();
    return currentWeather.toString();
  }
}
