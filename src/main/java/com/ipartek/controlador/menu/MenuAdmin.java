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
import com.ipartek.modelo.dto.Marca;
import com.ipartek.modelo.dto.V_Modelo;
import com.ipartek.modelo.dto.V_Ordenador;

/**
 * Servlet implementation class MenuAdmin
 */
@WebServlet("/MenuAdmin")
public class MenuAdmin extends HttpServlet implements I_Conexion{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuAdmin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    DB_Helper db = new DB_Helper();

		try (Connection con = db.conectar()) {
		    List<V_Modelo> listaModelos = Helper.obtenerListaModelos(db, con);
		    List<Marca> listaMarcas = Helper.obtenerListaMarcas(db, con);
		    //Solo los strings para simplificar la gestión del JSP
		    List<String> listaMarcasUnicas = Helper.obtenerMarcasUnicas(listaModelos);

		    // Configurar los atributos de la solicitud
		    request.setAttribute(ATR_LISTA_MODELOS, listaModelos);
		    request.setAttribute(ATR_LISTA_MARCAS_UNICAS, listaMarcasUnicas);
		    request.setAttribute(ATR_LISTA_MARCAS, listaMarcas);

		    // Redirigir a la JSP
		    request.getRequestDispatcher(JSP_ADMIN).forward(request, response);
		} catch (SQLException e) {
		    e.printStackTrace(); // Manejo de errores adecuado
		    // Aquí podríamos redirigir a un error.jsp
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
