<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div>
    <h2>Create a free Spitter account</h2>

    <sf:form method="post" modelAttribute="spitter">
        <fieldset>
            <table cellspacing="0">
                <tr>
                    <th><label for="user_full_name">Full Name: </label></th>
                    <td><sf:input path="name" size="15" id="user_full_name"/></td>
                </tr>
                <tr>
                    <th><label for="user_screen_name">User Name: </label></th>
                    <td>
                        <sf:input path="username" size="15" maxlength="15" id="user_screen_name"/>
                        <small id="username_msg">No spaces, please</small>
                    </td>
                </tr>
                <tr>
                    <th><label for="user_password">Password: </label></th>
                    <td>
                        <sf:password path="password" size="30" showPassword="true" id="user_password"/>
                        <small id="password_msg">6 characters or more</small>
                    </td>
                </tr>
                <tr>
                    <th><label for="user_email">Email: </label></th>
                    <td>
                        <sf:input path="email" size="30" id="user_email"/>
                        <small id="email_msg">In case you forget something</small>
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
            </table>
        </fieldset>
    </sf:form>
</div>
