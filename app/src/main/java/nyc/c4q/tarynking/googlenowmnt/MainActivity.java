package nyc.c4q.tarynking.googlenowmnt;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import nyc.c4q.tarynking.googlenowmnt.models.currency.Currency;
import nyc.c4q.tarynking.googlenowmnt.models.weather.WeatherModel;
import nyc.c4q.tarynking.googlenowmnt.networks.weather.WeatherClient;
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

        permission();

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        gnadapter = new GoogleNowAdapter();
        recyclerView.setAdapter(gnadapter);

        //mel's weather card
        //Weather weather1 = new Weather(); (Delete this) problem: makes a null WeatherCard
        //gnadapter.addToMyItemList(weather1); (Delete this)
        addWeatherCard();

        //Do for reminder
        Reminder reminder1 = new Reminder("do laundry");
        gnadapter.addToMyItemList(reminder1);

        //Nesada's currency card
        //Currency currency1 = new Currency(); (Delete this) problem: makes a null currency1
        //gnadapter.addToMyItemList(currency1); (Delete this)
        currencyCard();

        //CurrencyHolder.refresh();
    }

    private void currencyCard() {
        CurrencyApi api = CurrencyApi.Factory.getInstance();
        Call<Currency> call = api.getCurrency();
        call.enqueue(new Callback<Currency>() {
            @Override
            public void onResponse(Call<Currency> call, Response<Currency> response) {
                Currency currency = response.body();
                gnadapter.addToMyItemList(currency);
            }

            @Override
            public void onFailure(Call<Currency> call, Throwable t) {

            }
        });
    }

    public void addWeatherCard() {
        WeatherClient client = WeatherClient.getInstance();
        Call<WeatherModel> call = client.fetchWeather("new york");
        call.enqueue(new Callback<WeatherModel>() {
            @Override
            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                if (response.isSuccessful()) {
                    WeatherModel model = response.body();
                    gnadapter.addToMyItemList(model);
                }
            }

            @Override
            public void onFailure(Call<WeatherModel> call, Throwable t) {

            }
        });
    }


    public void permission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

//            ActivityCompat.requestPermissions(this,
//                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},   //request specific permission from user
//                    10);
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.INTERNET},   //request specific permission from user
                    10);

            return;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

}
