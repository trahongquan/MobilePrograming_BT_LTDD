package com.example.sqliteopenhelper_example;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnCreateDB, btnDelDB, btnCreateTable, btnDelTable, btnThem, btnXoa, btnSua, btnSearch;
    private DatabaseHelper databaseHelper;
    private EditText edtMasv, edtTensv, textInputEditText;
    private ListView lvSinhVien;
    private static final String DATABASE_NAME = "sinhvien.db";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lấy các view từ giao diện
        btnCreateDB = findViewById(R.id.btn_CreateDB);
        btnDelDB = findViewById(R.id.btn_DelDB);
        btnCreateTable = findViewById(R.id.btn_CreateTable);
        btnDelTable = findViewById(R.id.btn_DelTable);
        edtMasv = findViewById(R.id.edt_masv);
        edtTensv = findViewById(R.id.edt_tensv);
        btnThem = findViewById(R.id.btn_them);
        btnXoa = findViewById(R.id.btn_xoa);
        btnSua = findViewById(R.id.btn_sua);
        btnSearch = findViewById(R.id.btn_search);
        lvSinhVien = findViewById(R.id.lv_sinhvien);
        textInputEditText = findViewById(R.id.textInputLayout);

        // Gán sự kiện click cho các nút
        btnCreateDB.setOnClickListener(this);
        btnDelDB.setOnClickListener(this);
        btnCreateTable.setOnClickListener(this);
        btnDelTable.setOnClickListener(this);
        btnThem.setOnClickListener(this);
        btnXoa.setOnClickListener(this);
        btnSua.setOnClickListener(this);
        btnSearch.setOnClickListener(this);

        // Khởi tạo database
        databaseHelper = new DatabaseHelper(this);

        // Hiển thị danh sách sinh viên
        showStudents();
    }

    @Override
    public void onClick(View view) {
        if (view == btnCreateDB) {
            // Tạo cơ sở dữ liệu
            databaseHelper.getWritableDatabase();
            Toast.makeText(this, "Cơ sở dữ liệu đã được tạo!", Toast.LENGTH_SHORT).show();
        } else if (view == btnDelDB) {
            // Xóa cơ sở dữ liệu
            deleteMyDatabase(DATABASE_NAME);
            Toast.makeText(this, "Cơ sở dữ liệu đã được xóa!", Toast.LENGTH_SHORT).show();
        } else if (view == btnCreateTable) {
            // Tạo bảng
            String sql = "CREATE TABLE IF NOT EXISTS SinhVien ( " +
                    "MaSV TEXT PRIMARY KEY, " +
                    "TenSV TEXT NOT NULL )";
            databaseHelper.getWritableDatabase().execSQL(sql);
            showStudents();
            Toast.makeText(this, "Bảng SinhVien đã được tạo!", Toast.LENGTH_SHORT).show();
        } else if (view == btnDelTable) {
            // Xóa bảng
            String sql = "DROP TABLE IF EXISTS SinhVien";
            databaseHelper.getWritableDatabase().execSQL(sql);
            showStudents();
            Toast.makeText(this, "Bảng SinhVien đã được xóa!", Toast.LENGTH_SHORT).show();
        } else if (view == btnThem) {
            // Thêm sinh viên
            String maSV = edtMasv.getText().toString();
            String tenSV = edtTensv.getText().toString();
            databaseHelper.addStudent(maSV, tenSV);
            Toast.makeText(this, "Sinh viên đã được thêm!", Toast.LENGTH_SHORT).show();
            showStudents();
        } else if (view == btnXoa) {
            // Xóa sinh viên
            String maSV = edtMasv.getText().toString();
            databaseHelper.deleteStudent(maSV);
            Toast.makeText(this, "Sinh viên đã được xóa!", Toast.LENGTH_SHORT).show();
            showStudents();
        } else if (view == btnSua) {
            // Sửa sinh viên
            String maSV = edtMasv.getText().toString();
            String tenSV = edtTensv.getText().toString();
            databaseHelper.updateStudent(maSV, tenSV);
            Toast.makeText(this, "Sinh viên đã được sửa!", Toast.LENGTH_SHORT).show();
            showStudents();
        } else if (view == btnSearch) {
            String maSV = edtMasv.getText().toString();
            SinhVien sinhVien = databaseHelper.getStudentByMaSV(maSV);
            if (sinhVien != null) {
                // Hiển thị thông tin sinh viên
                Toast.makeText(MainActivity.this, "Tìm thấy sinh viên: " + sinhVien.getTenSV(), Toast.LENGTH_SHORT).show();
                edtMasv.setText(sinhVien.getMaSV());
                SpannableStringBuilder spannableStringBuilderTenSV = new SpannableStringBuilder(edtMasv.getText().toString());
                spannableStringBuilderTenSV.setSpan(new ForegroundColorSpan(Color.GREEN), 0, edtMasv.getText().toString().length(), 0);
                edtMasv.setText(spannableStringBuilderTenSV);

                edtTensv.setText(sinhVien.getTenSV());
                SpannableStringBuilder spannableStringBuilderMaSV = new SpannableStringBuilder(edtTensv.getText().toString());
                spannableStringBuilderMaSV.setSpan(new ForegroundColorSpan(Color.GREEN), 0, edtTensv.getText().toString().length(), 0);
                edtTensv.setText(spannableStringBuilderMaSV);
            } else {
                // Hiển thị thông báo không tìm thấy
                SpannableStringBuilder spannableStringBuilderTenSV = new SpannableStringBuilder(maSV);
                spannableStringBuilderTenSV.setSpan(new ForegroundColorSpan(Color.RED), 0, maSV.length(), 0);
                edtMasv.setText(spannableStringBuilderTenSV);
                edtTensv.setText("");
                Toast.makeText(MainActivity.this, "Không tìm thấy sinh viên với mã " + maSV, Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Hiển thị danh sách sinh viên
    private void showStudents() {
        List<SinhVien> sinhVienList = databaseHelper.getAllStudents();
        if(sinhVienList != null) {
            // Tạo adapter và gán dữ liệu cho ListView
            SinhVienAdapter adapter = new SinhVienAdapter(this, sinhVienList);
            lvSinhVien.setAdapter(adapter);
        }
    }
//    private void showSearch(String MaSV) {
//        List<SinhVien> sinhVienList = databaseHelper.getStudentByMaSV(MaSV);
//        // Tạo adapter và gán dữ liệu cho ListView
//        SinhVienAdapter adapter = new SinhVienAdapter(this, sinhVienList);
//        lvSinhVien.setAdapter(adapter);
//    }

    private void deleteMyDatabase(String databaseName) {
//        File databaseFile = new File(getFilesDir(), databaseName);
        File databaseFile = getDatabasePath(databaseName);
        if (databaseFile.exists()) {
            deleteDatabase(databaseName);
            Log.i("delDB","Đã xóa DB");
        } else {
            Toast.makeText(this, "Không tồn tại rồi", Toast.LENGTH_SHORT).show();
            String s = String.valueOf(databaseFile.exists());
            Log.i("delDB",s);
        }
    }
}
