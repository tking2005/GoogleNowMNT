package nyc.c4q.tarynking.googlenowmnt.reminderCard;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nyc.c4q.tarynking.googlenowmnt.R;

/**
 * Created by tarynking on 11/9/16.
 */

public class ReminderRecyclerViewHolder extends RecyclerView.ViewHolder {
    private final View mView;
    private TextView reminderView;

    public ReminderRecyclerViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        mView = itemView;
        reminderView = (TextView) mView.findViewById(R.id.reminder_textView);
    }

    private static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.reminder_item_vh, parent, false);
    }

    public void bind(String reminder) {
        reminderView.setText(reminder);
    }

}
