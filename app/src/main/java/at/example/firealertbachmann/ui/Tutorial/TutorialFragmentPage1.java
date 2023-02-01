package at.example.firealertbachmann.ui.Tutorial;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import at.example.firealertbachmann.R;
import at.example.firealertbachmann.databinding.FragmentTutorialPage1Binding;

public class TutorialFragmentPage1 extends Fragment
{
    Button button;
    private FragmentTutorialPage1Binding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        binding = FragmentTutorialPage1Binding.inflate(inflater, container, false);

        View root = binding.getRoot();

        button = root.findViewById(R.id.buttonTutorial);


        button.setOnClickListener(view ->
        {
            startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
        });

        return root;
    }




}
