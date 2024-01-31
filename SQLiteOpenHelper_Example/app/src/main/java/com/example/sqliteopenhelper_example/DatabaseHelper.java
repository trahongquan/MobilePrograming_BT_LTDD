package com.example.sqliteopenhelper_example;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "sinhvien.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Tạo bảng sinh viên
        String sql = "CREATE TABLE IF NOT EXISTS SinhVien ( " +
                "MaSV TEXT PRIMARY KEY, " +
                "TenSV TEXT NOT NULL )";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Xử lý nâng cấp cơ sở dữ liệu (nếu có)
    }

    // Hàm thêm sinh viên
    public void addStudent(String maSV, String tenSV) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MaSV", maSV);
        values.put("TenSV", tenSV);
        db.insert("SinhVien", null, values);
        db.close();
    }

    // Hàm xóa sinh viên
    public void deleteStudent(String maSV) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("SinhVien", "MaSV = ?", new String[]{maSV});
        db.close();
    }

    // Hàm cập nhật sinh viên
    public void updateStudent(String maSV, String tenSV) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TenSV", tenSV);
        db.update("SinhVien", values, "MaSV = ?", new String[]{maSV});
        db.close();
    }

    // Hàm lấy tất cả sinh viên
    public List<SinhVien> getAllStudents() {
        List<SinhVien> sinhVienList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM SinhVien";
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                SinhVien sinhVien = new SinhVien();
                sinhVien.setMaSV(cursor.getString(0));
                sinhVien.setTenSV(cursor.getString(1));
                sinhVienList.add(sinhVien);
            }
            cursor.close();
        }
        db.close();
        return sinhVienList;
    }

    public SinhVien getStudentByMaSV(String maSV) {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM SinhVien WHERE MaSV = ?";
        Cursor cursor = db.rawQuery(sql, new String[]{maSV});
        if (cursor != null && cursor.moveToFirst()) {
            SinhVien sinhVien = new SinhVien();
            sinhVien.setMaSV(cursor.getString(0));
            sinhVien.setTenSV(cursor.getString(1));
            cursor.close();
            return sinhVien;
        }
        db.close();
        return null;
    }
    public List<SinhVien> getListStudentByMaSV(String maSV) {
        List<SinhVien> sinhVienList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM SinhVien WHERE MaSV = ?";
        Cursor cursor = db.rawQuery(sql, new String[]{maSV});
        if (cursor != null && cursor.moveToFirst()) {
            SinhVien sinhVien = new SinhVien();
            sinhVien.setMaSV(cursor.getString(0));
            sinhVien.setTenSV(cursor.getString(1));
            cursor.close();
            return sinhVienList;
        }
        db.close();
        return null;
    }
}
