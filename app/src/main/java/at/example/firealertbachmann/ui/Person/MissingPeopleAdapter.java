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
import java.util.List;

public class MissingPeopleAdapter extends ArrayAdapter {

    List<Person> dataSet;
    Context mContext;

    public MissingPeopleAdapter(List<Person> dataSet, @NonNull Context context) {
        super(context, R.layout.missingpeople_listview, dataSet);
        this.dataSet = dataSet;
        this.mContext = context;
    }

    private class ViewHolder {
        TextView txtName;
        TextView date;
        CheckBox checkBox;
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
        ViewHolder viewHolder;
        View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.missingpeople_listview, parent, false);
            viewHolder.txtName = convertView.findViewById(R.id.txtMissingName);
            viewHolder.date = convertView.findViewById(R.id.txtMissingDate);
            viewHolder.checkBox = convertView.findViewById(R.id.isFound);
            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        Person item = getItem(position);
        viewHolder.txtName.setText(item.getName());
        viewHolder.checkBox.setChecked(item.isCheckBox());
        viewHolder.date.setText(item.getUhrzeit());
        return result;
    }
}