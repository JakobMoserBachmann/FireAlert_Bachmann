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
import at.example.firealertbachmann.databinding.FragmentFoundpeopleBinding;

public class FoundPeopleFragment extends Fragment {

    PersonListService peopleListService = PersonListService.getInstance();
    private FragmentFoundpeopleBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentFoundpeopleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        CreateListView();

        return root;
    }

    public void CreateListView()
    {
        ListView peopleListView = binding.getRoot().findViewById(R.id.foundPeopleList);
        FoundPeopleAdapter adapter = new FoundPeopleAdapter((ArrayList<Person>) peopleListService.getFoundPeople(), getContext());
        peopleListView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
