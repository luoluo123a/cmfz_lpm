<%@ page pageEncoding="UTF-8" %>

<script type="text/javascript">
    $(function () {
        $("#AddAlt").validatebox({
            required: true
        });
        $("#AddAc").validatebox({
            required: true
        });
        $("#AddAs").validatebox({
            required: true
        });
        $("#AddAa").validatebox({
            required: true
        });
        $("#AddAb").validatebox({
            required: true
        });
        $("#AddAbrief").validatebox({
            required: true
        });
        $("#AddADate").datebox({
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


        $("#AddAlbumButton").linkbutton({
            onClick: function () {
                //调用from中的submit方法
                $("#AddAlbumForm").form("submit", {
                    url: "${pageContext.request.contextPath}/album/insertAlbum",//提交到哪里去
                    onSubmit: function () {
                        return $("#AddAlbumForm").form("validate");
                    }, //提交之前触发
                    success: function () {
                        $.messager.show({
                            title: "标题",
                            msg: "保存成功",
                            timeout: 1000
                        });
                        $("#AddAlbum").dialog("close");
                        $("#album").treegrid("load");
                    } //成功后触发
                });
            }
        });
    });
</script>
<form id="AddAlbumForm" enctype="multipart/form-data" method="post">
    名称:<input id="AddAlt" name="title"/></br>
    数量:<input id="AddAc" name="count"/></br>
    封面:<input type="file" name="fi2"/></td></br>
    分数:<input id="AddAs" name="score"/></br>
    作者:<input id="AddAa" name="author"/></br>
    播音:<input id="AddAb" name="broadcast"/></br>
    简介:<input id="AddAbrief" name="brief"/></br>
    上传日期:<input id="AddADate" name="pubdate"/></br>
    <a id="AddAlbumButton">确定</a>
</form>
