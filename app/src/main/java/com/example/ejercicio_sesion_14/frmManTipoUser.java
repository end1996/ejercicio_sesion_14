package com.example.ejercicio_sesion_14;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.StrictMode;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import android.widget.Toast;
import android.view.View;

public class frmManTipoUser extends AppCompatActivity {
    private EditText txtUsu, txtPass,txtPassC;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_man_tipo_user);
        txtUsu=findViewById(R.id.txtUsuarioR);
        txtPass=findViewById(R.id.txtPasswordR);
        txtPassC=findViewById(R.id.txtPasswordRC);
    }

    public void Inicio(View view){
        Intent x=new Intent(this,MainActivity.class);
        startActivity(x);
    }


    public Connection conexionBD(){
        Connection cnn=null;
        try {
            StrictMode.ThreadPolicy pol=new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(pol);
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            cnn= DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.5:1433/BDCarrito;"+
                    "instance=MSSQLSERVER;user=sa;password=12345");
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
        return cnn;
    }
    public void Registrar(View view){
        try {
            Statement st=conexionBD().createStatement();
            if (txtUsu.toString().compareTo("")!=0 && txtPass.toString().compareTo("")!=0
                    && txtPassC.toString().compareTo("")!=0)
            {
                //st.executeUpdate("tipo_usuario");
                st.executeUpdate("insert into tipo_usuarios values('TU000010','cliente');"+
               "insert into usuarios values('USU000010','TU000010','"+txtUsu.getText().toString()+"','"+txtPass.getText().toString()+"')");
            }

            //tipo_usuario


        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}