<%@page pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(function () {
        $("#button").click(function () {
            var goEasy = new GoEasy({
                appkey: "BC-a36c38bc99ab4be39f74d7840201943e"
            });
            //GoEasy-OTP可以对appkey进行有效保护，详情请参考 7.GoEasy-OTP
            goEasy.publish({
                channel: "talk",
                message: $("#goeasy").val()
            });
            $("#goeasy").val("");
        });
    })
    var goEasy = new GoEasy({
        appkey: "BC-a36c38bc99ab4be39f74d7840201943e"
    });
    goEasy.subscribe({
        channel: "talk1",
        onMessage: function (message) {
            $("#talk").html(message.content);
        }
    });
</script>
<span id="talk"></span>
<input id="goeasy" type="text"/>
<input id="button" type="button" value="发送"/>
<a href="${pageContext.request.contextPath}/user/insertUser" javascript:void(0)>点我</a>

