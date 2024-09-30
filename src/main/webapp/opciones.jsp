
<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
int isaved = -1;
if (request.getAttribute(I_Conexion.ATR_CSV_GUARDADO) != null) {
    isaved = (int) request.getAttribute(I_Conexion.ATR_CSV_GUARDADO);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Opciones</title>
<link
	rel="stylesheet"
	href="css/style.css">
<link
	rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
	<%@ include file="includes/cabecera.jsp"%>
	<%@ include file="includes/menu.jsp"%>
	<main>
		<%
		if (isaved == 1) {
		%>
		<div class="message success">CSV guardado correctamente</div>
		<%
		} else if (isaved == 0) {
		%>
		<div class="message error">Error al guardar el csv</div>
		<%
		}
		%>
		<div class="adminContainer">
			<section>
				<form
					name="ordenadorForm"
					class="ordenadorForm"
					method="post"
					action="GuardarCSV"
					onsubmit="return validateForm()">
					<label for="myInput">Guardar ordenadores en CSV:</label>
					<div class="input-group">
						<button type="submit">
							GUARDAR <i class="fa fa-save"></i>
						</button>
					</div>
				</form>
			</section>
		</div>
	</main>
	<%@ include file="includes/pie.jsp"%>
</body>
</html>