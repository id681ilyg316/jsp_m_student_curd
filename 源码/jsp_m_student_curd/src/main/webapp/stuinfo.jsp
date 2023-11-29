<%@page import="java.util.List" %>
<%@ page import="com.deng.pojo.PageBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%
    PageBean pageBean = (PageBean) session.getAttribute("pageBean");
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>学生信息管理系统</title>
    <link rel="stylesheet" href="css/BusinessForm.css">
</head>
<body>
<H2>学生信息列表</H2>

<form action="stuRead" method="get">

    <input type="text" placeholder="请输入用户名" name="selectname">

    <input type="submit" value="搜索">

    <a href="stuinsert.jsp">新增</a>

</form>


<table border="1" width="100%" id="recruit">
    <tr align="center">
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>住址</th>
        <th>操作</th>
    </tr>

    <c:forEach items="${list}" var="stu">
        <tr align="center">
            <td>${stu.id }</td>
            <td>${stu.name }</td>
            <td>${stu.age }</td>
            <td>${stu.gender }</td>
            <td>${stu.addr }</td>
            <td><a href="stuUpdate?id=${stu.id}">更新</a> <a href="stuDelete?id=${stu.id}">删除</a></td>
        </tr>
    </c:forEach>

    <tr>
        <td colspan="8">
            第 ${pageBean.currentPage }/${pageBean.totalPage }页
            &nbsp;&nbsp;
            每页显示:<%= pageBean.getPageSize()%>条
            &nbsp;&nbsp;
            总的记录数:<%= pageBean.getTotalSize()%>
            <c:if test="${pageBean.currentPage != 1}">
                  <a href="PageStu?currentPage=1">首页</a>
                | <a href="PageStu?currentPage=${pageBean.currentPage-1 }">上一页</a>
                </c:if>

            <c:forEach begin="1" end="${pageBean.totalPage }" var="i">
                <c:if test="${pageBean.currentPage == i }">
                    ${i }
                </c:if>
                <c:if test="${pageBean.currentPage != i }">
                    <a href="PageStu?currentPage=${i }">${i }</a>
                </c:if>

            </c:forEach>

                <c:if test="${pageBean.currentPage !=pageBean.totalPage }">
                <a href="PageStu?currentPage=${pageBean.currentPage+1 }">下一页</a> |
                <a href="PageStu?currentPage=${pageBean.totalPage }">尾页</a>
                </c:if>
        </td>
    </tr>
</table>
</body>
</html>