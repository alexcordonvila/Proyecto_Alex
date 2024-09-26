<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ipartek.modelo.I_Conexion"%>
<%@page import="com.ipartek.modelo.dto.V_Modelo"%>
<%
int isMarcaUploaded = -1;
if (request.getAttribute(I_Conexion.ATR_MARCA_UPLOADED) != null) {
	isMarcaUploaded = (int) request.getAttribute(I_Conexion.ATR_MARCA_UPLOADED);
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
	if (isMarcaUploaded == 1) {
	%>
	<div class="message success">Marca insertada correctamente</div>
	<%
	} else if (isMarcaUploaded == 0) {
	%>
	<div class="message error">Error al insertar la marca</div>
	<%
	}
	%>
	<form
		name="ordenadorForm"
		class="login"
		method="post"
		action="InsertarMarca"
		onsubmit="return validateForm()">
		<H3>Añadir Marca</H3>
		</select> <label>Nombre de marca*</label> <input
			required
			type="text"
			name="p_marca"
			placeholder="Nombre de marca"> <br>
		<button type="submit">
			Insertar marca <i class="fa fa-upload"></i>
		</button>
	</form>
</body>
</html>