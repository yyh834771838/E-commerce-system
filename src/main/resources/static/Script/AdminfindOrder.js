jQuery(function () {
    jQuery("#btn_sch").click(function () {
        jQuery.post("/AdminFindDetailByMenuid",{"id": jQuery("#name").val()},function (result) {
            console.log(result)
            var body = "";
            for(var i = 0; i < result.length; i++)
            {
                var json=result[i];
                //开始添加
                body+="<tr>";
                //添加订单号
                body+="<td>";
                body += json.menu_id;
                body += "</td>";
                //添加用户名信息
                body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.name + "</td>"
                //添加下单时间信息
                body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.time + "</td>"
                //添加商品id信息
                body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.pro_id + "</td>"
                //添加商品数量信息
                body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.pro_number + "</td>"
                //添加总金额信息
                body += "<td style='vertical-align: center; text-align: center;background-color: #FFFFFF'>" + json.total + "</td>"
                //添加付款状态信息
                body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.status + "</td>"
                //添加详情
                body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>"  + "</td>"
                //添加商品
                body+="</tr>";
            }
            console.log(body)
            jQuery("#tbody1").html(body)
        })
    })
})
