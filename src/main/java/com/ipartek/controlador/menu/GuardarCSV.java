package com.ipartek.controlador.menu;

import java.io.BufferedWriter;
import java.io.FileWriter;
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
 * Servlet implementation class GuardarCSV
 */
@WebServlet("/GuardarCSV")
public class GuardarCSV extends HttpServlet implements I_Conexion {
    private static final long serialVersionUID = 1L;

    public GuardarCSV() {
	super();
	// TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	int csvGuardado = 0;
	DB_Helper db = new DB_Helper();

	try (Connection con = db.conectar()) {
	    List<V_Ordenador> listaOrdenadores = Helper.obtenerListaOrdenadores(db, con);

	    // Obtener la ruta absoluta de la carpeta csv dentro del proyecto
	    // Guardar los datos en formato CSV en la carpeta /csv
	    String rutaArchivo = getServletContext().getRealPath("/csv/ordenadores.csv");

	    csvGuardado = guardarEnCSV(listaOrdenadores, rutaArchivo);
	    // Configurar los atributos de la solicitud
	    request.setAttribute(ATR_LISTA_ORDENADORES, listaOrdenadores);

	    // Redirigir a la JSP
	    System.out.println("Ordenadores guardados en CSV");
	    request.getRequestDispatcher(JSP_OPCIONES).forward(request, response);
	} catch (SQLException e) {
	    e.printStackTrace(); // Manejo de errores adecuado
	    // Aquí podríamos redirigir a un error.jsp
	}
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	doGet(request, response);
    }

    private int guardarEnCSV(List<V_Ordenador> listaOrdenadores, String nombreArchivo) {

	try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
	    // Escribir la cabecera del CSV
	    writer.write("NumeroSerie;Marca;Modelo;Capacidad;Ram;Anotaciones");
	    writer.newLine();

	    // Escribir los datos de cada ordenador
	    for (V_Ordenador ordenador : listaOrdenadores) {
		writer.write(String.join(";", ordenador.getNumeroSerie(), ordenador.getMarca(), ordenador.getModelo(),
			String.valueOf(ordenador.getCapacidad()), String.valueOf(ordenador.getRam()),
			ordenador.getAnotaciones()));
		writer.newLine();
	    }
	    System.out.println("Datos guardados en " + nombreArchivo);
	    return 1;
	} catch (IOException e) {
	    e.printStackTrace();
	    return 0;
	}
    }
}
