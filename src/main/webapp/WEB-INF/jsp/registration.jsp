<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Регистрация</title>
<link href="css/style.css" rel="stylesheet" type="text/css">

</head>

<body>

<header>
  <h1><span class="logo">Ticket</span>Reservation</h1>
    <nav>
      <ul>
        <li><a href="urlToServlet?command=go_to_index_page">Главная</a></li>
        <li><a href="#">О нас</a></li>
        <li><a href="#">Услуги</a></li>
        <li><a href="#">Контакты</a></li>
     </ul>
            
      <div id="regAuth"><a href="urlToServlet?command=go_to_registration">Регистрация</a> | <a href="urlToServlet?command=go_to_authorization">Авторизация</a></div>
     </nav>
    
</header>

	<div id="containerRegistr" class="container mt-5">

		<h2>User<span id="logoRegistr">Registration</span></h2>

		<form action="urlToServlet" method="post">

		    <input type="hidden" name="command" value="new_user_registration"/>

		<div class="error-message" id="error-message">

            <c:if test="${not (param.regError eq null) }">

            <c:out value="${param.regError}" />

            </c:if>

        </div>

			<div class="form-group">
			 <input type="text" class="form-control" placeholder="Email адрес" id="username" name="username" required>
			</div>
			
			<div class="form-group">
	 			<input type="password" class="form-control" placeholder="Пароль" id="password" name="password" required>
			</div>
			
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Имя" id="name" name="name" required>
			</div>
			
			<div class="form-group">
				<input type="date" class="form-control" placeholder="Дата рождения" id="dob" name="dob" required>
			</div>
			<div class="form-group">
			 <select class="form-control" id="country" placeholder="Страна Проживания" name="country" required>
					<option value="">Выберите страну</option>
					<option value="russia">Россия</option>
					<option value="usa">США</option>
					<option value="germany">Германия</option>
					<option value="france">Франция</option>
					<!-- Добавьте другие страны по необходимости -->
				</select>
			</div>

			<button id="btnRegistration" type="submit" class="btn btn-primary">Зарегистрироваться</button>

		</form>
	</div>

<footer>

	<div id="social">

		<a href="http://vk.com" title="Группа VK" target="_blank"> <img
			src="img/vk.png" alt="VK" title="VK" />
		</a>

		<a href="http://facebook.com" title="Группа Facebook" target="_blank">
	        <img src="img/facebook.png" alt="Facebook" title="Facebook" />
		</a>

		<a href="http://twitter.com" title="Группа Twitter" target="_blank">
			<img src="img/twitter.png" alt="Twitter" title="Twitter" />
		</a>

	</div>

	<div id="right">
		<p id="right">Copyright &copy; Your Website</p>
	</div>

	<script>
		document.getElementById('right').innerHTML = 'Все права защищены &copy; '
				+ new Date().getFullYear() + '';
	</script>

</footer>

</body>
</html>