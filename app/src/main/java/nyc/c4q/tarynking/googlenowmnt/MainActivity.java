package nyc.c4q.tarynking.googlenowmnt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.tarynking.googlenowmnt.Model.WeatherApi;
import nyc.c4q.tarynking.googlenowmnt.Model.WeatherModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List<Object> carditems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        carditems = new ArrayList<>();
        GoogleNowAdapter gnadapter = new GoogleNowAdapter(carditems, this);
        recyclerView.setAdapter(gnadapter);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);


        Retrofit retrofit2 = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final WeatherApi weatherService = retrofit2.create(WeatherApi.class);
        final Call<WeatherModel> weatherCall = weatherService.fetchWeather("newyork","c6d36af88de5c6442e7961bd0c50d22f");
        weatherCall.enqueue(new Callback<WeatherModel>() {

            @Override
            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                if(response.isSuccessful()){
                    WeatherModel model = response.body();
                    carditems.add(model);
                }
            }

            @Override
            public void onFailure(Call<WeatherModel> call, Throwable t) {
                Log.d("Log", "Test");
            }
        });




    }

}
