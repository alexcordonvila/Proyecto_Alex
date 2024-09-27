package com.ipartek.modelo;

public interface I_Conexion {

    // Constantes para BD
    String BASE_DATOS = "db_reparaciones";
    String DRIVER = "com.mysql.jdbc.Driver";
    String CONEXION = "jdbc:mysql://localhost:3306/" + BASE_DATOS;
    String USUARIO = "root";
    String PASS = "1234";

    // Archivos JSP
    String JSP_TODOS = "index.jsp";
    String JSP_ADMIN = "admin.jsp";
    String JSP_MODIFICAR = "modificar.jsp";
    String JSP_OPCIONES = "opciones.jsp";

    // Tablas de la BD
    String TABLA_ORDENADORES = "ordenadores";
    String ORDENADORES_ID = "id";
    String ORDENADORES_NUMERO_SERIE = "numeroSerie";
    String ORDENADORES_FK_MODELO = "FK_modelo";
    String ORDENADORES_CAPACIDAD = "capacidad";
    String ORDENADORES_RAM = "ram";
    String ORDENADORES_ANOTACIONES = "anotaciones";

    String VISTA_PRODUCTOS = "v_ordenadores";
    String V_ORDENADORES_ID = "id";
    String V_ORDENADORES_NUMERO_SERIE = "numeroSerie";
    String V_ORDENADORES_CAPACIDAD = "capacidad";
    String V_ORDENADORES_RAM = "ram";
    String V_ORDENADORES_ANOTACIONES = "anotaciones";
    String V_ORDENADORES_MODELO = "modelo";
    String V_ORDENADORES_MARCA = "marca";

    String V_MODELOS_ID = "id";
    String V_MODELOS_MODELO = "modelo";
    String V_MODELOS_MARCA = "marca";
    String V_MODELOS_FK_MARCA = "FK_marca";

    String TABLA_MODELOS = "modelos";
    String MODELOS_ID = "id";
    String MODELOS_MODELO = "modelo";
    String MODELOS_FK_MARCA = "FK_marca";

    String TABLA_MARCAS = "marcas";
    String MARCAS_ID = "id";
    String MARCAS_MARCA = "marca";

    // stored procedures
    String SP_OBTENER_TODOS_ORDENADORES = "call sp_obtener_todos_ordenadores();";
    String SP_ELIMINAR_ORDENADOR = "call sp_eliminar_ordenador(?);";
    String SP_OBTENER_TODOS_MODELOS = "call sp_obtener_todos_modelos();";
    String SP_INSERTAR_ORDENADOR = "call sp_insertar_ordenador(?,?,?,?,?);";
    String SP_MODIFICAR_ORDENADOR = "call sp_modificar_ordenador(?,?,?,?,?,?);";
    String SP_OBTENER_ORDENADOR_POR_ID = "call sp_obtener_ordenador_por_id(?)";
    String SP_OBTENER_ORDENADORES_POR_NUMEROSERIE = "call sp_obtener_ordenador_por_numSerie(?);";
    String SP_OBTENER_TODAS_MARCAS = "call sp_obtener_todas_marcas()";
    String SP_INSERTAR_MARCA = "call sp_insertar_marca(?)";
    String SP_ELIMINAR_MARCA = "call sp_eliminar_marca(?)";
    String SP_ELIMINAR_MODELO = "call sp_eliminar_modelo(?)";
    String SP_INSERTAR_MODELO = "call sp_insertar_modelo(?,?)";
    
    // atributos de la mochila
    String ATR_LISTA_ORDENADORES = "atr_lista_ordenadores";
    String ATR_LISTA_MODELOS = "atr_lista_modelos";
    String ATR_ORDENADOR_UPLOADED = "atr_ordenador_uploaded";
    String ATR_ORDENADOR_BORRADO = "atr_ordenador_deleted";
    String ATR_ORDENADOR_UPDATED = "atr_ordenador_updated";
    String ATR_LISTA_MARCAS = "atr_lista_marcas";
    String ATR_ORDENADOR = "atr_ordenador";
    String ATR_LISTA_MARCAS_UNICAS = "atr_lista_marcas_unicas";
    String ATR_MARCA_UPLOADED = "atr_marca_uploaded";
    String ATR_MARCA_DELETED ="atr_marca_deleted";
    String ATR_MODELO_UPLOADED = "atr_modelo_uploaded";
    String ATR_MODELO_DELETED= "atr_modelo_deleted";
    String ATR_FILTRO_ACTIVADO = "atr_filtro_activado";
    String ATR_ORDENADOR_NUMEROSERIE ="atr_ordenador_numeroserie";
}
