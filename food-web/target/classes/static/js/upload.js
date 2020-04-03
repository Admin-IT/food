$(function () {
    $(".hastip").focus(function () {
        $(this).next().fadeIn();
    });
    $(".hastip").blur(function () {
        $(this).next().fadeOut();
    });

    $(".input_text_item2 input").live("focus", function () {
        $(this).parent().append(
            "<div class='tips_yl'>" +
            "<span>" +
            "<em class='num'></em>鍏�</span>" +
            "<span>" +
            "<em class='num'></em>姣崌</span>" +
            "</div>"
        );
        $(this).parents(".row1_box_half").css("z-index", "1");

        if (!(parseInt($(this).val()) == "" || isNaN(parseInt($(this).val())) || parseInt($(this).val()) == undefined)) {
            var t = parseInt($(this).val());
            $(this).next().show();
            $.each($(this).next().find(".num"), function () {
                $(this).html(t);
            });
        } else {
        }
    });

    $(".input_text_item2 input").live("blur", function () {
        var _this = $(this);
        setTimeout(function () {
            _this.parent().find(".tips_yl").remove();
            _this.parents(".row1_box_half").css("z-index", "0");
        }, 300);
    });

    $(".input_text_item2 input").live("keydown", function (e) {
        var _this = $(this);
        switch (e.keyCode) {
            case 38:
                e.preventDefault();
                if (_this.parent().find(".tips_yl span.current").length > 0) {
                    if (_this.parent().find(".tips_yl span.current").prev().length > 0) {
                        _this.parent().find(".tips_yl span.current").removeClass().prev().addClass("current");
                    } else {
                    }

                } else {
                    _this.parent().find(".tips_yl span").last().addClass("current");
                }
                break;
            case 40:
                e.preventDefault();
                if (_this.parent().find(".tips_yl span.current").length > 0) {
                    if (_this.parent().find(".tips_yl span.current").next().length > 0) {
                        _this.parent().find(".tips_yl span.current").removeClass().next().addClass("current");
                    } else {
                    }
                } else {
                    _this.parent().find(".tips_yl span").first().addClass("current");
                }
                break;
            case 8:
                if (_this.val() == "") {
                    _this.parent().find(".tips_yl").hide();
                }
                break;
            case 13:
                e.preventDefault();
                _this.val(_this.parent().find(".tips_yl span.current").text()).parent().find(".tips_yl").fadeOut();
                break;
            default:
                break
        }

        if (!(parseInt($(this).val()) == "" || isNaN(parseInt($(this).val())) || parseInt($(this).val()) == undefined)) {
            var t = parseInt($(this).val());
            $(this).next().show();
            $.each($(this).next().find(".num"), function () {
                $(this).html(t);
            });
        } else {

        }
    });

    $(".tips_yl span").live("mouseover", function () {
        $(this).addClass("current")
    });
    $(".tips_yl span").live("mouseout", function () {
        $(this).removeClass("current")
    });
    $(".tips_yl span").live("click", function () {
        $(this).parent().prev().val($(this).text());

    });

    $("#closehelp").click(function () {
        $("#helpbar").hide();
        $("#showhelp").show();
        var date = new Date();
        date.setTime(date.getTime() + 8640000000);
        document.cookie = "URHS=1;expires=" + date.toGMTString();
    });
    bindStepScSelect();
    $(".step_scselect_item div.c dl dd span.cb").live("click", function () {
        var _this = $(this);
        var _p = _this.parent();
        if (_p.hasClass("checked")) {
            _p.removeClass("checked");
        } else {
            _p.addClass("checked");
        }
    });
    $(".addinstep").live("click", function () {
        var _this = $(this);
        var _p = _this.parent()
        _p.before("<dd class='dd1 checked added'><span class='cb'></span><div class='d1'><input type='text'/></div><div class='d2'><input type='text'/></div></dd>");

    });

    $(".stepst_tips").click(function () {
        $(this).hide();
        $(this).next().show();
    });

    $("input").live("blur", function () {
        reshowSclist();
    });

    $(".selectitem").hover(function () {
        $(this).find("dt").css("border-bottom", "0px");
        $(this).find("dd").show();
        $(this).css("z-index", "200");
    }, function () {
        $(this).find("dt").css("border-bottom", "1px");
        $(this).find("dd").hide();
        $(this).css("z-index", "1");
        var l = $(this).find("span");
        $.each(l, function () {
            if ($(this).attr("cur") == 1) {
                $(this).addClass("current");
            }
        });
    });

    $(".selectitem span").hover(function () {
        $(this).siblings().removeClass("current");
        $(this).addClass("hover");
    }, function () {
        $(this).removeClass("hover");
    });
    $(".selectitem span").click(function () {
        var _this = $(this);
        if (_this.html() == '\u539f\u521b') {
            $('#from_site').hide();
        } else if (_this.html() == '\u8f6c\u8f7d') {
            $('#from_site').show();
        }
        var v = _this.attr("val");
        var t = _this.html();
        _this.addClass("current");
        _this.siblings().attr("cur", "0");
        _this.attr("cur", "1");
        _this.parents(".selectitem").find("input").val(v);
        _this.parents(".selectitem").find("dt").html(t);
        _this.parent().hide();
    });

    binddel1();
    bindSteprightEvents();
    $("#addazl").click(function () {
        if ($("#zlinputs .row1_box_half").length > 9) {
            alert("\u4eb2\uff0c\u4e3b\u6599\u592a\u591a\u5c31\u6210\u4e00\u9505\u5927\u6742\u70e9\u4e86\u54e6\uff01");
        } else {
            $(this).parent().prev().append("<div class='row1_box_half'><div class='suggestionsBox suggestions' style='display:none;'><ul class='suggestionList autoSuggestionsList' ></ul></div><div class='input_text_item1'><input class='inputtext_scname' value='' type='text' placeholder='璇峰～鍐欎富鏂欏悕绉�' name='q' defaultval='璇峰～鍐欎富鏂欏悕绉�' autocomplete='off' href='/ajax/shicai_rel.php'></div><div class='input_text_item2'><input type='text' placeholder='璇峰～鍐欑敤閲�'></div><span class='delsc'></span></div> ");
            $("#zlinputs .row1_box_half .delsc").show();
        }
        binddel1();
    });
    $("#addafl").click(function () {
        if ($("#flinputs .row1_box_half").length > 29) {
            alert("\u4eb2\uff0c\u8fd9\u9053\u83dc\u96be\u5ea6\u672a\u514d\u592a\u5927\u4e86\u54e6...");
        } else {
            $(this).parent().prev().append("<div class='row1_box_half'><div class='suggestionsBox suggestions' style='display:none;'><ul class='suggestionList autoSuggestionsList' ></ul></div><div class='input_text_item1'><input class='inputtext_scname' value='' type='text' placeholder='璇峰～鍐欒緟鏂欏悕绉�' name='q' defaultval='璇峰～鍐欒緟鏂欏悕绉�' autocomplete='off' href='/ajax/shicai_rel.php'></div><div class='input_text_item2'><input type='text' placeholder='璇峰～鍐欑敤閲�'></div><span class='delsc'></span></div> ");
        }
        binddel1();
    });
    $("#addstep_btn").click(function () {
        add_step();
    });
});

