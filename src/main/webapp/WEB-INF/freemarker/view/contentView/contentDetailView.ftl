<div>
<script type="text/javascript">

	contentSelectedListener[contentSelectedListener.length] = function(trigger, contentCode){
		// prepare content detail	
		// Initialize Menu
		$.get('${projectCode}/content/'+contentCode, function(data){
			$('#contentDetail').html(data);
			$('#contentDetailView').css("display","inline");
			});
			
	};
	$('document').ready(function (){
		$("#contentDetail").appendTo($("#contentDetailView"));
	});
</script>
<div id="contentDetail"></div>
</div>