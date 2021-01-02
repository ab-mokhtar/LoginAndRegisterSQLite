package com.example.loginandregistersqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    DatabaseHelper db;
    EditText EM,EP;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db= new DatabaseHelper(this);
        EM=findViewById(R.id.editName);
        EP=findViewById(R.id.editTextTextPassword);
        btn=findViewById(R.id.buttonlog);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=EM.getText().toString();
                String password= EP.getText().toString();
                boolean checklog=db.log(email,password);
                if(checklog==true){
                    Toast.makeText(getApplicationContext(), " successfully Login", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), " wrong email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}