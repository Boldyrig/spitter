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
        <c:forEach var="spitter" items="${spitters}">
            <s:url value="/spitters/{spitterName}" var="spitter_url">
                <s:param name="spitterName" value="${spitter.name}"/>
            </s:url>

            <li>
                <span class="spittleListImage">
                    <img src="<s:url value="/resources/images//spitter_avatar.png"/>"
                         width="48"
                         border="0"
                         align="middle"/>
                </span>
                <span class="spitterListText">
                    <a href="${spitter_url}">
                        <c:out value="${spitter.name}"/>
                        <span> : </span>
                        <c:out value="${spitter.id}"/>
                    </a>
                    <c:out value="${spitter.message}"/><br/>
                    <small>
                        <fmt:formatDate value="${spitter.date}" pattern="hh:mma MMM d. yyyy"/>
                    </small>
                </span>
            </li>
            <br/>
        </c:forEach>
    </ol>
</div>
