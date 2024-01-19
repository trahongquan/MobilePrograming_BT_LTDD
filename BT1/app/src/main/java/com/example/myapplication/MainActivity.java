package com.example.myapplication;

import static android.app.ProgressDialog.show;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("test.log", "onCreate");

        /** Cách viết bài bản */
//        Button button = findViewById(R.id.btnlogin);
//        // Thêm onClickListener cho button
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Thực hiện hành động khi button được nhấn
//                Toast.makeText(MainActivity.this, "Button được nhấn!", Toast.LENGTH_SHORT).show();
//            }
//        });

        /** Cách viết lamda */
        Button buttonCancel = findViewById(R.id.btnCancel);
        Button buttonLogin = findViewById(R.id.btnlogin);
        buttonLogin.setOnClickListener(v -> {
//                Toast.makeText(MainActivity.this, "Button Login được nhấn!", Toast.LENGTH_SHORT).show()
            Intent intent = new Intent(MainActivity.this, ScreenMain.class); // Thay thế "NewActivity.class" bằng tên lớp thực tế của activity mới của bạn
            startActivity(intent);
        });
        buttonCancel.setOnClickListener(v -> Toast.makeText(MainActivity.this, "Thoát!", Toast.LENGTH_SHORT).show());
        buttonCancel.setOnClickListener(v->alter());

    }
    private void checkData2Notice(Object data){
        /** Cách dùng Builder để truyền data*/
        // Tạo một đối tượng AlertDialog.Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        // Đặt tiêu đề cho hộp thoại
        builder.setTitle("Thông báo lỗi: ");
        // Đặt nội dung thông báo cho hộp thoại
        builder.setMessage((String) data );
        // Hiển thị hộp thoại
        builder.show();
    }

    @Override
    public void onClick(View v) {

    }

    private void alter(){
        // Tạo một đối tượng AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Đặt tiêu đề và nội dung cho hộp thoại
        builder.setTitle("Xác nhận thoát");
        builder.setMessage("Bạn có chắc chắn muốn thoát không?");
        // Thêm các nút cho hộp thoại
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        // Hiển thị hộp thoại
        builder.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(MainActivity.this, "onStart", Toast.LENGTH_SHORT).show();
        Log.i("test.log", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(MainActivity.this, "onStop", Toast.LENGTH_SHORT).show();
        Log.i("test.log", "onStop");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MainActivity.this, "onResume", Toast.LENGTH_SHORT).show();
        Log.i("test.log", "onResume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(MainActivity.this, "onPause", Toast.LENGTH_SHORT).show();
        Log.i("test.log", "onPause");
    }


}
