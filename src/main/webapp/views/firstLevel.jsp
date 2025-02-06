
<%@ page import="com.javarush.zaikin.service.*" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="com.javarush.zaikin.model.Level" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% GameService player = (GameService) session.getAttribute("player"); %>
<%Level level = player.getLevel();
 String questionByLvl = player.getQuestionForLvl();
 String[] answersByLvl = player.getAnswersByLvl();%>
<html>
<head>
    <link rel="stylesheet" href="/views/my.css">
    <title>Level <%=level.getId()%></title>
</head>
<body>

<%--<p>Отладка: sessionScope.player = ${sessionScope.player}</p>--%>
<%--<p>Отладка: sessionScope.player.currentLevel = ${sessionScope.player.currentLevel}</p>--%>
<%--<p>Отладка: sessionScope.player.isAvailableEnergetic = ${sessionScope.player.isAvailableEnergetic}</p>--%>


<h1>Поздравляем с переходом на <%=level.getId()%> уровень!</h1>
<h2>
    <p><%=player.getDescForLvl()%></p>
</h2>



<h2>ВОПРОС:</h2>
<%=questionByLvl%>
<form action="/gameServlet" method="GET">


    <p>Выберите вариант:</p>
    <input type="radio" id="option1" name="answer" value=<%=URLEncoder.encode(answersByLvl[0])%> required>
    <label for="option1"><%=answersByLvl[0]%></label><br>

    <input type="radio" id="option2" name="answer" value=<%=URLEncoder.encode(answersByLvl[1])%>>
    <label for="option2"><%=answersByLvl[1]%></label><br>

    <input type="radio" id="option3" name="answer" value=<%=URLEncoder.encode(answersByLvl[2])%>>
    <label for="option3"><%=answersByLvl[2]%></label><br>

    <button type="submit">Отправить</button>
</form>

<br>
<c:if test="${sessionScope.player.isAvailableEnergetic == true}">
    <form action="/gameServlet" method="POST">
        <button type="submit">Выпить энергетик!</button>
    </form>
</c:if>








<div class="sessionInfo"><h4>
    Данные по текущей сессии:
    <%= player.getSession().getId()%>
    <br>
    Имя персонажа:
    <%= player.getName()%>
    <br>
    Ваши жизни:
    <%=player.getHealth()%>
    <br>
    Ваша энергия:
    <%= player.getEnergy()%>
    <br>
    Текущий уровень:
    <%= player.getLevel().getId()%>
</h4>
</div>
</body>
</html>
