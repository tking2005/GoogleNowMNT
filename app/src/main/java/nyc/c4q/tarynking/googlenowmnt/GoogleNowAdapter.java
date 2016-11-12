package nyc.c4q.tarynking.googlenowmnt;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class GoogleNowAdapter extends RecyclerView.Adapter<GoogleNowAdapter.CardHolder> {
    private LayoutInflater mInflater;


    public GoogleNowAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public CardHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.test_card_view2, parent, false);
        CardHolder holder = new CardHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(CardHolder holder, int position) {

        Log.d("Yes", "" + position);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    //this class is going to keep one drop in a current moment
    public static class CardHolder extends RecyclerView.ViewHolder {
        TextView mWhat;

        //class constractor
        public CardHolder(View itemView) {
            super(itemView);

        }


    }

}
