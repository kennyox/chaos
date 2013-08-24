<!DOCTYPE html>
<html>
<head>
[#include "/commonHeader.ftl"]
<script type="text/javascript" src="/phoenix/js/jquery-ui-1.9.1.custom.js"></script>
	<style>
	label {
		display: inline-block;
		width: 5em;
	}
	</style>
	<script type="text/javascript">
	var tagSelectedListener = new Array();
	var contentSelectedListener = new Array();
	var navigationListener = new Array();
	
	$(function() {
		$( document ).tooltip({
			track: true
		});
	});
	function retrievedTag(data){
		$("#mainPage").css("display","inline");
		stack
		$("#mainPage").html(data);
	}
	
	function tagSelected (trigger, tagName,historyReset){
		for( var i=0; i<tagSelectedListener.length;i++){
			tagSelectedListener[i](trigger,tagName,historyReset);
		}
	}
	
	function contentSelected (trigger, contentCode){
		for( var i=0; i<contentSelectedListener.length;i++){
			contentSelectedListener[i](trigger,contentCode);
		}
	}
	
	function addNavigation(trigger, tagName,historyReset){
		for( var i=0; i<navigationListener.length;i++){
			navigationListener[i](trigger, tagName,historyReset);
		}
	}
	
	$("document").ready(function(){
		tagSelected("index", "${tag.name}");
	});
	</script>
	
</head>
<body>

[#include "/view/contentView/tagNavigationBar.ftl"]
[#include "/view/contentView/tagDetailView.ftl"]
[#include "/view/contentView/contentDetailView.ftl"]
[#include "/view/contentView/contentListView.ftl"]
<section id="tagNavigationView" style="display:none"></section>
<section id="tagDetailView" style="display:none"></section>
<section id="contentListView" style="display:none"></section>
<section id="contentDetailView" style="display:none"></section>
</body>
</html>
