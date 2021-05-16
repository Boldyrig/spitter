<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div>
    <h2>Java is a class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible</h2>
    <h3>Java was originally developed by James Gosling at Sun Microsystems</h3>
    <ol class="spittle-list">
        <c:forEach var="message" items="${messages}">
            <s:url value="/spitter/{spitterName}" var="spitter_url">
                <s:param name="spitterName" value="${message.userName}"/>
            </s:url>
            <li>
                <span class="spittleListImage">
                    <c:choose>
                        <c:when test="${message.imageUpload == true}">
                            <img src="/resources/${message.userName}.jpg" width="100px"/>
                        </c:when>
                        <c:otherwise>
                            <img src="/resources/images/spitter_avatar.png" width="48" height="48"/>
                        </c:otherwise>
                    </c:choose>
                </span>
                <span class="spitterListText">
                    <c:out value="${message.text}"/><br/>
                    <small>
                        <fmt:formatDate value="${message.date}" pattern="hh:mma MMM d. yyyy"/>
                    </small>
                </span>
            </li>
            <br/>
        </c:forEach>
    </ol>
</div>
