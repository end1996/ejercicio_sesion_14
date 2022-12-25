package com.example.ejercicio_sesion_14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class frmMainCliente1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_main_cliente1);
    }

    public void Pedir(View view){
        Intent x=new Intent(this,frmPedido.class);
        startActivity(x);
    }


}