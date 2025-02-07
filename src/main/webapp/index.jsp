<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!doctype html>
<html lang="en">
<!DOCTYPE html>
<html>
<head>
    <title>JAVA-QUEST</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/my.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</head>
<body>
<div class="container text-center mt-5">
    <h1 class="fw-bold">Добро пожаловать, путешественник по интернету!</h1>
</div>
<div class="container text-center mt-4">

    <div class="border p-4 rounded shadow-sm bg-light mt-3">
        <p>Тебя ждёт шесть уровней с интересными вопросами на тему JAVA, где важны логика, внимательность и интуиция.</p>
        <p>Испытания не слишком сложные, но каждый шаг приближает тебя к финалу. Сможешь ли ты доказать свое?</p>
    </div>


    <div class="border p-3 rounded shadow-sm bg-white mt-4 d-inline-block">
        <h4 class="fw-bold">Назови свое имя!</h4>
        <form action="levelFirst" method="GET">
            <input type="text" class="form-control d-inline w-auto" name="name" placeholder="Введите имя">
            <button class="btn btn-dark">Начать</button>
        </form>
    </div>

    <div class="position-absolute bottom-0 end-0 m-4" style="max-width: 300px;">
        <div class="accordion" id="questGuide">
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#guideContent">
                        📜 Небольшой гайд по квесту
                    </button>
                </h2>
                <div id="guideContent" class="accordion-collapse collapse">
                    <div class="accordion-body bg-light">
                        <ul class="list-unstyled">
                            <li>✅ 6 уровней</li>
                            <li>❤️ 2 жизни</li>
                            <li>🧪 1 эликсир жизни</li>
                            <li>🔄 Попытки неограничены</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>