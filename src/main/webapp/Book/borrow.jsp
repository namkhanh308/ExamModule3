<%--
  Created by IntelliJ IDEA.
  User: namkh
  Date: 11/19/2021
  Time: 10:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Mượn sách</h1>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <tr>
                <th>Mã mượn sách :</th>
                <td>
                    <input type="text" name="mms" size="45" value="MS-XXX"/>
                </td>
            </tr>
            <input type="hidden" name="idBook" size="45" value="${book.id}"/>
            <tr>
                <th>Tên sách</th>
                <td>
                    <input type="text" name="nameBook" size="45" value="${book.name}"/>
                </td>
            </tr>
            <tr>
                <th>Ngày mượn sách</th>
                <td>
                    <input type="text" name="borrowDate" size="15" value="${borrowDate}"/>
                </td>
            </tr>
            <tr>
                <th>Ngày trả sách</th>
                <td>
                    <input type="text" name="payDate" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Danh sách học sinh</th>
                <td>
                    <select name="IDstudent">
                        <c:forEach items="${studentList}" var="t">
                            <option value="${t.id}">${t.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
