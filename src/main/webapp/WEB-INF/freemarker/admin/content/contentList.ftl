<html>
<head>
[#include "/commonHeader.ftl"]
</head>
<body>
[#include "/admin/navigationBar.ftl"]
Content <a href="/phoenix/admin/content/createPage">+</a>
<br/>
[#list contents as content]
<a href="/phoenix/admin/content/${content.code}">${content.code}</a> - ${content.name}</br>

[/#list]
</body>
</html>
