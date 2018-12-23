<%@ page pageEncoding="UTF-8" %>

<script type="text/javascript">
    $(function () {
        $("#AddChaptertitle").validatebox({
            required: true
        });
        $("#AddChaptersize").validatebox({
            required: true
        });
        $("#AddChapterduration").validatebox({
            required: true
        });
        $("#AddChapterupddate").datebox({
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
        $("#AddChapteralbumid").validatebox({
            required: true
        });


        $("#AddChapterButton").linkbutton({
            onClick: function () {
                var row = $("#album").edatagrid("getSelected");
                $("#AddChapteralbumid").val(row.id);
                //调用from中的submit方法
                $("#AddChapterForm").form("submit", {
                    url: "${pageContext.request.contextPath}/chapter/insertChapter",//提交到哪里去
                    onSubmit: function () {
                        return $("#AddChapterForm").form("validate");
                    }, //提交之前触发
                    success: function () {
                        $.messager.show({
                            title: "标题",
                            msg: "保存成功",
                            timeout: 1000
                        });
                        $("#AddChapter").dialog("close");
                        $("#album").treegrid("load");
                    } //成功后触发
                });
            }
        });
    });
</script>
<form id="AddChapterForm" enctype="multipart/form-data" method="post">
    名称:<input id="AddChaptertitle" name="title"/></br>
    大小:<input id="AddChaptersize" name="size"/></br>
    时长:<input id="AddChapterduration" name="duration"/></br>
    音频:<input type="file" name="fi3"/></td></br>
    上传日期:<input id="AddChapterupddate" name="upddate"/></br>
    <input id="AddChapteralbumid" name="albumid" hidden/></br>
    <a id="AddChapterButton">确定</a>
</form>
