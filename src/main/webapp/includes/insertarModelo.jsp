<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ipartek.modelo.I_Conexion"%>
<%@page import="com.ipartek.modelo.dto.V_Modelo"%>
<%
int isModeloUploaded = -1;
if (request.getAttribute(I_Conexion.ATR_ORDENADOR_UPLOADED) != null) {
    isModeloUploaded = (int) request.getAttribute(I_Conexion.ATR_ORDENADOR_UPLOADED);
}
%>
<%
List<String> listaMarcasUnicas = new ArrayList<String>();
if (request.getAttribute(I_Conexion.ATR_LISTA_MARCAS_UNICAS) != null) {
    listaMarcasUnicas = (List) request.getAttribute(I_Conexion.ATR_LISTA_MARCAS_UNICAS);
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
	if (isModeloUploaded == 1) {
	%>
	<div class="message success">Modelo insertado correctamente</div>
	<%
	} else if (isModeloUploaded == 0) {
	%>
	<div class="message error">Error al insertar el modelo</div>
	<%
	}
	%>

	<form
		name="ordenadorForm"
		class="login"
		method="post"
		action="InsertarOrdenador"
		onsubmit="return validateForm()">
		<H3>Añadir modelo</H3>
		</select> <label>Nombre de modelo*</label> 
		<input
			required
			type="text"
			name="p_modelo"
			placeholder="Nombre de modelo"> <br> <label for="marca">
			Marca asociada* 
			<select
			required
			name="p_marca"
			id="marca">
				<%
				for (String elem : listaMarcasUnicas) {
				%>
				<option value=<%=elem%>>
					<%=elem%>
				</option>
				<%
				}
				%>
		</select></label> <br>  
		<button type="submit">
			Insertar modelo <i class="fa fa-upload"></i>
		</button>
	</form>
</body>
</html>