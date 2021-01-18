package com.kem.hotelharrisonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kem.hotelharrisonapp.retorfit.HotelHarrisonClient;
import com.kem.hotelharrisonapp.retorfit.HotelHarrisonService;
import com.kem.hotelharrisonapp.retorfit.request.RequestLogin;
import com.kem.hotelharrisonapp.retorfit.response.ResponseProfile;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLogin, btnBack;
    TextView tvGoSignUp;
    EditText edEmail, edPassword;
    HotelHarrisonClient hotelHarrisonClient;
    HotelHarrisonService hotelHarrisonService;
    //    llamando a la clase que configuramos shared
    private SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Objects.requireNonNull(getSupportActionBar()).hide();
        retrofitInit();
        findViews();
        events();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoBack();
            }
        });

    }


    private void retrofitInit() {
        hotelHarrisonClient = HotelHarrisonClient.getInstance();
        hotelHarrisonService = hotelHarrisonClient.getHotelHarrisonService();

    }

    private void events() {
        btnLogin.setOnClickListener(this);
        tvGoSignUp.setOnClickListener(this);
    }

    private void findViews() {
        edEmail = findViewById(R.id.tv_email);
        edPassword = findViewById(R.id.tv_password);
        btnLogin = findViewById(R.id.btn_login);
        tvGoSignUp = findViewById(R.id.tv_goSignUp);
        btnBack = findViewById(R.id.btn_back);
        preferences = getSharedPreferences("Preferencias", MODE_PRIVATE);

    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_login:
                doToLogin();
                break;
            case R.id.tv_goSignUp:
                goToSignUp();
                break;
        }
    }

    private void doToLogin() {
        String email = edEmail.getText().toString();
        String password = edPassword.getText().toString();

        if (email.isEmpty()) {
            edEmail.setError("Correo requerido");

        } else if (password.isEmpty()) {
            edPassword.setError("Contraseña requerida");

        } else {
            RequestLogin requestLogin = new RequestLogin(email, password);
            Call<ResponseProfile> call = hotelHarrisonService.doLogin(requestLogin);
            System.out.println(call);
            call.enqueue(new Callback<ResponseProfile>() {
                @Override
                public void onResponse(Call<ResponseProfile> call, Response<ResponseProfile> response) {
                    if (response.isSuccessful()) {

                        assert response.body().getValido();
                        SharedPreferences.Editor editor = preferences.edit()
                                .putInt("id", response.body().getHuesped().getId())
                                .putString("nombre", response.body().getHuesped().getNombre())
                                .putString("apellido", response.body().getHuesped().getApellido())
                                .putString("correo", response.body().getHuesped().getCorreo())
                                .putString("telefono", response.body().getHuesped().getTelefono());
                        editor.commit();

                        startActivity(new Intent(LoginActivity.this, DashboardActivity.class));

                        Toast.makeText(LoginActivity.this, "Usuario" + response.body().getHuesped().getNombre() + " inicio satisfactoriamente", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Huno un error, revise bien sus datos", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponseProfile> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, "Problemas de conexion. Intentelo de nuevo", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void goToSignUp() {
        Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(i);
        finish();
    }

    private void gotoBack() {
        Intent i = new Intent(LoginActivity.this, HallActivity.class);
        startActivity(i);
        finish();
    }


}

