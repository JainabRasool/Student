<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP - Hello World Tutorial - Programmer Gate</title>
</head>
<body>

<b> Emp Details are: </b></br> </br>

${emo.geteId()}

<table>
            <thead>
                <tr>
                    <th>EmplId</th>
                    <th>EmpName</th>
                 
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${emo}" var="empl">
                    <tr>
                        <td>${empl.eId}</td>
                        <td>${empl.eName}</td>
                     
                    </tr>
                </c:forEach>
            </tbody>
        </table>


</body>
</html>