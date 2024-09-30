package com.ipartek.controlador.menu;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.Helper;
import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.I_Conexion;
import com.ipartek.modelo.dto.Ordenador;
import com.ipartek.modelo.dto.V_Modelo;
import com.ipartek.modelo.dto.V_Ordenador;

/**
 * Servlet implementation class ModificarOrdenador
 */
@WebServlet("/ModificarOrdenador")
public class ModificarOrdenador extends HttpServlet implements I_Conexion {
    private static final long serialVersionUID = 1L;

    public ModificarOrdenador() {
	super();
	// TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession();
	// 1- Recuperamos datos del JSP:
	int p_id = Integer.parseInt(request.getParameter("p_id"));
	String p_numeroSerie = "";
	if (request.getParameter("p_numeroSerie") != null) {
	    p_numeroSerie = request.getParameter("p_numeroSerie");
	    if (p_numeroSerie.length() > 45) {
		p_numeroSerie = p_numeroSerie.substring(0, 45);
	    }
	}
	String p_anotaciones = "";
	if (request.getParameter("p_anotaciones") != null) {
	    p_anotaciones = request.getParameter("p_anotaciones");
	    if (p_anotaciones.length() > 45) {
		p_anotaciones = p_anotaciones.substring(0, 45);
	    }
	}
	int p_modelo = 0;
	if (request.getParameter("p_modelo") != null) {
	    try {
		p_modelo = Integer.parseInt(request.getParameter("p_modelo"));
	    } catch (NumberFormatException e) {
		p_modelo = 0;
	    }
	}
	int p_capacidad = 0;
	if (request.getParameter("p_capacidad") != null) {
	    try {
		p_capacidad = Integer.parseInt(request.getParameter("p_capacidad"));
	    } catch (NumberFormatException e) {
		p_capacidad = 0;
	    }
	}
	int p_ram = 0;
	if (request.getParameter("p_ram") != null) {
	    try {
		p_ram = Integer.parseInt(request.getParameter("p_ram"));
	    } catch (NumberFormatException e) {
		p_ram = 0;
	    }
	}

	Ordenador ordenador = new Ordenador(p_id, p_numeroSerie, p_capacidad, p_ram, p_anotaciones, p_modelo);

	DB_Helper db = new DB_Helper();

	try (Connection con = db.conectar()) { 

	    int modificar = Helper.modificarOrdenador(db, con, ordenador);
	    List<V_Ordenador> listaOrdenadores = Helper.obtenerListaOrdenadores(db, con);
	    List<V_Modelo> listaModelos = Helper.obtenerListaModelos(db, con);
	    List<String> listaMarcas = Helper.obtenerMarcasUnicas(listaModelos);

	    db.desconectar(con);

	    request.setAttribute(ATR_LISTA_ORDENADORES, listaOrdenadores);
	    request.setAttribute(ATR_ORDENADOR_UPDATED, modificar);
	    request.setAttribute(ATR_LISTA_MODELOS, listaModelos);
	    request.setAttribute(ATR_LISTA_MARCAS, listaMarcas);
	    session.setAttribute("CURRENT_PAGE", JSP_TODOS);
	    request.getRequestDispatcher(JSP_TODOS).forward(request, response);

	} catch (SQLException e) {
	    e.printStackTrace(); // Manejo de errores adecuado
	    // Aquí podríamos redirigir a un error.jsp
	}
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
    }

}
