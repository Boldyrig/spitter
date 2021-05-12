<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet" type="text/css"/>

<div>
    <h2>Messages for ${spitter.username}(${spitter.name})</h2>
    <table cellspacing="15">
        <c:forEach items="${messages}" var="message">
            <tr>
                <td>
                    <img src="/resources/images/spitter_avatar.png" width="48" height="48"/>
                </td>
                <td>
                    <a href="/spitter/${spitter.username}">${message.userId}</a>
                    <c:out value="${message.text}" /><br/>
                    <fmt:formatDate value="${message.date}" pattern="hh:mma MMM d. yyyy"/>
                </td>
            </tr>
        </c:forEach>
    </table>
    <sf:form method="POST" modelAttribute="message">
        <input type="hidden" name="userId" value="${spitter.id}">
        <input type="hidden" name="userName" value="${spitter.username}">
        <table class="message-container">
            <tr>
                <h3 class="message-container-title">Оставить сообщение</h3>
            </tr>
            <div class="message-container-form">
                <tr>
                    <div class="message-field">
                        <th>
                            <label for="text">Text: </label>
                        </th>
                        <td>
                            <sf:textarea path="text" cols="50" rows="5" id="message-text"/>
                        </td>
                    </div>
                </tr>
                <tr>
                    <div class="message-field">
                        <th>
                            <label for="tag">Tag: </label>
                        </th>
                        <td>
                            <sf:textarea path="tag" cols="5" rows="1" id="message-text"/>
                        </td>
                    </div>
                </tr>
                <tr>
                    <th>
                        <input name="commit" type="submit" value="Accept">
                    </th>
                </tr>
            </div>
        </table>
    </sf:form>
</div>
