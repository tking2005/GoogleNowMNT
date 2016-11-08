package nyc.c4q.tarynking.googlenowmnt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import nyc.c4q.tarynking.googlenowmnt.weatherCard.Weather;

public class MainActivity extends AppCompatActivity {
    ArrayList<CardsItem> carditems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rv);
        carditems = new ArrayList<>();
        carditems.add(new CardsItem( new Weather("Description", 0, "NewYork", "56")));
        GoogleNowAdapter gnadapter = new GoogleNowAdapter(carditems, this);
        recyclerView.setAdapter(gnadapter);

        LinearLayoutManager llm = new LinearLayoutManager(this);
//        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
    }
}
