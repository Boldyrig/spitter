<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

signin
<div class="wrap-login100">
    <sf:form action="/spitter/authentication" method="POST" modelAttribute="shortSpitter" enctype="application/x-www-form-urlencoded">
        <span>Welcome</span>
        <div>
            <span data-placeholder="Username">Username</span>
            <sf:input path="username" size="15" id="username"/>
            <sf:errors path="username" cssClass="error"/>
        </div>
        <div>
            <span data-placeholder="Password">Password</span>
            <sf:input path="password" size="15" id="password"/>
            <sf:errors path="password" cssClass="error"/>
        </div>
        <div>
            <button type="submit">Login</button>
        </div>

        <div>
            <span>Don’t have an account?</span>
            <a href="/spitter?new">Sign Up</a>
        </div>
    </sf:form>
</div>
