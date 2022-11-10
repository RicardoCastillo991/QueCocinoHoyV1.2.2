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
        tvNombre =(TextView)findViewById(R.id.txtProfileNombre);
        tvCorreo =(TextView)findViewById(R.id.txtProfileCorreo);
        tvEdad =(TextView)findViewById(R.id.txtProfileEdad);
        tvSexo =(TextView)findViewById(R.id.txtProfileSexo);
        tvComidaFav =(TextView)findViewById(R.id.txtProfileComidaFav);
    }
}