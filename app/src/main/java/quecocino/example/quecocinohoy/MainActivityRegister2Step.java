package quecocino.example.quecocinohoy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.quecocinohoy.R;

import quecocino.example.quecocinohoy.db.DbHelper;


public class MainActivityRegister2Step extends AppCompatActivity {
    private Button btnInicio;
    private ImageButton btnMostrarPass;
    private EditText txtPass, txtPassDos;
    private boolean visible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_register2_step);
        btnInicio = findViewById(R.id.btnInicio);
        btnMostrarPass = findViewById(R.id.imgbtnMostrarPass);
        txtPass = findViewById(R.id.txtPassRegister);
        txtPassDos = findViewById(R.id.txtPassDosRegister);

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
                        Bundle datos = MainActivityRegister2Step.this.getIntent().getExtras();
                        String correo = datos.getString("CorreoUsuario");
                        insertarPass(passUsuario, correo);
                        Intent intent = new Intent(MainActivityRegister2Step.this, MainActivityInicio.class);
                        Vibrator vibrator = (Vibrator)getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                        vibrator.vibrate(1500);
                        intent.putExtra("CorreoUsuario",correo);
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

    public void insertarPass(String passUsuario, String correo){
        try {
            DbHelper dbhelper = new DbHelper(MainActivityRegister2Step.this);
            SQLiteDatabase db = dbhelper.getWritableDatabase();
            String sql = "UPDATE usuarios SET pass_usuario = '"+passUsuario+"' WHERE correo = '"+correo+"'";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.execute();
            Toast.makeText(this, "Datos agregados satisfactoriamente en la base de datos.", Toast.LENGTH_LONG).show();
        }
        catch (Exception ex) {
            Toast.makeText(this, "Error no se pudieron guardar los datos.", Toast.LENGTH_LONG).show();
        }
    }
}