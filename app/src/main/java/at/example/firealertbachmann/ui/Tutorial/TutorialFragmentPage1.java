package at.example.firealertbachmann.ui.Tutorial;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import at.example.firealertbachmann.R;
import at.example.firealertbachmann.databinding.FragmentTutorialPage1Binding;
import at.example.firealertbachmann.ui.Person.Person;

public class TutorialFragmentPage1 extends Fragment
{
    Button button;
    TextView textView;
    private FragmentTutorialPage1Binding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        binding = FragmentTutorialPage1Binding.inflate(inflater, container, false);

        View root = binding.getRoot();

        button = root.findViewById(R.id.buttonTutorial);
        textView = root.findViewById(R.id.tutorialPage1NextStep);

        button.setOnClickListener(view ->
        {
            startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(TutorialFragmentPage1.this)
                        .navigate(R.id.action_nav_TutorialPage1_to_nav_TutorialPage2);
            }
        });



        return root;
    }





}
