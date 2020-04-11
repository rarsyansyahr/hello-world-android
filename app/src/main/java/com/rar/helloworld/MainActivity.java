package com.rar.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    String password = "if18s";

    public static final String EXTRA_MESSAGE = "com.rar.helloworld.nama";
    public static final int TEXT_REQUEST = 3;

    EditText txtNim;
    EditText txtPassword;
    Button btnLogin;
    TextInputLayout inlayNim;
    TextInputLayout inlayPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.txtNim = (EditText) findViewById(R.id.txtNim);
        this.txtPassword  = (EditText) findViewById(R.id.txtPassword);
        this.btnLogin = (Button) findViewById(R.id.btnLogin);
        this.inlayNim = (TextInputLayout) findViewById(R.id.inlayNim);
        this.inlayPassword = (TextInputLayout) findViewById(R.id.inlayPassword);

        this.txtNim.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int len = inlayNim.getCounterMaxLength();
                if(s.length() > len)
                    inlayNim.setError("Max character length is = " + len);
                else
                    inlayNim.setError(null);
            }
        });

        this.txtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int len = inlayPassword.getCounterMaxLength();
                if(s.length() > len)
                    inlayNim.setError("Max character length is = " + len);
                else
                    inlayNim.setError(null);
            }
        });

        this.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nim = txtNim.getText().toString();
                String password = txtPassword.getText().toString();
                String text = "";

                if (nim.equals(nim) && password.equals(password)) {
                    text = "Login Berhasil !";
                    String nama = "Rizky AR";

                    /*Bundle extras = new Bundle();
                    extras.putString(this.EXTRA_MESSAGE, nama);*/

                    Intent intent = new Intent(v.getContext(), DashboardActivity.class);
                    //intent.putExtras(intent);
                    intent.putExtra(EXTRA_MESSAGE, nama);
                    startActivity(intent);
                } else {
                    text = "NIM / Password salah !";
                }

                Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }

    /*protected void onActivityResult() {

    }*/

}
