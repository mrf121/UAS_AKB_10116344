package com.example.uas_akb8_10116344.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

//Nama  : Ilham Maulana Pratama
//NIM   : 10116335
//KLS   : IF 8
//TGL   : 3 Agustus 2019
public class FriendModel extends RealmObject {
    @PrimaryKey
    private Integer id;
    @Required
    private String nim;
    @Required
    private String Nama;
    @Required
    private String kelas;
    @Required
    private  String telp;
    @Required
    private  String email;
    @Required
    private  String sosmed;

    public Integer getId() {
        return id;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return Nama;
    }

    public String getKelas() {
        return kelas;
    }

    public String getTelp() {
        return telp;
    }

    public String getEmail() {
        return email;
    }

    public String getSosmed() {
        return sosmed;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setNama(String nama) {
        this.Nama = nama;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSosmed(String sosmed) {
        this.sosmed = sosmed;
    }
}
