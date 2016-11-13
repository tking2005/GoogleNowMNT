package nyc.c4q.tarynking.googlenowmnt.viewholders;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.tarynking.googlenowmnt.MainActivity;
import nyc.c4q.tarynking.googlenowmnt.R;
import nyc.c4q.tarynking.googlenowmnt.reminderCard.ReminderAdapter;



public class ReminderCardViewHolder extends RecyclerView.ViewHolder{
    private Context context;
    private final View mView;
    private RecyclerView recyclerView;
    private Button addButton;
    private EditText reminderEditText;
    private ReminderAdapter adapter;
    public static List<String> myReminderList = new ArrayList<>();
    public static SharedPreferences.Editor editor;


    public ReminderCardViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        mView = itemView;
        if(MainActivity.sharedPreferences.getStringSet("reminders", null) != null){
            myReminderList.addAll(MainActivity.sharedPreferences.getStringSet("reminders",null));
        }
        editor = MainActivity.sharedPreferences.edit();
        recyclerView = (RecyclerView) mView.findViewById(R.id.reminder_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(mView.getContext()));
        adapter = new ReminderAdapter(myReminderList);
        recyclerView.setAdapter(adapter);

        recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.requestFocus();
                return true;
            }
        });




        reminderEditText = (EditText) mView.findViewById(R.id.reminder_edit_view);
        addButton = (Button) mView.findViewById(R.id.reminder_add_new);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(itemView.getContext(), "Added a reminder", Toast.LENGTH_SHORT).show();
                //TODO: Code to add reminder to reminder adapter
                if(reminderEditText.getText() != null){
                    String reminder = String.valueOf(reminderEditText.getText());
                    adapter.updateList(reminder);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(view.getContext(), myReminderList.size()+"", Toast.LENGTH_SHORT).show();
                    ///recyclerView.getAdapter().notifyDataSetChanged();
//                    PreferenceManager.getDefaultSharedPreferences(view.getContext()).edit().putStringSet("reminder", ).apply();
                }

            }
        });
    }

    private static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.reminder_layout, parent, false);
    }

    public void bind(Object data) {
//        Reminder reminder = (Reminder) data;
//        ReminderAdapter adapter = (ReminderAdapter) recyclerView.getAdapter();
//        adapter.updateDataList(context,reminder);
    }
}
