<%@ page pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(function () {
        var id;
        var toolbar = [{
            iconCls: 'icon-add',
            text: '添加',
            handler: function () {
                $("#AddBanner").dialog("open")
            }
        }, '-', {
            iconCls: 'icon-edit',
            text: '修改',
            handler: function () {
                //获取选中行
                var row = $("#dg").edatagrid("getSelected")
                if (row != null) {
                    //编辑指定行
                    var a = $("#dg").edatagrid("getRowIndex", row);
                    $("#dg").edatagrid("editRow", a);
                } else {
                    $.messager.alert('我的消息', '请先选中行！', 'info');


                }
            }
        }, '-', {
            iconCls: 'icon-remove',
            text: '删除',
            handler: function () {
                var b = $("#dg").edatagrid("getSelected");
                $.post(
                    "${pageContext.request.contextPath}/banner/deleteBanner",
                    "id=" + b.id,
                    function (res) {
                        $.messager.alert('提示', '删除信息');
                    }, "JSON"
                );
                $("#dg").edatagrid("reload");
            }
        }, '-', {
            iconCls: 'icon-save',
            text: '保存',
            handler: function () {
                $("#dg").edatagrid("saveRow")
            }
        }]
        $('#dg').edatagrid({
            updateUrl: "${pageContext.request.contextPath}/banner/updateBanner",
            url: '${pageContext.request.contextPath}/banner/queryByPage',
            columns: [[
                {field: 'id', title: 'id', width: 100},
                {field: 'title', title: '名称', width: 100},
                {field: 'img_path', title: '图片', width: 100},
                {
                    field: 'status', title: '状态', width: 100, editor: {
                        type: "text",
                        options: {required: true}
                    }
                },
                {field: 'pub_date', title: '上传日期', width: 100},
                {field: 'des', title: '描述', width: 100, align: 'right'}
            ]],
            toolbar: toolbar,
            //自动变化列的大小，以适应网格的宽度，防止水平滚动。
            fitColumns: true,
            fit: true,
            pagination: true,
            pageSize: 3,
            pageList: [3, 5, 8],
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}' + rowData.img_path + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>描述: ' + rowData.des + '</p>' +
                    '<p>状态:' + rowData.status + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }

        });
    })
    //初始化添加页面
    $("#AddBanner").dialog({
        title: "添加页面",
        closed: true,
        width: 300,
        cache: false,
        height: 200,
        href: "${pageContext.request.contextPath}/back/addbanner.jsp",
        resizable: true
    });
</script>
<table id="dg"></table>
<div id="AddBanner"></div>


