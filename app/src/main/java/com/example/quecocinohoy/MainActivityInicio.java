package com.example.quecocinohoy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivityInicio extends AppCompatActivity {
    private ImageButton btnProfile, btnMap;
    List<ListElement> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_inicio);
        btnMap = (ImageButton)findViewById(R.id.imgButtonUbicacion);
        btnProfile = (ImageButton)findViewById(R.id.imgButtonPerfil);
        btnMap.setVisibility(View.INVISIBLE);
        init();

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityInicio.this , MapActivity.class);
                startActivity(intent);
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityInicio.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }


    public void init(){
        elements = new ArrayList<>();
        elements.add(new ListElement("#7754232", "Omelette", "Huevo, Jamon, Oregano ", "Desayuno"));
        elements.add(new ListElement("#7754232", "Picante de pollo", "Pollo, Papas, Arverjas, Arroz" , "Almuerzo"));
        elements.add(new ListElement("#7754232", "Pollo a lo pobre", "Pollo, Cebolla, Papas, Huevo", "Almuerzo"));
        elements.add(new ListElement("#7754232", "Palta con cebolla", "Palta, Aceite, Cebolla en cuadros, Sal", "Desayuno"));
        elements.add(new ListElement("#7754232", "Ensalada Cesar", "Pollo, Pan, Lechuga, Queso", "Cena"));
        elements.add(new ListElement("#7754232", "Crema de zapallo", "Zapallo, Cebolla, Papa, Zanahoria", "Cena"));

        ListAdapter listAdapter = new ListAdapter(elements, this);
        RecyclerView recyclerView = findViewById(R.id.listRecicleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }

}