package com.ipartek.modelo.dto;

public class Ordenador {

	private int id;
	private String numeroSerie;
	private int capacidad;
	private int ram;
	private String anotaciones;
	private int fk_modelo;
	
	
	public Ordenador() {
		super();
		this.id = 0;
		this.numeroSerie = "";
		this.capacidad = 0;
		this.ram = 0;
		this.anotaciones = "";
		this.fk_modelo = 0;
	}

	public Ordenador(int id, String numeroSerie, int capacidad, int ram, String anotaciones, int fk_modelo) {
		super();
		this.id = id;
		this.numeroSerie = numeroSerie;
		this.capacidad = capacidad;
		this.ram = ram;
		this.anotaciones = anotaciones;
		this.fk_modelo = fk_modelo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public String getAnotaciones() {
		return anotaciones;
	}
	public void setAnotaciones(String anotaciones) {
		this.anotaciones = anotaciones;
	}
	public int getFk_modelo() {
		return fk_modelo;
	}
	public void setFk_modelo(int fk_modelo) {
		this.fk_modelo = fk_modelo;
	}
	@Override
	public String toString() {
		return "Ordenador [id=" + id + ", numeroSerie=" + numeroSerie + ", capacidad=" + capacidad + ", ram=" + ram
				+ ", anotaciones=" + anotaciones + ", fk_modelo=" + fk_modelo + "]";
	}

	
}
