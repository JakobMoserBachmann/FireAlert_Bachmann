package at.example.firealertbachmann.ui.Person;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import at.example.firealertbachmann.R;
import at.example.firealertbachmann.databinding.FragmentPeopleBinding;

public class FoundPeopleFragment extends Fragment {

    ListView peopleListView;

    PersonListService peopleListService = PersonListService.getInstance();
    private FragmentPeopleBinding binding;
    private PersonAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentPeopleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        CreateListView();

        return root;
    }
    public void CreateListView()
    {
        peopleListView = (ListView) binding.getRoot().findViewById(R.id.FoundPeople);

        adapter = new PersonAdapter((ArrayList<Person>) peopleListService.getFoundPeople(), getContext());
        peopleListView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
