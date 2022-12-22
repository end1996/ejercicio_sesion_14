package com.example.ejercicio_sesion_14;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private EditText txtUsu, txtPass;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUsu=findViewById(R.id.txtUsuario);
        txtPass=findViewById(R.id.txtPassword);
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
    public void Consulta(View view){
        try {
            Statement st=conexionBD().createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM usuarios " +
                    "where logeo='"+txtUsu.getText().toString()+"'and clave='"+txtPass.getText().toString()+"'");
            if(rs.next()){

                String tipoU=rs.getString(2);
                Toast.makeText(getApplicationContext(),"Conexion establecida con Jhon Torres "+rs.getString(2),Toast.LENGTH_SHORT).show();
                if(tipoU.compareTo("TU00001")==0) {//cliente
                    Intent x=new Intent(this,frmMainCliente1.class);
                    startActivity(x);
                }
                if(tipoU.compareTo("TU00002")==0) {//admin
                    Intent x=new Intent(this,frmMainAdmin1.class);
                    startActivity(x);
                }
                if(tipoU.compareTo("TU00003")==0) {//invitado
                    Intent x=new Intent(this,frmMainInvitado1.class);
                    startActivity(x);
                }

            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}