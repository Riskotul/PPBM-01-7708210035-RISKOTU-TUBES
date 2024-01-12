package com.example.assesment3;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Ambil data nama snack dan deskripsi dari intent
        String namaSnack = getIntent().getStringExtra("OREO");
        String deskripsiSnack = getIntent().getStringExtra("Snack oreo merupaka snack yang memiliki banyak varian rasa mulai dari yang original sampai rasa es cream, cocok untuk cemilan kapan pun.");

        // Tampilkan data pada ImageView dan TextView di DetailActivity
        ImageView imageViewDetail = findViewById(R.id.imageViewDetail);
        imageViewDetail.setImageResource(R.drawable.oreo); // Ganti dengan gambar yang sesuai

        TextView textViewDetail = findViewById(R.id.textViewDetail);
        textViewDetail.setText(  "Snack oreo merupaka snack yang memiliki banyak varian rasa mulai dari yang original sampai rasa es cream, cocok untuk cemilan kapan pun." + deskripsiSnack);
    }
}
