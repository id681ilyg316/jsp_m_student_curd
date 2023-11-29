<%@ page import="com.deng.pojo.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    Student student=(Student) session.getAttribute("student");

%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="stuUpdate02" method="get">
    编号:<input type="text" name="id" value="<%= student.getId() %>"/><br/>
    姓名:<input type="text" name="name" value="<%= student.getName() %>"/><br/>
    年龄:<input type="text" name="age" value="<%= student.getAge() %>"/><br/>
    地址:<input type="text" name="addr" value="<%= student.getAddr() %>"/><br/>
    性别:<input type="text" name="gender" value="<%= student.getGender() %>"/><br/>
    <input type="submit" value="确定">
</form>

</body>
</html>
