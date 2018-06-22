$(function(){
	
	/* 
	* header
	*/
	
	//スレッド新規作成
	$('#open_create_threads').on('click', function(){
		$('.create_threads, .create_threads_mask').show();
	});
	$('.create_threads_mask').on('click', function(){
		$('.create_threads, .create_threads_mask').hide();
	});
	
	var params = {
	        url: "/getThreads",
	        dataType: "json",
	        type: "get"
	    };

	$.ajax(params)
	.done(function(data,status,jqXHR){
	    console.log(data);
	})
	.fail(function(jqXHR,status,errThrown){
	    console.error("Error:" + status);
	});
	
	
	
	
	
	
	
});