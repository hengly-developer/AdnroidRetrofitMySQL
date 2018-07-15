package com.example.xxxxxx.adnroidretrofitmysql.model;

public class DataModel {
    String npm,nama,prodi,fakeultas;

    public DataModel() {
    }

    public DataModel(String npm, String nama, String prodi, String fakeultas) {
        this.npm = npm;
        this.nama = nama;
        this.prodi = prodi;
        this.fakeultas = fakeultas;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public String getFakeultas() {
        return fakeultas;
    }

    public void setFakeultas(String fakeultas) {
        this.fakeultas = fakeultas;
    }
}
