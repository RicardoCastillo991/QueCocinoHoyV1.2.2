package com.example.quecocinohoy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quecocinohoy.db.DbHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        Bundle datos = ProfileActivity.this.getIntent().getExtras();
        String correo = datos.getString("correo");
        leerPerfil(correo);
        tvCorreo.setText(correo);


    }
    public void leerPerfil(String correoUsuario){
        try {
            String sql = "SELECT nombre, apellido, correo, sexo, edad, comida_fav FROM usuario WHERE correo = '"+correoUsuario+"'";
            DbHelper dbhelper = new DbHelper(ProfileActivity.this);
            SQLiteDatabase db = dbhelper.getWritableDatabase();
            SQLiteStatement statement = db.compileStatement(sql);
            statement.execute();
            Cursor cursor = db.rawQuery(sql,null);
            String nombre = String.valueOf(cursor.getColumnIndex("nombre"));
            String apellido = String.valueOf(cursor.getColumnIndex("apellido"));
            String correo = String.valueOf(cursor.getColumnIndex("correo"));
            String sexo = String.valueOf(cursor.getColumnIndex("sexo"));
            String edad = String.valueOf(cursor.getColumnIndex("edad"));
            String comidaFav = String.valueOf(cursor.getColumnIndex("gustos"));
            tvNombre.setText("Nombre: "+nombre+" "+apellido);
            tvCorreo.setText("Correo: "+correo);
            tvEdad.setText("Edad: "+edad);
            tvSexo.setText("Sexo: "+sexo);
            tvComidaFav.setText("Comida Favorita: "+comidaFav);
        }
        catch (Exception e) {
            Toast.makeText(this, "El correo ingresado ya ha sido registrado.", Toast.LENGTH_LONG).show();
        }
    }



}