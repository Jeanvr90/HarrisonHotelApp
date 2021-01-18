package com.kem.hotelharrisonapp.ui.FormReserva;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.kem.hotelharrisonapp.DashboardActivity;
import com.kem.hotelharrisonapp.R;
import com.kem.hotelharrisonapp.RoomDetailActivity;


public class ResumenReservaFragment extends Fragment {
    private SharedPreferences preferences;
    TextView texto_final;
    String texto;
    Button buttonClose;
    int preciototal, diferenciadepago;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_resumen_reserva, container, false);
        texto_final = v.findViewById(R.id.description_final);
        buttonClose=v.findViewById(R.id.fragment_btn_cerrar_resumen);
        preferences = this.getActivity().getSharedPreferences("Preferencias", Context.MODE_PRIVATE);

        preciototal = preferences.getInt("total_a_pagar", 0);
        Toast.makeText(getContext(), String.valueOf(preciototal), Toast.LENGTH_SHORT).show();
        diferenciadepago = preciototal / 2;
        String te = getString(R.string.description_final, "%( ".concat(String.valueOf(diferenciadepago)).concat(".00) "));
        texto_final.setText(te);


        buttonClose.setOnClickListener(view -> {
            Intent intent = new Intent(getContext(), DashboardActivity.class);
            startActivity(intent);
        });
        return v;
    }
}