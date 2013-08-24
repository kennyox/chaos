<html>
<head>
[#include "/commonHeader.ftl"]
</head>
<body>
[#if Session.SPRING_SECURITY_LAST_EXCEPTION?? && Session.SPRING_SECURITY_LAST_EXCEPTION.message?has_content]
    <@spring.message "login.bad.credentials"/>
[/#if]
<form action="../j_spring_security_check" method="post">
    <label for="j_username">Username</label><input type="text" id="j_username" name="j_username"><br/>
    <label for="j_password">Password</label><input type="text" id="j_password" name="j_password"><br/>
   <input type="submit" value="Login!">
</form>
</body>
</html>
