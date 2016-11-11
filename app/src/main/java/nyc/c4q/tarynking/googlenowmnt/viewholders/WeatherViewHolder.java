package nyc.c4q.tarynking.googlenowmnt.viewholders;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import nyc.c4q.tarynking.googlenowmnt.R;
import nyc.c4q.tarynking.googlenowmnt.weatherCard.Weather;

/**
 * Created by dannylui on 11/10/16.
 */

public class WeatherViewHolder extends RecyclerView.ViewHolder {
    private final View mView;
    CardView cardView;
    TextView tempTextV, locationTextV, descriptionTextV;
    ImageView iconImageV;

    public WeatherViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        mView = itemView;
        tempTextV = (TextView) itemView.findViewById(R.id.temperatureTV);
        locationTextV = (TextView) itemView.findViewById(R.id.locationTV);
        descriptionTextV = (TextView)itemView.findViewById(R.id.descriptionTV);
        iconImageV = (ImageView)itemView.findViewById(R.id.iconIV);
        cardView=(CardView)itemView.findViewById(R.id.weatherCV);
    }

    private static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.weather_item, parent, false);
    }

    public void bind(Object data) {
        Weather weather = (Weather) data;
        tempTextV.setText(weather.getTemp());

        locationTextV.setText(weather.getLocation());

        descriptionTextV.setText(weather.getLocation());

        iconImageV.setImageResource(R.drawable.part_cloudy);
    }
}
