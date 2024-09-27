
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.modelo.dto.V_Ordenador"%>
<%@page import="java.util.List"%>
<%@page import="com.ipartek.modelo.I_Conexion"%>
<%
boolean isfilterOn = false;
if (request.getAttribute(I_Conexion.ATR_FILTRO_ACTIVADO) != null) {
    isfilterOn = (boolean) request.getAttribute(I_Conexion.ATR_FILTRO_ACTIVADO);
}
%>
<%
String numeroSerie = "";
if (request.getAttribute(I_Conexion.ATR_ORDENADOR_NUMEROSERIE) != null) {
    numeroSerie = (String) request.getAttribute(I_Conexion.ATR_ORDENADOR_NUMEROSERIE);
} else {
    //TAREA PARA METER EN EL LOG
}
%>
<label for="myInput">Buscar por número de serie:</label>
<%
if (isfilterOn) {
%>
<form
	name="ordenadorForm"
	class="search-form"
	method="post"
	action="MenuTodos"
	onsubmit="return validateForm()">
	<div class="input-group">
		<input
			type="text"
			id="myInput"
			onkeyup="filterList()"
			name="p_numeroSerie"
			value="<%=numeroSerie%>"
			placeholder="Buscar en la lista..."
			required>
		<button
			type="submit"
			class="search-button">
			<i class="fa fa-close"></i>
		</button>
	</div>
	<%
	} else {
	%>
	<form
		name="ordenadorForm"
		class="search-form"
		method="post"
		action="FiltrarOrdenadores"
		onsubmit="return validateForm()">
		<div class="input-group">
			<input
				type="text"
				id="myInput"
				onkeyup="filterList()"
				name="p_numeroSerie"
				placeholder="Buscar en la lista..."
				required>
			<button
				type="submit"
				class="search-button">
				<i class="fa fa-search"></i>
			</button>
		</div>
		<%
		}
		%>
	</form>