package com.example.quecocinohoy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
    private Button btnVolver;
    private TextView tvNombre, tvCorreo, tvEdad,tvSexo, tvComidaFav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        tvNombre = findViewById(R.id.txtProfileNombre);
        tvCorreo = findViewById(R.id.txtProfileCorreo);
        tvEdad = findViewById(R.id.txtProfileEdad);
        tvSexo = findViewById(R.id.txtProfileSexo);
        tvComidaFav = findViewById(R.id.txtProfileComidaFav);
        String correo = getIntent().getExtras().getString("correo");

    }


}