
<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<div class="tablascroll">
		<main>
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
		</main>
	</div>
	<%@ include file="includes/pie.jsp"%>
</body>
</html>