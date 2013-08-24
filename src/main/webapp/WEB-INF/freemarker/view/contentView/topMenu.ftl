<link rel="stylesheet" type="text/css" href="/phoenix/css/jGlideMenu.css" />
<script type="text/javascript" src="/phoenix/js/jQuery.jGlideMenu.069.js"></script>
<script type="text/javascript">
	$("document").ready(function(){
		$( "tagButton" ).button().click(function(event){
			tagSelected("topMenu",event.currentTarget.id);
		});
		$("topMenu").appendTo("TopMenuView");
	});
</script>		
<section id="topMenu">
<menu type="context">
[#list tag.taggedTags as taggedTag]
<li>
<tagButton id="${taggedTag.name}" [#if taggedTag.desc?exists] title="${taggedTag.desc}"[/#if] >${taggedTag.name}</tagButton>
</li> 
[/#list]
</menu>	
</section>