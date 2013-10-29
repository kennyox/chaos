<%@ page language="java" contentType="text/html; charset=UTF8" pageEncoding="UTF8"%>
<%@ include file="../common/header.jsp"%>
<form id="login">
	<div>
		<label >用戶名稱:</label> <input id="j_username"
			name="j_username" type="text" value="" />
	</div>
	<div>
		<label >密碼:</label> <input id="j_password"
			name="j_password" type="text" value="" />
	</div>
	<div>
                <label>Remember Me:</label>
                <input type="checkbox" name="_spring_security_remember_me" />
            </div>
	<button type="submit" >提交</button>

</form>

<script>
	$(function() {
		$("#login").submit(function(e) {
			e.preventDefault();
			var data = $('#login').serialize();	
			$.ajax({
				type: 'POST',
				url: "/admin/login/perform",
				/* contentType: 'json', */
				data: data,
				cache: false,
				success: function(result) {
					if (result.enabled) {
						$( "#dialog" ).dialog( "close" );
						location.href="/admin/postLogin";
					} else {
						$(".error").remove();
						$("#login").prepend("<div class='error'>Login Failed. Username or Password is incorrect.</div>");
					}
				}
			});	
		});
	});
</script>

<%@ include file="../common/footer.jsp"%>