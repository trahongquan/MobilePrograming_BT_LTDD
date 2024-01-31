//package com.example.sqliteopenhelper_example;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.TextView;
//
//import java.util.List;
//
//public class SinhVienAdapter extends ArrayAdapter<SinhVien> {
//
//    private Context context;
//    private List<SinhVien> sinhVienList;
//
//    public SinhVienAdapter(Context context, List<SinhVien> sinhVienList) {
//        super(context, 0, sinhVienList);
//        this.context = context;
//        this.sinhVienList = sinhVienList;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View view = convertView;
//        if (view == null) {
//            view = LayoutInflater.from(context).inflate(R.layout.item_sinhvien, parent, false);
//        }
//
//        TextView tvMaSV = view.findViewById(R.id.tv_masv);
//        TextView tvTenSV = view.findViewById(R.id.tv_tensv);
//
//        SinhVien sinhVien = sinhVienList.get(position);
//        tvMaSV.setText(sinhVien.getMaSV());
//        tvTenSV.setText(sinhVien.getTenSV());
//
//        return view;
//    }
//}
//
package com.example.sqliteopenhelper_example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class SinhVienAdapter extends ArrayAdapter<SinhVien> {

    private Context context;
    private List<SinhVien> sinhVienList;

    public SinhVienAdapter(Context context, List<SinhVien> sinhVienList) {
        super(context, R.layout.item_sinhvien, sinhVienList);
        this.context = context;
        this.sinhVienList = sinhVienList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_sinhvien, parent, false);
            holder = new ViewHolder();
            holder.tvMasv = convertView.findViewById(R.id.tv_masv);
            holder.tvTensv = convertView.findViewById(R.id.tv_tensv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        SinhVien sinhVien = sinhVienList.get(position);
        holder.tvMasv.setText("Mã SV: " + sinhVien.getMaSV());
        holder.tvTensv.setText("Tên SV: " + sinhVien.getTenSV());

        return convertView;
    }

    static class ViewHolder {
        TextView tvMasv, tvTensv;
    }
}
