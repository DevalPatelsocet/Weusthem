package com.example.weusthem_test;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.weusthem_test.database.AppDatabase;
import com.example.weusthem_test.database.dao.Userdao;
import com.example.weusthem_test.database.entity.User;

public class Register extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        EditText firstName = findViewById(R.id.register_FN);
        EditText lastName = findViewById(R.id.register_LN);
        EditText email = findViewById(R.id.register_email);
        EditText phonenumber = findViewById(R.id.register_PHN);
        TextView save=findViewById(R.id.register_save);

        AppDatabase database = AppDatabase.getDatabaseInstance(this);
        Userdao.UserDao userDao = database.userDao();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fst=firstName.getText().toString();
                String lst=lastName.getText().toString();
                String eml=email.getText().toString();
                String phn=phonenumber.getText().toString();
                if(TextUtils.isEmpty(eml)|| TextUtils.isEmpty(phn)|| TextUtils.isEmpty(fst)|| TextUtils.isEmpty(lst))
                {

                    Toast.makeText(Register.this,"Enter all details!!!",Toast.LENGTH_SHORT).show();
                    return;
                }


                AppDatabase.databaseWriteExecutor.execute(() -> {
                    userDao.insert(new User(fst,lst,eml,phn));
                });


                startActivity(new Intent(Register.this,MainActivity.class));
            }
        });
    }
}
