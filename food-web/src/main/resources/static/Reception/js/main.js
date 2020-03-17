function close_tip(){
	$('#windown-close').click();
}
function show_info(){
		$('#dr_getmission_box1').fadeIn();
	}
$(function(){

	$("#exitaddrbox1").click(function(){
		$("#dr_getmission_box1").fadeOut();
	});
	var pass=1;
	$("#submitaddrbox1").click(function(){
		if(pass!=1){
			return false;
		}
		pass=0;//
		var prom = 1;
		$.each($(".addrinputw1 input"),function(){
			if($(this).val() == "" || $(this).val() == " " || $(this).val() == "undefined"){
				prom = 0;
			}
		});


		if(prom == 1){

			var real_name = $("#addr_info11").val();
			var mobile = $("#addr_info22").val();
			var qq = $("#addr_info33").val();
			var weixin = $("#addr_info44").val();
			var address = $("#addr_info55").val();

			var id= 151;

				$.post("/ajax/join_task.php",{id:id,act:'join_task',real_name:real_name,mobile:mobile,qq:qq,weixin:weixin,address:address},function(data){

					if(data.code== 1){
						$("#dr_getmission_box1").fadeOut();
						location.href="http://i.meishi.cc/daren_task/dr_postwz.php?id=151";

					}else{
						alert(data.msg);
					}

					pass=1;
				},'json');
		}else{
			alert("璇锋纭～鍐欐墍鏈夎仈绯绘柟寮弤");
			pass=1;
		}
	});


});

function guidGenerator() { 
	var S4 = function() { 
		return (((1+Math.random())*0x10000)|0).toString(16).substring(1); 
	}; 
	return (S4()+S4()+"-"+S4()+"-"+S4()+"-"+S4()+"-"+S4()+S4()+S4()); 
}
function loginreg(is_login){
	Alert("鐧诲綍缇庨鏉�", "iframe:/ajax/login.php?t=" + is_login + '&redirect=' + encodeURIComponent(location.href), "700", "300", "false", "", "true", "img");
}
var is_req_login_jifen = 0;
var is_req_sign_in = 0;
function sign_in(t){
	if(is_req_sign_in == 0){
		is_req_sign_in = 1;
		$.post("/ajax/sign_in.php", {},function(data){
			is_req_sign_in = 0;
			$.post("/ajax/login_jifen.php", {},function(data){$('.qdbox').html(data);});
		});
	}
}
function jifenpage_sign_in(t){
	$.post("/ajax/sign_in.php",{},function(data,status){
		if(data.add_jifen>0){
			$('.qdbtn').html('浠婃棩宸茬鍒�,娆㈣繋鍏変复!');
			msjLittletips("浠婃棩绛惧埌,绉垎+"+data.add_jifen);
			$("#jifen_num").html(data.jifen);
		}
    },'json');
}
function ztlistMoveleft(){
	$("#ztlist_style1_item_ww").animate({"margin-left":"0px"},600,function(){
		$("#ztlist_style1_item_ww .ztlist_style1_item_w1").last().prependTo($("#ztlist_style1_item_ww"));
		$("#ztlist_style1_item_ww").css("margin-left","-988px");
		$("#index_cd_leftarrow_mask").hide();
		index_cd_cur = index_cd_cur - 1;
		if(index_cd_cur == -1){
			index_cd_cur = 2;
		}
		setztlistCur();
	});
}
function ztlistMoveright(){
	$("#ztlist_style1_item_ww").animate({"margin-left":"-1976px"},600,function(){
		$("#ztlist_style1_item_ww .ztlist_style1_item_w1").first().appendTo($("#ztlist_style1_item_ww"));
		$("#ztlist_style1_item_ww").css("margin-left","-988px");
		$("#index_cd_rightarrow_mask").hide();
		index_cd_cur = index_cd_cur + 1;
		if(index_cd_cur == 3){
			index_cd_cur = 0;
		}
		setztlistCur();
	});
	
}
function setztlistCur(){
	$("#ztlist_cur span").removeClass("current");
	$("#ztlist_cur span").eq(parseInt(index_cd_cur)).addClass("current");
}

