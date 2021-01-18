package com.kem.hotelharrisonapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kem.hotelharrisonapp.R;
import com.kem.hotelharrisonapp.model.Reserva;
import com.kem.hotelharrisonapp.retorfit.response.ReservaByUser;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdapterHistorial extends RecyclerView.Adapter<AdapterHistorial.ViewHolder> {


    List<Reserva> listReservaHistorial = new ArrayList<>();


    public void setList(List<Reserva> lista) {
        this.listReservaHistorial = lista;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AdapterHistorial.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapterHistorial.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_historial_reserva, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull AdapterHistorial.ViewHolder holder, int position) {


        holder.fechaFinal.setText(listReservaHistorial.get(position).getFechaFinal());
        holder.fechaInicio.setText(listReservaHistorial.get(position).getFechaInicio());
        holder.tipodeHaticacion.setText(listReservaHistorial.get(position).getHabitacion().getTipoHabitacion().getNombre());
        holder.fechaReservada.setText(listReservaHistorial.get(position).getCreadoEn().toString());
        holder.totalPrecio.setText(listReservaHistorial.get(position).getPrecioTotal().toString());

    }

    @Override
    public int getItemCount() {
        return listReservaHistorial.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView totalPrecio, tipodeHaticacion, fechaInicio, fechaFinal, fechaReservada;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            totalPrecio = itemView.findViewById(R.id.item_historial_precio_total);
            tipodeHaticacion = itemView.findViewById(R.id.item_historial_tipo_room);
            fechaInicio = itemView.findViewById(R.id.item_historial_fecha_inicio);
            fechaFinal = itemView.findViewById(R.id.item_historial_fecha_final);
            fechaReservada = itemView.findViewById(R.id.item_historial_fecha_creada);
        }
    }
}
