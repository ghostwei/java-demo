<%--
  Created by IntelliJ IDEA.
  User: wei
  Date: 2022/9/20
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<form action="form" method="post">
	<div>
		用户名: <input type="text" name="username">
	</div>
	<div>
		密 0 码: <input type="password" name="password">
	</div>
	<div><button type="submit" name="submit" value="submit">提交</button></div>
</form>
<hr>
<pre>用户名：${username}
密码：${password}
${params}
</pre>
</body>
</html>
