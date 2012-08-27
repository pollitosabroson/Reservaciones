package com.opt.exc;


import java.util.ArrayList;
import java.util.List;

import com.opt.exc.InfoActivity.ListViewAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListaVuelos extends Activity {
	public ListView lv_info;
	public ArrayList<String> info;
	static ListViewAdapter adaptador;
	
	
	protected void onCreate( Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listar);
		inicioLista();
		
		
	}
	
	private void inicioLista(){
		
		try{
		List<Clientes > lista = Conector.listarClientes();
		if(lista == null){
			Toast.makeText(this, "Sola", Toast.LENGTH_LONG).show();
		}
		Log.e("lista", lista.size()+"");
		
		for (int i = 0; i < lista.size(); i++) {
			
			info.add("Hora de salida: "+lista.get(i).getHora_salida()+"\n"+
					  "Hora de llegada: "+lista.get(i).getHora_llegada()+"\n"+
					  "precio por adulto: "+lista.get(i).getPre_adul()+"\n"+
					  "Ciudad Origen: "+lista.get(i).getCiu_origen()+"\n"+
					  "ciudad Destino: "+lista.get(i).getCiu_destino());
					  
			Log.e("Error", "prueba del main");
			
			
		}
		
	}catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
		Log.e("Error", "prueba del main3");
	}
		Log.e("Error", "prueba del main2");
		ArrayAdapter<String> adatador = new ArrayAdapter<String>(this, android.R.layout.activity_list_item, info);
		lv_info = (ListView) findViewById(R.id.lv_info);
		lv_info.setAdapter(adatador);
	}
}
