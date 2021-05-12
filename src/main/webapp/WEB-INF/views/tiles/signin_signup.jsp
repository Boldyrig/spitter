<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

signin
<div class="wrap-login100">
    <sf:form action="/spitter/authentication" method="POST" modelAttribute="shortSpitter" enctype="application/x-www-form-urlencoded">
        <span class="login100-form-title p-b-26">Welcome</span>
        <div class="wrap-input100 validate-input" data-validate="Valid email is: a@b.c">
            <span class="focus-input100" data-placeholder="Username">Username</span>
            <sf:input path="username" size="15" id="username"/>
            <sf:errors path="username" cssClass="error"/>
        </div>
        <div class="wrap-input100 validate-input" data-validate="Enter password">
            <span class="focus-input100" data-placeholder="Password">Password</span>
            <sf:input path="password" size="15" id="password"/>
            <sf:errors path="password" cssClass="error"/>
        </div>
        <div class="container-login100-form-btn">
            <div class="wrap-login100-form-btn">
                <div class="login100-form-bgbtn"></div>
                <button class="login100-form-btn" type="submit">Login</button>
            </div>
        </div>

        <div class="text-center p-t-115">
            <span class="txt1">Don’t have an account?</span>
            <a class="txt2" href="/spitter?new">Sign Up</a>
        </div>
    </sf:form>
</div>
