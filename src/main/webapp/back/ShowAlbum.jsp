<%@ page pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(function () {
        var toolbar = [{
            iconCls: 'icon-edit',
            text: '专辑详情',
            handler: function () {
                //获取选中行
                var row = $("#album").edatagrid("getSelected");
                if (row != null) {
                    $("#SeleAlbum").dialog("open");
                    $("#SeleForm").form("load",
                        "${pageContext.request.contextPath}/album/queryById?id=" + row.id);
                } else {
                    $.messager.alert('我的消息', '请先选中行！', 'info');
                }
            }
        }, '-', {
            iconCls: 'icon-add',
            text: '添加专辑',
            handler: function () {
                $("#AddAlbum").dialog("open")
            }
        }, '-', {
            iconCls: 'icon-add',
            text: '添加章节',
            handler: function () {
                //获取选中行
                var row = $("#album").edatagrid("getSelected");
                if (row != null) {
                    if (row.duration != null) {
                        $.messager.alert('我的消息', '请先选中专辑！', 'info');
                    } else {
                        $("#AddChapter").dialog("open");
                    }
                } else {
                    $.messager.alert('我的消息', '请先选中专辑！', 'info');
                }
            }
        }, '-', {
            iconCls: 'icon-save',
            text: '下载音频',
            handler: function () {
                //获取选中行
                var row = $("#album").edatagrid("getSelected");
                if (row != null) {
                    if (row.duration != null) {
                        window.location.href = "${pageContext.request.contextPath}/chapter/download?url=" + row.url;
                    } else {
                        $.messager.alert('我的消息', '请先选中章节！', 'info');
                    }
                } else {
                    $.messager.alert('我的消息', '请先选中章节！', 'info');
                }
            }
        }]
        $('#album').treegrid({
            url: '${pageContext.request.contextPath}/album/queryAll',
            idField: 'id',
            treeField: 'title',
            columns: [[
                {field: 'title', title: '标题', width: 60},
                {field: 'size', title: '大小', width: 80},
                {field: 'duration', title: '时长', width: 80},
                {field: 'url', title: '下载路径', width: 80},
                {field: 'upddate', title: '上传时间', width: 80}
            ]],
            onDblClickRow: function (row) {
                if (row.size != null) {
                    var player = $("#audio")[0];
                    if (player.paused) {
                        player.play();
                        $("#audio").prop("src", "${pageContext.request.contextPath}" + row.url);
                    } else {
                        player.pause();
                    }
                }
            },
            toolbar: toolbar,
            fitColumns: true,
            fit: true,
        });
    })
    $("#SeleAlbum").dialog({
        modal: true,
        title: "详情",
        closed: true,
        cache: false,
        width: 300,
        height: 200
    });
    //初始化添加专辑页面
    $("#AddAlbum").dialog({
        title: "添加专辑",
        closed: true,
        width: 300,
        cache: false,
        height: 200,
        href: "${pageContext.request.contextPath}/back/addalbum.jsp",
        resizable: true
    });
    //初始化添加章节页面
    $("#AddChapter").dialog({
        title: "添加章节",
        closed: true,
        width: 300,
        cache: false,
        height: 200,
        href: "${pageContext.request.contextPath}/back/addchapter.jsp",
        resizable: true
    });
</script>
<table id="album"></table>
<div id="AddAlbum"></div>
<div id="AddChapter"></div>
<div id="SeleAlbum">
    <form id="SeleForm" method="post">
        id：<input id="Sid" name="id" readonly/></br>
        名称:<input id="Stitle" name="title" readonly/></br>
        数量:<input id="Scount" name="count" readonly/></br>
        图片路径:<input id="Scoverimg" name="coverimg" readonly/></br>
        分数:<input id="Sscore" name="score" readonly/></br>
        作者:<input id="Sauthor" name="author" readonly/></br>
        播音:<input id="Sbroadcast" name="broadcast" readonly/></br>
        简介:<input id="Sbrief" name="brief" readonly/></br>
        发布日期:<input id="Spubdate" name="pubdate" readonly/></br>
    </form>
</div>
<audio id="audio" autoplay controls></audio>


