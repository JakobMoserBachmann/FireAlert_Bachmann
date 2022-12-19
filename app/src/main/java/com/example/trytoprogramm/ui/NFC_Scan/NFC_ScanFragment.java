package com.example.trytoprogramm.ui.NFC_Scan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.trytoprogramm.R;
import com.example.trytoprogramm.databinding.FragmentNfcscanBinding;
import com.google.android.material.snackbar.Snackbar;

import cdflynn.android.library.checkview.CheckView;

public class NFC_ScanFragment extends Fragment {

    private FragmentNfcscanBinding binding;
    CheckView check;
    Button button;
    ProgressBar progressbar;
    Boolean startSearch = false;
    Integer btnCount = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,Bundle savedInstanceState) {

        binding = FragmentNfcscanBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        progressbar = root.findViewById(R.id.progressBar);
        //Button finden
        button = root.findViewById(R.id.nfc_scan_button);
        check = root.findViewById(R.id.check);

        //Loading bar invisible machen
        progressbar.setVisibility(View. INVISIBLE);
        //Button text ändern
        button.setText("Start NFC Scan");


        //Button on Click
        button.setOnClickListener(view ->
        {
            startSearch = true;
            btnCount++;

            // wenn btnCount ungerade ist (startwert = 0)
            if (btnCount%2 == 1)
            {
                progressbar. setVisibility(View. VISIBLE);
                check.setVisibility(View.INVISIBLE);

                button.setText("Stop NFC Scan");
            }
            // wenn btnCount gerade ist
            else if(btnCount%2 == 0)
            {
                progressbar.setVisibility(View. INVISIBLE);
                button.setText("Start NFC Scan");

                check.setVisibility(View.VISIBLE);
                check.check();

                Snackbar snackbar = Snackbar.make(view, "Go to Missing", Snackbar.LENGTH_LONG);
                snackbar.setAction(R.string.do_string, new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        NavHostFragment.findNavController(NFC_ScanFragment.this)
                                .navigate(R.id.nav_nfcScan);
                    }
                });
                snackbar.show();
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}