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
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;

public class PeopleFragment extends Fragment {

    ListView peopleListView;
    Button button;

    private FragmentPeopleBinding binding;
    private PeopleAdapter adapter;
    PeopleListService peopleService = PeopleListService.getInstance();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        peopleListView = (ListView) binding.getRoot().findViewById(R.id.peoplelist);
        adapter = new PeopleAdapter(peopleService.getMissingPeople(), getContext());
        peopleListView.setAdapter(adapter);


        binding = FragmentPeopleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        button = root.findViewById(R.id.buttonCheckPeople);





        button.setOnClickListener(view ->
        {
            for (People people: peopleService.getMissingPeople())
            {
                if (people.Status == Boolean.TRUE)
                {
                    people.Status = Boolean.FALSE;
                }
            }

            adapter.notifyDataSetChanged();
        });



        peopleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {

                People item = adapter.getItem(position);

                item.Status = !item.Status;

                adapter.notifyDataSetChanged();
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }






}