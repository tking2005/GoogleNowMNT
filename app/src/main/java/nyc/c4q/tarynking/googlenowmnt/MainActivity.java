package nyc.c4q.tarynking.googlenowmnt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import nyc.c4q.tarynking.googlenowmnt.reminderCard.Reminder;
import nyc.c4q.tarynking.googlenowmnt.weatherCard.Weather;

public class MainActivity extends AppCompatActivity {
    ArrayList<CardsItem> carditems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rv);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        GoogleNowAdapter gnadapter = new GoogleNowAdapter();
        recyclerView.setAdapter(gnadapter);

        Weather weather = new Weather("Description", 0, "NewYork", "56");
        gnadapter.addToMyItemList(weather);

        //Do for reminder

        Reminder reminder1 = new Reminder("do Homework");
        gnadapter.addToMyItemList(reminder1);
    }
}
