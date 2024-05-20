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
                    <li><a href="urlToServlet?command=go_to_doctors">Доктора</a></li>

         	    </c:if>

            </ul>

            <c:if test="${(sessionScope.userRole eq null)}">

                <div id="regAuth"><a href="urlToServlet?command=go_to_registration">Регистрация</a> |
                <a href="urlToServlet?command=go_to_authorization">Авторизация</a></div>

            </c:if>

            <c:if test="${(sessionScope.userRole eq 'user') }">

                <div id="regAuth">

                    <a href="urlToServlet?command=go_to_user_profile&idUser=${sessionScope.userId}">

                        Добро пожаловать <c:out value="${sessionScope.userName}" />

                    </a>

                </div>

            </c:if>

            <c:if test="${(sessionScope.userRole eq 'admin') }">

                <div id="regAuth">

                    <a href="urlToServlet?command=go_to_admin_profile">

                        Добро пожаловать <c:out value="${sessionScope.userName}" />

                    </a>

                </div>

            </c:if>

        </nav>

    </header>

    <div id="doctorInfo">

        <c:set var="doctorInformation" value="${requestScope.infoDoctor}" />

        <h2>${doctorInformation.fio}</h2>
        <p>Профессия: ${doctorInformation.profession} </p>
        <p>Информация: ${doctorInformation.description}</p>

        <c:set var="clinicInformation" value="${requestScope.infoClinic}" />

        <p>Работает: ${clinicInformation.name} </p>
        <p>Страна: ${clinicInformation.country} </p>
        <p>Город: ${clinicInformation.city} </p>
        <p>Адрес: ${clinicInformation.address} </p>

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