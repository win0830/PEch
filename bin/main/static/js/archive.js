var thParam;
var cateParam;
var threadPageParam;
var index;
const DISPLAY_NUM = 10;
var thData;

$(function(){

	$('#test').on('click', function(){
		console.log($('#category').val());
		console.log($('#category').html());
		return false;
	});
	
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
	
	$('#search').on('click',searchThreads);
	
	//スレッドの絞込み
	function searchThreads(){
		var cateVal = $('select:eq(0)').val() == 'null selected' ? null : $('select:eq(0)').val();
		var keyWord = $('#keyword').val() == '' ? null : $('#keyword').val();

		searchParam = {
	        url: "searchThreads",
	        dataType: "json",
	        type: "get",
	        contentType: "application/json",
	        data: {
	        	category : cateVal,
	        	searchWord : keyWord
	      	}
	  };

		$.ajax(searchParam)
		.done(function(data,status,jqXHR){
			thData=data;
			threadPageParam = 1;
			pageButtonUpdate();
			drawThreads();
			threadClick();
		 
		})
		.fail(function(jqXHR,status,errThrown){
		    console.error(jqXHR);
		});
	}
	
	//DB内データの受け取り(スレッド表)
	thParam = {
	        url: "/getThreads",
	        dataType: "json",
	        type: "get",
	        contentType: "application/json"
	    };

	$.ajax(thParam)
	.done(function(data,status,jqXHR){
		thData=data;
		threadPageParam = 1;
		pageButtonUpdate();
		drawThreads();
		threadClick();
	 
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
		
		
		//selectの値を取得
		$('select:eq(1)').change(function(){
			
			var n = $('select:eq(1)').val();
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
	
	//スレッド一覧表示
	function drawThreads(){
		drawNum = threadPageParam*DISPLAY_NUM;	//表示させるスレッド件数
		$("tbody").empty();
	    for(var i = drawNum-DISPLAY_NUM ; i < drawNum; i++){
	    	if(i >= thData.length) break;	//スレッド件数を超える場合、強制的に抜ける
	    	var table = '<tr class="threadId">'
	    		+ '<td><form action="/thread" method="get"><input type="text" name="threadId" style="display:none;" value="' + thData[i].threadId + '"></form>'
	    		+ thData[i].createdDate.date.year +'/'+ thData[i].createdDate.date.month +'/'+ thData[i].createdDate.date.day +' '+ thData[i].createdDate.time.hour +':'+ thData[i].createdDate.time.minute + ':'+ thData[i].createdDate.time.second 
	    		+ '</td><td>'
					+ thData[i].threadName + '</td><td>'
					+ thData[i].categories.categoryName + '</td><td><span class="badge badge-primary badge-pill">' + thData[i].resesCount  + '</span></td></tr>';
	    	$("tbody").append(table);
	    }
	}
	
	//ページ切り替え
	$('.page_change').each(function(i,v){
		$(v).click(function(){
			threadPageParam = Number( $(v).val() );
			window.location.href = '#';
			pageButtonUpdate();
			drawThreads();
			threadClick();
		});
	});
	
	function pageButtonUpdate(){
		$('#now_page').html( threadPageParam );
		$('#prev_page').val( threadPageParam-1 );
		$('#next_page').val( threadPageParam+1 );
		
		if(Number( $('#prev_page').val() )==0){
			$('#prev_page').prop("disabled", true);
		}else{
			$('#prev_page').prop("disabled", false);
		}
		
		$('#now_draw_num').html(DISPLAY_NUM*(threadPageParam-1)+1 );
		
		if(Number( $('#next_page').val() )-1 > (thData.length-1) / DISPLAY_NUM){
			$('#next_page').prop("disabled", true);
			$('#now_draw_num').html('( ' + $('#now_draw_num').html() + ' ～ ' + thData.length + ' )');
		}else{
			$('#next_page').prop("disabled", false);
			$('#now_draw_num').html('( ' + $('#now_draw_num').html() + ' ～ ' + threadPageParam*DISPLAY_NUM + ' )');
		}
	}
	
	function threadClick(){
		$('.threadId').on('click', function(){
				$(this).find('form').submit();
		});
	}
});


	