<div>
<link rel="stylesheet" type="text/css" href="/phoenix/css/jGlideMenu.css" />
<script type="text/javascript" src="/phoenix/js/jQuery.jGlideMenu.069.js"></script>
<script type="text/javascript">
	var init =false;
	var tagHistory = new Array();
	tagSelectedListener[tagSelectedListener.length] = function(trigger, tagName, historyReset){
		// prepare tag list
		if(	trigger != "tagDetail" && trigger != "tagNavigationBar"){
			// Initialize Menu
			if(!init){
				$('#subTagList').jGlideMenu({
					tileSource      : '/phoenix/${projectCode}/tag/',
					useTileURL	: true,
					useDragDrop : false,
					initialTile: tagName,
					slideRight		:	false,
					slideUp		:	true,
					width	: 600,
					height	: 100,
					tileWidth : 600,
					tileHeight : 100,
					URLSuffix : '/subTagList',
					type :'-tag',				
					loadImageStyle	 	:	{ 'position' : 'absolute', 'top' : '50px', 'left' : '300px' , 'z-index' : '99' },
					afterLoad : function( tagName){ 
						tagSelected("tagDetail",tagName);
						$( ".tag" ).button();
						addNavigation(trigger, tagName,historyReset);
					}
				}).show();
				
				$("#tagDetailView").css("display","inline");
				init=true;
			}else{
				if(tagName.substr(0,1)=='#')
					var dest = tagName.substr(1,target.length-1);
				else
					var dest =tagName;
				jQuery.jGlideMenu.loadTile(dest,jQuery.jGlideMenu.URLParams);
			}			
		}
	};
	
	
	$('document').ready(function (){
		$("#tagDetail").appendTo($("#tagDetailView"));
	});
	
	
</script>
<section id="subTagList" class="jGM_box" style="height:100px;width:640px"></section>	
<section id="tagDetail">
	<br />
	<br />
</section>
</div>