<html>
<body>
id:${tag.id}
desc:${tag.description}
<br/>
<#list tag.contentTagList as contentTag>
tag detail: ${contentTag.content.id} - ${contentTag.content.description}
<br/>
</#list>
</body>
</html>
