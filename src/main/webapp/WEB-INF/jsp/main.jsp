<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html> 

<head>

	<meta charset="UTF-8">
	<title>Добро пожаловать в курс Java!</title>
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

	<div class="container text-center">
		<h1 class="text-java">Добро пожаловать в курс Java!</h1>
		<p class="lead">Поздравляем с успешным входом на платформу. Вы
			готовы начать изучение?</p>
			
		
		<p class="lead"><c:out value="${requestScope.invitationMessage}" />	 </p>
		<div class="content">
			<a href="lessons.html" class="btn btn-lg btn-success">Перейти к
				урокам</a> <a href="profile.html" class="btn btn-lg btn-info"
				style="margin-left: 20px;">Мой профиль</a>
		</div>
		<div class="footer">
			<p>&copy; 2024 Изучаем Java. Все права защищены.</p>
		</div>
	</div>

</body>
</html>