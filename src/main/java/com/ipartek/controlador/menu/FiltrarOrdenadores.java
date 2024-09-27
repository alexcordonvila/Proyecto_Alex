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

import com.ipartek.Helper;
import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.I_Conexion;
import com.ipartek.modelo.dto.Ordenador;
import com.ipartek.modelo.dto.V_Modelo;
import com.ipartek.modelo.dto.V_Ordenador;

/**
 * Servlet implementation class FiltrarOrdenadores
 */
@WebServlet("/FiltrarOrdenadores")
public class FiltrarOrdenadores extends HttpServlet implements I_Conexion {
    private static final long serialVersionUID = 1L;

    public FiltrarOrdenadores() {
	super();
	// TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// 1- Recuperamos datos del JSP:

		String p_numeroSerie = "";
		if (request.getParameter("p_numeroSerie") != null) {
		    p_numeroSerie = request.getParameter("p_numeroSerie");
		    if (p_numeroSerie.length() > 45) {
			p_numeroSerie = p_numeroSerie.substring(0, 45);
		    }
		}
	DB_Helper db = new DB_Helper();
	Ordenador ord = new Ordenador();
	ord.setNumeroSerie(p_numeroSerie);

	try (Connection con = db.conectar()) {
	    List<V_Ordenador> listaOrdenadores = Helper.obtenerListaOrdenadoresFiltrados(db, con, ord);
	    List<V_Modelo> listaModelos = Helper.obtenerListaModelos(db, con);

	    List<String> listaMarcas = Helper.obtenerMarcasUnicas(listaModelos);

	    // Configurar los atributos de la solicitud
	    request.setAttribute(ATR_LISTA_ORDENADORES, listaOrdenadores);
	    request.setAttribute(ATR_LISTA_MODELOS, listaModelos);
	    request.setAttribute(ATR_LISTA_MARCAS, listaMarcas);
	    request.setAttribute(ATR_FILTRO_ACTIVADO, true);
	    request.setAttribute(ATR_ORDENADOR_NUMEROSERIE, p_numeroSerie);

	    // Redirigir a la JSP
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
