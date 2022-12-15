package com.example.trytoprogramm.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.trytoprogramm.R;
import com.example.trytoprogramm.databinding.FragmentListofpeopleBinding;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    ListView peopleListView;
    private FragmentListofpeopleBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentListofpeopleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        setUpList();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    private void setUpList() {

        List<String> people = new ArrayList<>();

        people.add("Jakob");
        people.add("Jonas");
        people.add("Marc");
        people.add("Martin");
        people.add("Lukas");
        people.add("Phillip");
        people.add("Killian");
        people.add("Mathias");

        peopleListView = (ListView) binding.getRoot().findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter;
        arrayAdapter = new ArrayAdapter<String>(this.getActivity(), R.layout.row_item, R.id.textView, people);
        peopleListView.setAdapter(arrayAdapter);
    }
}