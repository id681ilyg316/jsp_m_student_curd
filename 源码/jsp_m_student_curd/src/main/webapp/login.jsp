
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎来到登陆界面</title>
    <link rel="stylesheet" href="css/RegisterNewUser.css">
</head>
<div id="container">
    <h1>学生信息管理系统登陆</h1>
    <hr/>
    <!--autocomplete="on"规定输入字段是否启用自动完成功能-->
    <form method="get" action="login" autocomplete="on">
        <label>账号:
            <input type="text" placeholder="请输入用户名" name="username" required/>
            <!--required要求在提交之前必须输入字段-->
        </label>
        <br/>
        <label>密码:
            <input type="password" placeholder="请输入密码" name="password" required/>
        </label>
        <br/>
        <input type="submit" value="确定" id="button01">

    </form>
</div>
</body>
</html>
