<script type="text/javascript">
	$("document").ready(function(){
		$( "content" ).button().click(function(event){
			contentSelected("topMenu",event.currentTarget.id);
		});
	});
</script>
<ul id="${tagName}-content">
[#list contentList as content]
[#if content_index > 0] [/#if]
<li><content id="${content.code}" rel="${content.code}" [#if content.desc?exists] title="${content.desc}"[/#if]>${content.name}</content></li>
[/#list]
</ul>
