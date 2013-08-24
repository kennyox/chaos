<html>
<head>
[#include "/commonHeader.ftl"]
</head>
<body>
[#include "/admin/navigationBar.ftl"]
<br/>
user :${user.name}

project: ${user.project.code} - ${user.project.name}
<br/>
<a href="/phoenix/admin/tag">tag</a>
<br/>
<a href="/phoenix/admin/content">content</a>

</body>
</html>
