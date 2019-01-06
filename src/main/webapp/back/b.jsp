<%@page pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(function () {
        $("#button1").click(function () {
            var goEasy = new GoEasy({
                appkey: "BC-a36c38bc99ab4be39f74d7840201943e"
            });
            //GoEasy-OTP可以对appkey进行有效保护，详情请参考 7.GoEasy-OTP
            goEasy.publish({
                channel: "talk1",
                message: $("#goeasy1").val()
            });
            $("#goeasy1").val("");
        });
    })
    var goEasy = new GoEasy({
        appkey: "BC-a36c38bc99ab4be39f74d7840201943e"
    });
    goEasy.subscribe({
        channel: "talk",
        onMessage: function (message) {
            $("#talk1").html(message.content);
        }
    });
</script>
<span id="talk1"></span>
<input id="goeasy1" type="text"/>
<input id="button1" type="button" value="发送"/>

