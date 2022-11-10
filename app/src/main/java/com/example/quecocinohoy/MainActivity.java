package com.example.quecocinohoy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.*;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Button btnRegistrar;
    private Button btnIngresar;
    private EditText txtCorreoIngresar;
    private EditText txtPasswordIngresar;
    private TextView txtError;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == event.KEYCODE_BACK){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Desea salir de la aplicacion?")
                    .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
            builder.show();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCorreoIngresar = (EditText) findViewById(R.id.txtCorreo);
        txtPasswordIngresar = (EditText) findViewById(R.id.txtPassword);
        txtError = (TextView) findViewById(R.id.txtError);

        btnIngresar = (Button)findViewById(R.id.btnIngresar);
        btnRegistrar = (Button)findViewById(R.id.btnRegistrarse);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(MainActivity.this, MainActivityRegister.class);
                startActivity(intento);
            }
        });

        btnIngresar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String correoIngresar;
                String passwordIngresar;
                correoIngresar = txtCorreoIngresar.getText().toString();
                passwordIngresar = txtPasswordIngresar.getText().toString();
                if(correoIngresar.equals("hola1@gmail.com") && passwordIngresar.equals("1234")){
                    Intent intento = new Intent(MainActivity.this, MainActivityInicio.class);
                    startActivity(intento);
                }
                else
                {
                    txtCorreoIngresar.setText("");
                    txtPasswordIngresar.setText("");
                    txtError.setVisibility(View.VISIBLE);
                }
        };
    });
    }


}