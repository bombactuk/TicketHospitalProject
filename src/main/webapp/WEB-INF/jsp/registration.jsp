<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">
    <title>Registration</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">

</head>

<body>

    <header>

        <h1><span class="logo">Ticket</span>Reservation</h1>

        <nav>

            <ul>

                <li><a href="urlToServlet?command=go_to_index_page">Главная</a></li>
                <li><a href="urlToServlet?command=go_to_about_us">О нас</a></li>

                <c:if test="${(sessionScope.userRole eq null)}">

                    <li onclick ="showMessageAuthorization()" id="closedButtons">Медучреждения</li>
                    <li onclick ="showMessageAuthorization()" id="closedButtons">Доктора</li>

                   <script>

                       function showMessageAuthorization() {
                           alert("Для полного доступа функционалу надо авторизоваться");
                       }

                   </script>

                </c:if>

        	    <c:if test="${(sessionScope.userRole eq ('user' || 'admin'))}">

                    <li><a href="urlToServlet?command=go_to_clinics">Медучреждения</a></li>
                    <li><a href="urlToServlet?command=go_to_about_us">Доктора</a></li>

        	    </c:if>

            </ul>

            <c:if test="${(sessionScope.userRole eq null)}">

                <div id="regAuth"><a href="urlToServlet?command=go_to_registration">Регистрация</a> |
                <a href="urlToServlet?command=go_to_authorization">Авторизация</a></div>

            </c:if>

            <c:if test="${(sessionScope.userRole eq ('user' || 'admin')) }">

                <div id="regAuth">Привет <c:out value="${sessionScope.userName}" /></div>

            </c:if>

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
					<option value="belarus">Беларусь</option>
					<!-- Добавьте другие страны по необходимости -->

				</select>

			</div>

			<button id="btnRegistration" type="submit" class="btn btn-primary">Зарегистрироваться</button>

		</form>

	</div>

    <footer>

	    <div id="social">

	        <c:forEach var="contactsCommunications" items="${requestScope.contactsFooter}">

		        <a href="${contactsCommunications.link}" title="Связь с нами" target="Связь с нами">
		            <img src="${contactsCommunications.img}" alt="Связь с нами" title="Связь с нами" />
		        </a>

            </c:forEach>

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