function add_step() {
    if ($("#steps .stepitem").length > 99) {
        alert("\u5927\u5e08\uff0c\u8fd9\u9053\u83dc\u6b65\u9aa4\u672a\u514d\u592a\u591a\u4e86\u54e6...");
    } else {
        var guid = guidGenerator();
        $("#addstep_btn").parent().prev().append("<div class='stepitem'><div class='stepnum'></div><div class='stepupload'><iframe id='iframe_" + guid + "' src='/iframe/pic_step.php?step=" + guid + "' frameborder='0' height='180' width='180' scrolling='no'></iframe><input type='hidden' id='step_img_" + guid + "' name='step_img[]' /></div><div class='stepright'><div class='stepst_w'><div class='stepst_tips'>鏇村姝ラ缁嗚妭锛堥€夊～锛� ></div><div class='stepst'><div class='step_scselect'><div class='step_scselect_item'><span class='t'>姝ゆ楠ゆ墍鐢ㄩ鏉愶細</span><input type='hidden' value='' class='step_sc_input' name='step_sc_input[]'><div class='c'><dl class='zl clearfix'><dt class='zl'><span class='s1'>涓绘枡</span><span class='s2'>姝ラ鐢ㄩ噺锛堝彲淇敼锛�</span></dt></dl><dl class='fl clearfix'><dt class='fl'><span class='s1'>杈呮枡</span><span class='s2'>姝ラ鐢ㄩ噺锛堝彲淇敼锛�</span></dt></dl></div></div><p>姝ゆ楠ゆ墍鐢ㄩ鏉愶細</p><div class='selectitem_l'><p>璇烽€夋嫨椋熸潗</p></div></div><div class='step_timeselect'><p>姝ゆ楠ゆ墍鐢ㄦ椂闂达細</p><div class='timeinput'><input type='text' name='step_time[]'></div><span class='timedw_select'>鍒嗛挓</span></div></div></div><textarea placeholder='璇峰～鍐欐楠ゆ弿杩�' name='step_text[]'></textarea></div><div class='step_rightbtns'><a href='####' class='moveUp'></a><a href='####' class='moveDown'></a><a href='####' class='addStep'></a><a href='####' class='delStep'></a></div></div>");
    }
    relist_step();
    bindSteprightEvents();
    bindStepScSelect();
}

