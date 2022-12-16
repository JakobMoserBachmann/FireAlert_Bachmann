package com.example.trytoprogramm.ui.NFC_Scan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.trytoprogramm.databinding.FragmentNfcscanBinding;

public class NFC_ScanFragment extends Fragment {

    private FragmentNfcscanBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NFC_ScanViewModel NFCScanViewModel =
                new ViewModelProvider(this).get(NFC_ScanViewModel.class);

        binding = FragmentNfcscanBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}