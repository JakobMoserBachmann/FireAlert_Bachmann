package at.example.firealertbachmann.ui.Person;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import at.example.firealertbachmann.R;
import at.example.firealertbachmann.databinding.FragmentPeopleBinding;

public class PersonFragment extends Fragment {

    ListView peopleListView;
    Button button;
    PersonListService peopleListService = PersonListService.getInstance();
    private FragmentPeopleBinding binding;
    private PersonAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentPeopleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        button = root.findViewById(R.id.buttonCheckPeople);

        CreateListView();

        peopleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {

                Person item = adapter.getItem(position);

                item.IsFound = !item.IsFound;

                adapter.notifyDataSetChanged();
            }
        });


        button.setOnClickListener(view ->
        {
            for (Person person: peopleListService.getMissingPeople())
            {
                if (person.IsFound == Boolean.TRUE)
                {

                    peopleListService.FoundPerson(person);
                }
            }

            CreateListView();

        });

        return root;
    }
    public void CreateListView()
    {
        peopleListView = (ListView) binding.getRoot().findViewById(R.id.peoplelist);

        adapter = new PersonAdapter((ArrayList<Person>) peopleListService.getMissingPeople(), getContext());
        peopleListView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }





}