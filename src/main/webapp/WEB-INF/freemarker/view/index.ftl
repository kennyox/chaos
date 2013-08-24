<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
[#include "../commonHeader.ftl"]
	<script>
	function openPage(url){
		$GET(url,function (data){
			$("#mainSection").html(data);
		});
	}
	$('document').ready(function(){
		$('#viewMainMenu li').click(function (event){
			var url = event.currentTarget.getAttribute('url')
			$.get(url,function (data){
			$('#mainSection').html("");
				$('#mainSection').append(data);
			});
		});
	});
	</script>
</head>
<body>
<header style="margin-left:50px;">		
	<ul id="viewMainMenu" class="viewMainMenu">
		<img style="float:left;" alt="" src="/phoenix/img/menu_left.png"/>
		<li url='/phoenix/${projectCode}/home'>home</li>
		<li url='/phoenix/${projectCode}/content'>content</li>		
		[#list tag.taggedTags as taggedTag]
		<li url='/url='/phoenix${projectCode}/content?selected=${taggedTag.name}'>${taggedTag.name}</li>		 
		[/#list]
		 <li class="searchContainer">
			<div>
			<input type="text" id="searchField" />
			<img src="/phoenix/img/magnifier.png" alt="Search" onclick="alert('You clicked on search button')" /></div>
		</li>		
	</ul>	
	<img style="float:left;" alt="" src="/phoenix/img/menu_right.png"/>
</header>
<section id="mainSection" style="position: absolute;top:50px"/>
</body>
</html>
