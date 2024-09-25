package com.ipartek.modelo.dto;

public class V_Modelo extends Modelo {
    private String marca;

    public V_Modelo() {
	super();
	this.marca = "";
    }

    public V_Modelo(int id, String modelo, int fK_marca, String marca) {
	super(id, modelo, fK_marca);
	this.marca = marca;
    }

    public String getMarca() {
	return marca;
    }

    public void setMarca(String marca) {
	this.marca = marca;
    }

    @Override
    public String toString() {
	return "V_Modelo [marca=" + marca + "]";
    }

}
