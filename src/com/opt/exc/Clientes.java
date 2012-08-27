package com.opt.exc;

import org.ksoap2.serialization.SoapObject;


public class Clientes extends SoapObject {
	private String et_nombre;
	private String et_apaterno;
	private String et_amaterno;
	private String sexo;
	private String edad;
	private String adultos;
	private String ninos;
	private String hora_salida;
	private String hora_llegada;
	private String pre_nino;
	private String pre_adul;
	private String ciu_origen;
	private String ciu_destino;

	public Clientes(String namespace, String name) {
		super(namespace, name);
		// TODO Auto-generated constructor stub
	}

	public String getEt_nombre() {
		return et_nombre;
	}

	public void setEt_nombre(String et_nombre) {
		this.et_nombre = et_nombre;
	}

	public String getEt_apaterno() {
		return et_apaterno;
	}

	public void setEt_apaterno(String et_apaterno) {
		this.et_apaterno = et_apaterno;
	}

	public String getEt_amaterno() {
		return et_amaterno;
	}

	public void setEt_amaterno(String et_amaterno) {
		this.et_amaterno = et_amaterno;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getAdultos() {
		return adultos;
	}

	public void setAdultos(String adultos) {
		this.adultos = adultos;
	}

	public String getNinos() {
		return ninos;
	}

	public void setNinos(String ninos) {
		this.ninos = ninos;
	}

	public String getHora_salida() {
		return hora_salida;
	}

	public void setHora_salida(String hora_salida) {
		this.hora_salida = hora_salida;
	}

	public String getHora_llegada() {
		return hora_llegada;
	}

	public void setHora_llegada(String hora_llegada) {
		this.hora_llegada = hora_llegada;
	}

	public String getPre_nino() {
		return pre_nino;
	}

	public void setPre_nino(String pre_nino) {
		this.pre_nino = pre_nino;
	}

	public String getPre_adul() {
		return pre_adul;
	}

	public void setPre_adul(String pre_adul) {
		this.pre_adul = pre_adul;
	}

	public String getCiu_origen() {
		return ciu_origen;
	}

	public void setCiu_origen(String ciu_origen) {
		this.ciu_origen = ciu_origen;
	}

	public String getCiu_destino() {
		return ciu_destino;
	}

	public void setCiu_destino(String ciu_destino) {
		this.ciu_destino = ciu_destino;
	}
	
}
