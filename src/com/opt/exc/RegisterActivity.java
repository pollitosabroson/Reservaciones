package com.opt.exc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity implements OnClickListener {
	static EditText et_nombre;
	static EditText et_apaterno;
	static EditText et_amaterno;
	static EditText sexo;
	static EditText edad;
	static EditText ninos;
	static EditText adultos;
	static Button boton2;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		et_nombre = (EditText) findViewById(R.id.et_nombre);
		et_apaterno = (EditText) findViewById(R.id.et_apaterno);
		et_amaterno = (EditText) findViewById(R.id.et_amaterno);
		sexo = (EditText) findViewById(R.id.sexo);
		edad = (EditText) findViewById(R.id.edadcliente);
		ninos = (EditText) findViewById(R.id.ninos);
		adultos = (EditText) findViewById(R.id.adultos);

		boton2 = (Button) findViewById(R.id.boton2);
		boton2.setOnClickListener(this);

	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		Clientes objeto = new Clientes("", "");

		try {
			objeto.setEt_nombre(et_nombre.getText().toString());
			objeto.setEt_apaterno(et_apaterno.getText().toString());
			objeto.setEt_amaterno(et_amaterno.getText().toString());
			objeto.setSexo(sexo.getText().toString());
			objeto.setEdad(edad.getText().toString());
			objeto.setNinos(ninos.getText().toString());
			objeto.setAdultos(adultos.getText().toString());

			switch (v.getId()) {
			case R.id.boton2:

				if (Conector.agregarCliente(objeto)) {
					Toast.makeText(this, "Felicidades acabas de registrar tu vuelo =)",
							Toast.LENGTH_LONG).show();
					Bundle bundle = new Bundle();
					bundle.putString("nombre",et_nombre.getText().toString() );
					bundle.putString("Apaterno",et_apaterno.getText().toString());
					bundle.putString("Amaterno", et_amaterno.getText().toString());
					bundle.putString("Sexo", sexo.getText().toString());
					bundle.putString("Ninos", ninos.getText().toString());
					bundle.putString("Edad",edad.getText().toString());
					
					bundle.putString("Adultos",adultos.getText().toString());
					
					Intent intencion = new Intent("com.opt.exc.ListaTotal");
					intencion.putExtra("bundle", bundle);
					startActivity(intencion);
				} else {
					Toast.makeText(this, "No se Agrego nada", Toast.LENGTH_LONG)
							.show();
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

}
