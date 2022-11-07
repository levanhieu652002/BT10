package com.example.levanhieu_2050531200143;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.service.controls.Control;
import android.service.controls.templates.ControlButton;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    EditText edtuser, edtpassword;
    Button btndangky, btndangnhap, btnthoat;
    String ten, mk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        ControlButton();
    }


    private void ControlButton() {
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Bạn có thoát không");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        onBackPressed();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
            }
        });
        btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setTitle("Hộp thoại đăng ký");
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.customdialog);
                EditText edttk = (EditText) dialog.findViewById(R.id.edttk);
                EditText edtmk = (EditText) dialog.findViewById(R.id.edtmk);
                Button btnhuy = (Button) dialog.findViewById(R.id.buttonhuy);
                Button btndongy = (Button) dialog.findViewById(R.id.buttondongy);
                btndongy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ten = edttk.getText().toString().trim();
                        mk = edtmk.getText().toString().trim();
                        edtuser.setText(ten);
                        edtpassword.setText(mk);
                        dialog.cancel();
                    }
                });
                btnhuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtuser.getText().length() != 0 && edtpassword.getText().length() != 0) {
                    if (edtuser.getText().toString().equals(ten) && edtpassword.getText().toString().equals(mk)) {
                        Toast.makeText(MainActivity.this, "Bạn đã đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, Home_Activity.class);
                        startActivity(intent);
                    } else if (edtuser.getText().toString().equals("hieu") && edtpassword.getText().toString().equals("hieu6502")) {
                        Toast.makeText(MainActivity.this, "Bạn đã đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, Home_Activity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Đăng nhập không thành công", Toast.LENGTH_SHORT).show();

                    }
                } else {
                    Toast.makeText(MainActivity.this, "Mời bạn nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }


        });
    }

    private void AnhXa() {
        edtuser = (EditText) findViewById(R.id.edittextuser);
        edtpassword = (EditText) findViewById(R.id.edittextpass);
        btndangky = (Button) findViewById(R.id.buttondangky);
        btndangnhap = (Button) findViewById(R.id.buttondangnhap);
        btnthoat = (Button) findViewById(R.id.buttonthoat);
    }
}