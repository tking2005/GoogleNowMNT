package nyc.c4q.tarynking.googlenowmnt.reminderCard;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import nyc.c4q.tarynking.googlenowmnt.R;


/**
 * Created by tarynking on 11/9/16.
 */

public class ReminderAdapter extends RecyclerView.Adapter<ReminderViewHolder>{

    ArrayList<Reminder> myReminderList;



    public ReminderAdapter(ArrayList<Reminder> myReminderList) {

        this.myReminderList = myReminderList;
    }



    @Override
    public ReminderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.reminder_layout,parent,false);
        return new ReminderViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(ReminderViewHolder holder, int position) {

        Reminder reminder = myReminderList.get(position);
        holder.reminderView.setText(reminder.getReminderText());

    }

    @Override
    public int getItemCount() {
        return myReminderList.size();
    }
}
