package nyc.c4q.tarynking.googlenowmnt.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyc.c4q.tarynking.googlenowmnt.R;
import nyc.c4q.tarynking.googlenowmnt.reminderCard.Reminder;
import nyc.c4q.tarynking.googlenowmnt.reminderCard.ReminderAdapter;

/**
 * Created by dannylui on 11/10/16.
 */

public class ReminderViewHolder extends RecyclerView.ViewHolder{
    private final View mView;
    private RecyclerView recyclerView;

    public ReminderViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        mView = itemView;
        recyclerView = (RecyclerView) mView.findViewById(R.id.reminder_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(mView.getContext()));
        recyclerView.setAdapter(new ReminderAdapter());
    }

    private static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.reminder_layout, parent, false);
    }

    public void bind(Object data) {
        Reminder reminder = (Reminder) data;
        ReminderAdapter adapter = (ReminderAdapter) recyclerView.getAdapter();
        adapter.updateDataList(reminder);
    }
}
