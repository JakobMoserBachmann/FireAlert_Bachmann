package com.example.trytoprogramm.ui.PeopleList;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.trytoprogramm.R;
import com.example.trytoprogramm.databinding.FragmentPeoplelistBinding;
import com.google.android.material.snackbar.Snackbar;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PeopleListFragment extends Fragment {

    ListView peopleListView;
    private FragmentPeoplelistBinding binding;
    private PeopleAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentPeoplelistBinding.inflate(inflater, container, false);
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

        Log.v("test", "HALL");

        peopleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {

                People item = adapter.getItem(position);
                Log.v(item.Status.toString(), "I AM HERE1111111111");
                item.Status = !item.Status;
                Log.v(item.Status.toString(), "I AM HERE2222222222");
                adapter.notifyDataSetChanged();
            }
        });


    }
}