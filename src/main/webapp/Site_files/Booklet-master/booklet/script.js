$(document).ready(function(){
	$('#edit').click(function(){
		$('div').attr('contenteditable', 'true');
	});
	$('#save').click(function(){
		$('div').attr('contenteditable', 'false');
	});
});