function relist_zl() {
    var list = $("#zlinputs input");
    var len = list.length;
    var i = 1;
    for (var i = 0; i < len; i++) {
        if (i % 2 == 0) {
            $(list[i]).attr("name", "zlsc" + String(i / 2 + 1));
        } else {
            $(list[i]).attr("name", "zlyl" + String(Math.floor(i / 2) + 1));
        }
    }
}

function relist_fl() {
    var list = $("#flinputs input");
    var len = list.length;
    for (var i = 0; i < len; i++) {
        if (i % 2 == 0) {
            $(list[i]).attr("name", "flsc" + String(i / 2 + 1));
        } else {
            $(list[i]).attr("name", "flyl" + String(Math.floor(i / 2) + 1));
        }
    }
}

function aca_tips() {
    Alert("鎻愮ず", "id:rulebox", "530", "300", "false", "", "true", "img");
}

var can_submit = true;

function saveReport() {
    if (can_submit == false) return false;
    can_submit = false;

    $("#uploadform").ajaxSubmit(
        {
            success: function (message) {
                can_submit = true;
                setTimeout(function () {
                    do_submit(3);
                }, 60000);

                if (message != '') {
                    var result_obj = eval('(' + message + ')');
                    if (result_obj.code == 1 || result_obj.code == 2) {
                        alert(result_obj.msg);
                        if (result_obj.code == 1 && result_obj.obj2 == 1) {
                            aca_tips();
                        } else {
                            location.href = "/recipe.php?id=" + result_obj.obj;
                        }
                    } else if (result_obj.code == 3 || result_obj.code == 4) {
                        $('#r_act').val('edit');
                        $('#r_id').val(result_obj.obj);
                    } else {
                        alert(result_obj.msg);
                    }
                } else {
                    $('.submit_1').val('鎼炲畾锛屾彁浜ゅ鏍革紒');
                    $('.submit_1').css('color', 'white');
                    $('.submit_2').val('淇濆瓨涓鸿崏绋�');
                    $('.submit_2').css('color', 'white');
                }
            },
            error: function () {
                can_submit = true;
                alert("鎻愪氦澶辫触锛岃閲嶆柊鎻愪氦");
                $('.submit_1').val('鎼炲畾锛屾彁浜ゅ鏍革紒');
                $('.submit_1').css('color', 'white');
                $('.submit_2').val('淇濆瓨涓鸿崏绋�');
                $('.submit_2').css('color', 'white');
            }
        });
    return false;
}

function binddel1() {
    $(".delsc").unbind();
    $(".delsc").hover(function () {
        $(this).addClass("hover");
    }, function () {
        $(this).removeClass("hover");
    });
    $(".delsc").click(function () {
        var len = get_zlinputs_length();
        if ($(this).parents("#zlinputs").length && len == 2) {

            $("#zlinputs .row1_box_half .delsc").hide();
        }
        if ($(this).parents("#zlinputs").length && len > 1) {
            $(this).parents(".row1_box_half").remove();
            relist_zl();
            relist_fl();
        } else if ($(this).parents("#zlinputs").length) {
            alert("\u4e00\u9053\u83dc\u81f3\u5c11\u5e94\u8be5\u6709\u4e00\u4e2a\u4e3b\u6599\u54e6~");
        } else {
            $(this).parents(".row1_box_half").remove();
            relist_zl();
            relist_fl();
        }
    });
    relist_zl();
    relist_fl();
}

function bindStepEvents() {
    $(".delsc").unbind();
    $(".delsc").hover(function () {
        $(this).addClass("hover");
    }, function () {
        $(this).removeClass("hover");
    });
    $(".delsc").click(function () {
        var len = get_zlinputs_length();
        if ($(this).parents("#zlinputs").length && len == 2) {

            $("#zlinputs .row1_box_half .delsc").hide();
        }
        if ($(this).parents("#zlinputs").length && len > 1) {
            $(this).parents(".row1_box_half").remove();
            relist_step();
        } else if ($(this).parents("#zlinputs").length) {
            alert("\u4e00\u9053\u83dc\u81f3\u5c11\u5e94\u8be5\u6709\u4e00\u4e2a\u4e3b\u6599\u54e6~");
        } else {
            $(this).parents(".row1_box_half").remove();
            relist_step();
        }
    });
    relist_step();
}

function get_zlinputs_length() {
    return $("#zlinputs .row1_box_half").length;
}

function moveUp(ele) {
    var p = ele.parents(".stepitem");
    if (p.prev().length > 0) {
        p.prev().insertAfter(p);
        //p.prev().remove();
        relist_step();
        bindSteprightEvents();
    } else {
        alert("\u8fd9\u5df2\u7ecf\u662f\u7b2c\u4e00\u6b65\u4e86\u54e6\uff01");
    }

}

function moveDown(ele) {
    var p = ele.parents(".stepitem");
    if (p.next().length > 0) {
        p.next().insertBefore(p);
        //p.prev().remove();
        relist_step();
        bindSteprightEvents();
    } else {
        alert("\u8fd9\u5df2\u7ecf\u662f\u6700\u540e\u4e00\u6b65\u4e86\u54e6\uff01");
    }
}

