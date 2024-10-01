package com.ipartek;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;

import java.util.Set;
import java.util.stream.Collectors;

import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.dto.Marca;
import com.ipartek.modelo.dto.Ordenador;
import com.ipartek.modelo.dto.V_Modelo;
import com.ipartek.modelo.dto.V_Ordenador;

public class Helper {
    public static List<V_Ordenador> obtenerListaOrdenadores(DB_Helper db, Connection con) throws SQLException {
	return db.obtenerTodosOrdenadores(con);
    }
    public static List<V_Ordenador> obtenerListaOrdenadoresFiltrados(DB_Helper db, Connection con, Ordenador ordendaor) throws SQLException {
	return db.obtenerOrdenadoresFiltrados(con,ordendaor);
    }
    public static List<V_Modelo> obtenerListaModelos(DB_Helper db, Connection con) throws SQLException {
	return db.obtenerTodosModelos(con);
    }

    public static List<Marca> obtenerListaMarcas(DB_Helper db, Connection con) throws SQLException {
	return db.obtenerTodasMarcas(con);
    }

    public static V_Ordenador obtenerOrdenador(DB_Helper db, Connection con, int id) throws SQLException {
	return db.obtenerOrdenador(con, id);
    }
    public static Marca obtenerMarca(DB_Helper db, Connection con, int id) throws SQLException {
	return db.obtenerMarca(con, id);
    }
    public static int modificarOrdenador(DB_Helper db, Connection con, Ordenador ordenador) {

	return db.modificarOrdenador(con, ordenador);
    }

    public static int eliminarMarca(DB_Helper db, Connection con, int id) {

	return db.eliminarMarca(con, id);
    }

    public static int eliminarModelo(DB_Helper db, Connection con, int id) {

	return db.eliminarModelo(con, id);
    }

    public static List<String> obtenerMarcasUnicas(List<V_Modelo> listaModelos) {
	Set<String> marcasUnicas = new HashSet<>();

	for (V_Modelo v_Modelo : listaModelos) {
	    marcasUnicas.add(v_Modelo.getMarca());
	}

	return marcasUnicas.stream().collect(Collectors.toList());
    }
}
