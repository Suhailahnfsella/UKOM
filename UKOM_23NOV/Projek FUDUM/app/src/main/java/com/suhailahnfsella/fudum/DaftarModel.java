package com.suhailahnfsella.fudum;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DaftarModel {
    @SerializedName("idtoko")
    @Expose
    private String idtoko;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("namapanjang")
    @Expose
    private String namapanjang;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("telp")
    @Expose
    private String telp;
    @SerializedName("fotoprofil")
    @Expose
    private String fotoprofil;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("level")
    @Expose
    private String level;
    @SerializedName("api_token")
    @Expose
    private String apiToken;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("fototoko")
    @Expose
    private String fototoko;

    public String getIdtoko() {
        return idtoko;
    }

    public void setIdtoko(String idtoko) {
        this.idtoko = idtoko;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getNamapanjang() {
        return namapanjang;
    }

    public void setNamapanjang(String namapanjang) {
        this.namapanjang = namapanjang;
    }

    public String getFotoprofil() {
        return fotoprofil;
    }

    public void setFotoprofil(String fotoprofil) {
        this.fotoprofil = fotoprofil;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFototoko() {
        return fototoko;
    }

    public void setFototoko(String fototoko) {
        this.fototoko = fototoko;
    }
}
