<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.tictactoe.Field, com.tictactoe.Sign" %>

<!DOCTYPE html>
<html>
<head>
    <title>Tic-Tac-Toe</title>
    <link href="static/main.css" rel="stylesheet">
</head>
<body>
<h1>Tic-Tac-Toe</h1>

<table>
    <tr>
        <td onclick="window.location='/logic?click=0'"><%=((Field)request.getSession().getAttribute("field")).getField().get(0)%></td>
        <td onclick="window.location='/logic?click=1'"><%=((Field)request.getSession().getAttribute("field")).getField().get(1)%></td>
        <td onclick="window.location='/logic?click=2'"><%=((Field)request.getSession().getAttribute("field")).getField().get(2)%></td>
    </tr>
    <tr>
        <td onclick="window.location='/logic?click=3'"><%=((Field)request.getSession().getAttribute("field")).getField().get(3)%></td>
        <td onclick="window.location='/logic?click=4'"><%=((Field)request.getSession().getAttribute("field")).getField().get(4)%></td>
        <td onclick="window.location='/logic?click=5'"><%=((Field)request.getSession().getAttribute("field")).getField().get(5)%></td>
    </tr>
    <tr>
        <td onclick="window.location='/logic?click=6'"><%=((Field)request.getSession().getAttribute("field")).getField().get(6)%></td>
        <td onclick="window.location='/logic?click=7'"><%=((Field)request.getSession().getAttribute("field")).getField().get(7)%></td>
        <td onclick="window.location='/logic?click=8'"><%=((Field)request.getSession().getAttribute("field")).getField().get(8)%></td>
    </tr>
</table>

<%
    if (((Field)request.getSession().getAttribute("field")).getWinner() == Sign.CROSS){ %>
        <p>ThE WInNer is CROSS</p>
<%
    }
    else if (((Field)request.getSession().getAttribute("field")).getWinner() == Sign.NOUGHT){ %>
        <p> The Winner is NOUGHT </p>
<%
    }
%>








<script>

</script>

</body>
</html>