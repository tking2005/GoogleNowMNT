package nyc.c4q.tarynking.googlenowmnt.reminderCard;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by tarynking on 11/9/16.
 */

public class ReminderAdapter extends RecyclerView.Adapter<ReminderRecyclerViewHolder>{


    public  List<Reminder> myReminderList;
    private Set<String> myReminderSet = new HashSet<>();

    public ReminderAdapter(List<Reminder> data){
        this.myReminderList = data;
    }

    @Override
    public ReminderRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ReminderRecyclerViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(ReminderRecyclerViewHolder holder, int position) {
        Reminder reminder = myReminderList.get(position);
        holder.bind(reminder);
    }

    public void updateDataList(Context context, Reminder reminder) {
        myReminderList.add(reminder);
        myReminderSet.add(reminder.getReminderText());
//        PreferenceManager.getDefaultSharedPreferences(context).edit().putStringSet("reminders", myReminderSet).apply();
        notifyDataSetChanged();
    }

    public void updateList(Reminder data) {
        myReminderList.add(data);
        this.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return myReminderList.size();
    }
}
