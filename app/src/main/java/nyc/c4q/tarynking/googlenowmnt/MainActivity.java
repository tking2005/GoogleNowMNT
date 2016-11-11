package nyc.c4q.tarynking.googlenowmnt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import nyc.c4q.tarynking.googlenowmnt.models.weather.WeatherModel;
import nyc.c4q.tarynking.googlenowmnt.reminderCard.Reminder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private GoogleNowAdapter gnadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        gnadapter = new GoogleNowAdapter();
        recyclerView.setAdapter(gnadapter);

        //mel's weather card
        addWeatherCard();

        //Do for reminder
        Reminder reminder1 = new Reminder("do Homework");
        gnadapter.addToMyItemList(reminder1);

    }

    public void addWeatherCard() {
        WeatherClient client = WeatherClient.getInstance();
        Call<WeatherModel> call = client.fetchWeather("new york");
        call.enqueue(new Callback<WeatherModel>() {
            @Override
            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                if(response.isSuccessful()){
                    WeatherModel model = response.body();
                    gnadapter.addToMyItemList(model);
                }
            }

            @Override
            public void onFailure(Call<WeatherModel> call, Throwable t) {

            }
        });
    }
}
