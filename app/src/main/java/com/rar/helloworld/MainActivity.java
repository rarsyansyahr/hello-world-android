package com.rar.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String nim = "18.11.0153";
    String password = "if18s";

    EditText txtNim;
    EditText txtPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNim = (EditText) findViewById(R.id.txtNim);
        txtPassword  = (EditText) findViewById(R.id.txtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String text = "";

                if (txtNim.getText().toString().equals(nim) && txtPassword.getText().toString().equals(password)) {
                    text = "Login Berhasil !";
                } else {
                    text = "NIM / Password salah !";
                }

                Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }

}
