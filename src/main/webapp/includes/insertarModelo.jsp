<%@page import="com.ipartek.modelo.dto.Marca"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ipartek.modelo.I_Conexion"%>
<%@page import="com.ipartek.modelo.dto.V_Modelo"%>

<%
List<Marca> listaMarca = new ArrayList<Marca>();
if (request.getAttribute(I_Conexion.ATR_LISTA_MARCAS) != null) {
    listaMarca = (List) request.getAttribute(I_Conexion.ATR_LISTA_MARCAS);
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
	
	<form
		name="ordenadorForm"
		class="ordenadorForm"
		method="post"
		action="InsertarModelo"
		onsubmit="return validateForm()">
		<H3>Añadir modelo</H3>
		</select> <label>Nombre de modelo*</label> 
		<input
			required
			type="text"
			name="p_modelo"
			placeholder="Nombre de modelo"> 
			<br> 
			<label for="modelo">
			Marca asociada* 
			<select
			required
			name="p_fk_modelo"
			id="marca">
				<%
				for (Marca elem : listaMarca) {
				%>
				<option value=<%=elem.getId()%>>
					<%=elem.getMarca()%>
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