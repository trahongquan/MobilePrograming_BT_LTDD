//package com.example.myapplication;
//
//import android.os.AsyncTask;
//
//import com.mysql.cj.jdbc.result.ResultSetMetaData;
//import com.mysql.cj.xdevapi.Statement;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//
//public class ConnectTask extends AsyncTask<Void, Void, Void> {
//    String classs = "com.mysql.cj.jdbc.Driver";
//    //    String url = "jdbc:mysql://192.168.205.240:3306/appmess";
//    String url = "jdbc:mysql://localhost:3306/appmess";
//    String un = "root";
//    String password = "123456";
//    Statement st;
//    ResultSet rs;
//    ResultSetMetaData rsmd;
//    Connection conn = null;
//    @Override
//    protected Void doInBackground(Void... params) {
//        try {
//            Class.forName(classs);
//            conn = DriverManager.getConnection(url, un, password);
//        } catch (Exception e) {
//            e.printStackTrace();
//            runOnUiThread(() -> checkData2Notice("Lỗi kết nối: " + e.getMessage()));
//        }
//        return null;
//    }
//
//    @Override
//    protected void onPostExecute(Void aVoid) {
//        if (conn != null) {
//            checkData2Notice("Connect Successfull!");
//        }
//    }
//}
//
//// Trong onClick:
//new ConnectTask().execute();
