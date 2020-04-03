$(function () {
    // 信息加载
    $.ajax({
        url: "./get_user_info",
        type: "get",
        success: function (result) {

            if (result.code == 200) {

                $('.loginitem_h').empty();
                $('.loginitem_h').append('<script src=""></script>'
                    + '<div class="userinfo">'
                    + '<div class="userinfo_w" id="userinfo_w">'
                    + '<a href="user-center.html" class="avatar">'
                    + '<img src="img/jpg/head.jpg">' +
                    +'</a>'
                    + '<a href="user-center.html" class="outer">' + result.data.userId + '</a>'
                    + '<div class="top_userinfo_more">'
                    + '<div class="u">'
                    + '<a href="user-center.html" class="img">'
                    + '<img src="img/jpg/head.jpg">'
                    + '</a>'
                    + '<div class="n">'
                    + '<a href="user-center.html" data-name="' + result.data.userId + '">' + result.data.userId + '</a>'
                    + '<a target="_blank" href="" class="v"></a>'
                    + '</div>'
                    + '</div>'
                    + '<ul class="clearfix">'
                    + '<li>'
                    + '<a href="create-cp.html" class="redbtn">发布菜谱</a>'
                    + '<a class="greybtn free" onclick="">发布图文（400积分）</a>'
                    + '</li>'
                    + '<li>'
                    + '<a href="user-center.html" class="linkk">我的美食空间</a>'
                    + '</li>'
                    + '<li>'
                    + '<a href="" class="linkk">我的积分成长</a>'
                    + '</li>'
                    + '<li>'
                    + '<a href="../tologout" class="linkk">退出登录</a>'
                    + '</li>'
                    + '</ul>'
                    + '</div>'
                    + '</div>'
                    + '<a href="collected.html" class="outer">收藏</a>'
                    + '<div class="mes">'
                    + '<a href="user-center" class="outer">消息</a>'
                    + '<div class="topbar_mesbox" id="dr_getmission_box1" style="display: none"></div>'
                    + '</div>'
                    + '</div>'
                    + '</div>'
                    + '</div>');
            } else {
                $('.loginitem_h').empty();
                $('.loginitem_h').append('<a href="logon-youpu.html" class="link header_login">注册</a>'
                    + ' <a href="logon-youpu.html" class="link header_register">登录</a>')
            }
        }
    })


});