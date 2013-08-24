<html>
<head>
[#include "/commonHeader.ftl"]
</head>
<body>
[#include "/admin/navigationBar.ftl"]
Tags
<br/>
[#list tags as tag]
${tag.tagId}- tag name: <a href="/phoenix/admin/tag/${tag.name}"> ${tag.name}</a> - [#if tag.description?exists] ${tag.description}[/#if] <br/>	
[/#list]
</body>
</html>
