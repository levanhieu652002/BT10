package com.example.levanhieu_2050531200143;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class User extends AppCompatActivity {
    Button btnInsert, btnview;
    EditText name, email,age;
    DatabaseReference databaseUser1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        btnInsert=findViewById(R.id.btninsert);
        btnview=findViewById(R.id.btnview);
        name = findViewById(R.id.edtname);
        email =findViewById(R.id.edtemail);
        age = findViewById(R.id.edtage);
        databaseUser1= FirebaseDatabase.getInstance().getReference();
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InsertData();
            }
        });
        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(User.this,Userlist.class));
                finish();
            }
        });

    }

    private void InsertData() {
        String username= name.getText().toString();
        String useremail= email.getText().toString();
        String userage= age.getText().toString();
        String id = databaseUser1.push().getKey();

        User1 user1 =new User1(username,useremail,userage);
        databaseUser1.child("users1").child(id).setValue(user1).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(User.this, "User Details Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}