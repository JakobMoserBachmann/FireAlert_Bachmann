package at.example.firealertbachmann.ui.Person;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import at.example.firealertbachmann.CaptureAct;
import at.example.firealertbachmann.R;
import at.example.firealertbachmann.databinding.FragmentQrscanBinding;

public class QRScanFragment extends Fragment {

    Button btn_scan;
    private FragmentQrscanBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = FragmentQrscanBinding.inflate(inflater, container, false);

        View root = binding.getRoot();
        btn_scan = root.findViewById(R.id.btn_scan);
        btn_scan.setOnClickListener(v->
        {
            scanCode();
        });
        return root;
    }

    private void scanCode() {
        ScanOptions options = new ScanOptions();
        options.setPrompt("Volume up to flash on");
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);
        options.setCaptureActivity(CaptureAct.class);
        barLauncher.launch(options);
    };

    ActivityResultLauncher<ScanOptions> barLauncher = registerForActivityResult(new ScanContract(), result ->
    {
        if(result.getContents() != null){
            AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
            builder.setTitle("Result");
            builder.setMessage(result.getContents());
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).show();
        }
    });

}
