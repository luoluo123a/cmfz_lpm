<%@ page language="java" pageEncoding="utf-8" %>
<script type="text/javascript">

    function selectTab(name, icons, href) {
        //如果已经存在则选中
        if ($("#tt").tabs("exists", name)) {
            //选中
            $("#tt").tabs("select", name);
        } else {
            //如果不存在则创建
            $("#tt").tabs("add", {
                title: name,
                iconCls: icons,
                closable: true,
                href: "${pageContext.request.contextPath}/back/" + href
            });
        }
    }

    $(function () {
        //手风琴菜单选项卡
        $.post(
            "${pageContext.request.contextPath}/menu/queryAll",
            function (data) {
                $.each(data, function (index, obj) {
                    var content = "";
                    $.each(obj.list, function (i, o) {
                        content += "<a onclick='selectTab(\"" + o.name + "\",\"" + o.iconcls + "\",\"" + o.href + "\")' style='width:100%' class ='easyui-linkbutton' data-options='iconCls:\"" + o.iconCls + "\"'>" + o.name + "</a>";
                    });
                    $("#aa").accordion("add", {
                        title: obj.name,
                        content: content,
                        iconCls: obj.iconCls
                    });
                });
            },
            "JSON"
        );
    });

</script>
<div id="aa" class="easyui-accordion" data-options="fit:true">
</div>

