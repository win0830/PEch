var params;

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
	
	//ログアウト
	/*$('#logout').on('click',function(){
		const toast = swal.mixin({
			  toast: true,
			  position: 'top-end',
			  showConfirmButton: false,
			  timer: 3000
			});

			toast({
			  type: 'success',
			  title: 'ログアウト成功しました。'
			})
	});*/
	
	/* 
	* main
	*/
	
	//DB内データの受け取り
	params = {
	        url: "/getThreads",
	        dataType: "json",
	        type: "get",
	        contentType: "application/json"
	    };

	$.ajax(params)
	.done(function(data,status,jqXHR){
	    console.log(data);
	  //テーブルに受け取った値を表示
	    for(var i = 0 ; i < data.length ; i++){
	    	$("tbody").append('<tr><td>' + data[i].createdDate.date.year +'/'+ data[i].createdDate.date.month +'/'+ data[i].createdDate.date.day +' '+ data[i].createdDate.time.hour +':'+ data[i].createdDate.time.minute + ':'+ data[i].createdDate.time.second + '</td><td>'
					+ data[i].threadName + '</td><td>'
					+ data[i].categories.categoryName + '</td><td>'
					+ data[i].users.userName + '</td><td><span class="badge badge-primary badge-pill">' + data[i].resesCount  + '</span></td></tr>');
	    }
	    
	    
	    
	})
	.fail(function(jqXHR,status,errThrown){
	    console.error("Error:" + status);
	});
	
	
	//カテゴリ選択
//	cateParams = {
//	        url: "/getcatego",
//	        dataType: "json",
//	        type: "get",
//	        contentType: "application/json"
//	    };
//
//	$.ajax(params)
//	.done(function(data,status,jqXHR){
//	    console.log(data);
	
	$('select').append('<option value="null">選択しない</option>');
	
	for(var i=0; i<categories.size; i++){
		$('select').append('<option value="'+ categories[i].categoryId +'">'
				+ categories[i].categoryname  + '</option>');
	}
	
	$('select').append('<option value="0">全て</option>');

	
	
	
	
	
	
	
	
	
});