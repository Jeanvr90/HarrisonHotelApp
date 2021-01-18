package com.kem.hotelharrisonapp.ui.FormReserva;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputEditText;
import com.kem.hotelharrisonapp.LoginActivity;
import com.kem.hotelharrisonapp.R;
import com.kem.hotelharrisonapp.RegisterActivity;
import com.kem.hotelharrisonapp.commons.Constantes;
import com.kem.hotelharrisonapp.model.Habitacion;
import com.kem.hotelharrisonapp.model.Huesped;
import com.kem.hotelharrisonapp.retorfit.HotelHarrisonClient;
import com.kem.hotelharrisonapp.retorfit.request.RequestReserva;
import com.kem.hotelharrisonapp.retorfit.response.ResponseReserva;
import com.kem.hotelharrisonapp.ui.home.RoomListFragment;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.kem.hotelharrisonapp.commons.Constantes.EXTRA_NRO;
import static com.kem.hotelharrisonapp.commons.Constantes.EXTRA_PRICE;

public class FormReservaActivity extends AppCompatActivity {

    private FormReservaViewModel viewModel;

    private SharedPreferences preferences;
    int usuario_id, calcular_total, nr_dias;

    String priceTypo, description, nameTypo, nroTypo,
            fecha_de_inicio, fecha_de_fin, room_id;

    TextView f_inicio, f_final, precio_inicial, n_camas,
            tipo_room, tvdescription, cant_dias, precio_total;

    TextInputEditText placa;
    MaterialCheckBox rbthabilitar;
    Button btnReservarFinal;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = getSharedPreferences("Preferencias", MODE_PRIVATE);

        setContentView(R.layout.activity_form_reserva);
        init();
        loadExtras();
        setvalues();
        viewModel = new ViewModelProvider(this).get(FormReservaViewModel.class);
        placa.setEnabled(false);
        initButtons();


    }


    private void initButtons() {

        rbthabilitar.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (buttonView.isChecked()) {
                placa.setEnabled(true);
            } else {
                placa.setEnabled(false);
            }
        });

        btnReservarFinal.setOnClickListener(v -> {

            int id_cuarto = Integer.parseInt(room_id);

            viewModel.registerReserva(usuario_id, id_cuarto, fecha_de_inicio,
                    fecha_de_fin, placa.getText().toString(), calcular_total);
            enviarReserva();
        });
    }


    void init() {
        preferences = getApplication().getSharedPreferences("Preferencias", Context.MODE_PRIVATE);
        f_inicio = findViewById(R.id.form_fecha_inicio);
        f_final = findViewById(R.id.form_fecha_final);
        precio_inicial = findViewById(R.id.form_tv_precio);
        precio_total = findViewById(R.id.form_precio_total);
        n_camas = findViewById(R.id.form_tv_cama_cantidad);
        tipo_room = findViewById(R.id.form_tipo_habitacion);
        tvdescription = findViewById(R.id.form_habitacion_descripcion);
        cant_dias = findViewById(R.id.form_tv_dia_cantidad);
        placa = findViewById(R.id.form_placa_vehiculo);
        rbthabilitar = findViewById(R.id.rbtEstaciomiento);
        btnReservarFinal = findViewById(R.id.form_btnFinalizarReserva);
        usuario_id = preferences.getInt("id", 0);
        room_id = preferences.getString("id_room", null);


    }

    private void loadExtras() {

        priceTypo = preferences.getString("precio_cama", null);
        description = preferences.getString("description_cama", null);
        nameTypo = preferences.getString("tipo_cuarto", null);
        nroTypo = preferences.getString("numero_cama", null);
        nr_dias = preferences.getInt("total_dias_hospedados", 0);
        fecha_de_inicio = preferences.getString("fecha_inicial", null);
        fecha_de_fin = preferences.getString("fecha_final", null);
    }


    void setvalues() {

        calcular_total = nr_dias * Integer.parseInt(priceTypo);
        SharedPreferences.Editor editor = preferences.edit().putInt("total_a_pagar", calcular_total);
        editor.commit();
        cant_dias.setText(String.valueOf(nr_dias));
        precio_inicial.setText(priceTypo);
        tvdescription.setText(description);
        tipo_room.setText(nameTypo);
        n_camas.setText(nroTypo);
        precio_total.setText(String.valueOf(calcular_total));
        f_inicio.setText(fecha_de_inicio);
        f_final.setText(fecha_de_fin);
    }


    void enviarReserva() {

        LinearLayout linearLayout = findViewById(R.id.linear_contenido);
        linearLayout.setVisibility(View.GONE);
        FragmentManager fm = getSupportFragmentManager();
        ResumenReservaFragment fragment = new ResumenReservaFragment();
        fm.beginTransaction().replace(R.id.container_resumen, fragment).commit();
        Toast.makeText(getApplicationContext(), "Reservado", Toast.LENGTH_SHORT).show();
    }


}

