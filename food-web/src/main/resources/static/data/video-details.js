$(function () {
    /**
     * 从前一个界面获取数据id
     * @param name
     * @returns {string|null}
     */
    $.getUrlParam = function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]);
        return null;
    };
    //获取 上一个视频页面传来的分类字段值
    var searchUrl = window.location.href;
    var searchData = searchUrl.split("=");        //截取 url中的“=”,获得“=”后面的参数
    var searchText = decodeURI(searchData[2]);   //decodeURI解码
    /**
     * 显示前一个界面点击的视频
     */
    $.ajax({
        url: './get_video_msg',
        method: 'get',
        data: {"id": $.getUrlParam("id")},
        success: function (result) {
            if (result.code === 500) {
                alert(result.message)
            } else {
                $('#s_video').attr("src", "upload/" + result.data.name);
                $('#v_name').append(result.data.label);
                $('#v_title').append(result.data.label);
                $('#classified').attr("value", result.data.classified);
                $('#v_number').append(result.data.number + "次播放\t\t发布时间：" + result.data.time.substring(0, 10));
            }
        }
    });
    /**
     * 显示相关视频
     */
    $.ajax({
        url: './get_same_video',
        method: 'get',
        data: {"classified": searchText},
        success: function (result) {
            if (result.code === 500) {
                alert(result.message)
            } else {
                $.each(result.data, function (i, s) {
                    $('#same_video').append(
                        '<div class="recommend_item">' +
                        '<a href="menu-video-details.html?id=' + s.id + '">' +
                        '<div class="imgw"><video src="upload/' + s.name + '" width="120px" height="67px"></video></div>' +
                        '<div class="info">' +
                        '<strong>' + s.label + '</strong>' +
                        '<span>' + s.time.substring(0, 10) + '</span>' +
                        '</div></a></div>'
                    );
                    $('#v_list').append(
                        '<div class="v_item">' +
                        '<a href="menu-video-details.html?id=' + s.id + '">' +
                        '<div class="c1">' +
                        '<video src="upload/' + s.name + '" class="v_img"></video>' +
                        '<div class="v_time">' + s.number + '次播放</div>' +
                        '<div class="v_length">' + s.time.substring(0, 10) + '</div>' +
                        '<div class="v_cover"></div>' +
                        '</div>' +
                        '<div class="c2">' +
                        '<strong class="v_name">' + s.label + '</strong>' +
                        '</div>' +
                        '</a>' +
                        '</div>'
                    )
                })
            }
        }
    });
    $.ajax({
        url: './get_method',
        method: 'get',
        data: {"videoId": $.getUrlParam("id")},
        success: function (result) {
            if (result.code === 500) {
                alert(result.message)
            } else {
                $.each(result.data, function (i, s) {
                    $('#v_method').append(s.method)
                })
            }
        }
    })
});