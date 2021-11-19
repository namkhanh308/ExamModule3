<%--
  Created by IntelliJ IDEA.
  User: namkh
  Date: 11/19/2021
  Time: 9:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List Book</h2></caption>
        <tr>
            <th>Mã Sách</th>
            <th>Tên Sách</th>
            <th>Tác giả</th>
            <th>Số lượng</th>
            <th>Mô tả</th>
        </tr>
        <c:forEach var="book" items="${listBook}">
            <tr>
                <td><c:out value="${book.id}"/></td>
                <td><c:out value="${book.name}"/></td>
                <td><c:out value="${book.actor}"/></td>
                <td><c:out value="${book.quantity}"/></td>
                <td><c:out value="${book.description}"/></td>
                <td>
                    <a href="/card?action=borrow&id=${book.id}">Mượn</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/card?action=statistical">Trả</a>
</div>
</body>
</html>
