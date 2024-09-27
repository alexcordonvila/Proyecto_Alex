
<%@page import="com.ipartek.modelo.dto.V_Modelo"%>
<%@page import="com.ipartek.modelo.dto.Marca"%>
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
<%
List<V_Modelo> listaModelos = new ArrayList<V_Modelo>();
if (request.getAttribute(I_Conexion.ATR_LISTA_MODELOS) != null) {
    listaModelos = (List) request.getAttribute(I_Conexion.ATR_LISTA_MODELOS);
} else {
    //TAREA PARA METER EN EL LOG
}
%>
<%
List<Marca> listaMarcas = new ArrayList<Marca>();
if (request.getAttribute(I_Conexion.ATR_LISTA_MARCAS) != null) {
    listaMarcas = (List) request.getAttribute(I_Conexion.ATR_LISTA_MARCAS);
} else {
    //TAREA PARA METER EN EL LOG
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Marcas y modelos</title>
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
		<div class="message error">Error al modificar el ordenador</div>
		<%
		}
		%>
		<div class="adminContainer">
			<section>
				<%@ include file="includes/insertarModelo.jsp"%>
				
				<div class="tablascroll">
				<table>
					<caption>Lista de modelos</caption>
					<thead>
						<tr>
							<th scope="col"><h3>Id</h3></th>
							<th scope="col"><h3>Modelo</h3></th>
							<th scope="col"><h3>Admin</h3></th>
						</tr>
					</thead>
					<tbody>
						<div>
							<%
							for (V_Modelo elem : listaModelos) {
							%>
							<tr>
								<th scope="row"><%=elem.getId()%></th>
								<td><%=elem.getModelo()%></td>
								<td>
									<form
										method="post"
										action="EliminarModelo"
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
										action="AdminModificarModelo"
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
								colspan="2"># Modelos:</th>
							<td><%=listaModelos.size()%></td>
						</tr>
					</tfoot>
				</table>
			</section>
			<section>
				<%@ include file="includes/insertarMarca.jsp"%>
				<div class="tablascroll">
				<table>
					<caption>Lista de Marcas</caption>
					<thead>
						<tr>
							<th scope="col"><h3>Id</h3></th>
							<th scope="col"><h3>Marca</h3></th>
							<th scope="col"><h3>Admin</h3></th>
						</tr>
					</thead>
					<tbody>
						<div>
							<%
							for (Marca elem : listaMarcas) {
							%>
							<tr>
								<th scope="row"><%=elem.getId()%></th>
								<td><%=elem.getMarca()%></td>
								<td>
									<form
										method="post"
										action="EliminarMarca"
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
										action="AdminModificarModelo"
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
								colspan="2"># Marcas:</th>
							<td><%=listaMarcas.size()%></td>
						</tr>
					</tfoot>
				</table>
				</div>
			</section>
		</div>
	</main>
	<%@ include file="includes/pie.jsp"%>
</body>
</html>