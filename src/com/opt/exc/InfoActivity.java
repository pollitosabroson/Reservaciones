package com.opt.exc;


import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class InfoActivity extends ListActivity {
	static ListViewAdapter adaptador;
	static  ArrayList<ElementosLista> elementos = null;

	
	public void onCrate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listar);
		
		TextView titulo = (TextView) findViewById(R.id.titulo_listar);
		titulo.setText("Todos los registros");
		Log.e("error", "listas");
		
		
		elementos = new ArrayList<ElementosLista>();
		adaptador = new ListViewAdapter(this, R.layout.info_lista,elementos);
		setListAdapter(adaptador); 
		
		incializarLista();
		
	}
	private void incializarLista(){
		try{
			elementos = new ArrayList<ElementosLista>();
			ElementosLista elemento;
			List<Clientes> lista = new ArrayList<Clientes>();
			
			lista = Conector.listarClientes();
			
			for(int i = 0; i < lista.size(); i++){
				elemento = new ElementosLista("Hora de salida: "+lista.get(i).getHora_salida()+"\n"+
											  "Hora de llegada: "+lista.get(i).getHora_llegada()+"\n"+
											  "Precio por niño: "+lista.get(i).getPre_nino()+"\n"+
											  "precio por adulto: "+lista.get(i).getPre_adul()+"\n"+
											  "Ciudad Origen: "+lista.get(i).getCiu_origen(),
											  "ciudad Destino: "+lista.get(i).getCiu_destino());
				elementos.add(elemento);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (elementos != null && elementos.size() > 0) {
			for (int i = 0; i < elementos.size(); i++) {
				adaptador.add(elementos.get(i));
			}
		}
		adaptador.notifyDataSetChanged();
		
	}
	
	class ListViewAdapter extends ArrayAdapter<ElementosLista>{
		
		
	
		@SuppressWarnings("unused")
		private ArrayList<ElementosLista> elementos;

		public ListViewAdapter(Context context, int textViewResourceId,
				ArrayList<ElementosLista> elementos) {
			super(context, textViewResourceId,elementos);
			this.elementos = elementos;
		}
		
		
	}
		@SuppressWarnings("static-access")
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View v = convertView;
			
			if(v == null){
				LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 				v = vi.inflate(R.layout.info_lista, null);
			}
			try {
			
				ElementosLista e = this.elementos.get(position);
 				
 				if(e != null){
 	 				TextView nombres = (TextView) v.findViewById(R.id.nombre_lista);
 	 				TextView descripcion = (TextView) v.findViewById(R.id.descripcion_lista);
 	 				
 	 				if(nombres != null){
 	 					nombres.setText(e.getNombre());
 	 				}
 	 				if(descripcion != null){
 	 					descripcion.setText(e.getDescripcion());
 	 				}
 	 				
 	 			}
			}
			catch (Exception e) {
				Log.e("Exception", e.getMessage());
			}
 			
 			return v;
		}
		
	}
	


