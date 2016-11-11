package nyc.c4q.tarynking.googlenowmnt.networks.weather;

import nyc.c4q.tarynking.googlenowmnt.models.weather.WeatherModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by meltemyildirim on 11/9/16.
 * http://api.openweathermap.org/data/2.5/weather?q=newyork&appid=c6d36af88de5c6442e7961bd0c50d22f
 */

public interface WeatherApi {
    @GET("data/2.5/weather")
    Call<WeatherModel> fetchWeather(@Query("q") String location, @Query("appid") String apiKey);


    //@GET("c/data/2.5/weather?q=newyork&appid=c6d36af88de5c6442e7961bd0c50d22f")
    //Call<WeatherModel> getWeather();
}