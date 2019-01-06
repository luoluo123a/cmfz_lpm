<%@page pageEncoding="UTF-8" %>

<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main1" style="width: 600px;height:400px;"></div>
<script type="text/javascript" src="http://cdn-hangzhou.goeasy.io/goeasy.js"></script>

<script type="text/javascript">
    $(function () {
        var myMap = echarts.init(document.getElementById('main1'));

    option = {
        title: {
            text: '人数分布',
            left: 'center'
        },
        tooltip: {
            trigger: 'item'
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['用户数量']
        },
        visualMap: {
            min: 0,
            max: 2500,
            left: 'left',
            top: 'bottom',
            text: ['高', '低'],           // 文本，默认为数值文本
            calculable: true
        },
        toolbox: {
            show: true,
            orient: 'vertical',
            left: 'right',
            top: 'center',
            feature: {
                mark: {show: true},
                dataView: {show: true, readOnly: false},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        }
    };
        myMap.setOption(option)
    $.ajax({
        url: "${pageContext.request.contextPath}/user/queryProvince",
        dataType: "JSON",
        success: function (data) {
            myMap.setOption({
                series: [{
                    name: '用户数量',
                    type: 'map',
                    mapType: 'china',
                    roam: false,
                    label: {
                        normal: {
                            show: false
                        },
                        emphasis: {
                            show: true
                        }
                    },
                    data: data
                }]
            })
        }
    })
        // var goEasy = new GoEasy({
        //     appkey: "BC-a36c38bc99ab4be39f74d7840201943e"
        // });
        // goEasy.publish({
        //     channel: "140",
        //     message: "Hello, GoEasy!"
        // })
    })
</script>
