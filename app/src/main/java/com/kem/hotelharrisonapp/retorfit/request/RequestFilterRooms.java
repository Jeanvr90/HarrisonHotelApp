package com.kem.hotelharrisonapp.retorfit.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class RequestFilterRooms {

    @SerializedName("finish")
    @Expose
    private String finish;
    @SerializedName("start")
    @Expose
    private String start;

    public RequestFilterRooms() {
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }
}
