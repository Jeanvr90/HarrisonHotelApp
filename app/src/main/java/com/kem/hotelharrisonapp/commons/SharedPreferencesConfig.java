package com.kem.hotelharrisonapp.commons;

import android.content.Context;
import android.content.SharedPreferences;

import com.kem.hotelharrisonapp.R;

public class SharedPreferencesConfig {


    public void guardar(Context ctx, String name, Boolean value) {
        SharedPreferences s = ctx.getSharedPreferences("clipcodea", Context.MODE_PRIVATE);
        SharedPreferences.Editor edt = s.edit();
        edt.putBoolean(name, value);
        edt.apply();
    }

    public static String read(Context context,String name,boolean defaultValue){
        SharedPreferences s = context.getSharedPreferences("clipcodea",Context.MODE_PRIVATE);

        return s.getString(name, String.valueOf(defaultValue));
    }



}
