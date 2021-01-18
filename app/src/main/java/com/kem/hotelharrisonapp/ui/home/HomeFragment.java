package com.kem.hotelharrisonapp.ui.home;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.kem.hotelharrisonapp.R;
import com.kem.hotelharrisonapp.RoomAdapter;
import com.kem.hotelharrisonapp.retorfit.response.ResponseRoom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class HomeFragment extends Fragment {

    private SharedPreferences preferences;
    CardView card_fecha_inicio, card_fecha_final;
    String MES[] = {"ENE", "FEB", "MAR", "ABR", "MAY", "JUN", "JUL", "AGO", "SEP", "OCT", "NOV", "DIC"};
    int c_ninos, c_adultos;

    //    vistas
    TextView tv_dia_inicio, tv_dia_final;
    TextView tv_mes_inicio, tv_mes_final;
    TextView tv_year_inicio, tv_year_final;
//    EditText f_inicio, f_final, cant_adultos, cant_ninos;

    //    para fechas
    private int dia_inicio, mes_inicio, año_inicio;
    private int dia_final, mes_final, año_final;
    String strfechaInicio, strfechaFinal;
    int calculardia1 = 0, calculardia2 = 0, total_dias;
    Calendar calendar = Calendar.getInstance();
    DatePickerDialog picker;


    //    Botones
    private MaterialButton mPickDateButton;
//    ImageButton btn_aumentar_nino, btn_aumentar_adulto;
//    ImageButton btn_desminuir_nino, btn_disminuir_adulto;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.fragment_home, container, false);
        init(view);
        initButtons();


        mPickDateButton.setOnClickListener(v ->
                {
                    SharedPreferences.Editor editor;
                    if (calculardia1 > 0 && calculardia2 == 0 || strfechaInicio == null && strfechaFinal == null) {
                        Toast.makeText(getContext(), "Es necesario las dos fechas", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        total_dias = calculardia2 - calculardia1;
                        editor = preferences.edit().putInt("total_dias_hospedados", total_dias)
                                .putString("fecha_inicial", strfechaInicio)
                                .putString("fecha_final", strfechaFinal)
                        ;
                    }
                    editor.commit();


//                    remplazar este fragment por otro fragment
                    RoomListFragment roomListFragment = new RoomListFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.nav_host_fragment, roomListFragment).commit();

                }
        );

        return view;
    }

    private void initButtons() {


        card_fecha_inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dia_inicio = calendar.get(Calendar.DAY_OF_YEAR);
                mes_inicio = calendar.get(Calendar.MONTH);
                año_inicio = calendar.get(Calendar.YEAR);

                picker = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        if ((month + 1) < 10) {
                            strfechaInicio = (year + "-" + ("0" + (month + 1)) + "-" + dayOfMonth);
                        } else {
                            strfechaInicio = (year + "-" + (month + 1) + "-" + dayOfMonth);
                        }
                        calculardia1 = dayOfMonth;
                        enviarValoresFechaInicial(dayOfMonth, month, year);
                    }
                }, año_inicio, mes_inicio, dia_inicio);
                picker.getDatePicker().setMinDate(new Date().getTime());
                picker.show();
            }
        });

        card_fecha_final.setOnClickListener(v ->
                {
                    dia_final = calendar.get(Calendar.DAY_OF_YEAR);
                    mes_final = calendar.get(Calendar.MONTH);
                    año_final = calendar.get(Calendar.YEAR);
                    picker = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            if ((month + 1) < 10) {
                                strfechaFinal = (year + "-" + ("0" + (month + 1)) + "-" + dayOfMonth);
                            } else {
                                strfechaFinal = (year + "-" + (month + 1) + "-" + dayOfMonth);
                            }

                            calculardia2 = dayOfMonth;
                            enviarValoresFechaFinal(dayOfMonth, month, year);
                        }
                    }, año_final, mes_final, dia_final);
                    picker.getDatePicker().setMinDate(new Date().getTime());
                    picker.show();
                }

        );


//        btn_aumentar_nino.setOnClickListener(v -> {
//            int cant_input = Integer.parseInt(String.valueOf(cant_ninos.getText()));
//            c_ninos = cant_input + 1;
//            cant_ninos.setText(String.valueOf(c_ninos));
//        });
//
//        btn_desminuir_nino.setOnClickListener(v -> {
//            int cant_input = Integer.parseInt(String.valueOf(cant_ninos.getText()));
//            c_ninos = cant_input - 1;
//            if (c_ninos < 0) {
//                return;
//            }
//            cant_ninos.setText(String.valueOf(c_ninos));
//        });
//
//        btn_aumentar_adulto.setOnClickListener(v -> {
//            int cant_input = Integer.parseInt(String.valueOf(cant_adultos.getText()));
//            c_adultos = cant_input + 1;
//            cant_adultos.setText(String.valueOf(c_adultos));
//        });
//
//        btn_disminuir_adulto.setOnClickListener(v -> {
//            int cant_input = Integer.parseInt(String.valueOf(cant_adultos.getText()));
//            c_adultos = cant_input - 1;
//            if (c_adultos < 0) {
//                return;
//            }
//            cant_adultos.setText(String.valueOf(c_adultos));
//        });

    }


    void init(View view) {
        mPickDateButton = view.findViewById(R.id.pick_date_button);
        card_fecha_inicio = view.findViewById(R.id.card_calendar_inicio);
        card_fecha_final = view.findViewById(R.id.card_calendar_final);
        preferences = this.getActivity().getSharedPreferences("Preferencias", Context.MODE_PRIVATE);
        ;

        tv_dia_inicio = view.findViewById(R.id.home_dia_inicio);
        tv_mes_inicio = view.findViewById(R.id.home_mes_inicio);
        tv_year_inicio = view.findViewById(R.id.home_year_inicio);


        tv_dia_final = view.findViewById(R.id.home_dia_final);
        tv_mes_final = view.findViewById(R.id.home_mes_final);
        tv_year_final = view.findViewById(R.id.home_year_final);


//        cant_ninos = view.findViewById(R.id.cantidad_ninos);
//        cant_adultos = view.findViewById(R.id.cantidad_adultos);
//
////botones
//        btn_aumentar_nino = view.findViewById(R.id.btn_sumar_ninos);
//        btn_desminuir_nino = view.findViewById(R.id.btn_restar_ninos);
//        btn_disminuir_adulto = view.findViewById(R.id.btn_restar_adultos);
//        btn_aumentar_adulto = view.findViewById(R.id.btn_sumar_adultos);
    }


    public void enviarValoresFechaInicial(int dias, int mes, int year) {
        tv_mes_inicio.setText(MES[mes]);
        if (dias < 10) {
            tv_dia_inicio.setText("0" + String.valueOf(dias));
        } else {
            tv_dia_inicio.setText(String.valueOf(dias));
        }
        tv_year_inicio.setText(String.valueOf(year));
    }

    public void enviarValoresFechaFinal(int dias, int mes, int year) {
        tv_mes_final.setText(MES[mes]);
        if (dias < 10) {
            tv_dia_final.setText("0" + String.valueOf(dias));
        } else {
            tv_dia_final.setText(String.valueOf(dias));
        }
        tv_year_final.setText(String.valueOf(year));
    }


}