var index_cd_move = "";
var index_cd_cur = 1;

$(function(){


if($('#ztlist_style1_item_w').length > 0){
	index_cd_move = setInterval(function(){ztlistMoveright();},5000);
	$("#index_cd_leftarrow").click(function(){
		$("#index_cd_leftarrow_mask").show();
		ztlistMoveleft();
	});
	$("#index_cd_rightarrow").click(function(){
		$("#index_cd_rightarrow_mask").show();
		ztlistMoveright();
	});
	$("#index_cd_leftarrow").mouseenter(function(){
		clearInterval(index_cd_move);
	});
	$("#index_cd_leftarrow").mouseleave(function(){
		index_cd_move = setInterval(function(){ztlistMoveright();},5000);
	});
	$("#index_cd_rightarrow").mouseenter(function(){
		clearInterval(index_cd_move);
	});
	$("#index_cd_rightarrow").mouseleave(function(){
		index_cd_move = setInterval(function(){ztlistMoveright();},5000);
	});
	$("#ztlist_style1_item_w").mouseenter(function(){
		clearInterval(index_cd_move);
	});
	$("#ztlist_style1_item_w").mouseleave(function(){
		index_cd_move = setInterval(function(){ztlistMoveright();},5000);
	});
}
$("#userinfo_w").hover(function(){
	$(this).addClass("userinfo_w_hover");
},function(){
	$(this).removeClass("userinfo_w_hover");
});
$("#qd_inindex").hover(function(){
	$(this).addClass("qd_hover");
	if(is_req_login_jifen == 0){
		$('.qdbox').html("<p style=\"text-align:center;padding:30px 0;\">鍔犺浇涓�...</p>");
		is_req_login_jifen = 1;
		$.post("/ajax/login_jifen.php", {},function(data){$('.qdbox').html(data);});
	}
},function(){
	$(this).removeClass("qd_hover");
});
$("#main_nav li").hover(function(){
	$(this).siblings().removeClass("on");
	$(this).addClass("on");
},function(){
	$(this).removeClass("on");
});
$("#erweima_t").hover(function(){
	$(this).addClass("erweima_t_hover");
	$("#ewmbox").show();
},function(){
	$(this).removeClass("erweima_t_hover");
	$("#ewmbox").hide();
});
$("#ewmbox").hover(function(){
	$(this).show();
	$("#erweima_t").addClass("erweima_t_hover");
},function(){
	$(this).hide();
	$("#erweima_t").removeClass("erweima_t_hover");
});
$("#msjtop_loginbtn").bind("click",function(){
	loginreg(1);
});
$("#msjtop_registerbtn").bind("click",function(){
	loginreg(0);
});
$("#ztlist_style1_index li").hover(function(){
	$(this).siblings().removeClass("current");
	$(this).addClass("current");
},function(){});
$("#index_forum_right_list li").hover(function(){
	$(this).find("span").stop().slideDown();
},function(){
	$(this).find("span").stop().slideUp();
});
$(".index_sc_dd").hover(function(){
	$(this).siblings().removeClass("index_sc_dd_current");
	$(this).addClass("index_sc_dd_current");
},function(){});
$("#sccon_right").mouseenter(function(){
	$(this).find(".scc_masker").fadeOut();
	$(this).prev().find(".scc_masker").fadeIn();
	$(this).stop().animate({width:"718px"},600,function(){});
});
$("#sccon_left").mouseenter(function(){
	$(this).next().stop().animate({width:"232px"},600,function(){});
	$(this).next().find(".scc_masker").fadeIn();
	$(this).find(".scc_masker").fadeOut();
});
$(".index_healthitem li").hover(function(){
	$(this).siblings().removeClass("current");
	$(this).addClass("current");
},function(){
});
$("#index_zzw_main").mouseenter(function(){
	$("#zzw_prev_btn").trigger("mouseenter");
	$("#zzw_next_btn").trigger("mouseenter");
	$("#timedot_c").show();
});
$("#index_zzw_main").mouseleave(function(){
	$("#zzw_prev_btn").trigger("mouseleave");
	$("#zzw_next_btn").trigger("mouseleave");
	$("#timedot_c").hide();
});
$("#maskleft").mouseenter(function(){
	$("#zzw_prev_btn").trigger("mouseenter");
	$("#zzw_next_btn").trigger("mouseenter");
	$("#timedot_c").show();
});
$("#maskleft").mouseleave(function(){
	$("#zzw_prev_btn").trigger("mouseleave");
	$("#zzw_next_btn").trigger("mouseleave");
	$("#timedot_c").hide();
});
$("#maskright").mouseenter(function(){
	$("#zzw_prev_btn").trigger("mouseenter");
	$("#zzw_next_btn").trigger("mouseenter");
	$("#timedot_c").show();
});
$("#maskright").mouseleave(function(){
	$("#zzw_prev_btn").trigger("mouseleave");
	$("#zzw_next_btn").trigger("mouseleave");
	$("#timedot_c").hide();
});
$("#index_timelinebox").mouseleave(function(){
	$("#zzw_prev_btn").trigger("mouseleave");
	$("#zzw_next_btn").trigger("mouseleave");
	$("#timedot_c").hide();
});
bindtimex();
$("#index_zzw .prev_btn").click(function(){
	$(".zzw_item_3 h3").hide();
	$("#index_zzw_main").animate({left:'-990px'},"600",function(){
		
		$("#index_zzw_main .zzw_item").last().prependTo($("#index_zzw_main"));
		
		
		$.each($("#index_zzw_main .zzw_item"),function(){
			var _this = $(this);
			var po = parseInt($(this).attr("po"));
			if(po == 5){po = 0}
			$(this).removeClass().addClass("zzw_item").addClass("zzw_item_"+String(po+1)).attr("po",String(po+1));
			$("#zzw_prev_btn").trigger("mouseover");
			
		});
		var i = $("#index_timelinebox span.timex_current");
		if(i.prev().length >0 ){
			i.removeClass("timex_current").prev().addClass("timex_current");
		}else{
			i.removeClass("timex_current");
			$("#index_timelinebox span.timex").last().addClass("timex_current");
		}
		bindtimex();
		$("#index_zzw_main").mouseenter();
		$(".zzw_item h3").hide();
		$(".zzw_item_3 h3").fadeIn();
		$("#index_zzw_main").css("left","-1980px");
		
	});
});
$("#index_zzw .next_btn").click(function(){
	$(".zzw_item_3 h3").hide();
	$("#index_zzw_main").animate({left:'-2970px'},"600",function(){
		
		$("#index_zzw_main .zzw_item").first().appendTo($("#index_zzw_main"));
		
		
		$.each($("#index_zzw_main .zzw_item"),function(){
			var _this = $(this);
			var po = parseInt($(this).attr("po"));
			if(po == 1){po = 6}
			$(this).removeClass().addClass("zzw_item").addClass("zzw_item_"+String(po-1)).attr("po",String(po-1));
			$("#zzw_next_btn").trigger("mouseover");
		});
		var i = $("#index_timelinebox span.timex_current");
		if(i.next().length >0 ){
			i.removeClass("timex_current").next().addClass("timex_current");
		}else{
			i.removeClass("timex_current");
			$("#index_timelinebox span.timex").first().addClass("timex_current");
		}
		bindtimex();
		$("#index_zzw_main").mouseenter();
		$(".zzw_item h3").hide();
		$(".zzw_item_3 h3").fadeIn();
		$("#index_zzw_main").css("left","-1980px");
		
	});
});
$("#zzw_prev_btn").hover(function(){
	var now = parseInt($(".zzw_item_3").attr("c"));
	if(now == 1){now = 6}
	$(this).css("background-position","0px "+(6-(now-1)*74)+"px");
},function(){
	$(this).css("background-position","0px 6px");
});
$("#zzw_next_btn").hover(function(){
	var now = parseInt($(".zzw_item_3").attr("c"));
	if(now == 5){now = 0}
	$(this).css("background-position","-174px "+(6-(now+1)*74)+"px");
},function(){
	$(this).css("background-position","-174px 6px");
});
	$(".followTa,.followTaed").click(function(){
		var _this = $(this);
		var uid = $(this).attr("uid");
		$.post("/ajax/add_follow.php", { uid: uid },
			function(data){
				if(data != ''){
					var obj = eval('(' + data + ')');
					if(obj.status_code == -2){
						alert(obj.result);
					}else if(obj.status_code == -1){
						location.href = "http://i.meishi.cc/login.php?redirect=" + encodeURIComponent(location.href);
					}else if(obj.status_code == 0){
				    	_this.removeClass("followTa").addClass("followTaed");
					}else if(obj.status_code == 1){
				    	_this.removeClass("followTaed").addClass("followTa");
					}
		    	}
		});
	});
	$(".addToFav").click(function(){
		var _this = $(this);
		var uid = $(this).attr("uid");
		$.post("beAFan.php", { uid: uid },
			function(data){
		    alert("鏀惰棌鎴愬姛锛�");
		    _this.removeClass("addToFav").addClass("addToFaved");
		    _this.html("宸叉敹钘�");
		    _this.unbind();
		});
	});
	$("#cp_com_mask span").click(function(){
		var _this = $(this);
		_this.siblings().removeClass("current");
		_this.addClass("current");
		var type=_this.attr("type");
		$("#cp_com_type").val(type);
		//alert($("#cp_com_type").val());
		var t = $("#cp_com_textarea").val();
		var t_q = t.substring(0,8);
		if( t_q == "[鎻愰棶姹傝В]: " || t_q == "[闅忔剰鍚愭Ы]: "){
			t = t.substring(8,t.length);
		}

		$("#cp_com_textarea").val("["+_this.html()+"]: "+t);
		$("#cp_com_textarea").focus();
		moveEnd($("#cp_com_textarea").get(0));
		// $("#cp_com_submit").removeClass("submit_off");
		// $("#cp_com_mask").hide();
	});
	$("#cp_com_textarea").keyup(function(){
		var _this = $(this);
		
		//alert(_this.val());
		if(_this.val() == ""){
			$("#cp_com_mask span").removeClass("current");
			$("#cp_com_mask span").eq(0).addClass("current");
			var type=$("#cp_com_mask span").eq(0).attr("type");
			$("#cp_com_type").val(type);
			// $("#cp_com_mask").show();
			// $("#cp_com_submit").addClass("submit_off");
			// _this.blur();
		}
	});
	bind_re();
	
	setTimeout(function(){bind_scrollNews(".similar_cp", 1, 1, 600);},5000);
});	
function moveEnd(obj){
    obj.focus();
    var len = obj.value.length;
    if (document.selection) {
        var sel = obj.createTextRange();
        sel.moveStart('character',len);
        sel.collapse();
        sel.select();
    } else if (typeof obj.selectionStart == 'number' && typeof obj.selectionEnd == 'number') {
        obj.selectionStart = obj.selectionEnd = len;
    }
} 
function bind_re(){
	$(".re_slideUp").unbind();
	$(".re_slideUp").click(function(){
		var _this=$(this);
		_this.parents(".info").next().slideUp(function(){
			_this.html("灞曞紑鍥炲");
			_this.removeClass("re_slideUp").addClass("re_slideDown");
			bind_re();
		});
	});
	$(".re_slideDown").unbind();
	$(".re_slideDown").click(function(){
		var _this=$(this);
		_this.parents(".info").next().slideDown(function(){
			_this.html("鏀惰捣鍥炲");
			_this.removeClass("re_slideDown").addClass("re_slideUp");
			_this.parents(".info").next().find("textarea").focus();
			bind_re();
		});
	});
	$(".re_start").unbind();
	$(".re_start").click(function(){
		var _this=$(this);
		_this.parents(".info").next().find("form").css("paddingTop","20px");
		_this.parents(".info").next().find("form").show();
		_this.parents(".info").next().slideDown(function(){
			_this.html("鏀惰捣");
			_this.removeClass("re_start").addClass("re_slideUp1");
			_this.parents(".info").next().find("textarea").focus();
			bind_re();
		});
	});
	$(".re_slideUp1").unbind();
	$(".re_slideUp1").click(function(){
		var _this=$(this);
		_this.parents(".info").next().slideUp(function(){
			_this.html("鍥炲");
			_this.removeClass("re_slideUp1").addClass("re_start");
			bind_re();
		});
	});
	$(".saybtn").toggle(function(){
		var _this = $(this);
		_this.html("鏀惰捣");
		_this.addClass("saybtn_ed");
		_this.next().slideDown(function(){
			
			_this.next().find("textarea").focus();
		});
	},function(){
		var _this = $(this);
		_this.html("鎴戜篃璇翠竴鍙�");
		_this.removeClass("saybtn_ed");
		$(this).next().slideUp(function(){
			
		});
	});
}
function bind_scrollNews(obj, flag, step, time) {
    var $this = $(obj);
    if ($this.length > 0) {
        var scrollTimer;
        $this.hover(function() {
            clearInterval(scrollTimer)
        },
        function() {
            scrollTimer = setInterval(function() {
                scrollNews($this, flag, step, time)
            },
            3000)
        }).trigger("mouseleave")
    }
}
function scrollNews(obj, flag, step, time) {
    var $self = obj.find(".similar_cp_w");
    var lineHeight = $self.find("div:first").width()+30;
    //var w = 988+20;
    if (flag == 1) {
        $self.animate({
            "marginLeft": -lineHeight + "px"
        },
        time, 
        function() {
            $self.css({
                marginLeft: "-10px"
            }).find("div:first").appendTo($self)
        })
    }
}
$(function(){
			var ie6 = $.browser.msie && ($.browser.version == "6.0") && !$.support.style;
			if($("#main_search").attr("slideUp") == 1 && !ie6){
				$("#main_search").hover(function(){
					$(this).stop().animate({bottom:"0px",paddingTop:"0px"},300,function(){
						$(this).find("input.text").focus();
					});
					$("#bottom_back_top_top").stop().animate({bottom:"6px"},300,function(){});
					
				},function(){
					$(this).stop().animate({bottom:"-56px",paddingTop:"9px"},300,function(){});
					$("#bottom_back_top_top").animate({bottom:"20px"},300,function(){});
				});
			}
			if($("#searchslideup_btn").length > 0){
				$("#searchslideup_btn").click(function(){
					if($("#main_search").attr("slideUp") == 1){
					
					$(this).css("background-position","0px -0px");
					$("#main_search").unbind();
					$("#main_search").attr("slideUp", "0");
					setCookies('slideUp',0,720,'h','/');
					var a = getCookie("slideUp");
					}else{
			
					
					
						$(this).css("background-position","0px -48px");
						$("#main_search").stop().animate({bottom:"-56px",paddingTop:"9px"},300,function(){
							$("#bottom_back_top_top").stop().animate({bottom:"20px"},300,function(){});
							$("#main_search").hover(function(){
								$(this).stop().animate({bottom:"0px",paddingTop:"0px"},300,function(){});
								$("#bottom_back_top_top").stop().animate({bottom:"6px"},300,function(){});
								$(this).find("input.text").focus();
							},function(){
								$(this).stop().animate({bottom:"-56px",paddingTop:"9px"},300,function(){});
								$("#bottom_back_top_top").animate({bottom:"20px"},300,function(){});
							});
						});
						$("#main_search").attr("slideUp", "1");
						setCookies('slideUp',1,720,'h','/');
						var a = getCookie("slideUp");
					}
				});
			}
			
			var show_delay;
			var scroll_div_left = parseInt((document.body.offsetWidth - 990) / 2) +990;
		    $("#bottom_back_top_top").css('left', scroll_div_left);
		    $(window).resize(function() {
		        scroll_div_left = parseInt((document.body.offsetWidth - 990) / 2) +990;
		        $("#bottom_back_top_top").css('left', scroll_div_left)
		    });
		    reshow(scroll_div_left, show_delay);
		    $(window).scroll(function(){
				
		    	if($(window).scrollTop() > 300){$("#bottom_back_top_top").fadeIn();}else{$("#bottom_back_top_top").fadeOut();}
		    });
		});
		
	   
	    function reshow(marign_l, show_d) {
	        $("#bottom_back_top_top").css("left", marign_l);
	        if (show_d) window.clearTimeout(show_d);
	        scroll_div_left = parseInt((document.body.offsetWidth - 990) / 2) +990;
	        show_d = setTimeout(function() {
	            reshow(scroll_div_left)
	        },
	        500)
	    }
