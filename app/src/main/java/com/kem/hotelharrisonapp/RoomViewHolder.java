package com.kem.hotelharrisonapp;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RoomViewHolder extends RecyclerView.ViewHolder {

    Button btnInfo;
    ImageView ivPhoto;
    LinearLayout llRoomContainer;
    TextView tvName,tvDescription, tvPrice,tvNumber;

    public RoomViewHolder(@NonNull View itemView) {
        super(itemView);

        btnInfo=itemView.findViewById(R.id.btn_info);

        ivPhoto=itemView.findViewById(R.id.iv_room);
        llRoomContainer=itemView.findViewById(R.id.llRoomContainer);
        tvName=itemView.findViewById(R.id.txt_title_room);
        tvDescription=itemView.findViewById(R.id.txt_description_room);
        tvPrice=itemView.findViewById(R.id.txt_price);
        tvNumber=itemView.findViewById(R.id.txt_number_bet);


    }
}
