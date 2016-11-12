package nyc.c4q.tarynking.googlenowmnt;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import nyc.c4q.tarynking.googlenowmnt.Cards.Card1;
import nyc.c4q.tarynking.googlenowmnt.Cards.Card2;
import nyc.c4q.tarynking.googlenowmnt.Cards.Card3;

public class RecyclerAdapter extends RecyclerView.Adapter {

    private int[] items = new int[3];

    private final int card1 = 0, card2 = 1, card3 = 2;

    public RecyclerAdapter(Context context) {
        this.items[0] = card1;
        this.items[1] = card2;
        this.items[2] = card3;

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;

        switch (viewType) {
            case card1:
                viewHolder = new Card1(parent);
                break;
            case card2:
                viewHolder = new Card2(parent);
                break;
            default:
                viewHolder = new Card3(parent);
                break;
        }
        return viewHolder;


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case card1:
                Card1 firstCard = (Card1) holder;
                break;
            case card2:

                Card2 secondCard = (Card2) holder;

                break;
            default:
                Card3 thirdCard = (Card3) holder;

                break;

        }

    }

    @Override
    public int getItemCount() {
        return 1;
    }


    @Override
    public int getItemViewType(int position) {
        if (items[position] == 0) {
            return card1;
        } else if (items[position] == 1) {
            return card2;
        } else if (items[position] == 2) {
            return card3;
        }
        return -1;
    }

}
