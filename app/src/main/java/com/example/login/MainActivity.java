package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    EditText edUser, edPass;

    public boolean check(String pass){
        String s1 = "", s2 = "", s3 = "", s4 = "";
        boolean check1 = true, check = true;
        for(int i = 0; i < pass.length(); i++){
            if(pass.charAt(i) >= 'a' && pass.charAt(i) <= 'z' ){
                s1 += pass.charAt(i);
            }
            else if(pass.charAt(i) >= 'A' && pass.charAt(i) <= 'Z'){
                s2 += pass.charAt(i);
            }
            else if(pass.charAt(i) >= '0' && pass.charAt(i) <= '9'){
                s3 += pass.charAt(i);
            }
            else if(pass.charAt(i) == ' ' || pass.charAt(i) == '\n'){
                check1 = false;
            }else{
                s4 += pass.charAt(i);
            }
        }
        if(pass.length() >= 6 && s1.length() > 0 && s2.length() > 0 && s3.length() > 0 && s4.length() > 0 && check1 == true)
            return true;
        else return false;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Login");

        btnLogin = findViewById(R.id.btnLogin);
        edUser = findViewById(R.id.edUser);
        edPass = findViewById(R.id.edPass);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreatNewNode.class);
                //check(String.valueOf(edPass.getText().toString()))
                if (check(String.valueOf(edPass.getText().toString()))) {
                    startActivity(intent);
                } else
                    Toast.makeText(getBaseContext(), "Incorrect Account", Toast.LENGTH_LONG).show();
                //startActivity(intent);
            }
        });
    }
}
