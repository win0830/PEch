var resesParam;
$(function(){
	$('#open_create_threads').on('click', function(){
		$('.create_threads, .create_threads_mask').show();
	});
	$('.create_threads_mask').on('click', function(){
		$('.create_threads, .create_threads_mask').hide();
	});

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
