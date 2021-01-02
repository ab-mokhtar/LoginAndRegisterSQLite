package com.example.loginandregistersqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
EditText EM,EP1,EP2;
Button btn,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db= new DatabaseHelper(this);
        EM=findViewById(R.id.email);
        EP1=findViewById(R.id.editTextTextPassword);
        EP2=findViewById(R.id.confirmMdp);
        btn=findViewById(R.id.button);
        btn2=findViewById(R.id.login);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,login.class);
                startActivity(i);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail=EM.getText().toString();
                String mdp = EP1.getText().toString();
                String mdp1=EP2.getText().toString();
                if (mail.equals("")||mdp.equals("")||mdp1.equals("")) {
                    Toast.makeText(getApplicationContext(), "Champ vide", Toast.LENGTH_SHORT).show();
                }
                else {
                        if (mdp.equals(mdp1)){
                            boolean checkmail= db.checkmail(mail);
                            if(checkmail==true){
                                boolean insert=db.insert(mail,mdp);
                                if (insert==true){
                                    Toast.makeText(getApplicationContext(),"Registre done ",Toast.LENGTH_SHORT).show();
                                }
                            }
                            else {  Toast.makeText(getApplicationContext(),"Email exist",Toast.LENGTH_SHORT).show();
                        }
                    }else {
                            Toast.makeText(getApplicationContext()," Mot de passe incorrect",Toast.LENGTH_SHORT).show();
                        }

                }
            }
        });
    }
}