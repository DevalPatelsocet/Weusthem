package com.example.weusthem_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.weusthem_test.contactadd.CustomData;
import com.example.weusthem_test.contactadd.CustomAdaptor;
import com.example.weusthem_test.database.AppDatabase;
import com.example.weusthem_test.database.dao.Userdao;
import com.example.weusthem_test.database.entity.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    User crtuser;
    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private EditText phnumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button register=findViewById(R.id.main_create);
        AppDatabase database = AppDatabase.getDatabaseInstance(this);
        Userdao.UserDao userDao = database.userDao();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Register.class));
            }
        });

        RecyclerView recyclerView=findViewById(R.id.main_recycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


//        userDao.getUser(1).observe(this,user -> {
//            if(user==null)
//            {
//                Toast.makeText(MainActivity.this,"Enter Details",Toast.LENGTH_SHORT).show();
//            }
//            else {
//
//                Intent intent=new Intent(MainActivity.this,ContactDetails.class);
//                intent.putExtra("usrkey",user.getId());
//                startActivity(intent);
//            }
//        });

        ArrayList<CustomData> data = new ArrayList<>();
        data.add(new CustomData(R.layout.contacts_view,"Deval","deval@gmail.com",R.drawable.ic_launcher_background,"DEVAL","Patel",12345));
        data.add(new CustomData(R.layout.contacts_view,"Deval","deval@gmail.com",R.drawable.ic_launcher_background,"DEVAL","Patel",12345));
        CustomAdaptor adapter = new CustomAdaptor(this, data);
        recyclerView.setAdapter(adapter);


    }
}