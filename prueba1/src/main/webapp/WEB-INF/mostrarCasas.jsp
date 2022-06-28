<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>Casas</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
            </head>

            <body>
                <h1 style="text-align: center"> Los datos han sido guardados </h1>
                <div class="container">

                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Calle</th>
                                <th scope="col">Numero</th>
                                <th scope="col">Color</th>
                                <th scope="col">Material</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="casa" items="${casasCapturadas}">
                                <tr>
                                    <th scope="row">${casa.id}</th>
                                    <td>${casa.calle}</td>
                                    <td>${casa.numero}</td>
                                    <td>${casa.color}</td>
                                    <td>${casa.material}</td>
                                    <td><a class="btn btn-warning" href="/casa/editar/${casa.id}" role="button">Editar</a></td>
                                    <td><a class="btn btn-danger" href="eliminar/${casa.id}" role="button">Eliminar</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
            </body>

            </html>