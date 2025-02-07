
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Подведем итог</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/my.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<div class="container px-4 mt-5">
<c:choose>
    <c:when test="${sessionScope.player.level.id == sessionScope.size}">

        <h1 class="container text-center mt-5 text-success">Поздравляем!</h1>
        <h2> <br>Вы сумели ответить на достаточное количество вопросов правильно и прошли квест.</h2>

    </c:when>
    <c:otherwise>
<h1 class="container text-center mt-5 text-danger">Вы проиграли</h1>
<h2 class="border p-4 rounded shadow-sm bg-light mt-3"><p>Случилось это потому, что Вы допустили слишком много ошибок</p>
<p>Если желаете попробовать снова - нажмите на кнопку ниже</p></h2>
    </c:otherwise>

</c:choose>
<h3>Сыграем еще?</h3>
<form action="/restart">
  <button class=" btn btn-primary mt-3">Сыграем!</button>
</form>
</div>

</body>
</html>
