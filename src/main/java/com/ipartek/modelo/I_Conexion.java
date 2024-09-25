package com.ipartek.modelo;

import java.sql.Connection;

public interface I_Conexion {

	// Constantes para BD
	String BASE_DATOS = "db_reparaciones";
	String DRIVER = "com.mysql.jdbc.Driver";
	String CONEXION = "jdbc:mysql://localhost:3306/" + BASE_DATOS;
	String USUARIO = "root";
	String PASS = "1234";

	// Archivos JSP
	String JSP_TODOS = "index.jsp";
	String JSP_ADMIN = "admin.jsp";

	// Tablas de la BD
	String TABLA_ORDENADORES = "ordenadores";
	String ORDENADORES_ID = "id";
	String ORDENADORES_NUMERO_SERIE = "numeroSerie";
	String ORDENADORES_FK_MODELO = "FK_modelo";
	String ORDENADORES_CAPACIDAD = "capacidad";
	String ORDENADORES_RAM = "ram";
	String ORDENADORES_ANOTACIONES = "anotaciones";

	String VISTA_PRODUCTOS = "v_ordenadores";
	String V_ORDENADORES_ID = "id";
	String V_ORDENADORES_NUMERO_SERIE = "numeroSerie";
	String V_ORDENADORES_CAPACIDAD = "capacidad";
	String V_ORDENADORES_RAM = "ram";
	String V_ORDENADORES_ANOTACIONES = "anotaciones";
	String V_ORDENADORES_MODELO = "modelo";
	String V_ORDENADORES_MARCA = "marca";

	String TABLA_MODELOS = "modelos";
	String MODELOS_ID = "id";
	String MODELOS_MODELO = "ordenador";
	String MODELOS_FK_MARCA = "FK_marca";

	String TABLA_MARCAS = "marcas";
	String MARCAS_ID = "id";
	String MARCAS_MARCA = "marca";

	// stored procedures
	String SP_OBTENER_TODOS_ORDENADORES = "call sp_obtener_todos_ordenadores();";
	String SP_ELIMINAR_ORDENADOR = "call sp_eliminar_ordenador(?);";

	// atributos de la mochila
	String ATR_LISTA_ORDENADORES = "atr_lista_ordenadores";

}
