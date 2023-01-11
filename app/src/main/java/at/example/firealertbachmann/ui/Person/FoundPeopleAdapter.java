package at.example.firealertbachmann.ui.Person;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import at.example.firealertbachmann.R;
import java.util.ArrayList;

public class FoundPeopleAdapter  extends ArrayAdapter {

    ArrayList<Person> dataSet;
    Context mContext;

    public FoundPeopleAdapter(ArrayList<Person> dataSet, @NonNull Context context) {
        super(context, R.layout.missingpeople_listview, dataSet);
        this.dataSet = dataSet;
        this.mContext = context;
    }

    private class ViewHolder {
        TextView txtName;
        TextView date;
    }

    @Override
    public int getCount() {
        return dataSet.size();
    }

    @Nullable
    @Override
    public Person getItem(int position) {
        return dataSet.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        FoundPeopleAdapter.ViewHolder viewHolder;
        View result;
        if (convertView == null) {
            viewHolder = new FoundPeopleAdapter.ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.foundpeople_listview, parent, false);
            viewHolder.txtName = convertView.findViewById(R.id.txtFoundName);
            viewHolder.date = convertView.findViewById(R.id.txtFoundDate);
            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (FoundPeopleAdapter.ViewHolder) convertView.getTag();
            result = convertView;
        }

        Person item = getItem(position);
        viewHolder.txtName.setText(item.Name);
        viewHolder.date.setText(item.Uhrzeit);
        return result;
    }
}