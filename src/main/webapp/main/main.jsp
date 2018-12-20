<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>持名法州主页</title>
    <link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../themes/IconExtension.css">
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
        <!--菜单处理-->
        function title(list) {
            console.log(list)
            if (list.length != 0) {
                var str = "";
                for (var i = 0; i < list.length; i++) {
                    console.log(list[i].title)
                    str = str + "<a href=''>" + list[i].title + "</a><br>";
                }
                return str;
            } else {
                return "<a href=''>空</a>"
            }
        }

        <%--function selectTab(name,icons,href){--%>
        <%--//如果已经存在则选中--%>
        <%--if($("#tt").tabs("exists",name)){--%>
        <%--//选中--%>
        <%--$("#tt").tabs("select",name);--%>
        <%--}else{--%>
        <%--//如果不存在则创建--%>
        <%--$("#tt").tabs("add",{--%>
        <%--title:name,--%>
        <%--iconCls:icons,--%>
        <%--closable:true,--%>
        <%--href:"${pageContext.request.contextPath}/back/"+href--%>
        <%--});--%>
        <%--}--%>
        <%--}--%>
        $(function () {
            $.post(
                "${pageContext.request.contextPath}/menu/queryAll",
                function (result) {
                    // console.log(result)
                    //console.log(result[0].list.length)
                    for (var i = 0; i < result.length; i++) {
                        console.log("result[i].id=" + result[i].id + "   result[i].title" + result[i].title)
                        $("#menu").accordion("add", {
                            //title:"新标题",
                            title: result[i].title,
                            //content:"新内容",
                            content: title(result[i].list),
                            selected: false
                        });
                    }

                },
                "JSON"
            )

        })
    </script>

</head>
<body class="easyui-layout">
<div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    <div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px">
        持名法州后台管理系统
    </div>
    <div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">
        欢迎您:${session.admin.name}&nbsp;<a href="" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a
            href="${pageContext.request.contextPath}/admin/quit" class="easyui-linkbutton"
            data-options="iconCls:'icon-01'">退出系统</a></div>
</div>
<div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    <div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体">&copy;百知教育 htf@zparkhr.com.cn</div>
</div>

<div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    <div id="menu" class="easyui-accordion">


    </div>
</div>
<div data-options="region:'center'">
    <div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
        <div title="主页" data-options="iconCls:'icon-neighbourhood',"
             style="background-image:url(${pageContext.request.contextPath }/main/image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
    </div>
</div>
</body>
</html>