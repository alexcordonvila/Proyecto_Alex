package com.ipartek;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;

import java.util.Set;
import java.util.stream.Collectors;

import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.dto.V_Modelo;
import com.ipartek.modelo.dto.V_Ordenador;

public class Helper {
    public static List<V_Ordenador> obtenerListaOrdenadores(DB_Helper db, Connection con) throws SQLException {
	return db.obtenerTodosOrdenadores(con);
    }

    public static List<V_Modelo> obtenerListaModelos(DB_Helper db, Connection con) throws SQLException {
	return db.obtenerTodosModelos(con);
    }

    public static List<String> obtenerMarcasUnicas(List<V_Modelo> listaModelos) {
	Set<String> marcasUnicas = new HashSet<>();

	for (V_Modelo v_Modelo : listaModelos) {
	    marcasUnicas.add(v_Modelo.getMarca());
	}

	return marcasUnicas.stream().collect(Collectors.toList());
    }
}
