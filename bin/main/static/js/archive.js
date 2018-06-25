var thParam;
var cateParam;
var index;

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
	
	//DB内データの受け取り(スレッド表)
	thParam = {
	        url: "/getThreads",
	        dataType: "json",
	        type: "get",
	        contentType: "application/json"
	    };

	$.ajax(thParam)
	.done(function(data,status,jqXHR){
//	    console.log(data);
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

	//カテゴリ選択表示
	cateParam = {
	        url: "/getCategories",
	        dataType: "json",
	        type: "get",
	        contentType: "application/json"
	};

	$.ajax(cateParam)
	.done(function(data,status,jqXHR){
//	    console.log(data);
		$('select:eq(0)').append('<option value="null selected">全て</option>');	//検索
		
		for(var i=0; i < data.length; i++){
			if(i==0){
				//検索の場合はselectedなし
				$('select:eq(0)').append('<option value="'+ data[i].categoryId +'">'
						+ data[i].categoryName  + '</option>');
				
				//追加の場合はJavaにselected
				$('select:eq(1)').append('<option value="'+ data[i].categoryId +'" selected>'
						+ data[i].categoryName  + '</option>');
				
			}else{
			$('select').append('<option value="'+ data[i].categoryId +'">'
					+ data[i].categoryName  + '</option>');
			}
		}
		$('select:eq(1)').append('<option value="null">＋追加</option>');	//追加
		
	})
	.fail(function(jqXHR,status,errThrown){
	    console.error("Error:" + status);
	});
	
	

});