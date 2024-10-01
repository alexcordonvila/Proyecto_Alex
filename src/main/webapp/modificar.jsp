
<%@page import="com.ipartek.modelo.dto.V_Ordenador"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ipartek.modelo.I_Conexion"%>
<%@page import="com.ipartek.modelo.dto.V_Modelo"%>
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
<%
V_Ordenador objetoOrdenador = new V_Ordenador();
if (request.getAttribute(I_Conexion.ATR_ORDENADOR) != null) {
	objetoOrdenador = (V_Ordenador) request.getAttribute(I_Conexion.ATR_ORDENADOR);
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
		<H3>Modificar ordenador</H3>
		<label for="p_id">ID</label>
		<input type="tipo" size="tamaño" name="p_id" placeholder="Altura" readonly
			value="<%=objetoOrdenador.getId() %>"> </input>
		</select> <label>Número de serie*</label> <input
			required
			type="text"
			name="p_numeroSerie"
			value="<%=objetoOrdenador.getNumeroSerie()%>"
			placeholder="Número de serie"> <br> <label for="marca">Marca* <select
			required
			name="p_marca"
			id="marca">
				<%
				for (String elem : listaMarcas) {
				    if (elem.equals(objetoOrdenador.getMarca())) {
				%>
				<option
					value="<%=elem%>"
					selected>
					<%=elem%>
				</option>
				<%
				} else {
				%>
				<option value="<%=elem%>">
					<%=elem%>
				</option>
				<%
				}
				}
				%>
		</select> <br> <label for="modelo">Modelo* <select
				required
				name="p_modelo"
				id="modelo">
					<%
					for (V_Modelo elem : listaModelos) {

					    if (elem.getModelo().equals(objetoOrdenador.getModelo())) {
					%>
					<option
						value="<%=elem.getId()%>"
						selected>
						<%=elem.getModelo()%>
					</option>
					<%
					} else {
					%>
					<option value="<%=elem.getId()%>">
						<%=elem.getModelo()%>
					</option>
					<%
					}
					}
					%>
			</select>
		</label><br> <label>Capacidad*</label> <input
			required
			type="text"
			name="p_capacidad"
			value="<%=objetoOrdenador.getCapacidad()%>"
			placeholder="Ram"> <br> <label>Ram*</label> <input
			required
			type="text"
			name="p_ram"
			value="<%=objetoOrdenador.getRam()%>"
			placeholder="Ram"> <br> <label>Anotaciones*</label> <input
			required
			type="text"
			name="p_anotaciones"
			value="<%=objetoOrdenador.getAnotaciones()%>"
			placeholder="Anotaciones"> <br>
			
			<button type="submit">
				Modificar <i class="fa fa-edit"></i>
			</button>
	</form>
</body>
</html>