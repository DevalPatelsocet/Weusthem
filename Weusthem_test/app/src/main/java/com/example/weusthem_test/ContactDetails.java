package com.example.weusthem_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weusthem_test.database.AppDatabase;
import com.example.weusthem_test.database.dao.Userdao;
import com.example.weusthem_test.database.entity.User;

public class ContactDetails extends AppCompatActivity {

    User crtuser;
    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private EditText phnumber;
    private Button saveBtn;
    private Button dlt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        dlt=findViewById(R.id.profile_logout);
        firstName = findViewById(R.id.profile_FirstName);
        lastName = findViewById(R.id.profile_lastName);
        email = findViewById(R.id.profile_email);
        phnumber = findViewById(R.id.profile_PHN);
        saveBtn = findViewById(R.id.profile_submit);

        AppDatabase database = AppDatabase.getDatabaseInstance(this);
        Userdao.UserDao userDao = database.userDao();
        Intent intent=getIntent();
        int id=intent.getIntExtra("usrkey",0);

        userDao.getUser(id).observe(this,user -> {
            crtuser=user;
            firstName.setText(user.getFirstName());
            lastName.setText(user.getLastName());
            email.setText(user.getEmail());
            phnumber.setText(user.getPhnumber());

        });

//        saveBtn.setOnClickListener(v -> {
//
//
//            AppDatabase.databaseWriteExecutor.execute(() -> {
//                //        userDao.insert(user);
//            });
//        });
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fst=firstName.getText().toString();
                String lst=lastName.getText().toString();
                String eml=email.getText().toString();
                String phn=phnumber.getText().toString();

                if(TextUtils.isEmpty(fst)|| TextUtils.isEmpty(lst)|| TextUtils.isEmpty(eml)|| TextUtils.isEmpty(phn))
                {
                    Toast.makeText(ContactDetails.this,"Enter all details",Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    crtuser.setFirstName(firstName.getText().toString());
                    crtuser.setLastName(lastName.getText().toString());
                    crtuser.setEmail(email.getText().toString());
                    crtuser.setPhnumber(phnumber.getText().toString());
                    AppDatabase.databaseWriteExecutor.execute(() -> {
                        userDao.update(crtuser);
                    });

                }
                startActivity(new Intent(ContactDetails.this,MainActivity.class));
            }
        });


        dlt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ContactDetails.this,MainActivity.class));
            }
        });
    }
}