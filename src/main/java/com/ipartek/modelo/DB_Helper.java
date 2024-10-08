package com.ipartek.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.I_Colores;
import com.ipartek.modelo.dto.Marca;
import com.ipartek.modelo.dto.Modelo;
import com.ipartek.modelo.dto.Ordenador;
import com.ipartek.modelo.dto.V_Modelo;
import com.ipartek.modelo.dto.V_Ordenador;

public class DB_Helper implements I_Conexion, I_Metodos {

    @Override
    public Connection conectar() {

	Connection con = null;

	try {
	    Class.forName(DRIVER);
	    con = DriverManager.getConnection(CONEXION, USUARIO, PASS);

	    System.out.println(I_Colores.ANSI_GREEN + "BD conectada" + I_Colores.ANSI_RESET);
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

	    if (tieneSelect == true) {

		// cargar la lista

		ResultSet rs = cStmt.getResultSet();

		while (rs.next()) {

		    V_Ordenador ord = new V_Ordenador();

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

	    } else {
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

    @Override
    public int eliminarOrdenador(Connection con, int id) {
	try {

	    CallableStatement cStmt = con.prepareCall(SP_ELIMINAR_ORDENADOR);
	    cStmt.setInt(1, id);
	    return cStmt.executeUpdate();

	} catch (SQLException e) {

	    System.out.println("ERROR DE BD: DELETE");
	    System.out.println("Error al eliminar el ordenador");
	    System.out.println(e.getMessage());

	    return 0;
	}
    }

    @Override
    public List<V_Modelo> obtenerTodosModelos(Connection con) {
	List<V_Modelo> lista = new ArrayList<V_Modelo>();
	try {
	    CallableStatement cStmt = con.prepareCall(SP_OBTENER_TODOS_MODELOS);

	    boolean tieneSelect = cStmt.execute();

	    if (tieneSelect == true) {

		ResultSet rs = cStmt.getResultSet();

		while (rs.next()) {

		    V_Modelo modelo = new V_Modelo();

		    modelo.setId(rs.getInt(V_MODELOS_ID));
		    modelo.setModelo(rs.getString(V_MODELOS_MODELO));
		    modelo.setFK_marca(rs.getInt(V_MODELOS_FK_MARCA));
		    modelo.setMarca(rs.getString(V_MODELOS_MARCA));
		    lista.add(modelo);
		}

		return lista;

	    } else {
		System.out.println("No se pudo obtener una lista de modelos");
		System.out.println("El Stored procedure no tiene un RESULTSET");

		return new ArrayList<V_Modelo>();
	    }

	} catch (SQLException e) {
	    System.out.println("ERROR DE BD: CONSULTA");
	    System.out.println("Error al obtener la lista de todos los modelos");
	    System.out.println(e.getMessage());

	    return new ArrayList<V_Modelo>();
	}
    }

    @Override
    public List<Marca> obtenerTodasMarcas(Connection con) {
	List<Marca> lista = new ArrayList<Marca>();
	try {
	    CallableStatement cStmt = con.prepareCall(SP_OBTENER_TODAS_MARCAS);

	    boolean tieneSelect = cStmt.execute();

	    if (tieneSelect == true) {

		ResultSet rs = cStmt.getResultSet();

		while (rs.next()) {

		    Marca marca = new Marca();

		    marca.setId(rs.getInt(MARCAS_ID));
		    marca.setMarca(rs.getString(MARCAS_MARCA));

		    lista.add(marca);
		}

		return lista;

	    } else {
		System.out.println("No se pudo obtener una lista de marcas");
		System.out.println("El Stored procedure no tiene un RESULTSET");

		return new ArrayList<Marca>();
	    }

	} catch (SQLException e) {
	    System.out.println("ERROR DE BD: CONSULTA");
	    System.out.println("Error al obtener la lista de todas las marcas");
	    System.out.println(e.getMessage());

	    return new ArrayList<Marca>();
	}
    }

    @Override
    public int insertarOrdenador(Connection con, Ordenador ord) {
	try {

	    CallableStatement cStmt = con.prepareCall(SP_INSERTAR_ORDENADOR);

	    cStmt.setString(1, ord.getNumeroSerie());
	    cStmt.setInt(2, ord.getCapacidad());
	    cStmt.setInt(3, ord.getRam());
	    cStmt.setString(4, ord.getAnotaciones());
	    cStmt.setInt(5, ord.getFk_modelo());

	    return cStmt.executeUpdate();

	} catch (SQLException e) {

	    System.out.println("ERROR DE BD: INSERT");
	    System.out.println("Error al añadir el ordenador");
	    System.out.println(e.getMessage());

	    return 0;
	}
    }

    @Override
    public int insertarMarca(Connection con, Marca marca) {
	try {

	    CallableStatement cStmt = con.prepareCall(SP_INSERTAR_MARCA);
	    cStmt.setString(1, marca.getMarca());
	    return cStmt.executeUpdate();

	} catch (SQLException e) {

	    System.out.println("ERROR DE BD: INSERT");
	    System.out.println("Error al añadir la Marca");
	    System.out.println(e.getMessage());

	    return 0;
	}
    }

    @Override
    public int insertarModelo(Connection con, Modelo modelo) {
	try {

	    CallableStatement cStmt = con.prepareCall(SP_INSERTAR_MODELO);
	    cStmt.setString(1, modelo.getModelo());
	    cStmt.setInt(2, modelo.getFK_marca());
	    return cStmt.executeUpdate();

	} catch (SQLException e) {

	    System.out.println("ERROR DE BD: INSERT");
	    System.out.println("Error al añadir el modelo");
	    System.out.println(e.getMessage());

	    return 0;
	}
    }

    @Override
    public int modificarOrdenador(Connection con, Ordenador ord) {
	try {

	    CallableStatement cStmt = con.prepareCall(SP_MODIFICAR_ORDENADOR);

	    cStmt.setInt(1, ord.getId());
	    cStmt.setString(2, ord.getNumeroSerie());
	    cStmt.setInt(3, ord.getCapacidad());
	    cStmt.setInt(4, ord.getRam());
	    cStmt.setString(5, ord.getAnotaciones());
	    cStmt.setInt(6, ord.getFk_modelo());

	    return cStmt.executeUpdate();

	} catch (SQLException e) {

	    System.out.println("ERROR DE BD: UPDATE");
	    System.out.println("Error al modificar el ordenador con id=" + ord.getId());
	    System.out.println(e.getMessage());

	    return 0;
	}
    }

    @Override
    public V_Ordenador obtenerOrdenador(Connection con, int id) {
	V_Ordenador v_ordenador = new V_Ordenador();
	try {
	    CallableStatement cStmt = con.prepareCall(SP_OBTENER_ORDENADOR_POR_ID);
	    cStmt.setInt(1, id);
	    boolean tieneSelect = cStmt.execute();

	    if (tieneSelect == true) {
		ResultSet rs = cStmt.getResultSet();

		while (rs.next()) {
		    v_ordenador.setId(rs.getInt(V_ORDENADORES_ID));
		    v_ordenador.setNumeroSerie(rs.getString(V_ORDENADORES_NUMERO_SERIE));
		    v_ordenador.setCapacidad(rs.getInt(V_ORDENADORES_CAPACIDAD));
		    v_ordenador.setRam(rs.getInt(V_ORDENADORES_RAM));
		    v_ordenador.setAnotaciones(rs.getString(V_ORDENADORES_ANOTACIONES));
		    v_ordenador.setModelo(rs.getString(V_ORDENADORES_MODELO));
		    v_ordenador.setMarca(rs.getString(V_ORDENADORES_MARCA));
		}

		return v_ordenador;

	    } else {
		System.out.println("No se pudo obtener el ordenador con id:" + id);
		System.out.println("El Stored procedure no tiene un RESULTSET");

		return v_ordenador;
	    }

	} catch (SQLException e) {
	    System.out.println("ERROR DE BD: CONSULTA");
	    System.out.println("Error al obtener el ordenador con id:" + id);
	    System.out.println(e.getMessage());

	    return v_ordenador;
	}
    }

    @Override
    public Marca obtenerMarca(Connection con, int id) {
	Marca marca = new Marca();
	try {
	    CallableStatement cStmt = con.prepareCall(SP_OBTENER_MARCA_POR_ID);
	    cStmt.setInt(1, id);
	    boolean tieneSelect = cStmt.execute();

	    if (tieneSelect == true) {
		ResultSet rs = cStmt.getResultSet();

		while (rs.next()) {
		    System.out.println(rs.getInt(MARCAS_ID));
		    System.out.println(rs.getString(MARCAS_MARCA));
		    marca.setId(rs.getInt(MARCAS_ID));
		    marca.setMarca(rs.getString(MARCAS_MARCA));
		}

		return marca;
	    } else {
		System.out.println("No se pudo obtener la marca con id:" + id);
		System.out.println("El Stored procedure no tiene un RESULTSET");

		return marca;
	    }
	} catch (SQLException e) {
	    System.out.println("ERROR DE BD: CONSULTA");
	    System.out.println("Error al obtener la marca con id:" + id);
	    System.out.println(e.getMessage());

	    return marca;
	}
    }

    @Override
    public int eliminarMarca(Connection con, int id) {
	try {

	    CallableStatement cStmt = con.prepareCall(SP_ELIMINAR_MARCA);
	    cStmt.setInt(1, id);
	    return cStmt.executeUpdate();

	} catch (SQLException e) {

	    System.out.println("ERROR DE BD: DELETE");
	    System.out.println("Error al eliminar la marca");
	    System.out.println(e.getMessage());

	    return 0;
	}
    }

    public int eliminarModelo(Connection con, int id) {
	try {

	    CallableStatement cStmt = con.prepareCall(SP_ELIMINAR_MODELO);
	    cStmt.setInt(1, id);
	    return cStmt.executeUpdate();

	} catch (SQLException e) {

	    System.out.println("ERROR DE BD: DELETE");
	    System.out.println("Error al eliminar el modelo");
	    System.out.println(e.getMessage());

	    return 0;
	}
    }

    public List<V_Ordenador> obtenerOrdenadoresFiltrados(Connection con, Ordenador ordendaor) {
	List<V_Ordenador> lista = new ArrayList<V_Ordenador>();

	try {
	    CallableStatement cStmt = con.prepareCall(SP_OBTENER_ORDENADORES_POR_NUMEROSERIE);
	    cStmt.setString(1, ordendaor.getNumeroSerie());

	    boolean tieneSelect = cStmt.execute();

	    if (tieneSelect == true) {
		ResultSet rs = cStmt.getResultSet();

		while (rs.next()) {
		    V_Ordenador v_ordenador = new V_Ordenador();

		    v_ordenador.setId(rs.getInt(V_ORDENADORES_ID));
		    v_ordenador.setNumeroSerie(rs.getString(V_ORDENADORES_NUMERO_SERIE));
		    v_ordenador.setCapacidad(rs.getInt(V_ORDENADORES_CAPACIDAD));
		    v_ordenador.setRam(rs.getInt(V_ORDENADORES_RAM));
		    v_ordenador.setAnotaciones(rs.getString(V_ORDENADORES_ANOTACIONES));
		    v_ordenador.setModelo(rs.getString(V_ORDENADORES_MODELO));
		    v_ordenador.setMarca(rs.getString(V_ORDENADORES_MARCA));
		    lista.add(v_ordenador);
		}

		return lista;

	    } else {
		System.out.println("No se pudo obtener el ordenador con numSerie:" + ordendaor.getNumeroSerie());
		System.out.println("El Stored procedure no tiene un RESULTSET");

		return new ArrayList<V_Ordenador>();
	    }

	} catch (SQLException e) {
	    System.out.println("ERROR DE BD: CONSULTA");
	    System.out.println("Error al obtener el ordenador con numSerie:" + ordendaor.getNumeroSerie());
	    System.out.println(e.getMessage());

	    return new ArrayList<V_Ordenador>();
	}
    }

    public int modificarMarca(Connection con, Marca marca) {
	try {

	    CallableStatement cStmt = con.prepareCall(SP_MODIFICAR_MARCA);

	    cStmt.setInt(1, marca.getId());
	    cStmt.setString(2, marca.getMarca());

	    return cStmt.executeUpdate();

	} catch (SQLException e) {

	    System.out.println("ERROR DE BD: UPDATE");
	    System.out.println("Error al modificar la marca con id=" + marca.getId());
	    System.out.println(e.getMessage());

	    return 0;
	}
    }

}
