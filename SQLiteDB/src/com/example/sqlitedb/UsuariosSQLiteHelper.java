package com.example.sqlitedb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
 
public class UsuariosSQLiteHelper extends SQLiteOpenHelper {
 
    // Sentencia SQL para crear la tabla de Usuarios
    String sqlCreate = "CREATE TABLE Usuarios (codigo INTEGER, nombre TEXT)";
 
    public UsuariosSQLiteHelper(Context contexto, String nombre,
                               CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Se ejecuta la sentencia SQL de creaci�n de la tabla
        //db.execSQL("DROP TABLE IF EXISTS Usuarios");
        //db.execSQL("DROP TABLE IF EXISTS Ciudades");
 
      
        //Se crea la nueva versi�n de la tabla
        //db.execSQL(sqlCreate);
        
        db.execSQL( "CREATE TABLE Usuarios (codigo INTEGER, nombre TEXT) " );
        db.execSQL( "INSERT INTO Usuarios (codigo,nombre) VALUES (1,'alex') " );
        db.execSQL( "INSERT INTO Usuarios (codigo,nombre) VALUES (3,'pepe') " );
        db.execSQL( "INSERT INTO Usuarios (codigo,nombre) VALUES (9,'pepito') " );
        db.execSQL( "INSERT INTO Usuarios (codigo,nombre) VALUES (69,'maria') " );
        db.execSQL( "INSERT INTO Usuarios (codigo,nombre) VALUES (72,'juana'); ");
        db.execSQL( "INSERT INTO Usuarios (codigo,nombre) VALUES (73,'mariajuana'); ");
        
        db.execSQL( "CREATE TABLE ciudades ( codigo	TEXT, nombre TEXT) " );
        db.execSQL(  "INSERT INTO ciudades (codigo,nombre) VALUES ('73001','ibague') " );
        db.execSQL( "INSERT INTO ciudades (codigo,nombre) VALUES ('11001','bogota') " );
        db.execSQL( "INSERT INTO ciudades (codigo,nombre) VALUES ('73296','espinal') " );
        // db.execSQL(sqlCreate);
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        //NOTA: Por simplicidad del ejemplo aqu� utilizamos directamente la opci�n de
        //      eliminar la tabla anterior y crearla de nuevo vac�a con el nuevo formato.
        //      Sin embargo lo normal ser� que haya que migrar datos de la tabla antigua
        //      a la nueva, por lo que este m�todo deber�a ser m�s elaborado.
 
        //Se elimina la versi�n anterior de la tabla
    }
}
