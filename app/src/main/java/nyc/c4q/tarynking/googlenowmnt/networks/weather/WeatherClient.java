package nyc.c4q.tarynking.googlenowmnt.networks.weather;

import nyc.c4q.tarynking.googlenowmnt.models.weather.WeatherModel;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class WeatherClient {
    private static final String API_KEY = "c6d36af88de5c6442e7961bd0c50d22f";
    private static WeatherClient instance;
    private final WeatherApi api;

    private WeatherClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(WeatherApi.class);
    }

    public static WeatherClient getInstance() {
        if (instance == null) {
            instance = new WeatherClient();
        }
        return instance;
    }

    public Call<WeatherModel> fetchWeather(String location) {
        return api.fetchWeather(location, API_KEY);
    }
}
