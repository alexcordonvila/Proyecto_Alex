package com.ipartek.modelo;

import java.sql.Connection;
import java.util.List;

import com.ipartek.modelo.dto.V_Modelo;
import com.ipartek.modelo.dto.V_Ordenador;



public interface I_Metodos {

	
	public Connection conectar();
	void desconectar(Connection con);
	
	public List<V_Ordenador> obtenerTodosOrdenadores(Connection con);
	public int eliminarOrdenador(Connection con, int id);
	
	public List<V_Modelo> obtenerTodosModelos(Connection con);

}
