package at.example.firealertbachmann.ui.Person;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
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
import blazing.chain.LZSEncoding;

public class QRScanFragment extends Fragment {

    // Button to activate QR Scanner
    Button btn_scan;
    private FragmentQrscanBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        binding = FragmentQrscanBinding.inflate(inflater, container, false);

        View root = binding.getRoot();
        btn_scan = root.findViewById(R.id.btn_scan);

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
        options.setOrientationLocked(true);
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
            builder.setMessage(LZSEncoding.decompress(result.getContents()));
            String rawPeople = LZSEncoding.decompress(result.getContents());
            String[] peopleArray = rawPeople.split(";");

            for (String people: peopleArray) {


                Person newPerson = new Person();
                String[] personResult = people.split(",");
                Log.v("Person---> ", personResult[0]);
                Log.v("PersonKeynumber---> ", personResult[1]);
                newPerson.Name = personResult[0];
                newPerson.KeyNumber = personResult[1];
                PersonListService.getInstance().addPerson(newPerson);

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
