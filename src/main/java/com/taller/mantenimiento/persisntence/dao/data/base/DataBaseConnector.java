package com.taller.mantenimiento.persisntence.dao.data.base;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnector {
    private static final String URL = "jdbc:postgresql://localhost:5432/taller?autoReconnect=true&useSSL=false";
    private static final String USUARIO = "postgres";
    private static final String CLAVE = "proyects-db-acces";

    public Connection getConnection(){
        Connection conexion = null;
        try{
            Class.forName("org.postgresql.Driver");
            System.out.println("Conexión exitosa");
            return conexion = (Connection) DriverManager.getConnection(URL, USUARIO, CLAVE);
        }catch(Exception ex){
            System.out.println("ERROR: "+ex);
        }
        return conexion;
    }
}
