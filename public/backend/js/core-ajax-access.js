
var AjaxAccess = function(){

	var self = this;

	this.loadHTML = function(url, param, success, msg){
		var date = new Date();
		param["timezoneOffset"] = date.getTimezoneOffset();
		jQuery.ajax({
			url: url,
			type: 'GET',
			data: param,
			dataType: 'html',
			async : false
		})
		.done(function(html){

			// all items in main screen is disabled
//			$('#body').find('input, select, option, textarea, button').prop('disabled', true);
//			$('#body').find('a').attr('tabindex', -1);

			// only item in modal screen is enabled
//			$('.modal-dialog').find('input, select, option, textarea, button').prop('disabled', false);

			success(html);
		})
		.fail(function(data){
			ajaxerror(msg);
		});
	};

	this.loadHTMLNoDisabled = function(url, param, success, msg){

		jQuery.ajax({
			url: url,
			type: 'GET',
			data: param,
			dataType: 'html',
			async : false
		})
		.done(function(html){

			success(html);
		})
		.fail(function(data){
			ajaxerror(msg);
		});
	};

	this.loadingHTML = function(url, target, param, success, msg){
		var date = new Date();
		param["timezoneOffset"] = date.getTimezoneOffset();
		$(target).empty();
		//var loading = $('<i class="loader fa fa-spinner fa-2x" />').css('text-align','center');
		//var loading = $('<h2><span class="label label-default">Loading...</span></h2>').css('text-align','center');
		//$(target).append(loading);

		jQuery.ajax({
			url: url,
			type: 'GET',
			data: param,
			dataType: 'html',
			async : true
		})
		.done(function(html){
			$(target).empty();
			$(target).html(html);
			success();
		})
		.fail(function(data){
			ajaxerror(msg);
		});

	};

	this.loadingHTMLPOST = function(url, target, param, success, msg){
		var date = new Date();
		param["timezoneOffset"] = date.getTimezoneOffset();
		$(target).empty();
		//var loading = $('<i class="loader fa fa-spinner fa-2x" />').css('text-align','center');
		var loading = $('<h2><span class="label label-default">Loading...</span></h2>').css('text-align','center');
		$(target).append(loading);

		jQuery.ajax({
			url: url,
			type: 'POST',
			data: param,
			dataType: 'html',
			async : true
		})
		.done(function(html){
			$(target).empty();
			$(target).html(html);
			success();
		})
		.fail(function(data){
			ajaxerror(msg);
		});

	};


	this.getJSON = function(url, param, success, msg){

		jQuery.ajax({
			url: url,
			type: 'GET',
			data: param,
			dataType: 'json',
			async : false
		})
		.done(function(json){
			success(json);
		})
		.fail(function(data){
			ajaxerror(msg);
		});
	};

	this.update = function(url, target, param, success, msg){
		var date = new Date();
		param["timezoneOffset"] = date.getTimezoneOffset();
		var btn = null;
		var smt = null;
		if(target != null){
			btn = $(target).find('button');
			smt = $(target).find('input[type="submit"]');
		}

		if(confirm(msg.confirm) == true){

			// prohibit double submit
			loading(btn, true);
			loading(smt, true);

			jQuery.ajax({
				url: url,
				type: 'POST',
				data: param,
				dataType: 'json',
				async : false
			})
			.done(function(json){
			    $('.div_cls_form_msg:last').empty();
			    if(json['status'] == 'OK'){
			    	target.find('.div_cls_form_msg:last').hide();
			    	if(msg.success){
			    		alert(msg.success);
			    	}
			    	//$('#body').find('input, select, option, textarea, button').prop('disabled', false);
					//$('#body').find('a').removeAttr('tabindex');
			    	success(json);
			    	loading(btn, false);
					loading(smt, false);
			    }else{
			    	target.find('.div_cls_form_msg:last').html(json['messages']);
			    	target.find('.div_cls_form_msg:last').show();
			    	loading(btn, false);
					loading(smt, false);
			    }
			})
			.fail(function(data){
				ajaxerror(msg);
			});

		}else{
			if(target != null){
				btn.button('reset');
			}
		}
	};

	this.updateErrorNoComfirm = function(url, target, param, success, msg){
		var date = new Date();
		param["timezoneOffset"] = date.getTimezoneOffset();
			var btn = null;
			var smt = null;
			if(target != null){
				btn = $(target).find('button');
				smt = $(target).find('input[type="submit"]');
			}
			// prohibit double submit
			loading(btn, true);
			loading(smt, true);

			jQuery.ajax({
				url: url,
				type: 'POST',
				data: param,
				dataType: 'json',
				async : false
			})
			.done(function(json){
				$('.div_cls_form_msg').empty();
			    if(json['status'] == 'OK'){
			    	//if(msg.success){
			    		//alert(msg.success);
			    	//}
			    	success(json);
			    }else{
			    	//$('.div_cls_form_msg:last').html(json['messages']);
			    	//$('.div_cls_form_msg:last').show();
			    	//if(msg.success){
			    		//alert(msg.failure);
			    	//}

			    	success(json);

			    	//target.find('.div_cls_form_msg:last').html(json['messages']);
			    	//target.find('.div_cls_form_msg:last').show();
			    }
			    loading(btn, false);
				loading(smt, false);
			})
			.fail(function(data){
				ajaxerror(msg);
			});
		};

	this.updateNoComfirm = function(url, target, param, success, msg){
		var date = new Date();
		param["timezoneOffset"] = date.getTimezoneOffset();
			var btn = null;
			var smt = null;
			if(target != null){
				btn = $(target).find('button');
				smt = $(target).find('input[type="submit"]');
			}
			// prohibit double submit
			loading(btn, true);
			loading(smt, true);

			jQuery.ajax({
				url: url,
				type: 'POST',
				data: param,
				dataType: 'json',
				async : false
			})
			.done(function(json){
				$('.div_cls_form_msg').empty();
			    if(json['status'] == 'OK'){
			    	if(msg.success){
			    		alert(msg.success);
			    		/*
			    		$.pnotify({
					    	title: 'Success',
							text: msg.success,
							type: 'success'
						});
						*/
			    	}
			    	success(json);
			    }else{
			    	//$('.div_cls_form_msg:last').html(json['messages']);
			    	//$('.div_cls_form_msg:last').show();
			    	alert(msg.failure);
			    	target.find('.div_cls_form_msg:last').html(json['messages']);
			    	target.find('.div_cls_form_msg:last').show();
			    }
			    loading(btn, false);
				loading(smt, false);
			})
			.fail(function(data){
				ajaxerror(msg);
			});
		};

	this.confirm = function(url, param, success, msg){
		jQuery.ajax({
			url: url,
			type: 'POST',
			data: param,
			dataType: 'json',
			async : false
		})
		.done(function(json){
			$('.div_cls_form_msg').empty();
			if(json['status'] == 'OK'){
				success();
			}else{
				$('.div_cls_form_msg:last').html(json['messages']);
				$('.div_cls_form_msg:last').show();
			}
		})
		.fail(function(data){
			ajaxerror(msg);
		});
	};

	function ajaxerror(msg){
		$.ajax({
			error: function (xhr, textStatus, errorThrown) {
				switch(xhr.status){
				case 400:
				case 401:
					window.location.href = "/signin";
					break;
				default:
					window.location.reload();
				}

			}
		});
	}

	this.upload = function(url, target, param, success, msg, e){

		var btn = null;
		var smt = null;
		if(target != null){
			btn = $(target).find('button');
			smt = $(target).find('input[type="submit"]');
		}

		if(confirm(msg.confirm) == true){

			// prohibit double submit
			loading(btn, true);
			loading(smt, true);

			e.preventDefault();
			jQuery.ajax({
				url: url,
				type: 'POST',
				data: param,
				processData: false,
				contentType: false
			})
			.done(function(json){
			    $('.div_cls_form_msg').empty();
				if(json['status'] != 'OK'){
					//$('.div_cls_form_msg:last').html(json['messages']);
			    	//$('.div_cls_form_msg:last').show();

			    	target.find('.div_cls_form_msg:last').html(json['messages']);
			    	target.find('.div_cls_form_msg:last').show();

					loading(btn, false);
					loading(smt, false);
				}else{ // success
					if(msg.success){
						alert(msg.success);
					}
					loading(btn, false);
					loading(smt, false);
					$('.container').find('input, select, option, textarea, button').prop('disabled', false);
					$('.container').find('a').removeAttr('tabindex');
					success(json);
				}
			})
			.fail(function(data){
				ajaxerror(msg);
			});

		}else{
			if(target != null){
				btn.button('reset');
			}
			e.preventDefault();
		}
	};

	function loading(obj, flag){

		if(obj == null){
		}else{
			if(flag == true){
				$(obj).button('loading');
			}else{
				$(obj).button('reset');
			}
		}
	}
};