function delete_recipe(rid) {
    if (confirm("纭鍒犻櫎杩欑瘒鑿滆氨?")) {
        $.ajax({
            type: "POST",
            url: "/ajax/remove_recipe.php",
            data: "rid=" + rid,
            success: function (result) {
                location.href = "/user.php?t=recipe";
            }
        });
    }
    return false;
}

function close_tip() {
    $('#windown-close').click();
}

function tran_caidan_recipe(nid) {
    Alert("灏嗚繖閬撹彍鏀惰棌鍒�...", "iframe:/ajax/add_caidan.php?id=" + nid, "400", "376", "false", "", "true", "img");
}

function send_sixin(uid) {
    Alert("鍙戠淇�", "iframe:/new/inbox/sendsixinbox.php?id=" + uid, "400", "325", "false", "", "true", "img");
}

function sendAndShowx(to_user, comments, sixin_nicname) {
    $.ajax({
        type: "POST",
        url: "/ajax/inbox/send_inbox.php",
        data: "to_user=" + to_user + "&content=" + comments + "&sixin_nicname=" + sixin_nicname,
        success: function (result) {
            var result_obj = eval('(' + result + ')');
            if (result_obj.code == 6) {
                alert('鍙戦€佹垚鍔�');
                window.location.reload();
            } else {
                alert(result_obj.error_code);
            }
        }
    });
}

function remove_fans(uid) {
    if (confirm("纭鍒犻櫎杩欎綅绮変笣?")) {
        $.ajax({
            type: "POST",
            url: "/ajax/remove_fans.php",
            data: "uid=" + uid,
            success: function (result) {
                var result_obj = eval('(' + result + ')');
                if (result_obj.status_code == 1) {
                    $('.fans_' + uid).remove();
                } else {
                    alert(result_obj.result);
                }
            }
        });
    }
    return false;
}

function add_follow(uid) {
    $.post("/ajax/add_follow.php", {uid: uid},
        function (data) {
            if (data != '') {
                var obj = eval('(' + data + ')');
                if (obj.status_code == -2) {
                    alert(obj.result);
                } else if (obj.status_code == -1) {
                    location.href = "http://i.meishi.cc/login.php?redirect=" + encodeURIComponent(location.href);
                } else if (obj.status_code == 0) {
                    alert(obj.result);
                } else if (obj.status_code == 1) {
                    alert(obj.result);
                }
            }
        });
    return false;
}

function remove_follow(uid) {
    if (confirm("纭鍙栨秷鍏虫敞?")) {
        $.ajax({
            type: "POST",
            url: "/ajax/add_follow.php",
            data: "uid=" + uid,
            success: function (result) {
                var result_obj = eval('(' + result + ')');
                if (result_obj.status_code == 1) {
                    $('.follow_' + uid).remove();
                } else {
                    alert(result_obj.result);
                }
            }
        });
    }
    return false;
}

