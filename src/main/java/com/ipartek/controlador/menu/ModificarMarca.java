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
import com.ipartek.modelo.dto.Marca;
import com.ipartek.modelo.dto.Ordenador;
import com.ipartek.modelo.dto.V_Modelo;
import com.ipartek.modelo.dto.V_Ordenador;

/**
 * Servlet implementation class ModificarMarca
 */
@WebServlet("/ModificarMarca")
public class ModificarMarca extends HttpServlet implements I_Conexion {
	private static final long serialVersionUID = 1L;
       
    public ModificarMarca() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession();
		// 1- Recuperamos datos del JSP:
		int p_id = Integer.parseInt(request.getParameter("p_id"));
		String p_marca = "";
		if (request.getParameter("p_marca") != null) {
		    p_marca = request.getParameter("p_marca");
		    if (p_marca.length() > 45) {
			p_marca = p_marca.substring(0, 45);
		    }
		}

		Marca marca = new Marca(p_id, p_marca);

		DB_Helper db = new DB_Helper();

		try (Connection con = db.conectar()) { 

		    int modificar = Helper.modificarMarca(db, con, marca);
		    List<V_Modelo> listaModelos = Helper.obtenerListaModelos(db, con);
		    List<Marca> listaMarcas = Helper.obtenerListaMarcas(db, con);

		    db.desconectar(con);

		   
		    request.setAttribute(ATR_MARCA_UPDATED, modificar);
		    request.setAttribute(ATR_LISTA_MODELOS, listaModelos);
		    request.setAttribute(ATR_LISTA_MARCAS, listaMarcas);
		    
		    session.setAttribute("CURRENT_PAGE", JSP_ADMIN);
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
