package com.kem.hotelharrisonapp.ui.account;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.kem.hotelharrisonapp.repository.ProfileRepository;
import com.kem.hotelharrisonapp.retorfit.response.ResponseProfile;

public class AccountViewModel extends AndroidViewModel {
    public ProfileRepository profileRepository;

    public MutableLiveData<ResponseProfile> responseProfileMutableLiveData;

    public AccountViewModel(@NonNull Application application) {
        super(application);
        profileRepository = new ProfileRepository();
        responseProfileMutableLiveData = profileRepository.getProfile();
    }
}