package com.suhailahnfsella.fudum;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetDaftar {
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("pesan")
    @Expose
    private String pesan;
    @SerializedName("data")
    @Expose
    private DaftarModel data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public DaftarModel getData() {
        return data;
    }

    public void setData(DaftarModel data) {
        this.data = data;
    }
}
