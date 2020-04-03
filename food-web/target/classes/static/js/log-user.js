$(function () {

    $("#nl_gozc").click(function () {
        if ($(this).attr("opened") == 0) {
            $("#nl_more_zc").slideDown();
            $(this).html("已有账号？立即登录");
            $(this).attr("opened", "1");
            $("#msj_loginbox").slideUp();
        } else {
            $("#nl_more_zc").slideUp();
            $(this).html("没有账号？立即注册");
            $(this).attr("opened", "0");
            $("#msj_loginbox").slideDown();
        }
    });

});