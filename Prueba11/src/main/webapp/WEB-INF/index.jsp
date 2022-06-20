<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Registro casas</title>
        </head>

        <body>
            <h1> Gracias por ingresar sus datos
                <c:out value="${Calles}"></c:out>
                <c:out value="${comunas}"></c:out>
                <c:out value="${Numeros}"></c:out>
                <c:out value="${Propietarios}"></c:out>
            </h1>

            <p>
                <!-- <p> parrafo salto de linea-->
            </p>
            <p>
                <c:out value="${casa.calle} ${casa.getNumero()} ${casa.getComuna()} ${casa.getPropietario()}"></c:out>
                <!--dos formas de captar el contenido-->
            </p>


        </body>

        </html>