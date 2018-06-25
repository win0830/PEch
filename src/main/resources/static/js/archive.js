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
			  title: 'Signed in successfully'
			})
	});*/
	
	
	//DB内データの受け取り
	var params = {
	        url: "/getThreads",
	        dataType: "json",
	        type: "get",
	        contentType: "application/json"
	    };

	$.ajax(params)
	.done(function(data,status,jqXHR){
	    console.log(data);
	})
	.fail(function(jqXHR,status,errThrown){
	    console.error("Error:" + status);
	});
	
	
	
	
	
	
	
});