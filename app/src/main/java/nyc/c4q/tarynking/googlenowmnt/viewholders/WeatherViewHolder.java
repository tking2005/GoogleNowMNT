package nyc.c4q.tarynking.googlenowmnt.viewholders;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import nyc.c4q.tarynking.googlenowmnt.R;
import nyc.c4q.tarynking.googlenowmnt.models.weather.WeatherModel;

/**
 * Created by dannylui on 11/10/16.
 */

public class WeatherViewHolder extends RecyclerView.ViewHolder {
    CardView cardView;
    //TextView tempTextV, locationTextV, descriptionTextV;
    TextView tempTextV, locationTextV, descriptionTextV, hummidityTextTV, pressureTextTv;
    ImageView iconImageV;

    public WeatherViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        /*tempTextV = (TextView) itemView.findViewById(R.id.temperatureTV);
        locationTextV = (TextView) itemView.findViewById(R.id.locationTV);
        descriptionTextV = (TextView)itemView.findViewById(R.id.descriptionTV);
        iconImageV = (ImageView)itemView.findViewById(R.id.iconIV);
        cardView=(CardView)itemView.findViewById(R.id.weatherCV);*/
        tempTextV = (TextView) itemView.findViewById(R.id.temperatureTV);
        locationTextV = (TextView) itemView.findViewById(R.id.locationTV);
        descriptionTextV = (TextView)itemView.findViewById(R.id.descriptionTV);
        iconImageV = (ImageView)itemView.findViewById(R.id.iconIV);
        hummidityTextTV = (TextView) itemView.findViewById(R.id.hummudityTV);
        pressureTextTv = (TextView) itemView.findViewById(R.id.pressureTV);
        cardView=(CardView)itemView.findViewById(R.id.weatherCV);
    }

    private static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.weather_item, parent, false);
    }

    public void bind(Object data) {
        WeatherModel weather = (WeatherModel) data;
        /*tempTextV.setText(weather.getTemp());

        locationTextV.setText(weather.getLocation());

        descriptionTextV.setText(weather.getLocation());

        iconImageV.setImageResource(R.drawable.part_cloudy);*/

        tempTextV.setText(weather.getMain().getTemp() +" F");
        locationTextV.setText(weather.getName());
        descriptionTextV.setText(weather.getWeather().get(0).getDescription());
        hummidityTextTV.setText("Humm: "+ String.valueOf(weather.getMain().getHumidity())+"%");
        pressureTextTv.setText("Press: "+String.valueOf(weather.getMain().getPressure()));
        Picasso.with(itemView.getContext()).load("http://openweathermap.org/img/w/"+ weather.getWeather().get(0).getIcon()+".png").resize(180,180).centerCrop().into(iconImageV);



    }
}
