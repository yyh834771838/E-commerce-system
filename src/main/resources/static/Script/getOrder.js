function setTableHeader(body){
    body += "<tr>"
    body += "<th class='tableheader_product'>宝贝</th>"
    body += "<th class='tableheader_price'>单价</th>"
    body += "<th class='tableheader_num'>数量</th>"
    body += "<th class='tableheader_productop'>商品操作</th>"
    body += "<th class='tableheader_state'>交易状态</th>"
    body += "<th class='tableheader_time'>下单时间</th>"
    body += "</tr>"
    return body
}
var OrderInfo;
var cur_user_id=-1;
jQuery(function () {
    jQuery("#top_page").load("top.html");
    getStatus();
    function getStatus()
    {
        var cookies=document.cookie.split(";");
        for(var i=0;i<cookies.length;i++)
        {
            var cookie=cookies[i].trim();
            if(cookie.indexOf("info")==0)
            {
                var m=cookie.substring("info".length+1);
                m = m.substring(3);
                m = m.substring(0,m.length-4);
                jQuery.post("/findIdByName",{"user_name":m},function (rst) {
                    cur_user_id = rst;
                },"json");
                return;
                console.log("the current user id is" + cur_user_id)
            }
        }
    }
})

jQuery(function () {
    //在单击全部订单的按钮执行事件
    jQuery("#allorder").click(function () {
        jQuery.post("/getOrderInfo",{"user_id": cur_user_id}, function (NamePriceList) {
            OrderInfo = NamePriceList
            console.log("the length of the total list is: " + NamePriceList.length)
            var body = ""
            body = setTableHeader(body)
            if (NamePriceList.length!= 0)
            {
                for(var i = 0; i < NamePriceList.length; i++)
                {
                    var json=NamePriceList[i];
                    //开始添加
                    body+="<tr>";
                    //添加商品名字和图片信息
                    body+="<td class='table_product_des'>";
                    //添加商品图片信息
                    body += "<img src='images/iphone.jpg' alt='图片一' class='product_img'>"
                    body += json.name;
                    body += "</td>";
                    //添加商品单价信息
                    body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.pro_price + "</td>"
                    //添加商品数量信息
                    body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.pro_number + "</td>"
                    //添加商品操作信息
                    body += "<td style='vertical-align: center; text-align: center;background-color: #FFFFFF'>" + "评价跳转" + "</td>"
                    //添加商品状态
                    body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.status + "</td>"
                    //添加下单时间
                    body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.time + "</td>"
                    //添加商品
                    body+="</tr>";
                }
            }
            else {
                body+="<tr>";
                body +="<td style='font-size: 200%'>";
                body += "您尚未购买过商品"
                body +="</td>";
                body+="</tr>";
            }
            jQuery("#tbody").html(body)
        })
    })
})
//根据商品名称查询订单
jQuery(function () {
    jQuery("#searchbutton").click(function () {
        var body = ""
        var wantedName = jQuery('#searchbar').val()
        body = setTableHeader(body)
       for (var i=0; i< OrderInfo.length;i++){
           var json = OrderInfo[i]
           //如果输入的值和返回来的订单中的商品名相同,则展示其信息
           if (json.name == wantedName)
           {
               console.log("correspond")
               body+="<tr>";
               //添加商品名字和图片信息
               body+="<td class='table_product_des'>";
               //添加商品图片信息
               body += "<img src='images/iphone.jpg' alt='图片一' class='product_img'>"
               body += json.name;
               body += "</td>";
               //添加商品单价信息
               body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.pro_price + "</td>"
               //添加商品数量信息
               body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.pro_number + "</td>"
               //添加商品操作信息
               body += "<td style='vertical-align: center; text-align: center;background-color: #FFFFFF'>" + "评价跳转" + "</td>"
               //添加商品状态
               body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.status + "</td>"
               //添加下单时间
               body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.time + "</td>"
               //添加商品
               body+="</tr>";
           }
       }
        jQuery("#tbody").html(body)
    })
})

jQuery(function () {
    jQuery("#readyorder").click(function () {
        var body = ""
        body = setTableHeader(body)
        console.log("in the readyOrder the length of the OrderInfo is: " + OrderInfo.length)
        if (OrderInfo.length!=0)
        {
            for (var i=0; i< OrderInfo.length;i++){
                var json = OrderInfo[i]
                console.log("the status is : " + json.status)
                //如果输入的值和返回来的订单中的商品名相同,则展示其信息
                if (json.status == 0) {
                    console.log("correspond")
                    body += "<tr>";
                    //添加商品名字和图片信息
                    body += "<td class='table_product_des'>";
                    //添加商品图片信息
                    body += "<img src='images/iphone.jpg' alt='图片一' class='product_img'>"
                    body += json.name;
                    body += "</td>";
                    //添加商品单价信息
                    body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.pro_price + "</td>"
                    //添加商品数量信息
                    body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.pro_number + "</td>"
                    //添加商品操作信息
                    body += "<td style='vertical-align: center; text-align: center;background-color: #FFFFFF'>" + "评价跳转" + "</td>"
                    //添加商品状态
                    body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.status + "</td>"
                    //添加下单时间
                    body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.time + "</td>"
                    //添加商品
                    body += "</tr>";
                }
            }
        }
        else {
            body+="<tr>";
            body +="<td style='font-size: 200%'>";
            body += "您尚未购买过商品"
            body +="</td>";
            body+="</tr>";
        }
        jQuery("#tbody").html(body)
    })
})