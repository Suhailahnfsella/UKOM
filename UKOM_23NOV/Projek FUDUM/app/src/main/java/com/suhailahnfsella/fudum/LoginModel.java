package com.suhailahnfsella.fudum;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoginModel implements Serializable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("idtoko")
    @Expose
    private String idtoko;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("namapanjang")
    @Expose
    private String namapanjang;
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
    private Integer status;
    @SerializedName("fototoko")
    @Expose
    private String fototoko;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFototoko() {
        return fototoko;
    }

    public void setFototoko(String fototoko) {
        this.fototoko = fototoko;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}
