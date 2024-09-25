package com.ipartek.controlador.menu;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.I_Conexion;
import com.ipartek.modelo.dto.V_Modelo;
import com.ipartek.modelo.dto.V_Ordenador;

@WebServlet("/MenuTodos")
public class MenuTodos extends HttpServlet implements I_Conexion{
	private static final long serialVersionUID = 1L;

    public MenuTodos() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	    DB_Helper db = new DB_Helper();
		try (Connection con = db.conectar()) { // Usar try-with-resources
		    List<V_Ordenador> listaOrdenadores = db.obtenerTodosOrdenadores(con);
		    List<V_Modelo> listaModelos = db.obtenerTodosModelos(con);

		    // Usar un Set para almacenar marcas únicas
		    Set<String> marcasUnicas = new HashSet<>();

		    for (V_Modelo v_Modelo : listaModelos) {
			String marca = v_Modelo.getMarca();
			marcasUnicas.add(marca); // Agregar directamente al Set
			// Solo imprimir si es necesario
			System.out.println("Marca: " + marca);
		    }

		    // Convertir el Set a una lista
		    List<String> listaMarcas = marcasUnicas.stream().collect(Collectors.toList());
		    System.out.println("Lista Sin Duplicados: " + listaMarcas);

		    // Configurar los atributos de la solicitud
		    request.setAttribute(ATR_LISTA_ORDENADORES, listaOrdenadores);
		    request.setAttribute(ATR_LISTA_MODELOS, listaModelos);
		    request.setAttribute(ATR_LISTA_MARCAS, listaMarcas);
		    System.out.println(listaModelos);

		    // Redirigir a la JSP
		    request.getRequestDispatcher(JSP_TODOS).forward(request, response);
		} catch (SQLException e) {
		    e.printStackTrace(); // Manejo de errores adecuado
		    // Aquí podrías hacer más, como redirigir a un error.jsp
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
