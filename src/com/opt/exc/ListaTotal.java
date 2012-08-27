package com.opt.exc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListaTotal extends Activity implements OnItemClickListener{
	public ListView listas;
	public String [] info;
	
	
	
protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info);
		Bundle bundle = getIntent().getExtras().getBundle("bundle");
		listas = (ListView) findViewById(R.id.lv_info);
		
		info = new String[]{
				"Nombre: "+ bundle.getString("nombre"),
				"Apellido Paterno: "+ bundle.getString("Apaterno"),
				"Apellido Materno: "+ bundle.getString("Amaterno"),
				"Sexo: "+ bundle.getString("Sexo"),
				"Edad: "+ bundle.getString("Edad"),
				"Niños: "+bundle.getString("Ninos"),
				"Adultos: "+ bundle.getString("Adultos")
		};
		
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,info);
		//Se tiene que setear tod porque si no no funciona xD
		
		listas.setAdapter(adaptador);
		listas.setOnItemClickListener(this);
	}
	
		
	
	
	
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		Toast.makeText(this, info[arg2], Toast.LENGTH_LONG).show();
		
	}

}
