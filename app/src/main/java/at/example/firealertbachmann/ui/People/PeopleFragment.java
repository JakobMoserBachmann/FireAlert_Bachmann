package at.example.firealertbachmann.ui.People;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import at.example.firealertbachmann.R;
import at.example.firealertbachmann.databinding.FragmentPeopleBinding;
import at.example.firealertbachmann.ui.NfcScan.NfcScanFragment;

import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;

public class PeopleFragment extends Fragment {

    ListView peopleListView;
    Button button;

    private FragmentPeopleBinding binding;
    private PeopleAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentPeopleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        button = root.findViewById(R.id.buttonCheckPeople);

        setUpList();

        button.setOnClickListener(view ->
        {
            Snackbar snackbar = Snackbar.make(view, "Mitarbeiter wurde Abgehakt", Snackbar.LENGTH_LONG);
            snackbar.show();
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setUpList() {

        ArrayList<People> people = new ArrayList<>();

        people.add(new People("Jakob", false));
        people.add(new People("Jonas", false));
        people.add(new People("Marc", false));
        people.add(new People("Martin", false));
        people.add(new People("Lukas", false));
        people.add(new People("Phillip", false));
        people.add(new People("Killian", false));
        people.add(new People("Mathias", false));

        peopleListView = (ListView) binding.getRoot().findViewById(R.id.peoplelist);
        adapter = new PeopleAdapter(people, getContext());
        peopleListView.setAdapter(adapter);

        peopleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {

                People item = adapter.getItem(position);

                item.Status = !item.Status;

                adapter.notifyDataSetChanged();
            }
        });
    }
}