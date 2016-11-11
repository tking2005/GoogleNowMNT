package nyc.c4q.tarynking.googlenowmnt;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import nyc.c4q.tarynking.googlenowmnt.Model.WeatherModel;

/**
 * Created by tarynking on 10/30/16.
 */

public class GoogleNowAdapter extends RecyclerView.Adapter <GoogleNowAdapter.CardViewHolder>{

    private List<Object> myItemList;
    private Context context ;


    public static class CardViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView tempTextV, locationTextV, descriptionTextV, hummidityTextTV, pressureTextTv;
        ImageView iconImageV;
        View view;


        public CardViewHolder(View itemView) {
            super(itemView);
            view=itemView;
            tempTextV = (TextView) itemView.findViewById(R.id.temperatureTV);
            locationTextV = (TextView) itemView.findViewById(R.id.locationTV);
            descriptionTextV = (TextView)itemView.findViewById(R.id.descriptionTV);
            iconImageV = (ImageView)itemView.findViewById(R.id.iconIV);
            hummidityTextTV = (TextView) itemView.findViewById(R.id.hummudityTV);
            pressureTextTv = (TextView) itemView.findViewById(R.id.pressureTV);
            cardView=(CardView)itemView.findViewById(R.id.weatherCV);
        }

        public void bind(Object o) {
            WeatherModel model = (WeatherModel) o;
            tempTextV.setText(String.valueOf(model.getMain().getTemp()) +" F");
            locationTextV.setText(model.getName());
            descriptionTextV.setText(model.getWeather().get(0).getDescription());
            hummidityTextTV.setText("Humm: "+ String.valueOf(model.getMain().getHumidity())+"%");
            pressureTextTv.setText("Press: "+String.valueOf(model.getMain().getPressure()));
            Picasso.with(view.getContext()).load("http://openweathermap.org/img/w/"+ model.getWeather().get(0).getIcon()+".png").resize(180,180).centerCrop().into(iconImageV);

        }
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context cntx = parent.getContext();

        LayoutInflater inflater =LayoutInflater.from(context);
        View weatherView =inflater.inflate(R.layout.weather_item, parent, false);
        CardViewHolder cvh = new CardViewHolder(weatherView);
        return cvh;
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        holder.bind(myItemList.get(position));


    }
    //constructor
    public GoogleNowAdapter(List<Object> myItemList, Context context) {
        this.context = context;
        this.myItemList = myItemList;
    }

    public Context getContext() {
        return context;
    }

    @Override
    public int getItemCount() {
        return myItemList.size();
    }

    public void getWeatherPicture(String icon) throws MalformedURLException {

        URL imageURL= new URL("http://openweathermap.org/img/w/");

        try {
            InputStream content=(InputStream)imageURL.getContent();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
