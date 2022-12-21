package at.example.firealertbachmann.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.google.android.material.snackbar.Snackbar;
import at.example.firealertbachmann.R;
import at.example.firealertbachmann.databinding.FragmentHomeBinding;
import cdflynn.android.library.checkview.CheckView;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    CheckView check;
    Button button;
    ProgressBar progressbar;
    Boolean startSearch = false;
    Integer btnCount = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        progressbar = root.findViewById(R.id.progressBar);

        button = root.findViewById(R.id.nfc_scan_button);
        check = root.findViewById(R.id.check);

        progressbar.setVisibility(View. INVISIBLE);

        button.setText("Start NFC Scan");

        button.setOnClickListener(view ->
        {
            startSearch = true;
            btnCount++;

            if (btnCount%2 == 1)
            {
                check.setVisibility(View.INVISIBLE);
                progressbar. setVisibility(View. VISIBLE);
                check.setVisibility(View.INVISIBLE);
                Snackbar snackbar = Snackbar.make(view, "NFC Scan ist gestartet", Snackbar.LENGTH_LONG);
                snackbar.show();

                button.setText("Stop NFC Scan");
            }
            else if(btnCount%2 == 0)
            {
                progressbar.setVisibility(View. INVISIBLE);
                button.setText("Start NFC Scan");

                check.setVisibility(View.VISIBLE);
                check.check();

                Snackbar snackbar = Snackbar.make(view, "Info", Snackbar.LENGTH_LONG);
                snackbar.setAction(R.string.do_string, new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        NavHostFragment.findNavController(HomeFragment.this)
                                .navigate(R.id.nav_slideshow);
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