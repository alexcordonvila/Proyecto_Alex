
<%@page import="com.ipartek.modelo.I_Conexion"%>
<%@page import="com.ipartek.modelo.dto.V_Ordenador"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<V_Ordenador> listaOrdenadores = new ArrayList<V_Ordenador>();
if (request.getAttribute(I_Conexion.ATR_LISTA_ORDENADORES) != null) {
    listaOrdenadores = (List) request.getAttribute(I_Conexion.ATR_LISTA_ORDENADORES);
} else {
    //TAREA PARA METER EN EL LOG
}
%>
<%
int isOrdenadorUpdated = -1;
if (request.getAttribute(I_Conexion.ATR_ORDENADOR_UPDATED) != null) {
    isOrdenadorUpdated = (int) request.getAttribute(I_Conexion.ATR_ORDENADOR_UPDATED);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ORDENADORES</title>
<link
	rel="stylesheet"
	href="css/style.css">
<link
	rel="stylesheet"
	href="css/cuadricula_prod.css">
<link
	rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
	<%@ include file="includes/cabecera.jsp"%>
	<%@ include file="includes/menu.jsp"%>
	<main>
		<%
		if (isOrdenadorUpdated == 1) {
		%>
		<div class="message success">Ordenador modificado correctamente</div>
		<%
		} else if (isOrdenadorUpdated == 0) {
		%>
		<div class="message error">Error al insertar el ordenador</div>
		<%
		}
		%>
		<section>
			<%@ include file="includes/insertar.jsp"%>
		</section>
		<section>
			<table>
				<caption>Lista de ordenadores</caption>
				<thead>
					<tr>
						<th scope="col"><h3>Id</h3></th>
						<th scope="col"><h3>Numero de serie</h3></th>
						<th scope="col"><h3>RAM</h3></th>
						<th scope="col"><h3>Capacidad</h3></th>
						<th scope="col"><h3>Modelo</h3></th>
						<th scope="col"><h3>Marca</h3></th>
						<th scope="col"><h3>Anotaciones</h3></th>
						<th scope="col"><h3>Admin</h3></th>
					</tr>
				</thead>
				<tbody>
					<div>
						<%
						for (V_Ordenador elem : listaOrdenadores) {
						%>
						<tr>
							<th scope="row"><%=elem.getId()%></th>
							<td><%=elem.getNumeroSerie()%></td>
							<td><%=elem.getRam()%></td>
							<td><%=elem.getCapacidad()%></td>
							<td><%=elem.getModelo()%></td>
							<td><%=elem.getMarca()%></td>
							<td><%=elem.getAnotaciones()%></td>
							<td>
								<form
									method="post"
									action="EliminarOrdenador"
									class="botoneraTabla">
									<input
										type="hidden"
										name="p_id"
										value="<%=elem.getId()%>">
									<button
										type="submit"
										style="background: none; border: none; color: red; cursor: pointer;">
										<i class="fas fa-trash-alt"></i>
									</button>
								</form>
								<form
									method="post"
									action="AdminModificar"
									class="botoneraTabla">
									<input
										type="hidden"
										name="p_id"
										value="<%=elem.getId()%>">
									<button
										type="submit"
										style="background: none; border: none; color: blue; cursor: pointer;">
										<i class="fas fa-edit"></i>
									</button>
								</form>
							</td>
						</tr>
						<%
						}
						%>
					</div>
				</tbody>
				<tfoot>
					<tr>
						<th
							scope="row"
							colspan="2"># Ordenadores:</th>
						<td><%=listaOrdenadores.size()%></td>
					</tr>
				</tfoot>
			</table>
		</section>
	</main>
	<%@ include file="includes/pie.jsp"%>
</body>
</html>