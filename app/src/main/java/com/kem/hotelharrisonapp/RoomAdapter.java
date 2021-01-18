package com.kem.hotelharrisonapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.kem.hotelharrisonapp.commons.Constantes;
import com.kem.hotelharrisonapp.retorfit.response.ResponseRoom;

import java.util.ArrayList;
import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomViewHolder> {


    Context context;
    List<ResponseRoom> rooms = new ArrayList<>();

    public RoomAdapter(Context context) {
        this.context = context;
    }

    public RoomAdapter(Context context, List<ResponseRoom> rooms) {
        this.context = context;
        this.rooms = rooms;
    }

    public void setList(List<ResponseRoom> list) {
        this.rooms = list;
        notifyDataSetChanged();

    }


    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rooms_list, parent, false);
        return new RoomViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return rooms.size();
    }

    @Override
    public void onBindViewHolder(@NonNull RoomViewHolder holder, int position) {
        ResponseRoom room = rooms.get(position);


        holder.btnInfo.setOnClickListener(view -> {
            Intent intent = new Intent(context, RoomDetailActivity.class);
            intent.putExtra(Constantes.EXTRA_AVATAR, room.getImagen());
            intent.putExtra(Constantes.EXTRA_NAME, room.getNombre());
            intent.putExtra(Constantes.EXTRA_STATUS, room.getEstado().toLowerCase());
            intent.putExtra(Constantes.EXTRA_DESCRIPTION, room.getDescripcion().toLowerCase());
            intent.putExtra(Constantes.EXTRA_TYPO_ROOM_NAME, room.getTipoHabitacion().getNombre().toLowerCase());
            intent.putExtra(Constantes.EXTRA_NRO, room.getTipoHabitacion().getNroCamas().toString());
            intent.putExtra(Constantes.EXTRA_PRICE, room.getTipoHabitacion().getPrecio().toString());
            intent.putExtra(Constantes.EXTRA_ID, room.getId().toString());
            context.startActivity(intent);
        });

        Glide.with(context)
                .load(room.getImagen())
                .into(holder.ivPhoto);

        String name = context.getString(R.string.txt_title, room.getNombre());
        String price = context.getString(R.string.txt_price, room.getTipoHabitacion().getPrecio().toString());
        String description = context.getString(R.string.txt_description, room.getDescripcion());
        String number = context.getString(R.string.txt_number, room.getTipoHabitacion().getNroCamas().toString());

        holder.tvName.setText(name);
        holder.tvDescription.setText(description);
        holder.tvPrice.setText(price);
        holder.tvNumber.setText(number);
    }


}
