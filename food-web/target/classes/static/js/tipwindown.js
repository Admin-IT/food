var showWindown = true;

function Alert(title, content, width, height, drag, time, showbg, cssName, alrt) {
    $("#windown-box").remove(); //璇烽櫎鍐呭
    var width = width >= 950 ? this.width = 950 : this.width = width;	    //璁剧疆鏈€澶х獥鍙ｅ搴�
    var height = height >= 527 ? this.height = 527 : this.height = height;  //璁剧疆鏈€澶х獥鍙ｉ珮搴�
    if (showWindown == true) {
        var simpleWindown_html = new String;
        simpleWindown_html = "<div id=\"windownbg\" style=\"height:" + $(document).height() + "px;filter:alpha(opacity=0);opacity:0;z-index: 999901\"></div>";
        simpleWindown_html += "<div id=\"windown-box\">";
        simpleWindown_html += "<table id=\"windown-table\" cellspacing=\"0\" cellpadding=\"0\"><tr class=\"tr1\"><td class=\"td1\"></td><td class=\"td2\"></td><td class=\"td3\"></td></tr>";
        simpleWindown_html += "<tr class=\"tr2\"><td class=\"td1\"></td><td class=\"td2\">";
        simpleWindown_html += "<div id=\"windown-title\"><h2></h2><a href=\"####\" id=\"windown-close\"></a></div>";
        simpleWindown_html += "<div id=\"windown-content-border\"><div id=\"windown-content\"></div></div>";
        if (alrt) {
            simpleWindown_html += "<div id=\"windown-content-ok\"><a id=\"windown-ok\" href=\"####\">纭畾</a></div>";
        }
        simpleWindown_html += "</td><td class=\"td3\"></td></tr><tr class=\"tr3\"><td class=\"td1\"></td><td class=\"td2\"></td><td class=\"td3\"></td></tr></table>";
        simpleWindown_html += "</div>";
        $("body").append(simpleWindown_html);
        show = false;
    }
    contentType = content.substring(0, content.indexOf(":"));
    content = content.substring(content.indexOf(":") + 1, content.length);
    switch (contentType) {
        case "text":
            $("#windown-content").html("<p style='padding:10px 0px;font-size:14px;color:#666'>" + content + "</p>");
            break;
        case "id":
            $("#windown-content").html($("#" + content + "").html());
            break;
        case "img":
            $("#windown-content").html("<img src=" + content + " alt='' />");
            break;
        case "url":
            var content_array = content.split("?");
            $("#windown-content").ajaxStart(function () {
                //$(this).html("<img src='"+templateSrc+"/images/loading.gif' class='loading' />");
            });
            $.ajax({
                type: content_array[0],
                url: content_array[1],
                data: content_array[2],
                error: function () {
                    $("#windown-content").html("<p class='windown-error'>鍔犺浇鏁版嵁鍑洪敊...</p>");
                },
                success: function (html) {
                    $("#windown-content").html(html);
                }
            });
            break;
        case "iframe":
            $("#windown-content").ajaxStart(function () {
                //$(this).html("<img src='"+templateSrc+"/images/loading.gif' class='loading' />");
            });
            $("#windown-content").html("<iframe src=\"" + content + "\" width=\"100%\" height=\"" + parseInt(height) + "px" + "\" scrolling=\"auto\" frameborder=\"0\" marginheight=\"0\" marginwidth=\"0\" id=\"iframe_ss\"></iframe>");
    }
    $("#windown-title h2").html(title);
    if (showbg == "true") {
        $("#windownbg").show();
    } else {
        $("#windownbg").remove();
    }
    ;
    $("#windownbg").animate({opacity: "0.75"}, "normal");//璁剧疆閫忔槑搴�
    $("#windown-box").show();
    if (height >= 527) {
        $("#windown-title").css({width: (parseInt(width) + 22) + "px"});
        $("#windown-content").css({width: (parseInt(width) + 17) + "px", height: height + "px"});
    } else {
        $("#windown-title").css({width: (parseInt(width)) + "px"});
        $("#windown-content").css({width: width + "px", height: height + "px"});
    }
    var cw = document.documentElement.clientWidth, ch = document.documentElement.clientHeight,
        est = document.documentElement.scrollTop;
    var _version = $.browser.version;
    if (_version == 6.0) {
        $("#windown-box").css({
            left: "50%",
            top: (parseInt((ch) / 2) + est) + "px",
            marginTop: -((parseInt(height) + 53) / 2) + "px",
            marginLeft: -((parseInt(width) + 32) / 2) + "px",
            zIndex: "999999"
        });
    } else {
        $("#windown-box").css({
            left: "50%",
            top: "50%",
            marginTop: -((parseInt(height) + 53) / 2) + "px",
            marginLeft: -((parseInt(width) + 32) / 2) + "px",
            zIndex: "999999"
        });
    }
    ;
    var Drag_ID = document.getElementById("windown-box"), DragHead = document.getElementById("windown-title");

    var moveX = 0, moveY = 0, moveTop, moveLeft = 0, moveable = false;
    if (_version == 6.0) {
        moveTop = est;
    } else {
        moveTop = 0;
    }
    var sw = Drag_ID.scrollWidth, sh = Drag_ID.scrollHeight;
    DragHead.onmouseover = function (e) {
        if (drag == "true") {
            DragHead.style.cursor = "move";
        } else {
            DragHead.style.cursor = "default";
        }
    };
    DragHead.onmousedown = function (e) {
        if (drag == "true") {
            moveable = true;
        } else {
            moveable = false;
        }
        e = window.event ? window.event : e;
        var ol = Drag_ID.offsetLeft, ot = Drag_ID.offsetTop - moveTop;
        moveX = e.clientX - ol;
        moveY = e.clientY - ot;
        document.onmousemove = function (e) {
            if (moveable) {
                e = window.event ? window.event : e;
                var x = e.clientX - moveX;
                var y = e.clientY - moveY;
                if (x > 0 && (x + sw < cw) && y > 0 && (y + sh < ch)) {
                    Drag_ID.style.left = x + "px";
                    Drag_ID.style.top = parseInt(y + moveTop) + "px";
                    Drag_ID.style.margin = "auto";
                }
            }
        }
        document.onmouseup = function () {
            moveable = false;
        };
        Drag_ID.onselectstart = function (e) {
            return false;
        }
    }
    $("#windown-content").attr("class", "windown-" + cssName);
    var closeWindown = function () {

        $("#windown-box").fadeOut("slow", function () {
            $(this).remove();
            $("#windownbg").remove();
        });
    }
    if (time == "" || typeof (time) == "undefined") {
        $("#windown-close").click(function () {
            $("#windownbg").remove();
            $("#iframe_ss").remove();
            $("#windown-box").fadeOut("slow", function () {
                $(this).remove();
            });
        });
        $("#windown-ok").click(function () {
            $("#windownbg").remove();
            $("#iframe_ss").remove();
            $("#windown-box").fadeOut("slow", function () {
                $(this).remove();
            });
        });
    } else {
        setTimeout(closeWindown, time);
    }
}