function addStep(ele) {
    var p = ele.parents(".stepitem");
    var guid = guidGenerator();
    p.after("<div class='stepitem'><div class='stepnum'></div><div class='stepupload'><iframe src='/iframe/pic_step.php?step=" + guid + "' frameborder='0' height='180' width='180' scrolling='no'></iframe><input type='hidden' id='step_img_" + guid + "' name='step_img[]' /></div><div class='stepright'><div class='stepst'><div class='step_scselect'><div class='step_scselect_item'><span class='t'>姝ゆ楠ゆ墍鐢ㄩ鏉愶細</span><input type='hidden' value='' class='step_sc_input' name='step_sc_input[]'><div class='c'><dl class='zl clearfix'><dt class='zl'><span class='s1'>涓绘枡</span><span class='s2'>姝ラ鐢ㄩ噺锛堝彲淇敼锛�</span></dt></dl><dl class='fl clearfix'><dt class='fl'><span class='s1'>杈呮枡</span><span class='s2'>姝ラ鐢ㄩ噺锛堝彲淇敼锛�</span></dt></dl></div></div><p>姝ゆ楠ゆ墍鐢ㄩ鏉愶細</p><div class='selectitem_l'><p>璇烽€夋嫨椋熸潗</p></div></div><div class='step_timeselect'><p>姝ゆ楠ゆ墍鐢ㄦ椂闂达細</p><div class='timeinput'><input type='text' name='step_time[]'></div><span class='timedw_select'>鍒嗛挓</span></div></div><textarea placeholder='璇峰～鍐欐楠ゆ弿杩�' name='step_text[]'></textarea></div><div class='step_rightbtns'><a href='####' class='moveUp'></a><a href='####' class='moveDown'></a><a href='####' class='addStep'></a><a href='####' class='delStep'></a></div></div>");
    relist_step();
    bindSteprightEvents();
    bindStepScSelect();
}

function delStep(ele) {
    var p = ele.parents(".stepitem");
    if (p.siblings().length == 0) {
        alert("\u5927\u5e08\uff0c\u83dc\u8c31\u4e00\u4e2a\u6b65\u9aa4\u90fd\u6ca1\u6709\uff01\u53eb\u6211\u7b49\u5982\u4f55\u9886\u609f\u554a\uff01")
    } else {
        p.remove();
        relist_step();
        bindSteprightEvents();
        bindStepScSelect();
    }
}

function relist_step() {
    var list = $("#steps .stepitem");
    var len = list.length;
    for (var i = 0; i < len; i++) {
        $(list[i]).find(".stepnum").html((i + 1) + ".");
    }
}

function bindSteprightEvents() {
    $(".stepitem").unbind();
    $(".moveUp").unbind();
    $(".moveDown").unbind();
    $(".addStep").unbind();
    $(".delStep").unbind();
    $(".stepitem").hover(function () {
        $(this).find(".step_rightbtns").show();
    }, function () {
        $(this).find(".step_rightbtns").hide();
    });
    $(".moveUp").click(function () {
        moveUp($(this));
    });
    $(".moveDown").click(function () {
        moveDown($(this));
    });
    $(".addStep").click(function () {
        addStep($(this));
    });
    $(".delStep").click(function () {
        delStep($(this));
    });
}

function bindStepScSelect() {
    $(".step_scselect").hover(function () {
        reshowSclist();
        reshowSclistInStep($(this));
        $(this).find(".step_scselect_item").show();
    }, function () {
        writeScInStep($(this));
        addScInStep($(this));
        $(this).find(".step_scselect_item").hide();
    });
    $(".stepst_tips").click(function () {
        $(this).hide();
        $(this).next().show();
    });
}

var zlListString = "";
var flListString = "";

function reshowSclist() {
    zlListString = "";
    flListString = "";
    var _item1 = $("#zlinputs .row1_box_half");
    $.each(_item1, function () {
        var _this = $(this);
        var zl = _this.find(".input_text_item1 input");
        var yl = _this.find(".input_text_item2 input");
        if (!(zl.val() == "" && yl.val() == "")) {
            zlListString += zl.val() + ",";
            zlListString += yl.val() + ";";
        }
    });

    var _item2 = $("#flinputs .row1_box_half");
    $.each(_item2, function () {
        var _this = $(this);
        var zl = _this.find(".input_text_item1 input");
        var yl = _this.find(".input_text_item2 input");
        if (!(zl.val() == "" && yl.val() == "")) {
            flListString += zl.val() + ",";
            flListString += yl.val() + ";";
        }
    });

}

