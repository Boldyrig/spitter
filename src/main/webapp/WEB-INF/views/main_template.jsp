<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spitter</title>
</head>
<body>
<table>
    <tr>
        <td colspan="2">
            <tiles:insertAttribute name="top" />
        </td>
    </tr>
    <tr>
        <td>
            <tiles:insertAttribute name="side" />
        </td>
        <td>
            <tiles:insertAttribute name="content" />
        </td>
    </tr>
</table>
</body>
</html>
