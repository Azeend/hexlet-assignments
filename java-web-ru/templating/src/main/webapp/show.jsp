<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- BEGIN -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Users</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
</head>
<body>
<div class=\"container\">
    <a href="/users">Главная</a>
<table>
<tr>
<tr><td>${user.get("id")}</td></tr>
<tr><td>${user.get("firstName")} ${user.get("lastName")}</td></tr>
<tr><td>${user.get("email")}</td></tr>
<td><a href='/users/delete?id=${user.get("id")}'>delete</a></td>
</tr>
</table>
</div>
</body>
</html>
<!-- END -->
