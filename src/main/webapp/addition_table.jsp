<%--
  Created by IntelliJ IDEA.
  User: INT202&204
  Date: 9/22/2023
  Time: 11:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Addition Table</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        h3 {
            color: #333;
        }

        table {
            border-collapse: collapse;
            width: 50%;
            margin-top: 10px;
        }

        td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
            background-color: aliceblue;
        }

    </style>
</head>
<body>
<h3>Addition Table</h3>
<hr>

<c:if test="${param.number1 != null && param.number2 != null}">
    <table>
        <tr>
            <td colspan="5" style="background-color: lavender">Sum of ${param.number1} and ${param.number2}</td>
        </tr>
        <c:forEach begin="1" end="1" var="n"> <!-- Perform the loop just once for addition -->
            <tr>
                <td class="number">${param.number1}</td>
                <td>+</td>
                <td class="number">${param.number2}</td>
                <td>=</td>
                <td class="number">${(param.number1 + param.number2)}</td> <!-- Calculate and display the sum -->
            </tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${param.number1 == null || param.number2 == null}">
    <h3 style="color: red">
        Error: Please provide valid numbers for addition.
        (Number 1: ${param.number1 == null ? "Null/Empty" : param.number1},
        Number 2: ${param.number2 == null ? "Null/Empty" : param.number2})
    </h3>
</c:if>
</body>
</html>
