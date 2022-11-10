package com.example.quecocinohoy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Vibrator;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivityRegister2Step extends AppCompatActivity {
    private Button btnInicio;
    private ImageButton btnMostrarPass;
    private EditText txtPass, txtPassDos;
    private boolean visible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_register2_step);
        btnInicio = (Button) findViewById(R.id.btnInicio);
        btnMostrarPass = (ImageButton)findViewById(R.id.imgbtnMostrarPass);
        txtPass = (EditText) findViewById(R.id.txtPassRegister);
        txtPassDos = (EditText) findViewById(R.id.txtPassDosRegister);
        ArrayList<String> ArrayPassUsuario = new ArrayList<String>();
        ArrayList<String> datosCompletos = getIntent().getStringArrayListExtra("datos");

        btnMostrarPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(visible == false){
                    txtPass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    txtPassDos.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    visible = true;
                }
                else{
                    txtPass.setInputType(129);
                    txtPassDos.setInputType(129);
                    visible = false;
                }
            }
        });

        String passUsuario = txtPass.getText().toString();
        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(txtPass.getText().toString().equals("") && txtPassDos.getText().toString().equals(""))){
                    if(txtPass.getText().toString().equals(txtPassDos.getText().toString())){
                        ArrayPassUsuario.add(passUsuario);
                        Intent intent = new Intent(MainActivityRegister2Step.this, MainActivityInicio.class);
                        Bundle bundle = new Bundle();
                        bundle.putStringArrayList("datosCompletos", datosCompletos);
                        bundle.putStringArrayList("passUsuario", ArrayPassUsuario);
                        Vibrator vibrator = (Vibrator)getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                        vibrator.vibrate(1500);
                        startActivity(intent);
                    }
                    else
                    {
                        txtPass.setText("");
                        txtPassDos.setText("");
                        Toast mensajeError = Toast.makeText(MainActivityRegister2Step.this, "¡Las contraseñas deben ser iguales!", Toast.LENGTH_LONG);
                        mensajeError.show();
                    }
                }
                else{
                    Toast mensajeError = Toast.makeText(MainActivityRegister2Step.this, "¡Para registrarse debe ingresar una contraseña!", Toast.LENGTH_LONG);
                    mensajeError.show();
                }
            }
        });
    }
}