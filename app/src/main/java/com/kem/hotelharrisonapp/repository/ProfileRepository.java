package com.kem.hotelharrisonapp.repository;

import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.kem.hotelharrisonapp.commons.MyApp;
import com.kem.hotelharrisonapp.retorfit.HotelHarrisonClient;
import com.kem.hotelharrisonapp.retorfit.HotelHarrisonService;
import com.kem.hotelharrisonapp.retorfit.response.ResponseProfile;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileRepository {

    HotelHarrisonClient hotelHarrisonClient;
    HotelHarrisonService hotelHarrisonService;
    MutableLiveData<ResponseProfile> responseLoginMutableLiveData;

    public ProfileRepository() {
        hotelHarrisonClient = HotelHarrisonClient.getInstance();
        hotelHarrisonService = hotelHarrisonClient.getHotelHarrisonService();
        responseLoginMutableLiveData = getProfile();

    }

    public MutableLiveData<ResponseProfile> getProfile() {
        if (responseLoginMutableLiveData == null) {
            responseLoginMutableLiveData = new MutableLiveData<>();
        }

        Call<ResponseProfile> call = hotelHarrisonService.getProfile();
        call.enqueue(new Callback<ResponseProfile>() {
            @Override
            public void onResponse(Call<ResponseProfile> call, Response<ResponseProfile> response) {
                if (response.isSuccessful()) {
                    System.out.println(response.body());
                    responseLoginMutableLiveData.setValue(response.body());
                } else {
                }
            }

            @Override
            public void onFailure(Call<ResponseProfile> call, Throwable t) {
            }
        });
        return responseLoginMutableLiveData;

    }
}
