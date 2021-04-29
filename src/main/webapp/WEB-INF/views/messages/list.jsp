<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<div>
    <h2>Messages for ${spitter.username}</h2>
    <table cellspacing="15">
        <c:forEach items="${messages}" var="message">
            <tr>
                <td>
                    <img src="/resources/images/spitter_avatar.png" width="48" height="48"/>
                </td>
                <td>
                    <a href="/spitters/${message.userId}">${message.userId}</a>
                    <c:out value="${message.text}" /><br/>
                    <c:out value="${message.date}" />
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
