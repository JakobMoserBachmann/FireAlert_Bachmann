package at.example.firealertbachmann.ui.Tutorial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import at.example.firealertbachmann.R;
import at.example.firealertbachmann.databinding.FragmentTutorialPage3Binding;

public class TutorialFragmentPage3 extends Fragment
{
    private FragmentTutorialPage3Binding binding;
    TextView textviewNextStep;
    TextView textViewPreviousStep;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        binding = FragmentTutorialPage3Binding.inflate(inflater, container, false);

        View root = binding.getRoot();
        textviewNextStep = root.findViewById(R.id.tutorialPage3NextStep);
        textViewPreviousStep = root.findViewById(R.id.tutorialPage3PreviousStep);

        textviewNextStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(TutorialFragmentPage3.this)
                        .navigate(R.id.action_nav_TutorialPage3_to_nav_TutorialPage4);
            }
        });

        textViewPreviousStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(TutorialFragmentPage3.this)
                        .navigate(R.id.action_nav_TutorialPage3_to_nav_TutorialPage2);
            }
        });
        return root;
    }
}
