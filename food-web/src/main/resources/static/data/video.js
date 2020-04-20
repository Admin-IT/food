$(function () {
    $.ajax({
        url: './get_videos',
        method: 'get',
        data: {"pageNum": 1, "pageSize": 5},
        success: function (result) {
            if (result.code === 500) {
                alert(result.message)
            } else {
                addTable(result.data);
                page(result.data);
            }
        }
    })
});

//渲染表格
function addTable(pageInfo) {
    $('#v_list').empty();
    $.each(pageInfo.list, function (i, s) {
        $('#v_list').append(
            '<div class="v_item">' +
            '<a href="menu-video-details.html?id=' + s.id + '">' +
            '<div class="c1">' +
            '<video class="v_img" src="upload/' + s.name + '" width="330px" height="185px"></video>' +
            '<div class="v_time">' + s.number + '次播放</div>' +
            '<div class="v_length">' + s.time.substring(0, 10) + '</div>' +
            '<div class="v_cover"></div></div>' +
            '<div class="c2">' +
            '<strong class="v_name">' + s.label + '</strong>' +
            '</div></a></div>'
        );
    });
}

//分页
function page(pageInfo) {
    $("#page").pagination(pageInfo.total, { //第一个参数指定共多少条记录
        items_per_page: pageInfo.pageSize, // 每页显示多少条记录
        next_text: "下一页", //下一页按钮图标
        prev_text: "上一页", //上一页按钮图标
        num_display_entries: 2,//主体页数
        num_edge_entries: 3, //边缘页数
        callback: function (index) {//定义一个回调函数，用于每次点击页码发起分页查询请求
            //index为当前页码，只不过下标是从0开始，因此需要+1操作
            var pageNum = ++index;
            $.ajax({
                url: './get_videos',
                method: 'get',
                data: {'pageNum': pageNum, 'pageSize': 5},
                success: function (result) {
                    //渲染表格
                    addTable(result.data);
                }
            });
        }
    })
}
