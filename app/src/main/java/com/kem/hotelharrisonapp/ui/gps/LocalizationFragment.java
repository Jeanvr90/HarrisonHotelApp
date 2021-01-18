package com.kem.hotelharrisonapp.ui.gps;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kem.hotelharrisonapp.R;

public class LocalizationFragment extends Fragment {

    private LocalizationViewModel mViewModel;

    public static LocalizationFragment newInstance() {
        return new LocalizationFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.localization_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LocalizationViewModel.class);
        // TODO: Use the ViewModel
    }

}