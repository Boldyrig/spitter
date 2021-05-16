<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<div>
    <h2>Profile for ${spitter.username} (${spitter.name})</h2>
    <button>
        <a href="/message?username=${spitter.username}">Send new message</a>
    </button>
    <a href="/">Go To Home Page</a>
</div>
