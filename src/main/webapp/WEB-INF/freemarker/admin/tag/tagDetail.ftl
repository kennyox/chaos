<html>
<head>
[#include "/commonHeader.ftl"]
</head>
<body>
[#include "/admin/navigationBar.ftl"]
Tags
<form action="/phoenix/admin/tag/${tag.name}/update" method="post">
tag name:  ${tag.name}
<br/>
Description: <input name="description" type="text" value="[#if tag.description?exists] ${tag.description}[/#if]"/>
<br/>
<input type="text" name="taggedByTags" value="[#list tag.taggedByTags as taggedByTag]${taggedByTag.name} [/#list]" />
<input type="submit" >update</input>
</form>	
</body>
</html>
