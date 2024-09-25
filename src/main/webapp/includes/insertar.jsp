
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ipartek.modelo.I_Conexion"%>
<%@page import="com.ipartek.modelo.dto.V_Modelo"%>
<%
int isOrdenadorUploaded = -1;
if (request.getAttribute(I_Conexion.ATR_ORDENADOR_UPLOADED) != null) {
	isOrdenadorUploaded = (int) request.getAttribute(I_Conexion.ATR_ORDENADOR_UPLOADED);
}
%>
<%
int isOrdenadorDeleted= -1;
if (request.getAttribute(I_Conexion.ATR_ORDENADOR_BORRADO) != null) {
    isOrdenadorDeleted = (int) request.getAttribute(I_Conexion.ATR_ORDENADOR_BORRADO);
}
%>
<%
List<V_Modelo> listaModelos = new ArrayList<V_Modelo>();
if (request.getAttribute(I_Conexion.ATR_LISTA_MODELOS) != null) {
	listaModelos = (List) request.getAttribute(I_Conexion.ATR_LISTA_MODELOS);
} else {
	//TAREA PARA METER EN EL LOG
}
%>
<%
List<String> listaMarcas = new ArrayList<String>();
if (request.getAttribute(I_Conexion.ATR_LISTA_MARCAS) != null) {
	listaMarcas = (List) request.getAttribute(I_Conexion.ATR_LISTA_MARCAS);
} else {
	//TAREA PARA METER EN EL LOG
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subir</title>
<script type="text/javascript">
	function validateForm() {
		var titulo = document.forms["ordenadorForm"]["p_titulo"].value;
		var link = document.forms["ordenadorForm"]["p_link"].value;
		var descripcion = document.forms["ordenadorForm"]["p_descripcion"].value;
		if (titulo == "" || link == "" || descripcion == "") {
			alert("Todos los campos son obligatorios.");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<%
	if (isOrdenadorUploaded == 1) {
	%>
	<div class="message success">Ordenador insertado correctamente</div>
	<%
	} else if (isOrdenadorUploaded == 0) {
	%>
	<div class="message error">Error al insertar el ordenador</div>
	<%
	}
	%>
	<%
	if (isOrdenadorDeleted == 1) {
	%>
	<div class="message success">Ordenador borrado correctamente</div>
	<%
	} else if (isOrdenadorUploaded == 0) {
	%>
	<div class="message error">Error al borrar el ordenador</div>
	<%
	}
	%>
	<form
		name="ordenadorForm"
		class="login"
		method="post"
		action="InsertarOrdenador"
		onsubmit="return validateForm()">
		<H3>Añadir ordenador</H3>
		</select> <label>Número de serie*</label> <input
			required
			type="text"
			name="p_numeroSerie"
			placeholder="Número de serie"> <br> <label for="marca">Marca* <select
			required
			name="p_marca"
			id="marca">
				<%
				for (String elem : listaMarcas) {
				%>
				<option value=<%=elem%>>
					<%=elem%>
				</option>
				<%
				}
				%>
		</select></label> <br> <label for="modelo">Modelo* <select
			required
			name="p_modelo"
			id="modelo">
				<%
				for (V_Modelo elem : listaModelos) {
				%>
				<option value=<%=elem.getId()%>>
					<%=elem.getModelo()%>
				</option>
				<%
				}
				%>
		</select></label> <br> <label>Capacidad*</label> <input
			required
			type="text"
			name="p_capacidad"
			placeholder="Ram"> <br> <label>Ram*</label> <input
			required
			type="text"
			name="p_ram"
			placeholder="Ram"> <br> <label>Anotaciones*</label> <input
			required
			type="text"
			name="p_anotaciones"
			placeholder="Anotaciones"> <br>
		<button type="submit">
			Insertar <i class="fa fa-upload"></i>
		</button>
	</form>
</body>
</html>