package nyc.c4q.tarynking.googlenowmnt.reminderCard;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.tarynking.googlenowmnt.R;

/**
 * Created by tarynking on 11/9/16.
 */

public class ReminderViewHolder extends RecyclerView.ViewHolder {
    TextView reminderView;


    public ReminderViewHolder(View itemView) {
        super(itemView);
        reminderView = (TextView) itemView.findViewById(R.id.remindnder_textView);
    }
}
