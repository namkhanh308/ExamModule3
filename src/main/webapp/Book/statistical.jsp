<%--
  Created by IntelliJ IDEA.
  User: namkh
  Date: 11/19/2021
  Time: 11:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get" action="/card">
    <h2>Tìm kiếm theo tên sách</h2>
    <input type="text" name="name">
    <input name="action" value="searchByNameBook" hidden>
    <input type="submit">
</form>
<form method="get" action="/card">
    <h2>Tìm kiếm theo tên học sinh</h2>
    <input type="text" name="nameStudent">
    <input name="action" value="searchByNameStudent" hidden>
    <input type="submit">
</form>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List Book</h2></caption>
        <tr>
            <th>Mã mượn sách</th>
            <th>Tên sách</th>
            <th>Tác giả</th>
            <th>Tên học sinh</th>
            <th>Lớp</th>
            <th>Ngày mượn</th>
            <th>Ngày trả</th>
        </tr>
        <c:forEach var="st" items="${statisticalList}">
            <tr>
                <td>${st.id}</td>
                <td>${st.nameBook}</td>
                <td>${st.actor}</td>
                <td>${st.nameStudent}</td>
                <td>${st.classStudent}</td>
                <td>${st.borrowedDate}</td>
                <td>${st.payDate}</td>
                <td>
                    <a href="/card?action=pay&id=${st.id}">Trả</a>
                </td>
            </tr>
        </c:forEach>
        <a href="/card">Quay về trang chủ</a>
    </table>
</div>
</body>
</html>
