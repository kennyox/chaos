<html>
<head>
[#include "/commonHeader.ftl"]
</head>
<body>
[#include "/admin/navigationBar.ftl"]
Contents
<form action="/phoenix/admin/content/${content.code}/update" method="post">
content code:  ${content.code}
<br/>
name:${content.name}
<br/>
Description: <input name="description" type="text" value="[#if content.description?exists]${content.description}[/#if]"/>
<br/>
tag: <input type="text" name="taggedByTags" value="[#list content.taggedByTags as taggedByTag]${taggedByTag.name} [/#list]" />
<br/>
<input type="submit" >update</input>
</form>	
</body>
</html>