$(function () {
    $(".hasmore").hover(function () {
        $(this).addClass("hasmore_cur");
    }, function () {
        $(this).removeClass("hasmore_cur");
    });

    $(".userzp_zp").live("mouseenter", function () {
        $(this).find(".delthis").show();
    });
    $(".userzp_zp").live("mouseleave", function () {
        $(this).find(".delthis").hide();
    });

    $(".user_cditem_c").live("mouseenter", function () {
        $(this).find(".delthis").show();
    });
    $(".user_cditem_c").live("mouseleave", function () {
        $(this).find(".delthis").hide();
    });
    $("#send_sixin_btn").live("click", function () {
        send_sixin(0);
    });
    $("#editusertx_btn a").toggle(function () {
        var _this = $(this);
        $("#editusertx_btn").next().slideDown();
        _this.addClass("clicked");
        _this.html("鍙栨秷");
    }, function () {
        var _this = $(this);
        $("#editusertx_btn").next().slideUp();
        _this.removeClass("clicked");
        _this.html("淇敼澶村儚");
    });
    $("#cd_name").keyup(function () {
        var _this = $(this);
        var l = _this.val().length;
        if (l <= 20) {
            _this.parent().next().find(".tip").html("杩樿兘杈撳叆" + (20 - l) + "瀛�").css("color", "#999");
        } else {
            _this.parent().next().find(".tip").html("宸茬粡瓒呭嚭" + (l - 20) + "瀛�").css("color", "#ff3232");
        }
    });
    $("#editcdinfo").find("textarea").keyup(function () {
        var _this = $(this);
        var l = _this.val().length;
        if (l <= 120) {
            _this.parent().next().find(".tip").html("杩樿兘杈撳叆" + (120 - l) + "瀛�").css("color", "#999");
        } else {
            _this.parent().next().find(".tip").html("宸茬粡瓒呭嚭" + (l - 120) + "瀛�").css("color", "#ff3232");
        }
    });
    $("#editsignname").find("textarea").keyup(function () {
        var _this = $(this);
        var l = _this.val().length;
        if (l <= 150) {
            _this.parent().next().find(".tip").html("杩樿兘杈撳叆" + (150 - l) + "瀛�").css("color", "#999");
        } else {
            _this.parent().next().find(".tip").html("宸茬粡瓒呭嚭" + (l - 150) + "瀛�").css("color", "#ff3232");
        }
    });

    $("#editspacename").find("textarea").keyup(function () {
        var _this = $(this);
        var l = _this.val().length;
        if (l <= 30) {
            _this.parent().next().find(".tip").html("杩樿兘杈撳叆" + (30 - l) + "瀛�").css("color", "#999");
        } else {
            _this.parent().next().find(".tip").html("宸茬粡瓒呭嚭" + (l - 30) + "瀛�").css("color", "#ff3232");
        }
    });

    $(".sixin_qq_li").live("mouseenter", function () {
        $(this).find(".delete").show();
    });
    $(".sixin_qq_li").live("mouseleave", function () {
        $(this).find(".delete").hide();
    });

    $(".sixin_list_li").live("mouseenter", function () {
        $(this).find(".time a").show();
    });
    $(".sixin_list_li").live("mouseleave", function () {
        $(this).find(".time a").hide();
    });

    $(".cp_list_li").live("mouseenter", function () {
        $(this).find(".time a").show();
    });
    $(".cp_list_li").live("mouseleave", function () {
        $(this).find(".time a").hide();
    });

    $("#delete_cd").click(function () {
        if (confirm("纭畾瑕佸垹闄よ繖涓彍鍗曞悧? (鑿滃崟閲岀殑鑿滀篃浼氳涓€璧峰垹闄ゅ摝...)")) {
            alert("鍒犻櫎鎴愬姛锛�");
            //  if(confirm("淇濈暀杩欎釜鑿滃崟閲岀殑鑿滆氨鍚楋紵")){
            //     alert("鍒犻櫎鎴愬姛锛�(宸蹭负鎮ㄥ皢鑿滆氨淇濆瓨鍒颁簡鈥滄垜鐨勬敹钘忊€�)");
            // }
            // if(!confirm("淇濈暀杩欎釜鑿滃崟閲岀殑鑿滆氨鍚楋紵鐐瑰嚮鍙栨秷浼氬皢杩欎釜鑿滃崟鐨勬悳鏈夎彍璋变竴璧峰垹闄わ紒锛�")){
            // 		alert("鍒犻櫎鎴愬姛锛�");
            // }
        }
    });
    $(".cd_forcheck_li").live("click", function () {
        var _this = $(this);
        if (_this.hasClass("checkbox_checked")) {
            _this.removeClass("checkbox_checked")
        } else {
            _this.addClass("checkbox_checked");
        }
    });

    $(".delthiscp").live("click", function () {

    });

    $("#userfav_ztheader_main").hover(function () {
        $(this).find("a.delete_cd").show();
    }, function () {
        $(this).find("a.delete_cd").hide();
    });

    $(".listtyle3 .info2").live("mouseenter", function () {
        var _this = $(this);
        _this.find(".info2_c").stop().animate({left: "0px", opacity: "1"}, 800, function () {
        });
    });

    $(".listtyle3 .info2").live("mouseleave", function () {
        var _this = $(this);
        _this.find(".info2_c").stop().animate({left: "232px", opacity: "0"}, 800, function () {
        });
    });

    $(".listtyle3").live("mouseenter", function () {
        var _this = $(this);
        _this.find(".delete").show();
    });

    $(".listtyle3").live("mouseleave", function () {
        var _this = $(this);
        _this.find(".delete").hide();
    });

    $(".filter_otherbtn").toggle(function () {
        var _this = $(this);
        _this.html("<< 鏀惰捣");
        $(this).prev().find(".others").fadeIn(function () {

        });
    }, function () {
        var _this = $(this);
        _this.html("灞曞紑鍏ㄩ儴 >>");
        $(this).prev().find(".others").fadeOut(function () {
        });
    });

    $(".other_c").css("min-height", $("#listnav_con_c").height() + "px");
    if ($.browser.msie && ($.browser.version == "6.0") && !$.support.style) {
        $(".other_c").css("height", $("#listnav_con_c").height() + "px");//for ie6
    }

    $("#fliterstyle1 dt").click(function () {
        var _this = $(this);
        if (_this.parent().hasClass("on")) {
        } else {
            _this.parents(".tabcon").find("dl.on").find("dd").slideUp(function () {
            });
            _this.parents(".tabcon").find("dl.on").removeClass("on");
            _this.next().slideDown(function () {
                _this.parent().find(".long").slideDown();
            });
            _this.parent().addClass("on");
        }
    });

    $("#fliterstyle1 .tab li").click(function () {
        var po = $(this).attr("po");
        if (!$(this).hasClass("current")) {
            $(this).siblings().removeClass("current");
            $(this).addClass("current");
        }

        $("#fliterstyle1 .tabcon").each(function () {
            if ($(this).attr("po") == po) {
                $(this).siblings(".tabcon").hide();
                $(this).show();
            }
        });
    });
});

