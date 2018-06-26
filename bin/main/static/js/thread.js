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
	        contentType: "application/json",
	        data: {
	        	threadId : Number(location.search.substr(10))
	        }
	};

	$.ajax(resesParam)
	.done(function(data,status,jqXHR){
//	    console.log(data);
	  //テーブルに受け取った値を表示
	    for(var i = 0 ; i < data.length ; i++){
	    	console.log(data[i]);
	    	$('.reses_list').append(
	    		'<li class="list-group-item">' + (i+1) + '：' 
	    		+ (data[i].isOpenName == 0 ? data[i].users.userName : '名無し')
	    		+ '&nbsp;' + data[i].postTime.date.year + '/' + data[i].postTime.date.month + '/' + data[i].postTime.date.day + ' ' 
	    		+ data[i].postTime.time.hour + ':' + data[i].postTime.time.minute + ':' + data[i].postTime.time.second
	    		+ '<br>&nbsp;' + data[i].res + '</li>'
	    	);
	    }
	})
	.fail(function(jqXHR,status,errThrown){
	    console.error(jqXHR);
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
			
			var n = $('select').val();
			if(n=="null"){
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
		url: "/sendMessage",
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