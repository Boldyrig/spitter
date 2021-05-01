<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet" type="text/css"/>

<div>
    <h2>Create a free Spitter account</h2>

    <sf:form method="POST" modelAttribute="spitter" enctype="multipart/form-data">
        <fieldset>
            <table cellspacing="0">
                <tr>
                    <th><label for="user_full_name">Full Name: </label></th>
                    <td>
                        <sf:input path="name" size="15" id="user_full_name"/>
                        <sf:errors path="name" cssClass="error"/>
                    </td>
                </tr>
                <tr>
                    <th><label for="user_screen_name">User Name: </label></th>
                    <td>
                        <sf:input path="username" size="15" maxlength="15" id="user_screen_name"/>
                        <small id="username_msg">No spaces, please</small>
                        <sf:errors path="username" cssClass="error"/>
                    </td>
                </tr>
                <tr>
                    <th><label for="user_password">Password: </label></th>
                    <td>
                        <sf:password path="password" size="30" showPassword="true" id="user_password"/>
                        <small id="password_msg">6 characters or more</small>
                        <sf:errors path="password" cssClass="error"/>
                    </td>
                </tr>
                <tr>
                    <th><label for="user_email">Email: </label></th>
                    <td>
                        <sf:input path="email" size="30" id="user_email"/>
                        <small id="email_msg">In case you forget something</small>
                        <sf:errors path="email" cssClass="error"/>
                    </td>
                </tr>
                <tr>
                    <th></th>
                    <td>
                        <sf:checkbox path="updateByEmail" id="user_send_email"/>
                        <label for="user_send_email">Send email updates </label>
                    </td>
                </tr>
                <tr>
                    <th></th>
                    <td><input name="commit" type="submit" value="Accept"></td>
                </tr>
                <tr>
                    <th>
                        <label for="image">Profile image: </label>
                    </th>
                    <td>
                        <input name="image" id="image" type="file"/>
                        <sf:errors cssClass="error"/>
                    </td>
                </tr>
            </table>
        </fieldset>
    </sf:form>
</div>
