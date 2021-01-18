package com.kem.hotelharrisonapp.retorfit;

import com.kem.hotelharrisonapp.commons.Constantes;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HotelHarrisonClient {

    private static HotelHarrisonClient hotelHarrisonClient = null;
    private HotelHarrisonService hotelHarrisonService;
    private Retrofit retrofit;

    public HotelHarrisonClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Constantes.API_HOTELHARRISON_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        hotelHarrisonService = retrofit.create(HotelHarrisonService.class);
    }

    public static  HotelHarrisonClient getInstance(){
        if (hotelHarrisonClient==null){
            hotelHarrisonClient=new HotelHarrisonClient();
        }
        return hotelHarrisonClient;

    }

    public HotelHarrisonService getHotelHarrisonService(){
        return hotelHarrisonService;
    }
}
