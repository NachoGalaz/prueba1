<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>Casa</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
            </head>

            <body>
                <h1 style="text-align: center"> Por favor ingrese datos de su casa </h1>

                <div class="container">
                    <c:if test="${msgError!= null}">
                        <c:out value="${msgError}"></c:out>
                    </c:if>
                    <form:form action="/casa/guardar" method="post" modelAttribute="casa">
                        <form:label path="calle" class="form-label">Calle:</form:label>
                        <form:input path="calle" class="form-control" />
                        <br>
                        <form:label path="numero" class="form-label">Numero:</form:label>
                        <form:input type="number" path="numero" class="form-control" />
                        <br>
                        <form:label path="color" class="form-label">Color:</form:label>
                        <form:input path="color" class="form-control" />
                        <br>
                        <form:label path="material" class="form-label">Material:</form:label>
                        <form:input path="material" class="form-control" />
                        <br>
                        <input type="submit" value="Guardar Casa">
                    </form:form>
                </div>
            </body>

            </html>