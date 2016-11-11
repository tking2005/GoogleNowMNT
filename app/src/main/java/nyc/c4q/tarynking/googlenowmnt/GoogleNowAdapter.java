package nyc.c4q.tarynking.googlenowmnt;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
        TextView tempTextV, locationTextV, descriptionTextV;
        ImageView iconImageV;


        public CardViewHolder(View itemView) {
            super(itemView);

            tempTextV = (TextView) itemView.findViewById(R.id.temperatureTV);
            locationTextV = (TextView) itemView.findViewById(R.id.locationTV);
            descriptionTextV = (TextView)itemView.findViewById(R.id.descriptionTV);
            iconImageV = (ImageView)itemView.findViewById(R.id.iconIV);
            cardView=(CardView)itemView.findViewById(R.id.weatherCV);
        }

        public void bind(Object o) {
            WeatherModel model = (WeatherModel) o;
            tempTextV.setText(String.valueOf(model.getMain().getTemp()));
            locationTextV.setText(model.getName());
            descriptionTextV.setText(model.getWeather().get(0).getDescription());

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




//        TextView temperature = holder.tempTextV ;
//        temperature.setText((int) item.getWeatherCard().getMain().getTemp());
//
//        TextView location  = holder.locationTextV;
//        location.setText(item.getWeatherCard().getName());
//
//        TextView description = holder.descriptionTextV;
//        description.setText(item.getWeatherCard().getWeather().get;
//
//        ImageView images = holder.iconImageV;
//        images.setImageResource(R.drawable.part_cloudy);

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
}
