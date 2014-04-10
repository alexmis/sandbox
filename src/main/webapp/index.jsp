<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<div>
    <div>
        <h4>Index page:</h4>
    </div>
    <div>
        Context path: <%=request.getContextPath()%>
    </div>
    <div>
        Test jsp: <a href="<%=request.getContextPath()%>/test.jsp"><%=request.getContextPath()%>/test.jsp</a>
    </div>
</div>
</body>
</html>
