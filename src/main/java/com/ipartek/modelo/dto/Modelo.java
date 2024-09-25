package com.ipartek.modelo.dto;

public class Modelo {

	private int id;
	private String modelo;
	private int FK_marca;
	
	public Modelo() {
		super();
		this.id = 0;
		this.modelo = "";
		FK_marca = 0;
	}
	
	public Modelo(int id, String modelo, int fK_marca) {
		super();
		this.id = id;
		this.modelo = modelo;
		FK_marca = fK_marca;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getFK_marca() {
		return FK_marca;
	}
	public void setFK_marca(int fK_marca) {
		FK_marca = fK_marca;
	}

	@Override
	public String toString() {
		return "Modelo [id=" + id + ", modelo=" + modelo + ", FK_marca=" + FK_marca + "]";
	}
	
	
	
}
