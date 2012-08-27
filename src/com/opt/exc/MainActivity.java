package com.opt.exc;


import java.util.List;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	static Button boton1;
	static EditText destino;
	static EditText origen;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		destino = (EditText) findViewById(R.id.destino);
		origen = (EditText) findViewById(R.id.origen);

		boton1 = (Button) findViewById(R.id.boton1);
		boton1.setOnClickListener(this);
	}
	
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		//Resvuelos objResvuelos = new Resvuelos("","");

		try {
			//objResvuelos.setDestino(destino.getText().toString());
			//objResvuelos.setOrigen(origen.getText().toString());


			switch (v.getId()) {
			case R.id.boton1:
				List<Clientes> respuesta = Conector.listarClientes();
				if (respuesta != null && respuesta.size() >= 0) {
					Toast.makeText(this, "Vuelo encontrado", Toast.LENGTH_LONG).show();
				
				Intent intencion = new Intent("com.opt.exc.InfoActivity");
				startActivity(intencion);
				} else {
					limpiarCampos();
					Toast.makeText(this, "No se encontro ningun registro",
							Toast.LENGTH_LONG).show();
				}
				break;

			default:
				break;
			}
		} catch (Exception e) {
			Toast.makeText(this, "Ocurrió un error!", Toast.LENGTH_LONG).show();
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unused")
	private boolean verificarCampos() {
		if (!destino.getText().toString().equals("")
				&& !origen.getText().toString().equals("")) {
			return true;
		} else {
			return false;
		}
	}

	private void limpiarCampos() {
		destino.setText(null);
		origen.setText(null);
	}

	
	
		
	}



	

