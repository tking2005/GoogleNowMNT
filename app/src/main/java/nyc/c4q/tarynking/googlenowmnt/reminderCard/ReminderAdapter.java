package nyc.c4q.tarynking.googlenowmnt.reminderCard;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nyc.c4q.tarynking.googlenowmnt.viewholders.ReminderCardViewHolder;


/**
 * Created by tarynking on 11/9/16.
 */

public class ReminderAdapter extends RecyclerView.Adapter<ReminderRecyclerViewHolder>{


    public  List<String> myReminderList;
    private Set<String> myReminderSet = new HashSet<>();

    public ReminderAdapter(List<String> data){
        this.myReminderList = data;
    }

    @Override
    public ReminderRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ReminderRecyclerViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(ReminderRecyclerViewHolder holder, int position) {
        String reminder = myReminderList.get(position);
        holder.bind(reminder);
    }

    public void updateDataList(Context context, String reminder) {
        myReminderList.add(reminder);
        myReminderSet.add(reminder);
//        PreferenceManager.getDefaultSharedPreferences(context).edit().putStringSet("reminders", myReminderSet).apply();
        notifyDataSetChanged();
    }

    public void updateList(String data) {
        myReminderList.add(data);
        myReminderSet.add(data);
        ReminderCardViewHolder.editor.putStringSet("reminders",myReminderSet).apply();
        this.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return myReminderList.size();
    }
}
