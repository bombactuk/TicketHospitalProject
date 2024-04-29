<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>

<head> 
<meta charset="UTF-8">
<title>User authorization</title>
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

	<div id="container" class="container">
	
		<form id="form-signin" class="form-signin" action="urlToServlet" method="post">
		
			<input type="hidden" name="command" value="do_auth" />
			
			<h2 class="form-signin-heading text-java text-center">User<span id=logoAuthor>Authorization</span></h2>
			
		    <div class="auth-message" id="auth-message">

			    <c:if test="${not (param.authMessage eq null) }">

                    <c:out value="${param.authMessage}" />

			    </c:if>

			<input type="email" id="inputEmail" class="form-control" placeholder="Email адрес" name="login" required autofocus>
			<input type="password" id="inputPassword" class="form-control" placeholder="Пароль" name="password" required>
			
			<button id="btn" class="btn btn-lg btn-success btn-block" type="submit">Войти</button>
			
			<div class="text-center mt-2">
			
				<a href="urlToServlet?command=go_to_registration">Регистрация нового аккаунта</a>
				
			</div>
			
		</form>
		
	</div>

<footer>

	<div id="social">

		<a href="http://vk.com" title="Группа VK" target="_blank"> <img
			src="img/vk.png" alt="VK" title="VK" />
		</a> <a href="http://facebook.com" title="Группа Facebook" target="_blank">
			<img src="img/facebook.png" alt="Facebook" title="Facebook" />
		</a> <a href="http://twitter.com" title="Группа Twitter" target="_blank">
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