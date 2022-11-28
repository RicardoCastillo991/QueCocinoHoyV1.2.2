package quecocino.example.quecocinohoy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.quecocinohoy.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivityInicio extends AppCompatActivity {
    private ImageButton btnProfile, btnMap;
    RecyclerView recyclerView;
    DatabaseReference database;
    ListAdapter listAdapter;
    ArrayList<Receta> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_inicio);
        btnMap = (ImageButton)findViewById(R.id.imgButtonUbicacion);
        btnProfile = (ImageButton)findViewById(R.id.imgButtonPerfil);
        Bundle datos = MainActivityInicio.this.getIntent().getExtras();
        String correo = datos.getString("CorreoUsuario");
        init();

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityInicio.this , MapsActivity.class);
                startActivity(intent);
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityInicio.this, ProfileActivity.class);
                intent.putExtra("correo",correo);
                startActivity(intent);
            }
        });
    }


    public void init(){
        recyclerView = findViewById(R.id.listRecicleView);
        database = FirebaseDatabase.getInstance().getReference("recetas");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        listAdapter = new ListAdapter(this, list);
        recyclerView.setAdapter(listAdapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Receta receta = dataSnapshot.getValue(Receta.class);
                    list.add(receta);
                }
                listAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}