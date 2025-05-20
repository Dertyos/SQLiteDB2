package com.example.sqlitedb;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
	SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//Abrimos la base de datos 'Empresa' en modo escritura
		UsuariosSQLiteHelper usdbh = new UsuariosSQLiteHelper( this, "Empresa", null, 1 );

		db = usdbh.getWritableDatabase();
	}

	public void funAgregar( View V ){
		String sql, x, y;
		TextView cod = (TextView) findViewById(R.id.edtCodigo);
		TextView nom = (TextView) findViewById(R.id.edtNombre);

		x = cod.getText().toString();
		y = nom.getText().toString();
		sql = "select * from usuarios where codigo='"+x+"'";
		Cursor c = db.rawQuery( sql , null);
		try{
			if(  c.moveToFirst() ){
				Toast.makeText( getApplicationContext(), "Usuario "+x+" existe", Toast.LENGTH_SHORT).show();
			}
			else{
				sql = "INSERT INTO Usuarios (codigo, nombre) " +
						"VALUES (" + x + ", '" + y +"')";
				db.execSQL( sql );		
				Toast.makeText( getApplicationContext(), "Registro Insertado", Toast.LENGTH_SHORT).show();
				cod.setText("");
				nom.setText("");
			}
		}catch( Exception e){
			Log.e("SQLite", "Error base de datos" );
		}

	}

	public void funEliminar( View V ){
		String sql, x, y;
		TextView cod = (TextView) findViewById(R.id.edtCodigo);
		TextView nom = (TextView) findViewById(R.id.edtNombre);

		x = cod.getText().toString();
		y = nom.getText().toString();
		sql = "select * from usuarios where codigo='"+x+"'";
		Cursor c = db.rawQuery( sql , null);
		try{
			if( ! c.moveToFirst() ){
				Toast.makeText( getApplicationContext(), "Usuario "+x+" NO existe", Toast.LENGTH_SHORT).show();
			}
			else{
				sql = "DELETE FROM usuarios WHERE codigo = '" + x + "'";
				db.execSQL( sql );		
				Toast.makeText( getApplicationContext(), "Registro Eliminado", Toast.LENGTH_SHORT).show();
				cod.setText("");
				nom.setText("");
			}
		}catch( Exception e){
			Log.e("SQLite", "Error base de datos" );
		}

	}

	public void funBuscar( View V ){
		String sql, x, y;
		TextView cod = (TextView) findViewById(R.id.edtCodigo);
		TextView nom = (TextView) findViewById(R.id.edtNombre);

		x = cod.getText().toString();
		y = nom.getText().toString();
		sql = "select * from usuarios where codigo='"+x+"'";
		Cursor c = db.rawQuery( sql , null);
		try{
			if( ! c.moveToFirst() ){
				Toast.makeText( getApplicationContext(), "Usuario "+x+" NO existe", Toast.LENGTH_SHORT).show();
			}
			else{
				x = c.getString(0); // codigo 
				y = c.getString(1);  //nombre
				Toast.makeText( getApplicationContext(), "Registro Encontrado", Toast.LENGTH_SHORT).show();
				cod.setText( x );
				nom.setText( y );
			}
		}catch( Exception e){
			Log.e("SQLite", "Error base de datos" );
		}

	}
	
	public void funListar( View V ){
		TextView lst = (TextView) findViewById(R.id.txtListar);
		String x, cod, nom = "";
		String sql = "select * from usuarios order by codigo";
		Cursor c = db.rawQuery( sql , null);
		x = "";
		try{
			if( c.moveToFirst() ){
				do{
					cod = c.getString(0); // codigo 
					nom = c.getString(1);  //nombre
					x = x + cod + " " + nom + "\n";
				}while( c.moveToNext() );
			}
			lst.setText( x );
		}catch( Exception e){
			Log.e("SQLite", "Error base de datos" );
		}
	}

	public void funListar2( View V ){
		TextView lst = (TextView) findViewById(R.id.txtListar);
		String x, cod, nom = "";
		String sql = "select * from ciudades order by codigo";
		Cursor c = db.rawQuery( sql , null);
		x = "";
		try{
			if( c.moveToFirst() ){
				do{
					cod = c.getString(0);
					nom = c.getString(1);
					x = x + cod + " " + nom + "\n";
				}while( c.moveToNext() );
			}
			lst.setText( x );
		}catch( Exception e){
			Log.e("SQLite", "Error base de datos" );
		}

	}
}
/*

//Si hemos abierto correctamente la base de datos
if(db != null)
{
	//Insertamos 5 usuarios de ejemplo
	for(int i=1; i<=5; i++)
	{
		//Generamos los datos
		int codigo = i;
		String nombre = "Usuario" + i;

		//Insertamos los datos en la tabla Usuarios
		db.execSQL("INSERT INTO Usuarios (codigo, nombre) " +
				"VALUES (" + codigo + ", '" + nombre +"')");
	}

	//Cerramos la base de datos
	db.close();
}	

 */