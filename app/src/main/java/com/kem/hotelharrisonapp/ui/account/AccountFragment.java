package com.kem.hotelharrisonapp.ui.account;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.kem.hotelharrisonapp.LoginActivity;
import com.kem.hotelharrisonapp.R;
import com.kem.hotelharrisonapp.RegisterActivity;
import com.kem.hotelharrisonapp.commons.SharedPreferencesConfig;
import com.kem.hotelharrisonapp.retorfit.response.ResponseProfile;

import java.util.Objects;

public class AccountFragment extends Fragment {

    private SharedPreferences preferences;

    private AccountViewModel accountViewModel;
    TextView edName, edLastName, edEmail, edPhone, edStatus;
    Button btnSalir;
    String name ="";
    String lastname ="";
    String email ="";
    String fono =null;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();


        accountViewModel = new ViewModelProvider(this).get(AccountViewModel.class);
        init();
        name=  preferences.getString("nombre",null);
        lastname=  preferences.getString("apellido",null);
        email=  preferences.getString("correo",null);
        fono=  preferences.getString("telefono",null);
        System.out.println("este es el valor viene desde el fragment + " + name);
    }


    private void init(){
        preferences = getContext().getSharedPreferences("Preferencias", Context.MODE_PRIVATE);
    }


    public void CerrarSession(){
        preferences.edit().clear().apply();
        Intent i = new Intent(getContext(), LoginActivity.class);
        startActivity(i);
    }


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.account_fragment, container, false);
        edName = view.findViewById(R.id.tv_name_account_fragment);
        edLastName = view.findViewById(R.id.tv_last_name_account_fragment);
        edEmail = view.findViewById(R.id.tv_email_account_fragment);
        edName = view.findViewById(R.id.tv_name_account_fragment);
        edPhone = view.findViewById(R.id.tv_phone_account_fragment);
        btnSalir =view.findViewById(R.id.btnLogout);
        edName.setText(name);
        edLastName.setText(lastname);
        edEmail.setText(email);
        if(fono ==null){
            edPhone.setText("numero no registrado");
        }else{
            edPhone.setText(fono);
        }


        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CerrarSession();
            }
        });
        accountViewModel.responseProfileMutableLiveData.observe(getActivity(), new Observer<ResponseProfile>() {
            @Override
            public void onChanged(@Nullable ResponseProfile responseProfile) {

            }
        });

        return view;
    }

    }
