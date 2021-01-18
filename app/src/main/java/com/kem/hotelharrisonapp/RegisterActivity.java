package com.kem.hotelharrisonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kem.hotelharrisonapp.retorfit.HotelHarrisonClient;
import com.kem.hotelharrisonapp.retorfit.HotelHarrisonService;
import com.kem.hotelharrisonapp.retorfit.request.RequestRegister;
import com.kem.hotelharrisonapp.retorfit.response.ResponseProfile;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSignUp;
    TextView tvGoLogin;
    EditText edName, edLastName, edEmail, edPassword;
    HotelHarrisonClient hotelHarrisonClient;
    HotelHarrisonService hotelHarrisonService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Objects.requireNonNull(getSupportActionBar()).hide();
        retrofitInit();
        findViews();
        events();

    }

    private void retrofitInit() {
        hotelHarrisonClient = HotelHarrisonClient.getInstance();
        hotelHarrisonService = hotelHarrisonClient.getHotelHarrisonService();
    }

    private void events() {
        btnSignUp.setOnClickListener(this);
        tvGoLogin.setOnClickListener(this);
    }

    private void findViews() {
        btnSignUp = findViewById(R.id.btn_register);
        tvGoLogin = findViewById(R.id.tv_goLogin);
        edName = findViewById(R.id.ed_name);
        edLastName = findViewById(R.id.ed_last_name);
        edEmail = findViewById(R.id.ed_email);
        edPassword = findViewById(R.id.ed_password);
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        switch (id) {
            case R.id.btn_register:
                if (TextUtils.isEmpty(edName.getText().toString().trim()) ||
                        TextUtils.isEmpty(edLastName.getText().toString().trim()) ||
                        TextUtils.isEmpty(edEmail.getText().toString().trim()) ||
                        TextUtils.isEmpty(edPassword.getText().toString().trim())
                ) {
                    Toast.makeText(RegisterActivity.this, "Todo los Campos son Oblitarios", Toast.LENGTH_SHORT).show();
                } else {
                    goToSignUp();
                }
                break;
            case R.id.tv_goLogin:
                goToLogin();
                break;
        }
    }

    private void goToLogin() {
        Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(i);
        finish();
    }

    private void goToSignUp() {
        String name = edName.getText().toString();
        String lastName = edLastName.getText().toString();
        String email = edEmail.getText().toString();
        String password = edPassword.getText().toString();

        //instanciamos new Objeto y enviaremos
        // los valores capturados de los inputs
        RequestRegister request = new RequestRegister();
        request.setNombre(name);
        request.setApellido(lastName);
        request.setCorreo(email);
        request.setPassword(password);

        Call<ResponseProfile> responseCall = hotelHarrisonService.doRegister(request);
        responseCall.enqueue(new Callback<ResponseProfile>() {
            @Override
            public void onResponse(Call<ResponseProfile> call, Response<ResponseProfile> response) {
                if(response.isSuccessful()){
                    System.out.println("esto es el mensaje "+response.body().getMensaje());
                    Toast.makeText(RegisterActivity.this, "Registro Exitoso", Toast.LENGTH_SHORT).show();
                    cleanInputs();
                } else {
                    Toast.makeText(RegisterActivity.this, "Error al Registrar", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseProfile> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Thorwable : " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void cleanInputs() {
        edName.setText("");
        edLastName.setText("");
        edEmail.setText("");
        edPassword.setText("");
    }

}