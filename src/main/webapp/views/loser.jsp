
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Подведем итог</title>
</head>
<body>
<c:choose>
    <c:when test="${sessionScope.player.level.id == 20}">

        <h1>Поздравляю! <br>Вы сумели ответить на достаточное количество вопросов правильно и выиграли квест.</h1>

    </c:when>
    <c:otherwise>
<h1>Вы проиграли</h1>
<h2><p>Случилось это потому, что Вы не уследили за своей энергией или жизнями!</p>
<p>Если желаете попробовать снова - нажмите на кнопку ниже</p></h2>
    </c:otherwise>

</c:choose>
<h3>Сыграем еще?</h3>
<form action="/restart">
  <button>Сыграем!</button>
</form>

</body>
</html>
