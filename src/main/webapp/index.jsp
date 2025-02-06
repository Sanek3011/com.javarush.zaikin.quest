<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!doctype html>
<html lang="en">
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Приветствие. Входное описание." %>
</h1>


<form action="/levelFirst" method="GET">
    <label for="inputField">Представьтесь</label>
    <input type="text" id="inputField" name="name" placeholder="Введите значение">
    <button>Начать</button>

</form>

</body>
</html>