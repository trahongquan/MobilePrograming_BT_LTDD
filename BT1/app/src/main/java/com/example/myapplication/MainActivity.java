package com.example.myapplication;

import static android.app.ProgressDialog.show;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mysql.cj.jdbc.result.ResultSetMetaData;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button buttonLogin, buttonCancel;
//    String classs = "com.mysql.jdbc.Driver";
    String classs = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://192.168.205.240:3306/appmess";
//    String url = "jdbc:mysql://localhost:3306/appmess";
    String un = "root";
    String password = "123456";
    Statement st;
    ResultSet rs;
    ResultSetMetaData rsmd;
    Connection conn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("test.log", "onCreate");

        buttonCancel = findViewById(R.id.btnCancel);
        buttonLogin = findViewById(R.id.btnlogin);
        buttonLogin.setOnClickListener(this);
        buttonCancel.setOnClickListener(this);

        IntentFilter filter = new IntentFilter("com.tutorialspoint.CUSTOM_INTENT");
        registerReceiver(new MyReceiver(), filter);

    }
TextView mTextView;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        mTextView = findViewById(R.id.text_view);
//
//        DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
//        Connection connection = null;
//        try {
//            connection = databaseHelper.getConnection();
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
//
//            while (resultSet.next()) {
//                String name = resultSet.getString("name");
//                String email = resultSet.getString("email");
//
//                mTextView.append(name + ", " + email + "\n");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
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
        if(v==buttonLogin) {new ConnectTask().execute();}
//            try {
//                Class.forName(classs);
//                Connection conn2 = DriverManager.getConnection(url, un, password);
////                conn = DriverManager.getConnection(url, un,password);
//                checkData2Notice("Connect Successfull!");
////                Toast.makeText(this, "Connect Successfull!", Toast.LENGTH_SHORT).show();
//                conn2.close();
//
//            } catch (ClassNotFoundException e) {
//                checkData2Notice("Lỗi không tìm thấy class SQL");
////                Toast.makeText(this, "Lỗi không tìm thấy class SQL", Toast.LENGTH_SHORT).show();
//            } catch (SQLException e) {
////                Toast.makeText(this, "Lỗi kết nối SQL" + e.getMessage(), Toast.LENGTH_SHORT).show();
//                checkData2Notice("Lỗi: " + e.getMessage());
//                Log.i("SQL", e.getMessage());
//                e.printStackTrace();
//
//            }
////                Toast.makeText(MainActivity.this, "Button Login được nhấn!", Toast.LENGTH_SHORT).show()
////            Intent intent = new Intent(MainActivity.this, ScreenMain.class); // Thay thế "NewActivity.class" bằng tên lớp thực tế của activity mới của bạn
////            startActivity(intent);
//        }
//        else if (v==buttonCancel) {
//            alter();
//        }
////        else if () {}
////        else if () {}
////        else if () {}
////        else if () {}


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

//    @Override
//    protected void onStart() {
//        super.onStart();
//        Toast.makeText(MainActivity.this, "onStart", Toast.LENGTH_SHORT).show();
//        Log.i("test.log", "onStart");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Toast.makeText(MainActivity.this, "onStop", Toast.LENGTH_SHORT).show();
//        Log.i("test.log", "onStop");
//    }
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Toast.makeText(MainActivity.this, "onResume", Toast.LENGTH_SHORT).show();
//        Log.i("test.log", "onResume");
//    }
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Toast.makeText(MainActivity.this, "onPause", Toast.LENGTH_SHORT).show();
//        Log.i("test.log", "onPause");
//    }
    class ConnectTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Class.forName(classs);
                conn = DriverManager.getConnection(url, un, password);
            } catch (Exception e) {
                e.printStackTrace();
                runOnUiThread(() -> checkData2Notice("Lỗi kết nối: " + e.getMessage()));
                Log.i("SQL", e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            if (conn != null) {
                checkData2Notice("Connect Successfull!");
                Log.i("SQL", "Connect Successfull!");
            }
        }
    }


}

