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
import at.example.firealertbachmann.databinding.FragmentTutorialPage4Binding;

public class TutorialFragmentPage4 extends Fragment
{
    private FragmentTutorialPage4Binding binding;
    TextView textviewNextStep;
    TextView textViewPreviousStep;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        binding = FragmentTutorialPage4Binding.inflate(inflater, container, false);

        View root = binding.getRoot();
        textviewNextStep = root.findViewById(R.id.tutorialPag4NextStep);
        textViewPreviousStep = root.findViewById(R.id.tutorialPage4PreviousStep);

        textviewNextStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(TutorialFragmentPage4.this)
                        .navigate(R.id.action_nav_TutorialPage4_to_nav_NfcScanFragment);
            }
        });

        textViewPreviousStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(TutorialFragmentPage4.this)
                        .navigate(R.id.action_nav_TutorialPage4_to_nav_TutorialPage3);
            }
        });
        return root;
    }
}
