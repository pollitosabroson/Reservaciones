package com.opt.exc;

import java.util.ArrayList;
import java.util.List;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;




import android.util.Log;

public class Conector {
	private static String WS_NAMESPACE = "http://web.service.org/";
	private static String WS_URL = "http://192.168.9.204:8080/ProyectoAndroid/Servicio";
	private static String WS_OPERATION;
	
	public static boolean agregarCliente(Clientes instancia){
		WS_OPERATION ="CreateCliente";
		
		SoapObject peticion = new SoapObject(WS_NAMESPACE, WS_OPERATION);
		peticion.addProperty("Nombre", instancia.getEt_nombre());
		peticion.addProperty("A_paterno", instancia.getEt_apaterno());
		peticion.addProperty("A_materno", instancia.getEt_amaterno());
		peticion.addProperty("Sexo", instancia.getSexo());
		peticion.addProperty("Edad",instancia.getEdad());
		peticion.addProperty("CantidadDeNinos", instancia.getNinos());
		peticion.addProperty("CantidadDeAdultos",instancia.getAdultos());
		
	
		SoapSerializationEnvelope envoltura = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envoltura.setOutputSoapObject(peticion);
		
		HttpTransportSE transporte = new HttpTransportSE(WS_URL);
		
		try{
			transporte.call("", envoltura);
			Log.e("Error", "ddfdsfdsa");
			return envoltura.getResponse().toString().equals("true");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static List<Clientes> listarClientes(){
		WS_OPERATION = "listVuelos";
		Clientes objetoVuelo = null;
		List<Clientes> listaClientes = null;
		List<SoapObject> listaSoap = null;
		
		SoapObject peticion = new SoapObject(WS_NAMESPACE, WS_OPERATION);
		
		SoapSerializationEnvelope envoltura = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			envoltura.setOutputSoapObject(peticion);
		
		HttpTransportSE transporte = new HttpTransportSE(WS_URL);
		
		try {
			transporte.call("", envoltura);
			listaSoap = (List<SoapObject>) envoltura.getResponse();
			
		} catch (Exception e) {
			Log.e("EXCEPTION IN: ", "ListarClientes");
			return null;
		}
		listaClientes = new ArrayList<Clientes>();
		
		
		for(SoapObject soap : listaSoap){
			objetoVuelo = new Clientes("", "");
			objetoVuelo.setCiu_origen(soap.getPropertyAsString("ciudadOrigen"));
			objetoVuelo.setCiu_destino(soap.getPropertyAsString("ciudadDestino"));
			objetoVuelo.setHora_salida(soap.getPropertyAsString("horaSalida"));
			objetoVuelo.setHora_llegada(soap.getPropertyAsString("horaLlegada"));
			objetoVuelo.setPre_adul(soap.getPropertyAsString("precioAdultos"));
			
			listaClientes.add(objetoVuelo);
			Log.e("ciudad", soap.getPropertyAsString("ciudadOrigen"));
			Log.e("origen", soap.getPropertyAsString("ciudadDestino"));
			Log.e("SALIDA", soap.getPropertyAsString("horaSalida"));
			Log.e("LLEGADA", soap.getPropertyAsString("horaLlegada"));
			Log.e("Adultos", soap.getPropertyAsString("precioAdultos"));
			
			
		}
		Log.e("lista", listaClientes.size()+"");
		return listaClientes;
	}
	
	
	@SuppressWarnings({ "unchecked", "null" })
	public static List<Resvuelos>searchCriterioVuelos(Resvuelos instancia){
		WS_OPERATION = "SearchCriteriosVuelos";
		
		Resvuelos objetovuelo = null;
		List<Resvuelos> listavuelo = null;
		List<SoapObject> listaSoap = null;
		
		SoapObject peticion = new SoapObject(WS_NAMESPACE, WS_OPERATION);
		peticion.addProperty("Ciudad_origen", instancia.getOrigen().toString());
		peticion.addProperty("Ciudad_destino", instancia.getDestino().toString());
		
		SoapSerializationEnvelope envoltura = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envoltura.setOutputSoapObject(peticion);
		
		HttpTransportSE transporte = new HttpTransportSE(WS_URL);
		
		try{
			transporte.call("", envoltura);
			
			listaSoap = (List<SoapObject>) envoltura.getResponse();
		}catch (Exception e) {
			// TODO: handle exception
			Log.e("EXCEPTION IN","searchCriterioVuelos" );
			return null;
		}
		for(SoapObject soap: listaSoap){
			objetovuelo.setDestino(soap.getPropertyAsString("Ciudad_destino"));
			objetovuelo.setOrigen(soap.getPropertyAsString("Ciudad_origen"));
			listavuelo.add(objetovuelo);
		}
		return listavuelo;
	}

}
