package com.opt.exc;

import org.ksoap2.serialization.SoapObject;

public class Resvuelos extends SoapObject {
	public Resvuelos(String namespace, String name) {
		super(namespace, name);
		// TODO Auto-generated constructor stub
	}


	private String destino;
	private String origen;
	private String Hora_salida;
	private String Hora_llegada;
	private String PreciosNinos;
	private String PrecioAdultos;
	private String ciudad_origen;
	private String Ciudad_destino;
	
	


	/**
	 * @return the destino
	 */
	public String getDestino() {
		return destino;
	}


	/**
	 * @param destino the destino to set
	 */
	public void setDestino(String destino) {
		this.destino = destino;
	}


	/**
	 * @return the origen
	 */
	public String getOrigen() {
		return origen;
	}


	/**
	 * @param origen the origen to set
	 */
	public void setOrigen(String origen) {
		this.origen = origen;
	}


	/**
	 * @return the hora_salida
	 */
	public String getHora_salida() {
		return Hora_salida;
	}


	/**
	 * @param hora_salida the hora_salida to set
	 */
	public void setHora_salida(String hora_salida) {
		Hora_salida = hora_salida;
	}


	/**
	 * @return the hora_llegada
	 */
	public String getHora_llegada() {
		return Hora_llegada;
	}


	/**
	 * @param hora_llegada the hora_llegada to set
	 */
	public void setHora_llegada(String hora_llegada) {
		Hora_llegada = hora_llegada;
	}


	/**
	 * @return the preciosNinos
	 */
	public String getPreciosNinos() {
		return PreciosNinos;
	}


	/**
	 * @param preciosNinos the preciosNinos to set
	 */
	public void setPreciosNinos(String preciosNinos) {
		PreciosNinos = preciosNinos;
	}


	/**
	 * @return the precioAdultos
	 */
	public String getPrecioAdultos() {
		return PrecioAdultos;
	}


	/**
	 * @param precioAdultos the precioAdultos to set
	 */
	public void setPrecioAdultos(String precioAdultos) {
		PrecioAdultos = precioAdultos;
	}


	/**
	 * @return the ciudad_origen
	 */
	public String getCiudad_origen() {
		return ciudad_origen;
	}


	/**
	 * @param ciudad_origen the ciudad_origen to set
	 */
	public void setCiudad_origen(String ciudad_origen) {
		this.ciudad_origen = ciudad_origen;
	}


	/**
	 * @return the ciudad_destino
	 */
	public String getCiudad_destino() {
		return Ciudad_destino;
	}


	/**
	 * @param ciudad_destino the ciudad_destino to set
	 */
	public void setCiudad_destino(String ciudad_destino) {
		Ciudad_destino = ciudad_destino;
	}

	
}
