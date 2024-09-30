package com.ipartek;

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

import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.I_Conexion;

import com.ipartek.modelo.dto.V_Modelo;
import com.ipartek.modelo.dto.V_Ordenador;

@WebServlet("/Cargar")
public class Cargar extends HttpServlet implements I_Conexion {
    private static final long serialVersionUID = 1L;

    public Cargar() {
	super();
	// TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	  // Obtener o crear una nueva sesión si no existe
	    HttpSession session = request.getSession();
	    System.out.println("SESSION= " + session);

	    // Verificar si ya hay un atributo 'CURRENT_PAGE' en la sesión
	    String currentPage = (String) session.getAttribute("CURRENT_PAGE");
	    System.out.println("Current Page= " + currentPage);
	    
	    // Si no hay una página actual, establecer la página por defecto
	    if (currentPage == null) {
	        session.setAttribute("CURRENT_PAGE", JSP_TODOS);
	    }

	DB_Helper db = new DB_Helper();
	try (Connection con = db.conectar()) { // Usar try-with-resources
	    List<V_Ordenador> listaOrdenadores = Helper.obtenerListaOrdenadores(db, con);
	    List<V_Modelo> listaModelos = Helper.obtenerListaModelos(db, con);
	    List<String> listaMarcas = Helper.obtenerMarcasUnicas(listaModelos);

	    // Configurar los atributos de la solicitud
	    request.setAttribute(ATR_LISTA_ORDENADORES, listaOrdenadores);
	    request.setAttribute(ATR_LISTA_MODELOS, listaModelos);
	    request.setAttribute(ATR_LISTA_MARCAS, listaMarcas);

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
