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
                    if (row.duration != null) {
                        $.messager.alert('我的消息', '请先选中专辑！', 'info');
                    } else {
                        $("#SeleAlbum").dialog("open");
                        $("#SeleForm").form("load", row);
                        $("#Scoverimg").prop("src", "${pageContext.request.contextPath}/" + row.coverimg);

                    }

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
        }, '-', {
            iconCls: 'icon-add',
            text: '导入',
            handler: function () {
                location.href = "${pageContext.request.contextPath}/poi/userImport"
            }
        }, '-', {
            iconCls: 'icon-add',
            text: '导出',
            handler: function () {
                location.href = "${pageContext.request.contextPath}/poi/testExport"
            }
        }]
        $('#album').treegrid({
            url: '${pageContext.request.contextPath}/album/queryByPage',
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
            pagination: true,
            pageSize: 3,
            pageList: [3, 5, 8]
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
<div id="SeleAlbum" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">

    <form id="SeleForm" method="post">
        <div>
            <input class="easyui-validatebox" type="text" name="title" data-options="required:true"/>
        </div>
        <div>
            <input class="easyui-validatebox" type="text" name="count" data-options="required:true"/>
        </div>
        <div>
            <input class="easyui-validatebox" type="text" name="score" data-options="required:true"/>
        </div>
        <div>
            <input class="easyui-validatebox" type="text" name="author" data-options="required:true"/>
        </div>
        <div>
            <input class="easyui-validatebox" type="text" name="brief" data-options="required:true"/>
        </div>
        <div>
            <input class="easyui-validatebox" type="text" name="broadcast" data-options="required:true"/>
        </div>
        <div>
            <input class="easyui-validatebox" type="text" name="pubdate" data-options="required:true"/>
        </div>
        <div>
            <img src="" id="Scoverimg">
        </div>
    </form>

</div>
</div>
<audio id="audio" autoplay controls></audio>


