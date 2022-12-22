package at.example.firealertbachmann.ui.People;

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

public class PeopleAdapter extends ArrayAdapter {

    ArrayList<People> dataSet;
    Context mContext;

    public PeopleAdapter(ArrayList<People> dataSet, @NonNull Context context) {
        super(context, R.layout.fragment_people_listitem, dataSet);
        this.dataSet = dataSet;
        this.mContext = context;
    }

    private class ViewHolder {
        TextView txtName;
        CheckBox checkBox;
    }

    @Override
    public int getCount() {
        return dataSet.size();
    }

    @Nullable
    @Override
    public People getItem(int position) {
        return dataSet.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        View result;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_people_listitem, parent, false);
            viewHolder.txtName = convertView.findViewById(R.id.rowitem);
            viewHolder.checkBox = convertView.findViewById(R.id.checkBox);
            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        People item = getItem(position);
        viewHolder.txtName.setText(item.Name);
        viewHolder.checkBox.setChecked(item.Status);
        return result;
    }
}