<div>
<link rel="stylesheet" type="text/css" href="/phoenix/css/jGlideMenu.css" />
<script type="text/javascript" src="/phoenix/js/jQuery.jGlideMenu.069.js"></script>
<script type="text/javascript">
	
	tagSelectedListener[tagSelectedListener.length] = function(trigger, tagName,historyReset){
		// prepare content list	
		// Initialize Menu
		$.get('/phoenix/${projectCode}/tag/'+tagName+'/contentList', function(data){
			$('#contentList').html(data);
			$('#contentList').css("display","inline");
			});
	};
	$('document').ready(function (){
		$("#contentList").appendTo($("#contentListView"));
		$("#contentListView").css("display","inline");
	});
	
	
</script>
		

<section id="contentList" style="display:none"></section>

</div>