function reshowSclistInStep(ele) {
    var e = ele;
    ele.find("dd").remove();
    var arr_zl = zlListString.split(";");
    arr_zl.pop();
    var c = "";
    $.each(arr_zl, function () {
        var a = this.split(",");
        c += "<dd class='dd1'><span class='cb'></span><div class='d1'><input type='text' readonly='' value='" + a[0] + "'></div><div class='d2'><input type='text' value='" + a[1] + "'></div></dd>";
    });
    c += "<dd class='dd2'><a href='javascript:void(0);'' class='addinstep'>+ 澧炲姞涓€琛�</a></dd>"
    ele.find("dt.zl").after(c);

    var arr_fl = flListString.split(";");
    arr_fl.pop();
    var d = "";
    $.each(arr_fl, function () {
        var a = this.split(",");
        d += "<dd class='dd1'><span class='cb'></span><div class='d1'><input type='text' readonly='' value='" + a[0] + "'></div><div class='d2'><input type='text' value='" + a[1] + "'></div></dd>";
    });
    d += "<dd class='dd2'><a href='javascript:void(0);'' class='addinstep'>+ 澧炲姞涓€琛�</a></dd>"
    ele.find("dt.fl").after(d);
    if (e.attr("zl")) {
        var st = e.attr("zl");
        var arr1 = st.split(";");
        arr1.pop();
        $.each(arr1, function () {
            var a = this.split(",");
            var d = e.find(".zl .d1 input");
            $.each(d, function () {
                if ($(this).val() == a[0]) {
                    $(this).parents(".d1").next().find("input").val(a[1]);
                    $(this).parents("dd").addClass("checked");
                }
            });
        });
    }
    if (e.attr("fl")) {
        var st = e.attr("fl");
        var arr1 = st.split(";");
        arr1.pop();
        $.each(arr1, function () {
            var a = this.split(",");
            var d = e.find(".fl .d1 input");
            $.each(d, function () {
                if ($(this).val() == a[0]) {
                    $(this).parents(".d1").next().find("input").val(a[1]);
                    $(this).parents("dd").addClass("checked");
                }
            });
        });
    }
}

function writeScInStep(ele) {
    var e = ele;
    var ced = e.find("dl.zl dd.checked");
    var record_zl = "";
    $.each(ced, function () {
        var r1 = $(this).find("input").first().val();
        var r2 = $(this).find("input").last().val();
        if (!(r1 == "" && r2 == "")) {
            record_zl += r1 + "," + r2 + ";";
        }
    });
    e.attr("zl", record_zl);
    var ced1 = e.find("dl.fl dd.checked");
    var record_fl = "";
    $.each(ced1, function () {
        var r1 = $(this).find("input").first().val();
        var r2 = $(this).find("input").last().val();
        if (!(r1 == "" && r2 == "")) {
            record_fl += r1 + "," + r2 + ";";
        }
    });
    e.attr("fl", record_fl);
    e.find(".step_sc_input").val("zl:" + record_zl + "|fl:" + record_fl);
}

$(function () {
    $("#zlinputs .input_text_item1 input").live("blur", function () {
        checkReSc_zl($(this));
    });
    $(".step_scselect_item .zl .d1 input").live("blur", function () {
        checkReSc_zl($(this));
    });
    $("#flinputs .input_text_item1 input").live("blur", function () {
        checkReSc_fl($(this));
    });
    $(".step_scselect_item .fl .d1 input").live("blur", function () {
        checkReSc_fl($(this));
    });
    $(".added .d1 input").live("blur", function () {
        var arr = $(this).parents("dd").siblings().find(".d1 input");
        var e = $(this);
        $.each(arr, function () {
            if ($(this).val() == e.val() && e.val() != "") {
                alert("\u60a8\u5df2\u7ecf\u6dfb\u52a0\u8fc7\u8fd9\u79cd\u98df\u6750\u4e86\u54e6\uff01");
                e.val("").focus();
                return false;
            }
        });
    });
});

function checkReSc_zl(ele) {
    var e = ele;
    var zls = e.parents(".ylinputs .row1_box_half").siblings().find(".input_text_item1 input");
    $.each(zls, function () {
        if ($(this).val() == e.val() && e.val() != "") {
            alert("\u60a8\u5df2\u7ecf\u6dfb\u52a0\u8fc7\u8fd9\u79cd\u98df\u6750\u4e86\u54e6\uff01");
            e.val("").focus();
            return false;
        }
    });
}

function checkReSc_fl(ele) {
    var e = ele;
    var fls = e.parents(".ylinputs .row1_box_half").siblings().find(".input_text_item1 input");
    $.each(fls, function () {
        if ($(this).val() == e.val() && e.val() != "") {
            alert("\u60a8\u5df2\u7ecf\u6dfb\u52a0\u8fc7\u8fd9\u79cd\u98df\u6750\u4e86\u54e6\uff01");
            e.val("").focus();
            return false;
        }
    });
}

