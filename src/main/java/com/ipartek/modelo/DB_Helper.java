package com.ipartek.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.I_Colores;
import com.ipartek.modelo.dto.V_Ordenador;


public class DB_Helper implements I_Conexion, I_Metodos {

	@Override
	public Connection conectar() {

		Connection con= null;

		try {
			Class.forName(DRIVER);
			con= DriverManager.getConnection(CONEXION, USUARIO ,PASS );

			System.out.println(I_Colores.ANSI_GREEN+"BD conectada"+I_Colores.ANSI_RESET);
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR DE BD");
			System.out.println("No se encontro el driver");
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("ERROR DE BD");
			System.out.println("No se pudo conectar a la BD");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("ERROR DE BD");
			System.out.println("Error desconocido");
			System.out.println(e.getMessage());
		}

		return con;
	}

	@Override
	public void desconectar(Connection con) {

		try {
			con.close();
			System.out.println("BD desconectada");
		} catch (SQLException e) {
			System.out.println("ERROR DE BD");
			System.out.println("No se pudo desconectar de la BD");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("ERROR DE BD");
			System.out.println("Error desconocido");
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<V_Ordenador> obtenerTodosOrdenadores(Connection con) {
		List<V_Ordenador> lista = new ArrayList<V_Ordenador>();
		try {
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_TODOS_ORDENADORES);
			
			boolean tieneSelect = cStmt.execute();
			
			if (tieneSelect==true) {
				
				//cargar la lista
				
				ResultSet rs=cStmt.getResultSet();
				
				while(rs.next()) {	
					
					V_Ordenador ord=new V_Ordenador();
					System.out.println("DDDDDDDDDDDDDDDDDDDDDDD");
					ord.setId(rs.getInt(V_ORDENADORES_ID));
					ord.setNumeroSerie(rs.getString(V_ORDENADORES_NUMERO_SERIE));
					ord.setCapacidad(rs.getInt(V_ORDENADORES_CAPACIDAD));
					ord.setRam(rs.getInt(V_ORDENADORES_RAM));
					ord.setAnotaciones(rs.getString(V_ORDENADORES_ANOTACIONES));
					ord.setModelo(rs.getString(V_ORDENADORES_MODELO));
					ord.setMarca(rs.getString(V_ORDENADORES_MARCA));
					
					lista.add(ord);
				}
				
				System.out.println("Lista de todos los ordenadores obtenida:");
				System.out.println(lista);
				
				return lista;
				
			}else {
				System.out.println("No se pudo obtener una lista de ordenadores");
				System.out.println("El Stored procedure no tiene un RESULTSET");
				
				return new ArrayList<V_Ordenador>();	
			}

		} catch (SQLException e) {
			System.out.println("ERROR DE BD: CONSULTA");
			System.out.println("Error al obtener la lista de todos los ordenadores");
			System.out.println(e.getMessage());
			
			return new ArrayList<V_Ordenador>();
		}
	}
}
