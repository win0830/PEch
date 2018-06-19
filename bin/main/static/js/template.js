/**
 * 
 */
var params = {
	url: '',
	data: null,
	dataType: 'JSON',
	method: 'GET',
	contentType: 'application/json'
};

function send(){
	$.ajax(params)
	.done(function(data, status, jqXHR){
		
	})
	.fail(function(jqXHR, status, errThrown){
		console.error(jqXHR);
	});
}