
<%@page import="com.ipartek.modelo.dto.Marca"%>
<%@page import="com.ipartek.modelo.dto.V_Ordenador"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ipartek.modelo.I_Conexion"%>
<%@page import="com.ipartek.modelo.dto.V_Modelo"%>


<%
Marca objetoMarca = new Marca();
if (request.getAttribute(I_Conexion.ATR_MARCA) != null) {
    objetoMarca = (Marca) request.getAttribute(I_Conexion.ATR_MARCA);
} else {
	//TAREA PARA METER EN EL LOG
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<link
	rel="stylesheet"
	href="css/style.css">
<link
	rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<%@ include file="includes/cabecera.jsp"%>
<%@ include file="includes/menu.jsp"%>
<body>
	<form
		name="ordenadorForm"
		class="login"
		method="post"
		action="ModificarOrdenador"
		onsubmit="return validateForm()">
		<H3>Modificar marca</H3>
		
		<label for="p_id">ID</label> 
		<input
			type="tipo"
			size="tamaño"
			name="p_id"
			placeholder="ID"
			readonly
			value="<%=objetoMarca.getId() %>"
		>
			</input> 
			
			 <label>Nombre marca*</label> 
			 <input
			required
			type="text"
			name="p_nombreMarca"
			placeholder="Nombre de marca"
			value="<%=objetoMarca.getMarca()%>">
			<br>
		<button type="submit">
			Modificar marca <i class="fa fa-edit"></i>
		</button>
	</form>
</body>
</html>