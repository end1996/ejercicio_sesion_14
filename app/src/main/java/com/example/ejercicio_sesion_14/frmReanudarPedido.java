package com.example.ejercicio_sesion_14;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class frmReanudarPedido extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_reanudar_pedido);
    }

//    public class ProductoDAO {
//        Connection con;
//        Conexion cn=new Conexion();
//        PreparedStatement ps;
//        ResultSet rs;
//
//        public List listar(){
//            List<Producto>productos=new ArrayList();
//            String sql="select * from productos";
//            try {
//                con=cn.getConnection();
//                ps=con.prepareStatement(sql);
//                rs=ps.executeQuery();
//            }
//        }
//
//    }
}