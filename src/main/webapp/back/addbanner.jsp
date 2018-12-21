<%@ page pageEncoding="UTF-8" %>

<script type="text/javascript">
    $(function () {
        $("#AddTitle").validatebox({
            required: true
        });
        $("#AddStatus").validatebox({
            required: true
        });
        $("#AddDate").datebox({
            required: true,
            editable: false,
            formatter: function (date) {
                var y = date.getFullYear();
                var m = date.getMonth() + 1;
                var d = date.getDate();
                return y + "-" + m + "-" + d;
            },
            parser: function (s) {
                var t = Date.parse(s);
                if (!isNaN(t)) {
                    return new Date(t);
                } else {
                    return new Date();
                }
            }
        });
        $("#AddDes").validatebox({
            required: true
        });


        $("#AddBannerButton").linkbutton({
            onClick: function () {
                //调用from中的submit方法
                $("#AddBannerForm").form("submit", {
                    url: "${pageContext.request.contextPath}/banner/insertBanner",//提交到哪里去
                    onSubmit: function () {
                        return $("#AddBannerForm").form("validate");
                    }, //提交之前触发
                    success: function () {
                        $.messager.show({
                            title: "标题",
                            msg: "保存成功",
                            timeout: 1000
                        });
                        $("#AddBanner").dialog("close");
                        $("#dg").datagrid("load");
                    } //成功后触发
                });
            }
        });
    });
</script>
<form id="AddBannerForm" enctype="multipart/form-data" method="post">
    姓名:<input id="AddTitle" name="title"/></br>
    图片:<input type="file" name="fi1"/></td></br>
    状态:<input id="AddStatus" type="radio" name="status" value="Y"/>显示
    <input type="radio" name="status" value="N"/>不显示</br>
    上传日期:<input id="AddDate" name="pub_date"/></br>
    描述:<input id="AddDes" name="des"/></br>
    <a id="AddBannerButton">确定</a>
</form>
