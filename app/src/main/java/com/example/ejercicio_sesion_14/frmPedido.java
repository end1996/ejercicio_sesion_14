package com.example.ejercicio_sesion_14;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import android.widget.Toast;
import android.view.View;

public class frmPedido extends AppCompatActivity {
    private static int valor = 1;
    private EditText txtMM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_pedido);
        txtMM = findViewById(R.id.txtMM);
        TextView cantidad = findViewById(R.id.txtMM);
        Button aumentar = findViewById(R.id.btnMas);
        Button disminuir = findViewById(R.id.btnMenos);
        TextView cantidad2 = findViewById(R.id.txtMM2);
        Button aumentar2 = findViewById(R.id.btnMas2);
        Button disminuir2 = findViewById(R.id.btnMenos2);
        TextView cantidad3 = findViewById(R.id.txtMM3);
        Button aumentar3 = findViewById(R.id.btnMas3);
        Button disminuir3 = findViewById(R.id.btnMenos3);

        aumentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantidad.setText(String.valueOf(++valor));
            }
        });

        disminuir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantidad.setText(String.valueOf(--valor));
            }
        });
        aumentar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantidad2.setText(String.valueOf(++valor));
            }
        });

        disminuir2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantidad2.setText(String.valueOf(--valor));
            }
        });
        aumentar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantidad3.setText(String.valueOf(++valor));
            }
        });

        disminuir3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantidad3.setText(String.valueOf(--valor));
            }
        });
    }

    public void Logout(View view){
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
    public void RegistrarCompra(View view){
        try {
            Statement st=conexionBD().createStatement();
            if(txtMM.toString().compareTo("1") != 0) {

                //st.executeUpdate("tipo_usuario");
                st.executeUpdate("insert into productos values('p00007','memoria ram','1','309','8gb','1',1)");

                    Intent x=new Intent(this,frmReanudarPedido.class);
                    startActivity(x);

            }


        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}


