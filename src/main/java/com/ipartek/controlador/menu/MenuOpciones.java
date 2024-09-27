package com.ipartek.controlador.menu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.modelo.I_Conexion;

/**
 * Servlet implementation class MenuOpciones
 */
@WebServlet("/MenuOpciones")
public class MenuOpciones extends HttpServlet implements I_Conexion {
	private static final long serialVersionUID = 1L;
       
    public MenuOpciones() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    request.getRequestDispatcher(JSP_OPCIONES).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