function addScInStep(ele) {
    var e = ele;
    var add_zl = e.find(".zl dd.added");
    var add_zl_t = "";
    $.each(add_zl, function () {
        add_zl_t += $(this).find("input").first().val() + "," + $(this).find("input").last().val() + ";";
        var l = $("#zlinputs .row1_box_half").length;
        var txt = "<div class='row1_box_half'><div class='input_text_item1'><input name='zlsc" + String((l + 1)) + "' type='text' placeholder='璇峰～鍐欓鏉愬悕绉�' value=" + $(this).find("input").first().val() + "></div><div class='input_text_item2'><input name='zlyl" + String((l + 1)) + "' type='text' placeholder='璇峰～鍐欑敤閲�' value=" + $(this).find("input").last().val() + "></div><span class='delsc'></span></div>"
        $("#zlinputs").append(txt);
    });
    $.each($("#zlinputs .row1_box_half"), function () {
        var _this = $(this);
        if (_this.find("input").val() == []) {
            _this.remove();
        }
    });
    binddel1();
    var add_fl = e.find(".fl dd.added");
    var add_fl_t = "";
    $.each(add_fl, function () {
        add_fl_t += $(this).find("input").first().val() + "," + $(this).find("input").last().val() + ";";
        var l = $("#flinputs .row1_box_half").length;
        var txt = "<div class='row1_box_half'><div class='input_text_item1'><input name='zlsc" + String((l + 1)) + "' type='text' placeholder='璇峰～鍐欓鏉愬悕绉�' value=" + $(this).find("input").first().val() + "></div><div class='input_text_item2'><input name='zlyl" + String((l + 1)) + "' type='text' placeholder='璇峰～鍐欑敤閲�' value=" + $(this).find("input").last().val() + "></div><span class='delsc'></span></div>"
        $("#flinputs").append(txt);
    });
    $.each($("#flinputs .row1_box_half"), function () {
        var _this = $(this);
        if (_this.find("input").val() == []) {
            _this.remove();
        }
    });
    binddel1();
    var tt = "";
    var at = e.find(".checked").find(".d1 input");
    $.each(at, function () {
        if ($(this).val() != "") {
            tt += $(this).val() + "銆�";
        }
    });
    tt = tt.substring(0, tt.length - 1);
    var t = "";
    if (tt == "") {
        t = "\u8bf7\u9009\u62e9\u98df\u6750"
    } else if (tt.length <= 9) {
        t = tt
    } else if (tt.length > 9) {
        t = tt.substring(0, 9) + "..."
    }
    e.find(".selectitem_l p").html(t);
}

var active = -1;
var lastKeyValue = '';
var lastKeyPressCode = 0;
var default_value = "";

function lookup(inputString, ele) {
    var inputstring = ele;
    var sug = ele.parent().prev();
    var autosug = sug.find("ul");
    if (inputString.length == 0) {
        sug.hide();
    } else {
        if (inputString != lastKeyValue) {
            lastKeyValue = inputString;
            $.get(inputstring.attr('href'), {
                    words: encodeURIComponent(inputString)
                },
                function (data) {
                    if (data.length > 0) {
                        sug.show();
                        autosug.html(data);
                        $("li", autosug).removeClass("ac_over");
                        active = -1
                    }
                })
        } else if (autosug.html() != '') {
            sug.show()
        }
    }
}

$(document).ready(function () {
    $(".autoSuggestionsList li").live("mouseup", function () {
        // alert(1);
        var _this = $(this);
        var autosug = _this.parent();
        var inputstring = autosug.parent().next().find("input");
        inputstring.val($(this).html());
    });

    $(".autoSuggestionsList li").live("mouseenter", function () {
        var _this = $(this);
        var autosug = _this.parent();
        var inputstring = autosug.parent().next().find("input");
        var liss = $("li.ac_over", autosug);
        liss.css("backgroundColor", "#fff");
        liss.css("color", "#333");
        $("li", autosug).removeClass("ac_over");
        $(this).addClass("ac_over");
        $(this).css("backgroundColor", "#ff3232");
        $(this).css("color", "#fff");
        for (var i = 0; i <= $("li", autosug).length; i++) {
            if ($("li", autosug)[i] == $(this)[0]) {
                active = i
            }
        }
    });

    $(".autoSuggestionsList li").live("mouseleave", function () {
        var _this = $(this);
        var autosug = _this.parent();
        var inputstring = autosug.parent().next().find("input");
        $(this).removeClass("ac_over");
        $(this).css("backgroundColor", "#fff");
        $(this).css("color", "#333");
    });
    $('.inputtext_scname').live("keyup", function (e) {
        var _this = $(this);
        lastKeyPressCode = e.keyCode;
        if ((lastKeyPressCode > 32 && lastKeyPressCode < 41) || (lastKeyPressCode > 8 && lastKeyPressCode < 32)) {
            return false
        } else {
            lookup(_this.val(), _this)
        }
    });
    $('.inputtext_scname').live("keydown", function (e) {
        var _this = $(this);
        var inputstring = _this;
        var sug = _this.parent().prev();
        var autosug = sug.find("ul");
        switch (e.keyCode) {
            case 38:
                $("li", autosug).removeClass("ac_over");
                e.preventDefault();
                moveSelect(-1, _this);
                break;
            case 40:
                $("li", autosug).removeClass("ac_over");
                e.preventDefault();
                moveSelect(1, _this);
                break;
            case 13:
                var t = _this.parents(".row1_box_half").find(".ac_over").html();
                inputstring.val(t);
                fill(_this);
            default:
                break
        }
    });
    $('.inputtext_scname').live("blur", function () {
        var _this = $(this);
        fill(_this);
    })
});

