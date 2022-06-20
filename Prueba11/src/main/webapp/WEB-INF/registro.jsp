<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
            <!--PERMITE TRABAJAR CON FORMULARIOS, CAPTURAR OBJETO COMPLETO Y PASAR EL OBJETO COMPLETO-->

            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>Registro Casas</title>
            </head>
            <div>
                <c:if test="${msgError!= null}">
                    <c:out value="${msgError}"></c:out>
                </c:if>
                <form:form action="/registro/casa" method="post" modelAttribute="casa" autocomplete="off">
                    <!--form:form unicamente para trabajar con formularios-->
                    <!--Estructura para trabajar con formularios, action method modelAtt atributos-->
                    <form:label path="calle">Calle:</form:label>
                    <!--En path va lo que queremos tomar y entre los dos cierres (Nombre:) va lo que queremos q se muestre en la pagina-->
                    <form:input path="calle" />
                    <!--Por default el type = "text"-->
                    <br>
                    <form:label path="comuna">Comuna:</form:label>
                    <form:input path="comuna" />
                    <br>
                    <form:label path="numero">Numero:</form:label>
                    <form:input type="number" path="numero" />
                    <br>
                    <form:label path="propietario">Propietario:</form:label>
                    <form:input path="propietario" />
                    <!--Aca agregamos type = ya que queremos q sea number-->
                    <!--Dentro de path va el nombre del atributo de un objeto-->
                    <br>
                    <input type="submit" value="Registrar">

                </form:form>


            </div>


            </body>

            </html>