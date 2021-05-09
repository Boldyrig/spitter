<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet" type="text/css"/>

<div>
    <h2>Send a message</h2>

    <sf:form method="POST" modelAttribute="message" enctype="application/x-www-form-urlencoded">
        <fieldset>
            <table cellspacing="0">
                <tr>
                    <th><label for="text">Text: </label></th>
                    <td>
                        <sf:textarea path="text" size="50" id="text"/>
                        <sf:errors path="text" cssClass="error"/>
                    </td>
                </tr>
                <tr>
                    <th><label for="tag">Tag: </label></th>
                    <td>
                        <sf:input path="tag" size="15" id="tag"/>
                        <sf:errors path="tag" cssClass="error"/>
                    </td>
                </tr>
                <tr>
                    <th></th>
                    <td><input name="commit" type="submit" value="Send message"></td>
                </tr>
            </table>
        </fieldset>
    </sf:form>
</div>