$(function(){
	$("#xbyjfk").toggle(function(){
		$("#doulike").animate({width:"300px"},300,function(){
		});
	},function(){
		$("#doulike").animate({width:"48px"},300,function(){
		});
	});
	$("#doulike .yjfkly a").click(function(){
		$(this).siblings().removeClass("current");
		$(this).addClass("current");
		$("#likeornot").val($(this).attr("like"));
	});
	$("#yjfkshut").click(function(){
		$("#xbyjfk").trigger("click");
	});
});
function setCookies(name,value,time,type,path) {
var cd = [name + '=' + encodeURIComponent(value)];
if (typeof time == 'number'){
var temp = 86400000;
if(type == 'h') {
temp = 3600000;
}else if(type == 'i'){
temp = 60000;
}else if(type == 's'){
temp = 1000;
}
time = new Date((new Date()).getTime() + time * temp);
cd.push('expires=' + time.toGMTString());
}
if (path)   cd.push('path=' + path);
document.cookie = cd.join('; ');
}
function getCookie(name) {
for(var b=[],d=document.cookie.split(/; */),c=0;c<d.length;c++){
var e=d[c].split("=");
e[0] == name && b.push(decodeURIComponent(e[1]));
}
return b[0];
}
function delCookie(name) { 
	setCookies(name,'',0,'s','/');
}
function bindtimex(){
	$("#index_timelinebox span.timex").unbind();
	$("#index_timelinebox span.timex_current").prev().bind("mouseenter",function(){
		
		$("#zzw_prev_btn").click();
	});
	$("#index_timelinebox span.timex_current").next().bind("mouseenter",function(){
		
		$("#zzw_next_btn").click();
	});
	// $("#index_timelinebox span.timex_current").prev().bind("click",function(){
		
	// 	$("#zzw_prev_btn").click();
	// });
	// $("#index_timelinebox span.timex_current").next().bind("click",function(){
		
	// 	$("#zzw_next_btn").click();
	// });
}
var active = -1;
var lastKeyValue = '';
var lastKeyPressCode = 0;
var default_value = $("#inputString").attr('defaultval');
function lookup(inputString) {
    if (inputString.length == 0) {
        $('#suggestions').hide()
    } else {
        if (inputString != lastKeyValue) {
            lastKeyValue = inputString;
            $.get($("#inputString").attr('href'), {
                words: encodeURIComponent(inputString)
            },
            function(data) {
                if (data.length > 0) {
                    $('#suggestions').show();
                    $('#autoSuggestionsList').html(data);
                    $("li", $('#autoSuggestionsList')).removeClass("ac_over");
                    $("#autoSuggestionsList li").hover(function() {
                        var liss = $("li.ac_over", $('#autoSuggestionsList'));
                        liss.find('a').css("backgroundColor", "#fff");
                        liss.find('a').css("color", "#333");
                        liss.find('a').find('span').css("color", "#2b952b");
                        $("li", $('#autoSuggestionsList')).removeClass("ac_over");
                        $(this).addClass("ac_over");
                        $(this).find('a').css("backgroundColor", "#ff3232");
                        $(this).find('a').css("color", "#fff");
                        $(this).find('a').find('span').css("color", "#fff");
                        for (var i = 0; i <= $("li", $('#autoSuggestionsList')).length; i++) {
                            if ($("li", $('#autoSuggestionsList'))[i] == $(this)[0]) {
                                active = i
                            }
                        }
                    },
                    function() {
                        $(this).removeClass("ac_over");
                        $(this).find('a').css("backgroundColor", "#fff");
                        $(this).find('a').css("color", "#333");
                        $(this).find('a').find('span').css("color", "#2b952b")
                    });
                    active = -1
                }
            })
        } else if ($('#autoSuggestionsList').html() != '') {
            $('#suggestions').show()
        }
    }
}
$(document).ready(function() {
    $('#inputString').keyup(function(e) {
        lastKeyPressCode = e.keyCode;
        if ((lastKeyPressCode > 32 && lastKeyPressCode < 41) || (lastKeyPressCode > 8 && lastKeyPressCode < 32)) {
            return false
        } else {
            lookup($('#inputString').val())
        }
    });
    $('#inputString').keydown(function(e) {
        switch (e.keyCode) {
        case 38:
            $("li", $('#autoSuggestionsList')).removeClass("ac_over");
            e.preventDefault();
            moveSelect( - 1);
            break;
        case 40:
            $("li", $('#autoSuggestionsList')).removeClass("ac_over");
            e.preventDefault();
            moveSelect(1);
            break;
        case 9:
        case 13:
            break;
        default:
            break
        }
    }).blur(function() {
        fill()
    })
});
function submit_headerfrom() {
    if ($('#inputString').val() == '' || $('#inputString').val() == default_value) {
        return false
    }
    var submit_from = true;
    if (active != -1) {
        var lis = $("li", $('#autoSuggestionsList'));
        if (lis) {
            var jump_href = $(lis[active]).find("a").attr('href');
            if (jump_href != '') {
                location.href = jump_href;
                submit_from = false
            }
        }
    }
    if (submit_from == true) {
        $('#suggestions_from').submit(function() {
            $('#suggestions_from').submit()
        });
        $('#suggestions_from').submit()
    }
}
function fill() {
    setTimeout("$('#suggestions').hide();", 200)
}
function moveSelect(step) {
    var lis = $("li", $('#autoSuggestionsList'));
    if (!lis) return;
    active += step;
    if (active < 0) {
        active = 0
    } else if (active >= lis.size()) {
        active = lis.size() - 1
    }
    var li_val = $(lis[active]).html();
    li_val = li_val.toLowerCase();
    var find1 = li_val.indexOf('</span>');
    var find2 = li_val.indexOf('</a>', find1);
    var words_val = li_val.substring(find1 + 7, find2);
    if (words_val != '') {
        $('#inputString').val(words_val)
    }
    lis.find('a').css("backgroundColor", "#fff");
    lis.find('a').css("color", "#333");
    lis.find('a').find('span').css("color", "#2b952b");
    $(lis[active]).addClass("ac_over");
    $(lis[active]).find('a').css("backgroundColor", "#ff3232");
    $(lis[active]).find('a').css("color", "#fff");
    $(lis[active]).find('span').css("color", "#fff")
};
var pxarr = [" "," "," "," "," "," "," "," "];
var pxflag;
function refresh_inews(st,forward){
pxflag = 0;
if(pxarr[st] != undefined && pxarr[st] != null && pxarr[st] != " "){
	pxflag = 1;
	var data = pxarr[st];
	if(forward == 1){
		$("#index_cp_rightarrow_mask").show();
		$("#index_pxw").append(data);
		$("#index_pxw").css("margin-left","0px");
		$("#index_pxw").animate({"margin-left":"-988px"},600,function(){
			$("#index_pxw .index_pxi").first().remove();
			$("#index_pxw").css("margin-left","0px");
			$("#index_cp_rightarrow_mask").hide();
		});
	}else if(forward==-1){
		$("#index_pxw").css("margin-left","-988px");
		$("#index_cp_leftarrow_mask").show();
		$("#index_pxw").prepend(data);
		$("#index_pxw").animate({"margin-left":"0px"},600,function(){
			$("#index_pxw .index_pxi").last().remove();
			$("#index_pxw").css("margin-left","0px");
			$("#index_cp_leftarrow_mask").hide();
		});
	}
	$('.paixu').find('.current').removeClass('current');
	$('.l_n_' + st).addClass('current');
}
	if(pxflag==0){$.get('/ajax/index_more_news.php?st=' + st, null,
		function(data) {
			if (data != '') {
				if(forward==1){
					$("#index_cp_rightarrow_mask").show();
					$("#index_pxw").append(data);
					$("#index_pxw").css("margin-left","0px");
					$("#index_pxw").animate({"margin-left":"-988px"},600,function(){
						$("#index_pxw .index_pxi").first().remove();
						$("#index_pxw").css("margin-left","0px");
						$("#index_cp_rightarrow_mask").hide();
					});
				}else if(forward==-1){
					$("#index_cp_leftarrow_mask").show();
					$("#index_pxw").prepend(data);
					$("#index_pxw").css("margin-left","-988px");
					$("#index_pxw").animate({"margin-left":"0px"},600,function(){
						$("#index_pxw .index_pxi").last().remove();
						$("#index_pxw").css("margin-left","0px");
						$("#index_cp_leftarrow_mask").hide();
					});
				}
				$('.paixu').find('.current').removeClass('current');
				$('.l_n_' + st).addClass('current');
				pxarr.splice(st,1,data);
			}
		})
	}
}
var paixu_i = 2;
var sti;
$(function(){
	if($('#index_pxw').length > 0){
	setsti();
	setInterval(function(){pxarr = [" "," "," "," "," "," "," "," "]},10*60*1000);
	$(".paixu .l_n").mouseover(function(){
		clearInterval(sti);
		var po = $(this).attr("po");
		paixu_i = parseInt(po)+1;
		if(paixu_i==3){paixu_i=4}
		if(paixu_i==6){paixu_i=1}
		refresh_inews(po,1);
	});
	$(".paixu .l_n").mouseout(function(){
		clearInterval(sti);
		setsti();
	});
	$('#index_pxw_w').mouseenter(function(){
		clearInterval(sti);
	});
	$('#index_pxw_w').mouseleave(function(){
		clearInterval(sti);
		setsti();
	});
	$('#index_cp_leftarrow').mouseenter(function(){
		clearInterval(sti);
	});
	$('#index_cp_leftarrow').mouseleave(function(){
		clearInterval(sti);
		setsti();
	});
	$('#index_cp_rightarrow').mouseenter(function(){
		clearInterval(sti);
	});
	$('#index_cp_rightarrow').mouseleave(function(){
		clearInterval(sti);
		setsti();
	});
	$('#index_cp_leftarrow').click(function(){
		paixu_i--;
		if(paixu_i==0){paixu_i=5}
		if(paixu_i==3){paixu_i=2}
		refresh_inews(paixu_i,-1);
	});
	$('#index_cp_rightarrow').click(function(){
		paixu_i ++;
		if(paixu_i==3){paixu_i=4}
		if(paixu_i==6){paixu_i=1}
		refresh_inews(paixu_i,1);
	});
	}
});
function setsti(){
	sti = setInterval(function(){
		refresh_inews(paixu_i,1);
		paixu_i ++;
		if(paixu_i==3){paixu_i=4}
		if(paixu_i==6){paixu_i=1}
	},5000);
}

function msjLittletips(html){
	$("body").append("<div class='msjLittletips'>"+html+"</div>");
	$(".msjLittletips").fadeIn();
	var _x = setTimeout(function(){
		$(".msjLittletips").fadeOut(function(){
			$(".msjLittletips").remove();
		});
		
	},3000);
}





