package com.rar.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class DashboardActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView lblNama;
    Button btnToast;
    Button btnSnackbar;
    AutoCompleteTextView txtAuto;
    Spinner spinJurusan;
    RecyclerView recyclerView;
    RecyclerView.Adapter rAdapter;
    RecyclerView.LayoutManager layoutManager;

    String nama;
    private static final String[] DESA = { "Kalitinggar", "Prigi", "Dawuhan", "Karangranti", "Karanggambas", "Padamara", "Sokawera" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        this.lblNama = (TextView) findViewById(R.id.lblNama);
        this.btnToast = (Button) findViewById(R.id.btnToast);
        this.btnSnackbar = (Button) findViewById(R.id.btnSnackbar);
        this.txtAuto = (AutoCompleteTextView) findViewById(R.id.txtAuto);
        this.spinJurusan = (Spinner) findViewById(R.id.spinJurusan);
        this.recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        this.layoutManager = new LinearLayoutManager(this);


        Intent intent = getIntent();
//        Bundle extras = intent.getExtras();
        this.nama = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        this.lblNama.setText("Selamat Datang " + nama + " !");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, this.DESA);
        this.txtAuto.setThreshold(1);
        this.txtAuto.setAdapter(adapter);


        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.jurusan, R.layout.support_simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        this.spinJurusan.setAdapter(adapter2);
        this.spinJurusan.setOnItemSelectedListener(this);


        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.setLayoutManager(this.layoutManager);
//        this.rAdapter = new MyAdapter(myDataset);
//        this.recyclerView.setAdapter(this.rAdapter);


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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
