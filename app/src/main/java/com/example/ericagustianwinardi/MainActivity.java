package com.example.ericagustianwinardi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EricAgustianWinardi pinjaman;

    EditText bunga,jumlahPinjaman,lamaPinjaman;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jumlahPinjaman = findViewById(R.id.input_pinjaman);
        lamaPinjaman = findViewById(R.id.input_lama_pinjaman);
        bunga = findViewById(R.id.input_bunga);

    }
    public void HitungPinjaman(View view) {
        pinjaman = new EricAgustianWinardi(Double.parseDouble(jumlahPinjaman.getText().toString()), Double.parseDouble(lamaPinjaman.getText().toString()), Double.parseDouble(bunga.getText().toString()));
        RecyclerView listView = (RecyclerView) findViewById(R.id.viewElement);

        listView.setHasFixedSize(true);
        listView.setLayoutManager(new LinearLayoutManager(this));

        PinjamanAdapter adapter = new PinjamanAdapter();

        adapter.data = pinjaman.Hasil();

        listView.setAdapter(adapter);
    }
}