function fill(ele) {
    var sug = ele.parent().prev();
    setTimeout(function () {
        sug.hide();
    }, 200);
}

function moveSelect(step, ele) {
    var inputstring = ele;
    var sug = ele.parent().prev();
    var autosug = sug.find("ul");
    var lis = $("li", autosug);
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

    lis.css("backgroundColor", "#fff");
    lis.css("color", "#333");
    lis.find('span').css("color", "#2b952b");
    $(lis[active]).addClass("ac_over");
    $(lis[active]).css("backgroundColor", "#ff3232");
    $(lis[active]).css("color", "#fff");
};

function cut_img(img) {
    Alert("鎷栧姩閫夋淇敼鎴愬搧鍥剧殑灞曠ず鑼冨洿", "iframe:/iframe/upload_cut_pic.php?pid=" + img, "700", "500", "false", "", "true", "img");
}

function cut_img_complete(photo) {
    $('#windown-close').click();
    document.getElementById('newsphoto_iframe').src = "/iframe/pic.php?photo=" + photo;
}

function do_submit(type) {
    if (type == 2) {
        $('.submit_2').val('保存中...请稍后');
        $('.submit_2').css('color', 'yellow');
    } else if (type == 1) {
        $('.submit_1').val('提交中...请稍后');
        $('.submit_1').css('color', 'yellow');
    }
    $('#stype').val(type);
    $("#uploadform").submit();
}

$(function () {
    var session_id = $("#session_id").val();
    $('#multiple_uploade_step_img').uploadify({
        'formData': {
            'act': 'step',
            'session_id': session_id,
        },
        'swf': 'uploadify.swf',
        'uploader': 'iframe/upload_pic_mul.php',
        onDialogClose: function (queueData) {
            var file_num = queueData.filesQueued;
            var n = 0;
            $.each($("#steps iframe"), function (index, iframe) {
                var default_src = $(iframe).contents().find("#clickToUpload").attr("default_src");
                var current_src = $(iframe).contents().find("#clickToUpload").attr("src");

                if (default_src == current_src) {
                    n++;
                }
            });
            if (file_num > n) {
                for (var i = file_num - n; i > 0; i--) {
                    add_step();
                }
                ;
            }
        },

        onUploadSuccess: function (file, data, respone) {
            if (data != '0') {
                var add_scr = false;
                $.each($("#steps iframe"), function (index, iframe) {
                    var default_src = $(iframe).contents().find("#clickToUpload").attr("default_src");
                    var current_src = $(iframe).contents().find("#clickToUpload").attr("src");
                    var step_id = $(iframe).contents().find("#step").val();
                    if (default_src == current_src && add_scr == false) {
                        var data_result = data.split(",");
                        if (data_result.length == 3) {
                            $(iframe).contents().find("#clickToUpload").attr("src", data_result[0]);
                            $("#step_img_" + step_id).val(data_result[1]);
                            var old_src = $(iframe).attr("src");
                            $(iframe).attr("src", old_src + '&photo=' + data_result[2]);
                            add_scr = true;
                        } else {
                            alert('鍟婂摝,濂藉儚鍑洪敊浜�');
                        }
                    }
                });
            } else {
                alert('鍟婂摝,濂藉儚鍑洪敊浜�');
            }
        }
    });

    $('#multiple_uploade_done_img').uploadify({
        'formData': {
            'act': 'step_result',
            'session_id': session_id,
        },
        // uploadLimit: 4,
        'swf': 'uploadify.swf',
        'uploader': 'iframe/upload_pic_mul.php',
        onDialogClose: function (queueData) {
            var file_num = queueData.filesQueued;
            var n = 0;
            $.each($("#step_result iframe"), function (index, iframe) {
                var default_src = $(iframe).contents().find("#clickToUpload").attr("default_src");
                var current_src = $(iframe).contents().find("#clickToUpload").attr("src");
                if (default_src == current_src) {
                    n++;
                }
            });
            if (file_num > n) {
                alert('鎴愬搧鍥炬渶澶氬彧鑳戒笂浼�4寮犲摝');
                $('#multiple_uploade_done_img').uploadify('cancel', '*');
            }
        },
        onUploadSuccess: function (file, data, respone) {
            if (data != '0') {
                var add_scr = false;
                $.each($("#step_result iframe"), function (index, iframe) {
                    var default_src = $(iframe).contents().find("#clickToUpload").attr("default_src");
                    var current_src = $(iframe).contents().find("#clickToUpload").attr("src");
                    var step_id = $(iframe).contents().find("#step").val();
                    if (default_src == current_src && add_scr == false) {
                        var data_result = data.split(",");
                        if (data_result.length == 3) {
                            $(iframe).contents().find("#clickToUpload").attr("src", data_result[0]);
                            $("#step_img_" + step_id).val(data_result[1]);
                            add_scr = true;
                        } else {
                            alert('鍟婂摝,濂藉儚鍑洪敊浜�');
                        }
                    }
                });
            } else {
                alert('鍟婂摝,濂藉儚鍑洪敊浜�');
            }
        }
    });
});

