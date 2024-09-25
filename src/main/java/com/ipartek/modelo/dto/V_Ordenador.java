package com.ipartek.modelo.dto;

public class V_Ordenador extends Ordenador {

	private String modelo;
	private String marca;
	private int fk_marca;

	public V_Ordenador() {
		super();
		this.modelo = "";
		this.marca = "";
		this.fk_marca = 0;
	}

	public V_Ordenador(String modelo, String marca, int fk_marca) {
		super();
		this.modelo = modelo;
		this.marca = marca;
		this.fk_marca = fk_marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getFK_Marca() {
		return fk_marca;
	}

	public void setFK_Marca(int fk_marca) {
		this.fk_marca = fk_marca;
	}

	@Override
	public String toString() {
		return "V_Ordenador [modelo=" + modelo + ", marca=" + marca + ", fk_marca=" + fk_marca + "]";
	}

	
	
}
