<div>
<link rel="stylesheet" href="/phoenix/css/BreadCrumb.css" type="text/css">
<script src="/phoenix/js/jquery.easing.1.3.js" type="text/javascript" language="JavaScript"></script>
<script src="/phoenix/js/jquery.jBreadCrumb.1.1.js" type="text/javascript" language="JavaScript"></script>
<script>
	navigationListener[navigationListener.length] = function (trigger, tagName,historyReset){
			if(historyReset){
				$('#navigationItem .historyItem').remove();
			}
			var newHistory = $('#navigationItem .historyItem').length+1;
			
			var tempName = $($('#navigationItem .historyItem')[newHistory - 2]).text();
	 		$($('#navigationItem .historyItem')[newHistory - 2]).text('');
			$($('#navigationItem .historyItem')[newHistory - 2]).append('<a href="#">'+tempName+'</a>');
			$('#navigationItem').append('<span class="historyItem" id="'+ newHistory +'" >'+tagName+'</span>');
				
				
			$($('#navigationItem .historyItem')[newHistory - 2]).find('a').click(function(event) {
				//remove the right items
				jQuery.jGlideMenu.scrollToTile(parseInt(event.currentTarget.parentElement.id));
				$('#navigationItem .historyItem').each(function (index,data){
					if(index+1 > event.currentTarget.parentElement.id){
						data.remove();
						}
				});
				var tempName = $($('#navigationItem .historyItem')[$('#navigationItem .historyItem').length - 1]).find('a').text();
					 	$($('#navigationItem .historyItem')[$('#navigationItem .historyItem').length - 1]).remove('a');
					 	$($('#navigationItem .historyItem')[$('#navigationItem .historyItem').length - 1]).text(tempName);
				historyUpdate();				
			});
			historyUpdate();
			
		
	}
	$('document').ready(function (){
		$("#tagNavigation").appendTo($("#tagNavigationView"));
		$("#tagNavigationView").css("display","inline");
	});
	
	function historyUpdate(){
		jQuery("#tagNavigation").jBreadCrumb();
	}
</script>
<nav id="tagNavigation" class="breadCrumb module">
	<span class="history" id="navigationItem"></span>
</nav>
</div>