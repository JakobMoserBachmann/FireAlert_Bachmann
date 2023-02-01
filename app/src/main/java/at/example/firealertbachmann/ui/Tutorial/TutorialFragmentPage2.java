package at.example.firealertbachmann.ui.Tutorial;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import at.example.firealertbachmann.R;
import at.example.firealertbachmann.databinding.FragmentTutorialPage2Binding;


public class TutorialFragmentPage2 extends Fragment
{
    TextView textviewNextStep;
    TextView textViewPreviousStep;
    private FragmentTutorialPage2Binding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        binding = FragmentTutorialPage2Binding.inflate(inflater, container, false);

        View root = binding.getRoot();
        textviewNextStep = root.findViewById(R.id.tutorialPage2NextStep);
        textViewPreviousStep = root.findViewById(R.id.tutorialPage2PreviousStep);

        textviewNextStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(TutorialFragmentPage2.this)
                        .navigate(R.id.action_nav_TutorialPage2_to_nav_TutorialPage3);
            }
        });

        textViewPreviousStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(TutorialFragmentPage2.this)
                        .navigate(R.id.action_nav_TutorialPage2_to_nav_TutorialPage1);
            }
        });



        return root;
    }
}
