package com.ipartek.controlador.menu;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.Helper;
import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.I_Conexion;
import com.ipartek.modelo.dto.Marca;

@WebServlet("/AdminModificarMarca")
public class AdminModificarMarca extends HttpServlet implements I_Conexion {
    private static final long serialVersionUID = 1L;

    public AdminModificarMarca() {
	super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession();
	// Obtener el parámetro "id" por URL
	String idParam = request.getParameter("p_id");
	// Validar y convertir el parámetro a un tipo adecuado si es necesario
	int id = 0;
	try {
	    id = Integer.parseInt(idParam);
	} catch (NumberFormatException e) {
	    // Manejar el error en caso de que el parámetro no sea un número válido
	    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido");
	    return;
	}
	
	DB_Helper db = new DB_Helper();

	try (Connection con = db.conectar()) {
	    System.out.println(id);
	    Marca marca = Helper.obtenerMarca(db, con, id);
	    System.out.println("Marca ID= "+marca.getId());
	    System.out.println("Marca= "+marca.getMarca());
	    // Redirigir a la JSP de modificar
	    request.setAttribute(ATR_MARCA, marca);
	    session.setAttribute("CURRENT_PAGE", JSP_ADMIN);
	    request.getRequestDispatcher(JSP_MODIFICAR_MARCA).forward(request, response);

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
