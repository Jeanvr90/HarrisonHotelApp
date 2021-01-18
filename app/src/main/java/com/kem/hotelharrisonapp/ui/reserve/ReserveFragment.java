package com.kem.hotelharrisonapp.ui.reserve;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.kem.hotelharrisonapp.R;
import com.kem.hotelharrisonapp.model.Reserva;
import com.kem.hotelharrisonapp.retorfit.response.ReservaByUser;
import com.kem.hotelharrisonapp.ui.adapter.AdapterHistorial;

import java.util.ArrayList;
import java.util.List;

public class ReserveFragment extends Fragment {
    private SharedPreferences preferences;
    private ReserveViewModel mViewModel;
    RecyclerView recyclerView;
    AdapterHistorial historiaAdapter;
    int usuario_id;
    TextView info_historial;


    public static ReserveFragment newInstance() {
        return new ReserveFragment();
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.reserve_fragment, container, false);
        init(v);
        getValue();

        mViewModel = new ViewModelProvider(this).get(ReserveViewModel.class);

        mViewModel.getReservaHistorial(usuario_id);


        historiaAdapter = new AdapterHistorial();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(historiaAdapter);
        if (recyclerView.isActivated()) {


        }
        cargarInfo();
        return v;
    }

    private void cargarInfo() {

        mViewModel.reservaMutable.observe(getViewLifecycleOwner(), new Observer<List<Reserva>>() {
            @Override
            public void onChanged(List<Reserva> reservas) {
                info_historial.setText("");
                historiaAdapter.setList(reservas);
            }
        });
    }

    private void getValue() {
        usuario_id = preferences.getInt("id", 0);
    }

    private void init(View v) {
        recyclerView = v.findViewById(R.id.recyclerHistorial);
        preferences = v.getContext().getSharedPreferences("Preferencias", Context.MODE_PRIVATE);
        info_historial = v.findViewById(R.id.info_historial);
    }


}