$(window).load(function () {
    var photo = $('#myphoto');
    var width = photo.width();
    if (width < 180) {
        return false;
    }
    var ori_width = width / 0.6 - 180;
    var height = photo.height();
    var ori_height = height / 0.6 - 180;
    var draging = false;
    var position = {
        w: width,
        h: height
    };
    var getPos = function () {
        var w = photo.width(), h = photo.height(), p = photo.position();
        var p_l = (60 - p.left) / w, p_t = (60 - p.top) / h, p_w = 180 / w;
        return {x: parseInt(p_l * width), y: parseInt(p_t * height), win: parseInt(width * p_w)};
    };

    $('#photocrop-form').submit(function () {
        var el = $(this), pos = getPos();
        el.find('input[name=x]').val(pos.x);
        el.find('input[name=y]').val(pos.y);
        el.find('input[name=width]').val(pos.win);
        el.find('input[name=height]').val(pos.win);
    });
    //璋冩澶у皬
    var resizePhoto = function (val) {
        //val = 180+(val<0?0:(val>100?100:val))*10;
        if (width < height) {
            val = ori_width * (val / 100);
            if (val < 180) {
                return false;
            }
            photo.width(val);
        } else {
            val = ori_height * (val / 100);
            if (val < 180) {
                return false;
            }
            photo.height(val);
        }
        //灏嗚皟鏁村悗鐨勫ぇ灏忎繚瀛樺埌position
        position.w = photo.width();
        position.h = photo.height();

        photo.css(setPos());
    };
    //璁剧疆鍥剧墖浣嶇疆
    var setPos = function (p) {
        p = p ? p : photo.position();
        var w = position.w, h = position.h;
        //浠ヤ笅鍥涘彞灏嗗浘鐗囧浐瀹氬埌浜嗘鐨勫乏涓婅
        if (p.left > 60) p.left = 60;
        else if (p.left < 180 - w) p.left = 180 - w;
        if (p.top > 60) p.top = 60;
        else if (p.top < 180 - h) p.top = 180 - h;
        return p;
    };

    var posPhoto = function (e) {
        var p = photo.position();
        var l = p.left + e.pageX - position.x;
        var t = p.top + e.pageY - position.y;
        photo.css(setPos({
            left: l,
            top: t
        }));
        position.x = e.pageX;
        position.y = e.pageY;
    };
    //#photo-canvas绉诲姩妗�
    $('#photo-canvas').mousedown(function (e) {
        draging = true;
        position.x = e.pageX;
        position.y = e.pageY;
        position.w = photo.width();
        position.h = photo.height();
        e.preventDefault();
    }).mousemove(function (e) {
        if (!draging) return;
        posPhoto(e);
        e.preventDefault();
    });
    $(document).mouseup(function (e) {
        draging = false;
    });
    $('#photo-slider').slider({
        startValue: 60,
        slide: function (e, ui) {
            resizePhoto(ui.value);
        }
    });
});