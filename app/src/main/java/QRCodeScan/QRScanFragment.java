package QRCodeScan;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import com.journeyapps.barcodescanner.CaptureActivity;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;
import at.example.firealertbachmann.R;
import at.example.firealertbachmann.databinding.FragmentQrscanBinding;
import at.example.firealertbachmann.ui.Person.PersonListService;
import blazing.chain.LZSEncoding;

public class QRScanFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        FragmentQrscanBinding binding = FragmentQrscanBinding.inflate(inflater, container, false);

        View root = binding.getRoot();
        Button btn_scan = root.findViewById(R.id.btn_scan);

        // Starting Scanning
        btn_scan.setOnClickListener(v->
        {
            scanCode();
        });
        return root;
    }

    // Scan options for QR scanner
    private void scanCode() {
        ScanOptions options = new ScanOptions();
        options.setPrompt("Volume up to flash on");
        options.setBeepEnabled(true);
        options.setOrientationLocked(false);
        options.setCaptureActivity(CaptureActivity.class);
        barLauncher.launch(options);
    };

    // Launching scanner
    ActivityResultLauncher<ScanOptions> barLauncher = registerForActivityResult(new ScanContract(), result ->
    {
        if(result.getContents() != null){
            AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
            builder.setTitle("Result");
            PersonListService.getInstance().clearList();
            //Messagebox
            builder.setMessage("QR Code wurde erfolgreich gescannt.");

            String[] peopleArray = LZSEncoding.decompress(result.getContents()).split(";");
            for (String people: peopleArray) {

                String[] personResult = people.split(",");
                PersonListService.getInstance().addPerson(personResult[0], personResult[1]);
            }

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).show();
        }
    });
}
