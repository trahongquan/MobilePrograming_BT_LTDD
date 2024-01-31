package com.example.sqliteopenhelper_example;

public class SinhVien {
    String TenSV, MaSV;

    public SinhVien() {
    }

    public SinhVien(String tenSV, String maSV) {
        TenSV = tenSV;
        MaSV = maSV;
    }

    public String getTenSV() {
        return TenSV;
    }

    public void setTenSV(String tenSV) {
        TenSV = tenSV;
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String maSV) {
        MaSV = maSV;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "TenSV='" + TenSV + '\'' +
                ", MaSV='" + MaSV + '\'' +
                '}';
    }
}
