package com.kem.hotelharrisonapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.kem.hotelharrisonapp.commons.Constantes;
import com.kem.hotelharrisonapp.ui.FormReserva.FormReservaActivity;

import java.util.Objects;

import static com.kem.hotelharrisonapp.commons.Constantes.EXTRA_ID;
import static com.kem.hotelharrisonapp.commons.Constantes.EXTRA_NRO;
import static com.kem.hotelharrisonapp.commons.Constantes.EXTRA_PRICE;

public class RoomDetailActivity extends AppCompatActivity {
    private SharedPreferences preferences;
    Button btnLogin;
    TextView title_logearse;
    String avatar, name, description, nameTypo, nroTypo, priceTypo;
    String id_room;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms_detail);
        findView();
        loadExtras();
        loadViews();
        Objects.requireNonNull(getSupportActionBar()).hide();

        valideSession();
    }

    private void loadExtras() {
        avatar = getIntent().getStringExtra(Constantes.EXTRA_AVATAR);
        name = getIntent().getStringExtra(Constantes.EXTRA_NAME);
        description = getIntent().getStringExtra(Constantes.EXTRA_DESCRIPTION);
        nameTypo = getIntent().getStringExtra(Constantes.EXTRA_TYPO_ROOM_NAME);
        nroTypo = getIntent().getStringExtra(EXTRA_NRO);
        priceTypo = getIntent().getStringExtra(EXTRA_PRICE);
        id_room = getIntent().getStringExtra(EXTRA_ID);

    }

    private void loadViews() {
        ImageView ivAvatar = findViewById(R.id.iv_avatar_detail);
        Glide.with(this)
                .load(avatar)
                .into(ivAvatar);

        TextView tvDescription = findViewById(R.id.txt_description_room_detail);
        tvDescription.setText(description);
        TextView tvNameTypo = findViewById(R.id.txt_typo_room_name_detail);
        tvNameTypo.setText(nameTypo.toUpperCase());
        TextView tvNroTypo = findViewById(R.id.txt_typo_room_nro_detail);
        tvNroTypo.setText(nroTypo);
        title_logearse = findViewById(R.id.tv_list_description);
        TextView tvPrice = findViewById(R.id.txt_typo_room_price_detail);
        tvPrice.setText(priceTypo);
        btnLogin = findViewById(R.id.btn_goToLogin);
    }

    private void findView() {
        preferences = getSharedPreferences("Preferencias", MODE_PRIVATE);
    }

    private void buttonLoginEvent() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }


    @SuppressLint({"ResourceAsColor"})
    private void valideSession() {
        int usuario_id = preferences.getInt("id", 0);

        if (usuario_id > 0) {
            btnLogin.setText("reservar");
            title_logearse.setText("");
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    validarFechaExistente();

                }
            });

        } else {
            btnLogin.setText("logearse");
            title_logearse.setText(R.string.list_log_desc);
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buttonLoginEvent();
                }
            });
        }

    }

    private void validarFechaExistente() {
        int total_dias_hospedados = preferences.getInt("total_dias_hospedados", 0);

        if (total_dias_hospedados > 0) {
            SharedPreferences.Editor editor =
                    preferences.edit().putString("precio_cama", priceTypo)
                            .putString("description_cama", description)
                            .putString("numero_cama", nroTypo)
                            .putString("id_room", id_room)
                            .putString("tipo_cuarto", nameTypo);
            editor.commit();
            Intent intent = new Intent(RoomDetailActivity.this, FormReservaActivity.class);
            startActivity(intent);
            Toast.makeText(getApplication(), "nos vamos al formulario de reserva por que elijio su fecha", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplication(), "No a selecionado Ninguna fecha de estadia", Toast.LENGTH_LONG).show();
        }
    }
}
