var resesParam;
var sendMessageParam;
$(function(){
	$('#open_create_threads').on('click', function(){
		$('.create_threads, .create_threads_mask').show();
	});
	$('.create_threads_mask').on('click', function(){
		$('.create_threads, .create_threads_mask').hide();
	});

	$('#send_message').on('click', send_message);

	//DB内データの受け取り
	resesParam = {
	        url: "/getReses",
	        dataType: "json",
	        type: "get",
	        contentType: "application/json"
	};

	$.ajax(resesParam)
	.done(function(data,status,jqXHR){
	    console.log(data);
	  //テーブルに受け取った値を表示
	    for(var i = 0 ; i < data.length ; i++){
	    	console.log(data);
	    }
	})
	.fail(function(jqXHR,status,errThrown){
	    console.error("Error:" + status);
	});


});

function send_message(){
	sendMessageParam = {
		url: "/getReses",
	  dataType: "json",
	  type: "get",
	  contentType: "application/json",
	  data: {
	  	isOpenName : $('.form-check-input').prop('checked'),
	  	res : $('#msg').val(),
	  	//threadId : $('#thread_id').val()
	  }
	}

	$.ajax(sendMessageParam)
	.done(function(data,status,jqXHR){
	    console.log(data);
	  //テーブルに受け取った値を表示
	    for(var i = 0 ; i < data.length ; i++){
	    	console.log(data);
	    }
	})
	.fail(function(jqXHR,status,errThrown){
	    console.error("Error:" + status);
	});
}