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

    <form action="urlToServlet" method="post">

    	<input type="hidden" name="command" value="go_to_admin_profile"/>

	    <select class="form-control" id="functionAdmin" placeholder="Функции администратора" name="function" required>

	        <option value="">Выберите функцию</option>
		    <option value="addClinic">Добавление поликлинники</option>
		    <option value="addDoctor">Добавление доктора</option>
		    <option value="addFooter">Добавление связи с нами</option>
		    <option value="addNews">Добавление новостей</option>
		    <option value="deleteClinic">Удаление поликлинники</option>
		    <option value="deleteDoctor">Удаление доктора</option>
		    <option value="deleteFooter">Удаление связи с нами</option>
		    <option value="deleteNews">Удаление новостей</option>
		    <option value="updateAbout">Редактирование о нас</option>
		    <option value="idUpdateNews">Редактирование новостей</option>
		    <option value="idUpdateClinic">Редактирование клиники</option>
		    <option value="idUpdateDoctor">Редактирование доктора</option>
		    <option value="idUpdateFooter">Редактирование связи с нами</option>
		    <option value="idUpdateUser">Редактирование пользователя</option>

	    </select>

	    <button id="functionChoice" type="submit" class="btn btn-primary">Выбрать</button>

	</form>

	<div class="error-messageFunction" id="error-messageFunction">

        <c:if test="${not (param.functionError eq null) }">

            <c:out value="${param.functionError}" />

        </c:if>

    </div>

	<div id="exitAdminProfile">

	    <a href="urlToServlet?command=logout_from_account">Выйти с аккаунта</a>

	</div>

	<c:if test="${(requestScope.functionInformation eq 'addClinic')}">

        <div id="formFunction">

            <form action="urlToServlet" method="post">

                <input type="hidden" name="command" value="add_clinic"/>

                <input type="text" placeholder="Название поликлинники" id="nameClinic" name="name" required>

                <input type="text" placeholder="Страна" id="countryClinic" name="country" required>

                <input type="text" placeholder="Город" id="cityClinic" name="city" required>

                <input type="text" placeholder="Адресс" id="addressClinic" name="address" required>

                <input type="text" placeholder="Номер регистратуры" id="numberClinic" name="number" required>

                <input type="text" placeholder="Информация" id="generalClinic" name="general" required>

                <input type="text" placeholder="Структура" id="structure" name="structure" required>

                <input type="text" placeholder="Расписание" id="schedule" name="schedule" required>

                <button id="btnAdminFunction" type="submit" class="btn btn-primary">Добавить</button>

            </form>

        </div>

    </c:if>

    <c:if test="${(requestScope.functionInformation eq 'addFooter')}">

        <div id="formFunction">

            <form action="urlToServlet" method="post">

                <input type="hidden" name="command" value="add_footer"/>

                <input type="text" placeholder="Изображение" id="imgFooter" name="img" required>

                <input type="text" placeholder="Ссылка" id="linkFooter" name="link" required>

                <button id="btnAdminFunction" type="submit" class="btn btn-primary">Добавить</button>

            </form>

        </div>

    </c:if>

    <c:if test="${(requestScope.functionInformation eq 'addNews')}">

        <div id="formFunction">

            <form action="urlToServlet" method="post">

                <input type="hidden" name="command" value="add_news"/>

                <input type="text" placeholder="Заголовок" id="titleNews" name="title" required>

                <input type="text" placeholder="Краткое содержание" id="briefNews" name="brief" required>

                <input type="text" placeholder="Изображение" id="imgNews" name="img" required>

                <input type="text" placeholder="Ссылка" id="linkNews" name="link" required>

                <button id="btnAdminFunction" type="submit" class="btn btn-primary">Добавить</button>

            </form>

        </div>

    </c:if>

    <c:if test="${(requestScope.functionInformation eq 'addDoctor')}">

        <div id="formFunction">

            <form action="urlToServlet" method="post">

                <input type="hidden" name="command" value="add_doctor"/>

                <input type="text" placeholder="Id Клиники" id="idClinic" name="idClinic" required>

                <input type="text" placeholder="Фио" id="fioDoctor" name="fio" required>

                <input type="text" placeholder="Профессия" id="professionDoctor" name="profession" required>

                <input type="text" placeholder="Описание" id="descriptionDoctor" name="description" required>

                <button id="btnAdminFunction" type="submit" class="btn btn-primary">Добавить</button>

            </form>

        </div>

    </c:if>

    <c:if test="${(requestScope.functionInformation eq 'deleteClinic')}">

        <div id="formFunction">

            <form action="urlToServlet" method="post">

                <input type="hidden" name="command" value="delete_clinic"/>

                <input type="text" placeholder="Id Клиники" id="idClinic" name="idClinic" required>

                <button id="btnAdminFunction" type="submit" class="btn btn-primary">Удалить</button>

            </form>

        </div>

    </c:if>

    <c:if test="${(requestScope.functionInformation eq 'deleteDoctor')}">

        <div id="formFunction">

            <form action="urlToServlet" method="post">

                <input type="hidden" name="command" value="delete_doctor"/>

                <input type="text" placeholder="Id Врача" id="idDoctor" name="idDoctor" required>

                <button id="btnAdminFunction" type="submit" class="btn btn-primary">Удалить</button>

            </form>

        </div>

    </c:if>

    <c:if test="${(requestScope.functionInformation eq 'deleteFooter')}">

        <div id="formFunction">

            <form action="urlToServlet" method="post">

                <input type="hidden" name="command" value="delete_footer"/>

                <input type="text" placeholder="Id Связи с нами" id="idFooter" name="idFooter" required>

                <button id="btnAdminFunction" type="submit" class="btn btn-primary">Удалить</button>

            </form>

        </div>

    </c:if>

    <c:if test="${(requestScope.functionInformation eq 'deleteNews')}">

        <div id="formFunction">

            <form action="urlToServlet" method="post">

                <input type="hidden" name="command" value="delete_news"/>

                <input type="text" placeholder="Id Новостей" id="idNews" name="idNews" required>

                <button id="btnAdminFunction" type="submit" class="btn btn-primary">Удалить</button>

            </form>

        </div>

    </c:if>

    <c:if test="${(requestScope.functionInformation eq 'updateAbout')}">

        <div id="formFunction">

            <c:set var="infoAbout" value="${requestScope.infoObject}" />

            <form action="urlToServlet" method="post">

                <input type="hidden" name="command" value="update_about"/>

                <input type="text" value="${infoAbout.text}" id="textAbout" name="text" required>

                <button id="btnAdminFunction" type="submit" class="btn btn-primary">Редактировать</button>

            </form>

        </div>

    </c:if>

    <c:if test="${(requestScope.functionInformation eq 'idUpdateNews')}">

        <div id="formFunction">

            <form action="urlToServlet" method="post">

                <input type="hidden" name="command" value="go_to_admin_profile"/>

                <input type="hidden" name="function" value="updateNews"/>

                <input type="text" placeholder="Id News" id="idNews" name="id" required>

                <button id="btnAdminFunction" type="submit" class="btn btn-primary">Вывод для редоктирования</button>

            </form>

        </div>

    </c:if>

    <c:if test="${(requestScope.functionInformation eq 'updateNews')}">

            <div id="formFunction">

                <c:set var="infoNews" value="${requestScope.infoObject}" />

                <form action="urlToServlet" method="post">

                    <input type="hidden" name="command" value="update_news"/>

                    <input type="hidden" value="${infoNews.id}" id="idNews" name="id" required>

                    <input type="text" value="${infoNews.title}" id="titleNews" name="title" required>

                    <input type="text" value="${infoNews.brief}" id="briefNews" name="brief" required>

                    <input type="text" value="${infoNews.img}" id="imgNews" name="img" required>

                    <input type="text" value="${infoNews.link}" id="linkNews" name="link" required>

                    <button id="btnAdminFunction" type="submit" class="btn btn-primary">Редоктировать</button>

                </form>

            </div>

        </c:if>

        <c:if test="${(requestScope.functionInformation eq 'idUpdateClinic')}">

            <div id="formFunction">

                <form action="urlToServlet" method="post">

                    <input type="hidden" name="command" value="go_to_admin_profile"/>

                    <input type="hidden" name="function" value="updateClinic"/>

                    <input type="text" placeholder="Id Clinic" id="idClinic" name="id" required>

                    <button id="btnAdminFunction" type="submit" class="btn btn-primary">Вывод для редоктирования</button>

                </form>

            </div>

        </c:if>

        <c:if test="${(requestScope.functionInformation eq 'updateClinic')}">

            <div id="formFunction">

                <c:set var="infoClinic" value="${requestScope.infoObject}" />

                <form action="urlToServlet" method="post">

                    <input type="hidden" name="command" value="update_clinic"/>

                    <input type="hidden" value="${infoClinic.idClinic}" id="idClinic" name="id" required>

                    <input type="text" value="${infoClinic.name}" id="nameClinic" name="name" required>

                    <input type="text" value="${infoClinic.country}" id="countryClinic" name="country" required>

                    <input type="text" value="${infoClinic.city}" id="cityClinic" name="city" required>

                    <input type="text" value="${infoClinic.address}" id="addressClinic" name="address" required>

                    <input type="text" value="${infoClinic.registrationNumber}" id="registrationNumberClinic" name="registrationNumber" required>

                    <input type="text" value="${infoClinic.generalInformation}" id="generalInformationClinic" name="generalInformation" required>

                    <input type="text" value="${infoClinic.structure}" id="structureClinic" name="structure" required>

                    <input type="text" value="${infoClinic.schedule}" id="scheduleClinic" name="schedule" required>

                    <button id="btnAdminFunction" type="submit" class="btn btn-primary">Редоктировать</button>

                </form>

            </div>

        </c:if>

        <c:if test="${(requestScope.functionInformation eq 'idUpdateDoctor')}">

            <div id="formFunction">

                <form action="urlToServlet" method="post">

                    <input type="hidden" name="command" value="go_to_admin_profile"/>

                    <input type="hidden" name="function" value="updateDoctor"/>

                    <input type="text" placeholder="Id Doctor" id="idDoctor" name="id" required>

                    <button id="btnAdminFunction" type="submit" class="btn btn-primary">Вывод для редоктирования</button>

                </form>

            </div>

        </c:if>

        <c:if test="${(requestScope.functionInformation eq 'updateDoctor')}">

            <div id="formFunction">

                <c:set var="infoDoctor" value="${requestScope.infoObject}" />

                <form action="urlToServlet" method="post">

                    <input type="hidden" name="command" value="update_doctor"/>

                    <input type="hidden" value="${infoDoctor.idDoctor}" id="idDoctor" name="id" required>

                    <input type="text" value="${infoDoctor.idClinic}" id="idClinic" name="idClinic" required>

                    <input type="text" value="${infoDoctor.fio}" id="fioDoctor" name="fio" required>

                    <input type="text" value="${infoDoctor.profession}" id="professionDoctor" name="profession" required>

                    <input type="text" value="${infoDoctor.description}" id="descriptionDoctor" name="description" required>

                    <button id="btnAdminFunction" type="submit" class="btn btn-primary">Редоктировать</button>

                </form>

            </div>

        </c:if>

        <c:if test="${(requestScope.functionInformation eq 'idUpdateFooter')}">

            <div id="formFunction">

                <form action="urlToServlet" method="post">

                    <input type="hidden" name="command" value="go_to_admin_profile"/>

                    <input type="hidden" name="function" value="updateFooter"/>

                    <input type="text" placeholder="Id Footer" id="idFooter" name="id" required>

                    <button id="btnAdminFunction" type="submit" class="btn btn-primary">Вывод для редоктирования</button>

                </form>

            </div>

        </c:if>

        <c:if test="${(requestScope.functionInformation eq 'updateFooter')}">

            <div id="formFunction">

                <c:set var="infoFooter" value="${requestScope.infoObject}" />

                <form action="urlToServlet" method="post">

                    <input type="hidden" name="command" value="update_footer"/>

                    <input type="hidden" value="${infoFooter.id}" id="idFooter" name="id" required>

                    <input type="text" value="${infoFooter.img}" id="imgFooter" name="img" required>

                    <input type="text" value="${infoFooter.link}" id="linkFooter" name="link" required>

                    <button id="btnAdminFunction" type="submit" class="btn btn-primary">Редоктировать</button>

                </form>

            </div>

        </c:if>

        <c:if test="${(requestScope.functionInformation eq 'idUpdateUser')}">

            <div id="formFunction">

                <form action="urlToServlet" method="post">

                    <input type="hidden" name="command" value="go_to_admin_profile"/>

                    <input type="hidden" name="function" value="updateUser"/>

                    <input type="text" placeholder="Id User" id="idUser" name="id" required>

                    <button id="btnAdminFunction" type="submit" class="btn btn-primary">Вывод для редоктирования</button>

                </form>

            </div>

        </c:if>

        <c:if test="${(requestScope.functionInformation eq 'updateUser')}">

            <div id="formFunction">

                <c:set var="infoUser" value="${requestScope.infoObject}" />

                <form action="urlToServlet" method="post">

                    <input type="hidden" name="command" value="update_user"/>

                    <input type="hidden" value="${infoUser.id}" id="idUser" name="id" required>

                    <input type="text" value="${infoUser.name}" id="nameUser" name="name" required>

                    <input type="text" value="${infoUser.role}" id="roleUser" name="role" required>

                    <button id="btnAdminFunction" type="submit" class="btn btn-primary">Редоктировать</button>

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