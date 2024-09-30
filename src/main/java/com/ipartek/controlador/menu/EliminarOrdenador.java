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
import com.ipartek.modelo.dto.V_Modelo;
import com.ipartek.modelo.dto.V_Ordenador;

/**
 * Servlet implementation class EliminarOrdenador
 */
@WebServlet("/EliminarOrdenador")
public class EliminarOrdenador extends HttpServlet implements I_Conexion {
    private static final long serialVersionUID = 1L;

    public EliminarOrdenador() {
	super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession();
	// 1- Recuperamos datos del JSP:

	int id = Integer.parseInt(request.getParameter("p_id"));
	System.out.println("Dato ID del ordenador a borrar recuperado del JSP: " + id);

	DB_Helper db = new DB_Helper();

	try (Connection con = db.conectar()) { // Usar try-with-resources
	    int deleteOrdenador = db.eliminarOrdenador(con, id);

	    List<V_Ordenador> listaOrdenadores = Helper.obtenerListaOrdenadores(db, con);
	    List<V_Modelo> listaModelos = Helper.obtenerListaModelos(db, con);
	    List<String> listaMarcas = Helper.obtenerMarcasUnicas(listaModelos);

	    db.desconectar(con);

	    request.setAttribute(ATR_LISTA_ORDENADORES, listaOrdenadores);
	    request.setAttribute(ATR_ORDENADOR_BORRADO, deleteOrdenador);
	    request.setAttribute(ATR_LISTA_MODELOS, listaModelos);
	    request.setAttribute(ATR_LISTA_MARCAS, listaMarcas);
	    request.setAttribute(ATR_LISTA_ORDENADORES, listaOrdenadores);
	    session.setAttribute("CURRENT_PAGE", JSP_TODOS);
	    request.getRequestDispatcher(JSP_TODOS).forward(request, response);

	} catch (SQLException e) {
	    e.printStackTrace(); // Manejo de errores adecuado
	    // Aquí podríamos redirigir a un error.jsp
	}

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	doGet(request, response);
    }

}
