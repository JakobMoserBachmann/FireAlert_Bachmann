package at.example.firealertbachmann.ui.NfcScan;

import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.MifareClassic;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.google.android.material.snackbar.Snackbar;
import java.io.IOException;
import at.example.firealertbachmann.MainActivity;
import at.example.firealertbachmann.R;
import at.example.firealertbachmann.databinding.FragmentNfcscanBinding;
import cdflynn.android.library.checkview.CheckView;

public class NfcScanFragment extends Fragment {

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

        button = root.findViewById(R.id.nfc_scan_button);
        check = root.findViewById(R.id.check);

        progressbar.setVisibility(View. INVISIBLE);


        button.setOnClickListener(view ->
        {
            startSearch = true;
            btnCount++;

            if (btnCount%2 == 1)
            {
                button.setText("Stop NFC Scan");
                ((MainActivity)getActivity()).startNFC();
                setProgressGIF();

                //Snackbar erstellen
                Snackbar snackbar = Snackbar.make(view, "NFC Scan ist gestartet", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
            else if(btnCount%2 == 0)
            {
                button.setText("Start NFC Scan");
                ((MainActivity)getActivity()).stopNFC();
                stopGIF();
                CreateSnackBarButton(view);
            }
        });
        return root;
    }


    public void processNFC(Intent intent) {
        Log.v("HALLO", "''#############");
        Tag tagFromIntent = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);

        MifareClassic mifareClassic = MifareClassic.get(tagFromIntent);
        if (mifareClassic != null) {
            try {
                mifareClassic.connect();
                mifareClassic.authenticateSectorWithKeyA(4, new byte[]{0x6d, 0x4b, 0x00, 0x00, 0x01, 0x43});
                byte[] bytes = mifareClassic.readBlock(16);

                String keyNumber = new String(bytes); // Das hier ist die gesuchte Schlüsselnummer

                String KeyNumberShort = keyNumber.substring(keyNumber.length() - 6);
                Log.v("KeyNumber", KeyNumberShort.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

            setCheckGIF();
            //GIF Timer
            Handler handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 1) {
                    setProgressGIF();
                }
            }
        };
        handler.sendEmptyMessageDelayed(1, 1000);


    } else  {
            // kein MIFARE Classic NFC Tag
        }
    }

    private void setProgressGIF()
    {
        check.setVisibility(View.INVISIBLE);
        progressbar.setVisibility(View.VISIBLE);
    }
    private void setCheckGIF()
    {
        progressbar.setVisibility(View.INVISIBLE);
        check.setVisibility(View.VISIBLE);
        check.check();
    }
    private void stopGIF()
    {
        check.setVisibility(View.INVISIBLE);
        progressbar.setVisibility(View.INVISIBLE);
    }

    private void CreateSnackBarButton(View view)
    {
        Snackbar snackbar = Snackbar.make(view, "Info", Snackbar.LENGTH_LONG);
        snackbar.setAction(R.string.snackbar_button, new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                NavHostFragment.findNavController(NfcScanFragment.this)
                        .navigate(R.id.nav_People);
            }
        });
        snackbar.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}