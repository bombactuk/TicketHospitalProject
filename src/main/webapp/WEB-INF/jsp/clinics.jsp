<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

<head>
    <meta charset="UTF-8">
    <title>List Clinic</title>
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

    <form id="search_form" action="urlToServlet" method="post">

        <input type="hidden" name="command" value="search_clinic"/>
        <input type="search" name="query" placeholder="Поиск...">
        <button type="submit">Найти</button>

    </form>

    <div id="listOfClinics">

        <c:forEach var="clinicsList" items="${requestScope.clinicsList}">

           <h2>${clinicsList.name}</h2>
           <p>${clinicsList.country},${clinicsList.city}</p>
           <p>${clinicsList.address}</p>

           <a href="urlToServlet?command=go_to_clinic_info&idClinic=${clinicsList.idClinic}">Подробнее</a>

           <hr id="divider">

        </c:forEach>

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