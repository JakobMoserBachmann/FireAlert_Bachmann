package at.example.firealertbachmann.ui.Person;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import at.example.firealertbachmann.R;
import at.example.firealertbachmann.databinding.FragmentMissingpeopleBinding;

public class MissingPeopleFragment extends Fragment {

    ListView peopleListView;
    Button button;
    SearchView searchView;
    PersonListService peopleListService = PersonListService.getInstance();
    private FragmentMissingpeopleBinding binding;
    private MissingPeopleAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //peopleListService.SetBackPeople();
        binding = FragmentMissingpeopleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        button = root.findViewById(R.id.buttonCheckPeople);
        CreateListView();

        peopleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {

                Person person = adapter.getItem(position);

                person.setCheckBox(!person.isCheckBox());

                adapter.notifyDataSetChanged();
            }
        });

        button.setOnClickListener(view ->
        {
            for (Person person: peopleListService.getMissingPeople())
            {
                if (person.isCheckBox())
                {
                    peopleListService.foundPerson(person);
                }
            }
            CreateListView();
        });

        searchView = root.findViewById(R.id.simpleSearchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                CreateListView(searchView.getQuery().toString());
                return false;
            }
        });
        return root;
    }

    public void CreateListView(String filterText)
    {
        peopleListView = (ListView) binding.getRoot().findViewById(R.id.missingPeopleList);
        List<Person> filteredPerson = peopleListService.getMissingPeople()
                .stream()
                .filter(x -> x.getName().toLowerCase().contains(filterText.toLowerCase()))
                .collect(Collectors.toList());
        adapter = new MissingPeopleAdapter(filteredPerson, getContext());
        peopleListView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }

    public void CreateListView()
    {
        peopleListView = (ListView) binding.getRoot().findViewById(R.id.missingPeopleList);
        adapter = new MissingPeopleAdapter((ArrayList<Person>) peopleListService.getMissingPeople(), getContext());
        peopleListView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}