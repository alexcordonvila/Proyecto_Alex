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
import com.ipartek.modelo.dto.Modelo;
import com.ipartek.modelo.dto.V_Modelo;


@WebServlet("/InsertarModelo")
public class InsertarModelo extends HttpServlet implements I_Conexion {
	private static final long serialVersionUID = 1L;
       
    public InsertarModelo() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession();
	 // 1- Recuperamos datos del JSP:

		String p_modelo = "";
		if (request.getParameter("p_modelo") != null) {
		    p_modelo = request.getParameter("p_modelo");
		    if (p_modelo.length() > 45) {
			p_modelo = p_modelo.substring(0, 45);
		    }
		}
		int p_fk_modelo = 0;
		if (request.getParameter("p_fk_modelo") != null) {
		    try {
			p_fk_modelo = Integer.parseInt(request.getParameter("p_fk_modelo"));
		    } catch (NumberFormatException e) {
			p_fk_modelo = 0;
		    }
		}
		Modelo modelo = new Modelo(0, p_modelo, p_fk_modelo);
		DB_Helper db = new DB_Helper();

		try (Connection con = db.conectar()) { // Usar try-with-resources

		    int modeloInsertado = db.insertarModelo(con, modelo);
		    List<V_Modelo> listaModelos = Helper.obtenerListaModelos(db, con);
		    List<Marca> listaMarcas = Helper.obtenerListaMarcas(db, con);

		    // Configurar los atributos de la solicitud
		    request.setAttribute(ATR_LISTA_MODELOS, listaModelos);
		    request.setAttribute(ATR_LISTA_MARCAS, listaMarcas);
		    request.setAttribute(ATR_MODELO_UPLOADED, modeloInsertado);
		    //request.setAttribute(ATR_MODELO_DELETED, -1);

		    // Redirigir a la JSP
		    session.setAttribute("CURRENT_PAGE", JSP_ADMIN);
		    request.getRequestDispatcher(JSP_ADMIN).forward(request, response);
		} catch (SQLException e) {
		    e.printStackTrace(); // Manejo de errores adecuado
		    // Aquí podríamos redirigir a un error.jsp
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
