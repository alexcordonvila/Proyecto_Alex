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
import com.ipartek.modelo.dto.V_Modelo;
import com.ipartek.modelo.dto.V_Ordenador;

/**
 * Servlet implementation class AdminModificar
 */
@WebServlet("/AdminModificar")
public class AdminModificar extends HttpServlet implements I_Conexion {
    private static final long serialVersionUID = 1L;

    public AdminModificar() {
	super();
	// TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	
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
	    List<V_Ordenador> listaOrdenadores = Helper.obtenerListaOrdenadores(db, con);
	    List<V_Modelo> listaModelos = Helper.obtenerListaModelos(db, con);
	    V_Ordenador datosOrdenador = Helper.obtenerOrdenador(db, con, id);
	    List<String> listaMarcas = Helper.obtenerMarcasUnicas(listaModelos);

	    
	    // Configurar los atributos de la solicitud
	    request.setAttribute(ATR_ORDENADOR, datosOrdenador);
	    request.setAttribute(ATR_LISTA_MODELOS, listaModelos);
	    request.setAttribute(ATR_LISTA_MARCAS, listaMarcas);

	    // Redirigir a la JSP de modificar
	    request.getRequestDispatcher(JSP_MODIFICAR).forward(request, response);

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
