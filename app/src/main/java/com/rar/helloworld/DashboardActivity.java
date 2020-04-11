package com.rar.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class DashboardActivity extends AppCompatActivity {

    TextView lblNama;
    Button btnToast;
    Button btnSnackbar;

    String nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        this.lblNama = (TextView) findViewById(R.id.lblNama);
        this.btnToast = (Button) findViewById(R.id.btnToast);
        this.btnSnackbar = (Button) findViewById(R.id.btnSnackbar);

        Intent intent = getIntent();
//        Bundle extras = intent.getExtras();
        this.nama = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        this.lblNama.setText("Selamat Datang " + nama + " !");

        this.btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "LONG Toast", Toast.LENGTH_LONG);
                toast.show();
            }
        });

        this.btnSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(v, "SHORT Snackbar", Snackbar.LENGTH_SHORT);
                snackbar.setAction("BACK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                snackbar.show();
            }
        });
    }
}
