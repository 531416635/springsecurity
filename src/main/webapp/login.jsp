<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录测试</title>
</head>
<body>
<h2>login Page</h2>
<a href="index.jsp">index</a>
<form action="${pageContext.request.contextPath}/mylogin.html" method="post">
  <fieldset>
    <legend>登陆</legend>
    <security:csrfInput/>
    
    用户： <input type="text" name="username" style="width:150px;" value="${sessionScope['SPRING_SECURITY_LAST_USERNAME']}"/><br />
    密码： <input type="password" name="password" style="width:150px;" /><br />
    
    <input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit" value="登陆"/>
    <input type="reset" value="重置"/>
  </fieldset>
</form>
</body>
</html>