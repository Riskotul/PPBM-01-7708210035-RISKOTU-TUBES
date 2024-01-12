package com.example.assesment3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        ListView list = findViewById(R.id.ListView);

        String[] namasnack = {"Oreo", "Beng-Beng", "Keripik Tempe", "Kacang Rosta", "Malkist Gery salut", "kentang", "cilok", "tahu gejrot", "cilor", "batagor", "siomay", "Kripik Usu", "Basreng Pedas", "Sosis Bakar", "Cirambay", "Makroni Basah", "Pisang Goreng", "Tahu Walik", "Dimsum Campur", "Pisang Bakar", "Telur Gulung"};

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, namasnack);

        list.setAdapter(myAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Ambil nama snack yang diklik
                String selectedSnack = namasnack[position];

                // Pindah ke Activity Detail dan kirimkan data nama snack
                Intent intent = new Intent(NextActivity.this, DetailActivity.class);
                intent.putExtra("nama_snack", selectedSnack);
                startActivity(intent);
            }
        });
    }
}
