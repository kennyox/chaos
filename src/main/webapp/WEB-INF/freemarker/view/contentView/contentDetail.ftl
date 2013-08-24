<script>
$("document").ready(function(){
		$( "tag" ).button().click(function(event){
			tagSelected("content",event.currentTarget.id);
		});
		$("topMenu").appendTo("TopMenuView");
	});
</script>
content code:  <span id="contentCode">${content.code}</span>
<br/>
name: <span id="contentName">${content.name}</span>
<br/>
Description: <span id="contentDesc">[#if content.description?exists]${content.description}[/#if]</span>
<br/>
tagged by: 
<div id="taggedBy">
[#list content.taggedByTags as taggedByTag]
<tag id="${taggedByTag.name}" [#if taggedByTag.desc?exists] title="${taggedByTag.desc}"[/#if]>${taggedByTag.name}</tag> 
[/#list]
</div>