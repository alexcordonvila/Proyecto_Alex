package com.ipartek.modelo;

import java.sql.Connection;
import java.util.List;

import com.ipartek.modelo.dto.Marca;
import com.ipartek.modelo.dto.Modelo;
import com.ipartek.modelo.dto.Ordenador;
import com.ipartek.modelo.dto.V_Modelo;
import com.ipartek.modelo.dto.V_Ordenador;

public interface I_Metodos {

    public Connection conectar();

    void desconectar(Connection con);

    public List<V_Ordenador> obtenerTodosOrdenadores(Connection con);

    public V_Ordenador obtenerOrdenador(Connection con, int id);

    public int eliminarOrdenador(Connection con, int id);

    public int insertarOrdenador(Connection con, Ordenador ord);

    public int modificarOrdenador(Connection con, Ordenador ord);

    public List<V_Modelo> obtenerTodosModelos(Connection con);

    public List<Marca> obtenerTodasMarcas(Connection con);

    public int insertarMarca(Connection con, Marca marca);

    public int eliminarMarca(Connection con, int id);

    public int eliminarModelo(Connection con, int id);

    public int insertarModelo(Connection con, Modelo modelo);

    public Marca obtenerMarca(Connection con, int id);
}
