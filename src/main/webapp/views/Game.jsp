
<%@ page import="com.javarush.zaikin.service.*" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="com.javarush.zaikin.model.Level" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% GameService player = (GameService) session.getAttribute("player"); %>
<%Level level = player.getLevel();
int levelInOrder = player.getLevelIndex(level);
String questionByLvl = player.getQuestionForLvl();
 String[] answersByLvl = player.getAnswersByLvl();%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Level <%=levelInOrder%></title>
</head>
<body>


<div class="container px-4 mt-5"> <%-- mt - отступ по вертикали px - горизонт отступ  fs - fontsize--%>
<div class="container text-center mt-5"> <h1><%=levelInOrder%> уровень!</h1> </div>

<div class="question-box mt-4">
    <h2 class="mb-3">❓ ВОПРОС: ❓</h2>
    <p class="fs-5"><%=questionByLvl%></p>
    <form action="/gameServlet" method="GET">
        <div class="text-start">
            <input type="radio" id="option1" name="answer" value=<%=URLEncoder.encode(answersByLvl[0])%> required>
            <label for="option1"><%=answersByLvl[0]%></label><br>

            <input type="radio" id="option2" name="answer" value=<%=URLEncoder.encode(answersByLvl[1])%>>
            <label for="option2"><%=answersByLvl[1]%></label><br>

            <input type="radio" id="option3" name="answer" value=<%=URLEncoder.encode(answersByLvl[2])%>>
            <label for="option3"><%=answersByLvl[2]%></label><br>
        </div>
        <button type="submit" class="btn btn-primary mt-3">Отправить</button>
    </form>
</div>

<br>
<c:if test="${sessionScope.player.isAvailablePotion == true}">
    <form action="/gameServlet" method="POST">
        <button type="submit">Воспользоваться эликсиром жизни!</button>
    </form>
</c:if>
    <c:if test="${sessionScope.player.isTipsOn == true}">
    <div class="accordion mt-4 w-75" id="levelDesc">
        <div class="accordion-item">
            <h2 class="accordion-header">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#descContent">
                    ℹ️ Подглядеть подсказку
                </button>
            </h2>
            <div id="descContent" class="accordion-collapse collapse">
                <div class="accordion-body bg-light">
                    <p><%=player.getDescForLvl()%></p>
                </div>
            </div>
        </div>
    </div>
    </c:if>


    <div class="position-fixed bottom-0 end-0 m-3 p-3 border border-secondary rounded bg-light shadow-sm small">
        <h6 class="text-center fw-bold"> Данные сессии</h6>
        <p class="mb-1">ID: <%= session.getId()%></p>
        <p class="mb-1">Имя: <%= player.getName()%></p>
        <p class="mb-1">Жизни: <%= player.getHealth()%></p>
        <p class="mb-0">Уровень: <%= player.getLevelIndex(level)%></p>
    </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</html>
