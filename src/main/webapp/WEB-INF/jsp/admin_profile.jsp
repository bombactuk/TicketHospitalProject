<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">
    <title>Clinic information</title>
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

                <div id="regAuth">

                    <a href="urlToServlet?command=go_to_user_profile">

                        Добро пожаловать <c:out value="${sessionScope.userName}" />

                    </a>

                </div>

            </c:if>

        </nav>

    </header>

    <form action="urlToServlet" method="post">

    	<input type="hidden" name="command" value="function_admin_profile"/>

	    <select class="form-control" id="functionAdmin" placeholder="Функции администратора" name="function" required>

	        <option value="">Выберите функцию</option>
		    <option value="addClinic">Добавление поликлинники</option>
		    <option value="updateClinic">Изменение поликлинники</option>
		    <option value="deleteClinic">Удаление поликлинники</option>
		    <option value="addNews">Добавление статьи</option>
		    <option value="updateNews">Редактирование статьи</option>
		    <option value="deleteNews">Удаление статьи</option>
		    <!-- Добавьте другие по необходимости -->

	    </select>

	    <button id="functionChoice" type="submit" class="btn btn-primary">Выбрать</button>

	</form>

	<c:if test="${(param.functionInformation eq 'addClinic')}">

        <div id="formFunction">

            <form action="urlToServlet" method="post">

                <input type="hidden" name="command" value="add_clinic"/>

                <input type="text" placeholder="Название поликлинники" id="nameClinic" name="name" required>

                <input type="text" placeholder="Страна" id="countryClinic" name="country" required>

                <input type="text" placeholder="Город" id="cityClinic" name="city" required>

                <input type="text" placeholder="Адресс" id="addressClinic" name="address" required>

                <input type="text" placeholder="Номер регистратуры" id="numberClinic" name="number" required>

                <input type="text" placeholder="Информация" id="generalClinic" name="general" required>

            </form>

        </div>

    </c:if>

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