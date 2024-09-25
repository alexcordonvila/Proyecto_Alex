package com.ipartek.controlador.menu;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.I_Conexion;
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
	// 1- Recuperamos datos del JSP:

	int id = Integer.parseInt(request.getParameter("p_id"));
	System.out.println("Dato ID del ordenador a borrar recuperado del JSP: " + id);

	DB_Helper db = new DB_Helper();
	Connection con = db.conectar();
	
	int deleteOrdenador = db.eliminarOrdenador(con, id);
	List<V_Ordenador> listaOrdenadores = db.obtenerTodosOrdenadores(con);
	db.desconectar(con);
	
	request.setAttribute(ATR_LISTA_ORDENADORES, listaOrdenadores);
	
	request.getRequestDispatcher(JSP_TODOS).forward(request, response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	doGet(request, response);
    }

}
