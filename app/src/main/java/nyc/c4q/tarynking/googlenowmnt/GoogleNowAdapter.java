package nyc.c4q.tarynking.googlenowmnt;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.tarynking.googlenowmnt.models.currency.Currency;
import nyc.c4q.tarynking.googlenowmnt.Cards.CurrencyHolder;
import nyc.c4q.tarynking.googlenowmnt.models.weather.WeatherModel;
import nyc.c4q.tarynking.googlenowmnt.reminderCard.Reminder;
import nyc.c4q.tarynking.googlenowmnt.viewholders.ReminderViewHolder;
import nyc.c4q.tarynking.googlenowmnt.viewholders.WeatherViewHolder;

/**
 * Created by tarynking on 10/30/16.
 */

public class GoogleNowAdapter extends RecyclerView.Adapter {

    //3. change cardsItem to object
    private List<Object> myItemList = new ArrayList<Object>();

    //1. Add Final Variables
    private final int WEATHER = 0, REMINDER = 1, CURRENCY = 2;

    //2. Add this method
    public int getItemViewType(int position) {
        if (myItemList.get(position) instanceof WeatherModel) {
            System.out.println("getItemViewType: weather");
            return WEATHER;
        } else if (myItemList.get(position) instanceof Reminder) {
            System.out.println("getItemViewType: reminder");
            return REMINDER;
        } else if (myItemList.get(position) instanceof Currency) {
            System.out.println("getItemViewType: currency");
            return CURRENCY;
        }


        //2. getItemViewType() returns constant number depending on the type of object in the dataList
        //   then feeds it to onCreateViewHolder() to inflate a viewholder depending on that constant number
        //   - essentially allows different view holders for the same adapter (in our case, different cards)
        //   Add another else if for your card,
        //   example: else if (dataList.(position) instanceof <name_of_your_POJO>)
        //            return <your_card_constant_in_the_field>
        return -1;
    }

    //4. MAke WeatherViewHolder and delete this
//    public static class CardViewHolder extends RecyclerView.ViewHolder{
//        CardView cardView;
//        TextView tempTextV, locationTextV, descriptionTextV;
//        ImageView iconImageV;
//
//
//        public CardViewHolder(View itemView) {
//            super(itemView);
//
//            tempTextV = (TextView) itemView.findViewById(R.id.temperatureTV);
//            locationTextV = (TextView) itemView.findViewById(R.id.locationTV);
//            descriptionTextV = (TextView)itemView.findViewById(R.id.descriptionTV);
//            iconImageV = (ImageView)itemView.findViewById(R.id.iconIV);
//            cardView=(CardView)itemView.findViewById(R.id.weatherCV);
//
//
//        }
//    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //View itemView = LayoutInflater.from(context).inflater(R.layout.item_watch_movie,parent,false)
        // we need use get itemViewType

        RecyclerView.ViewHolder viewHolder;

        switch (viewType) {
            case WEATHER:
                System.out.println("Inflating viewHolder: weather");
                viewHolder = new WeatherViewHolder(parent);
                break;
            case REMINDER:
                System.out.println("Inflating viewHolder: reminder");
                viewHolder = new ReminderViewHolder(parent);
                break;
            case CURRENCY:
                System.out.println("Inflating viewHolder: currency");
                viewHolder = new CurrencyHolder(parent);
                break;
            default:
                System.out.println("Inflating viewHolder: default");
                viewHolder = new WeatherViewHolder(parent);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case WEATHER:
                WeatherViewHolder weatherViewHolder = (WeatherViewHolder) holder;
                weatherViewHolder.bind(myItemList.get(position));
                break;
            case REMINDER:
                ReminderViewHolder reminderViewHolder = (ReminderViewHolder) holder;
                reminderViewHolder.bind(myItemList.get(position));
                break;
            case CURRENCY:
                CurrencyHolder currencyHolder = (CurrencyHolder) holder;
                currencyHolder.bind(myItemList.get(position));
                break;

            //4. Data that is in dataList.get(position) is the data you sent from MainActivity
            //   You'll then send this data to your view holder class here
            //   Add a case for <your_card_constant>
            //   call the bind() method in your view holder class that will stylize your data with the your card layout

        }
    }

    public void addToMyItemList(Object item) {
        myItemList.add(item);
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        //return this.myItemList.size();
        return myItemList.size();
    }



}
