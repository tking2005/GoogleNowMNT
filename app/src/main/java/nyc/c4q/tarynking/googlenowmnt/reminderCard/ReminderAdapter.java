package nyc.c4q.tarynking.googlenowmnt.reminderCard;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by tarynking on 11/9/16.
 */

public class ReminderAdapter extends RecyclerView.Adapter<ReminderListViewHolder>{

    private List<Reminder> myReminderList = new ArrayList<Reminder>();

    @Override
    public ReminderListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ReminderListViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(ReminderListViewHolder holder, int position) {
        Reminder reminder = myReminderList.get(position);
        holder.bind(reminder);
    }

    public void updateDataList(Reminder reminder) {
        myReminderList.add(reminder);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return myReminderList.size();
    }
}
