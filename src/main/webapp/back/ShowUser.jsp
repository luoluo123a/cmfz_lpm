<%@ page pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(function () {
        var id;
        var toolbar = [{
            iconCls: 'icon-add',
            text: '导入',
            handler: function () {
                location.href = "${pageContext.request.contextPath}/poi/userImport"
            }
        }, '-', {
            iconCls: 'icon-add',
            text: '导出',
            handler: function () {
                location.href = "${pageContext.request.contextPath}/poi/userExport"
            }
        }]
        $('#usertable').edatagrid({
            url: '${pageContext.request.contextPath}/user/queryAll',
            columns: [[
                {field: 'id', title: 'id', width: 100},
                {field: 'phone', title: '电话', width: 100},
                {field: 'pwd', title: '密码', width: 100},
                {field: 'salt', title: '盐', width: 100},
                {field: 'sign', title: '标志', width: 100},
                {field: 'headpic', title: '头像', width: 100, align: 'right'},
                {field: 'name', title: '姓名', width: 100, align: 'right'},
                {field: 'dharma', title: '法号', width: 100, align: 'right'},
                {field: 'sex', title: '性别', width: 100, align: 'right'},
                {field: 'province', title: '省', width: 100, align: 'right'},
                {field: 'city', title: '地址', width: 100, align: 'right'},
                {field: 'status', title: '状态', width: 100, align: 'right'},
                {field: 'regdate', title: '注册日期', width: 100, align: 'right'}

            ]],
            toolbar: toolbar,
            //自动变化列的大小，以适应网格的宽度，防止水平滚动。
            fitColumns: true,
            fit: true

        });
    })
</script>
<table id="usertable"></table>
<div id="AddBanner"></div>


