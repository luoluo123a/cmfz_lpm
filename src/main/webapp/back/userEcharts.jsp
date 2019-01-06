<%@page pageEncoding="UTF-8" %>
<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main" style="width: 600px;height:400px;"></div>

<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));
    var option = {
        title: {
            text: ' 用户注册详情',
            subtext: '人数'
        },
        tooltip: {},
        legend: {
            type: "scroll",
            data: ['人数']
        },
        xAxis: {
            data: ['近三个月', '近一星期', '近两星期', '近三星期']
        },
        yAxis: {},
    }

    myChart.setOption(option);
    $.ajax({
        url: "${pageContext.request.contextPath}/user/queryCountM",
        dataType: "JSON",
        success: function (data) {
            myChart.setOption({
                series: [{
                    // 根据名字对应到相应的系列
                    name: '人数',
                    data: data,
                    type: "line"
                }]
            })
        }
    })
    var goEasy = new GoEasy({
        appkey: "BC-a36c38bc99ab4be39f74d7840201943e"
    });
    goEasy.subscribe({
        channel: "140",
        onMessage: function (message) {
            var eval1 = eval("(" + message.content + ")");
            myChart.setOption({
                series: [{
                    // 根据名字对应到相应的系列
                    name: '人数',
                    data: eval1,
                    type: "line"
                }]
            })
        }
    });
</script>
