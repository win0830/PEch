var resesParam;
var sendMessageParam;
var cateParam;

$(function(){
	$('#open_create_threads').on('click', function(){
		$('.create_threads, .create_threads_mask').show();
	});
	$('.create_threads_mask').on('click', function(){
		$('.create_threads, .create_threads_mask').hide();
	});

	$('#send_message').on('click', send_message);
	$('.cal').datepicker();

	//DB内データの受け取り 
	resesParam = {
	        url: "/getReses",
	        dataType: "json",
	        type: "get",
	        contentType: "application/json"
	};

	$.ajax(resesParam)
	.done(function(data,status,jqXHR){
//	    console.log(data);
	  //テーブルに受け取った値を表示
	    for(var i = 0 ; i < data.length ; i++){
	    	console.log(data);
	    }
	})
	.fail(function(jqXHR,status,errThrown){
	    console.error("Error:" + status);
	});
	
	//DB内データの受け取り(カテゴリ表) 
	cateParams = {
	        url: "/getCategories",
	        dataType: "json",
	        type: "get",
	        contentType: "application/json"
	    };

	$.ajax(cateParams)
	.done(function(data,status,jqXHR){
//	    console.log(data);
	  //テーブルに受け取った値を表示
	    for(var i=0; i < data.length ; i++){
	    	if(i==0){
		    	$('select').append('<option value="' + data[i].categoryId + '" selected>' + data[i].categoryName + '</option>');
	    	}else{
		    	$('select').append('<option value="' + data[i].categoryId + '">' + data[i].categoryName + '</option>');

	    	}
	    }
	    $('select').append('<option value="null">＋追加</option>');
	    
	  //selectの値を取得
		$('select').change(function(){
			var n = $('option:selected').val();
			if(n == null){
				$('#add_category').show();
				
			}else{
				$('#add_category').hide();
			}
		});
	
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
//	    console.log(data);
	  //テーブルに受け取った値を表示
	    for(var i = 0 ; i < data.length ; i++){
	    	console.log(data);
	    }
	})
	.fail(function(jqXHR,status,errThrown){
	    console.error("Error:" + status);
	});
}