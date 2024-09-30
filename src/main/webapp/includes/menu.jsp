<%@page import="com.ipartek.modelo.I_Conexion"%>
<nav class="navbar">
    <ul class="navbar-menu">
        <%
        if ("index.jsp".equals(session.getAttribute("CURRENT_PAGE"))) {
        %>
        <li class="navbar-item"><a href="MenuTodos" class="navbar-link active">Ordenadores</a></li>
        <%
        } else {
        %>
        <li class="navbar-item"><a href="MenuTodos" class="navbar-link">Ordenadores</a></li>
        <%
        }

        if ("admin.jsp".equals(session.getAttribute("CURRENT_PAGE"))) {
        %>
        <li class="navbar-item"><a href="MenuAdmin" class="navbar-link active">Admin</a></li>
        <%
        } else {
        %>
        <li class="navbar-item"><a href="MenuAdmin" class="navbar-link">Admin</a></li>
        <%
        }

        if ("opciones.jsp".equals(session.getAttribute("CURRENT_PAGE"))) {
        %>
        <li class="navbar-item"><a href="MenuOpciones" class="navbar-link active">Opciones</a></li>
        <%
        } else {
        %>
        <li class="navbar-item"><a href="MenuOpciones" class="navbar-link">Opciones</a></li>
        <%
        }
        %>
    </ul>
</nav>
