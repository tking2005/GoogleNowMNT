package nyc.c4q.tarynking.googlenowmnt.Cards;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import nyc.c4q.tarynking.googlenowmnt.R;


/**
 * Created by Nesada on 11/12/2016.
 */
public class Card2 extends RecyclerView.ViewHolder {

    public Card2(ViewGroup parent) {
        super(inflateView(parent));

    }


    public static View inflateView(ViewGroup parent){
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.second_item, parent,false);

    }


}
