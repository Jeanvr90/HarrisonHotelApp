package com.kem.hotelharrisonapp.ui.home;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.kem.hotelharrisonapp.R;
import com.kem.hotelharrisonapp.RoomAdapter;
import com.kem.hotelharrisonapp.retorfit.response.ResponseRoom;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class RoomListFragment extends Fragment {

    String fecha_init;
    String fecha_final;
    private static final String[] STUFF = new String[]{"INDIVIDUAL", "QUEEN", "KING","MINI SUITE","MASTER SUITE"};

    private SharedPreferences preferences;

    HomeViewModel homeViewModel;
    RoomAdapter adapter;
    RecyclerView recyclerView;
    AutoCompleteTextView autoCompleteTextView;
    ImageView imageView;
    ImageButton btnFilter;



    String tipoCuarto = "";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        View view = inflater.inflate(R.layout.fragment_room_list, container, false);
        init(view);

        adapter = new RoomAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ViewModelRoom();

        ArrayAdapter<String> adp = new ArrayAdapter<String>(
                getContext(), android.R.layout.simple_dropdown_item_1line, STUFF
        );
        autoCompleteTextView.setAdapter(adp);

        initButtons();

        return view;
    }


    void init(View v) {
        preferences = v.getContext().getSharedPreferences("Preferencias", Context.MODE_PRIVATE);
        fecha_init = preferences.getString("fecha_inicial", null);
        fecha_final = preferences.getString("fecha_final", null);
        autoCompleteTextView = v.findViewById(R.id.autocomplete_room);
        imageView = v.findViewById(R.id.verInfo);
        homeViewModel.getRoomsByDate(fecha_init, fecha_final);
        recyclerView = v.findViewById(R.id.rv_fragment_rooms);
        btnFilter = v.findViewById(R.id.btnFilterRoom);
    }


    void initButtons() {

        imageView.setOnClickListener(v -> autoCompleteTextView.showDropDown());
        btnFilter.setOnClickListener(v -> {
            tipoCuarto = autoCompleteTextView.getText().toString();
            settingAnimation();
            ViewModelRoom();
        });
    }


    void ViewModelRoom() {
        homeViewModel.roomMutable.observe(getViewLifecycleOwner(), new Observer<List<ResponseRoom>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onChanged(List<ResponseRoom> responseRooms) {

                settingAnimation();
                List<ResponseRoom> newListroom = new ArrayList<>();
                newListroom = responseRooms.stream().filter(res -> res.getTipoHabitacion().getNombre().contains(tipoCuarto)
                ).collect(Collectors.toList());
                adapter.setList(newListroom);
            }
        });

        recyclerView.setAdapter(adapter);
    }

    void settingAnimation(){
        LayoutAnimationController layoutAnimationController = AnimationUtils.loadLayoutAnimation(getContext(),R.anim.layou_slide_right);
        recyclerView.setLayoutAnimation(layoutAnimationController);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();

    }

}