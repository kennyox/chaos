<html>
<head>
[#include "/commonHeader.ftl"]
</head>
<body>
[#include "/admin/navigationBar.ftl"]
Content
<br/>
<form action="/phoenix/admin/content/create" method="post">
code:  <input name="code" type="text" value="[#if content?exists && content.code?exists]${content.code}[/#if]"/>
<br/>
name:<input name="name" type="text" value="[#if content?exists && content.name?exists]${content.name}[/#if]"/>
<br/>
Description: <input name="description" type="text" value="[#if content?exists && content.description?exists]${content.description}[/#if]"/>
<br/>
tag: <input type="text" name="taggedByTags" value="[#list content.taggedByTags as taggedByTag]${taggedByTag.name} [/#list]" />
<br/>
<input type="submit" >update</input>
</form>	
</body>
</html>