$(function () {
    if (navigator.userAgent.indexOf("MSIE") != -1) {
        IE_Flash();
    }
    // 鍖呭惈銆孎irefox銆嶆枃瀛楀垪
    else {
        FF_or_Chrome_Flash();
    }
});

var swf;

function IE_Flash() {
    try {
        var swf = new ActiveXObject("ShockwaveFlash.ShockwaveFlash");
        var flashVersion = swf.GetVariable("$version");
        var arr = flashVersion.split(" ");
        var brr = arr[1].split(",");
        var b_version = navigator.appVersion
        var version = b_version.split(";");
        var trim_Version = version[1].replace(/[ ]/g, "");
        if (brr[0] <= 12 && trim_Version == "MSIE8.0") {
            $(".muluploadbox .tip").html("浣犵殑娴忚鍣ㄥ畨瑁協alsh鐗堟湰杩囦綆,鍙兘浼氬奖鍝嶆壒閲忎笂浼犲姛鑳界殑浣跨敤 <a href='http://get.adobe.com/cn/flashplayer/' target='_blank'>鐐瑰嚮涓嬭浇鏂扮増flash ></a>");
            $(".muluploadbox_done .tip").html("浣犵殑娴忚鍣ㄥ畨瑁協alsh鐗堟湰杩囦綆,鍙兘浼氬奖鍝嶆壒閲忎笂浼犲姛鑳界殑浣跨敤 <a href='http://get.adobe.com/cn/flashplayer/' target='_blank'>鐐瑰嚮涓嬭浇鏂扮増flash ></a>");
        }
    } catch (e) {
        $("#multiple_uploade_step_img").remove();
        $("#multiple_uploade_step_img-queue").remove();
        $(".muluploadbox .tip").css({"position": "relative", "left": "0px", "top": "0px"});
        $(".muluploadbox .tip").html("浣犵殑娴忚鍣ㄦ湭瀹夎falsh锛屽畨瑁協lash鍚庡彲浣跨敤鎵归噺涓婁紶鍔熻兘鍝 <a href='http://get.adobe.com/cn/flashplayer/' target='_blank'>鐐瑰嚮涓嬭浇 ></a>");
        $("#multiple_uploade_done_img").remove();
        $("#multiple_uploade_done_img-queue").remove();
        $(".muluploadbox_done .tip").css({"position": "relative", "left": "0px", "top": "0px"});
        $(".muluploadbox_done .tip").html("浣犵殑娴忚鍣ㄦ湭瀹夎falsh锛屽畨瑁協lash鍚庡彲浣跨敤鎵归噺涓婁紶鍔熻兘鍝 <a href='http://get.adobe.com/cn/flashplayer/' target='_blank'>鐐瑰嚮涓嬭浇 ></a>");

    }
}

function FF_or_Chrome_Flash() {
    var swf = navigator.plugins["Shockwave Flash"];
    if (!swf) {
        $("#multiple_uploade_step_img").remove();
        $("#multiple_uploade_step_img-queue").remove();
        $(".muluploadbox .tip").css({"position": "relative", "left": "0px", "top": "0px"});
        $(".muluploadbox .tip").html("浣犵殑娴忚鍣ㄦ湭瀹夎falsh锛屽畨瑁協lash鍚庡彲浣跨敤鎵归噺涓婁紶鍔熻兘鍝 <a href='http://get.adobe.com/cn/flashplayer/' target='_blank'>鐐瑰嚮涓嬭浇 ></a>");
        $("#multiple_uploade_done_img").remove();
        $("#multiple_uploade_done_img-queue").remove();
        $(".muluploadbox_done .tip").css({"position": "relative", "left": "0px", "top": "0px"});
        $(".muluploadbox_done .tip").html("浣犵殑娴忚鍣ㄦ湭瀹夎falsh锛屽畨瑁協lash鍚庡彲浣跨敤鎵归噺涓婁紶鍔熻兘鍝 <a href='http://get.adobe.com/cn/flashplayer/' target='_blank'>鐐瑰嚮涓嬭浇 ></a>");
    }
}