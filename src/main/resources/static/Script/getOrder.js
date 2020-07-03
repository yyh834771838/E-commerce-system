function setTableHeader(body){
    body += "<tr>"
    body += "<th class='tableheader_product'>宝贝</th>"
    body += "<th class='tableheader_price'>单价</th>"
    body += "<th class='tableheader_num'>数量</th>"
    body += "<th class='tableheader_num'>功能</th>"
    body += "<th class='tableheader_state'>交易状态</th>"
    body += "<th class='tableheader_time'>下单时间</th>"
    body += "</tr>"
    return body
}
jQuery("#comment").hide();
var OrderInfo;
var cur_user_id=0;
jQuery("#top_page").load("top.html");
getStatus();
jQuery(function () {
    jQuery("#allorder").click(function () {
            getStatus();
            console.log("the click")
            //getorderInfo();
        })
})
function showorder() {
    var body = ""
    body = setTableHeader(body)
    if (NamePriceList.length != 0) {
        for (var i = 0; i < NamePriceList.length; i++) {
            var json = NamePriceList[i];
            //开始添加
            body += "<tr>";
            //添加商品名字和图片信息
            body += "<td class='table_product_des'>";
            //添加商品图片信息
            body += "<img src=" + json.photo +  " alt='图片一' class='product_img'>"
            body += json.name;
            body += "</td>";
            //添加商品单价信息
            body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.pro_price + "</td>"
            //添加商品数量信息
            body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.pro_number + "</td>"
            //添加商品操作信息
            body += "<td style='vertical-align: center; text-align: center;background-color: #FFFFFF'>" +
                "<a href='#' onclick='showComment(\""+json.pro_id+"\",\""+json.user_id+"\")'>评论</a>" + "</td>"
            //添加商品状态
            body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.status + "</td>"
            //添加下单时间
            body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.time + "</td>"
            //添加商品
            body += "</tr>";
        }
    } else {
        body += "<tr>";
        body += "<td style='font-size: 200%'>";
        body += "没有符合条件的商品"
        body += "</td>";
        body += "</tr>";
    }
}

function showComment(pro_id,user_id) {
    jQuery("#pro_id").val(pro_id);
    jQuery("#user_id").val(user_id);
    jQuery("#comment").show();
}
function comment(){
    var text=jQuery("#commentArea").val();
    var pro_id=jQuery("#pro_id").val();
    var user_id=jQuery("#user_id").val();
    jQuery.post("/comment",{"pro_id":pro_id,"user_id":user_id,"text_content":text},function (rst) {
        alert(rst);
        if(rst=="评论成功")
        {
            jQuery("#comment").hide();
        }
    })
}
//get user id
function getStatus() {
    var cookies = document.cookie.split(";");
    console.log(cookies)
    for (var i = 0; i < cookies.length; i++) {
        var cookie = cookies[i].trim();
        if (cookie.indexOf("info") == 0) {
            var m = cookie.substring("info".length + 1);
            m = m.substring(3);
            m = m.substring(0, m.length - 4);
            console.log(m)
            jQuery.post("/getOrderInfo", {"username": m}, function (NamePriceList) {
                console.log(NamePriceList)
                OrderInfo = NamePriceList
                var body = ""
                body = setTableHeader(body)
                if (NamePriceList.length != 0) {
                    for (var i = 0; i < NamePriceList.length; i++) {
                        var json = NamePriceList[i];
                        //开始添加
                        body += "<tr>";
                        //添加商品名字和图片信息
                        body += "<td class='table_product_des'>";
                        //添加商品图片信息
                        body += "<img src=" + json.photo +  " alt='图片一' class='product_img'>"
                        body += json.pname;
                        body += "</td>";
                        //添加商品单价信息
                        body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.pro_price + "</td>"
                        //添加商品数量信息
                        body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.pro_number + "</td>"
                        //添加商品状态
                        body += "<td style='vertical-align: center; text-align: center;background-color: #FFFFFF'>" +
                            "<a href='#' onclick='showComment(\""+json.pro_id+"\",\""+json.user_id+"\")'>评论</a>" + "</td>"
                        body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.status + "</td>"
                        //添加下单时间
                        body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.time + "</td>"
                        //添加商品
                        body += "</tr>";
                    }
                } else {
                    body += "<tr>";
                    body += "<td style='font-size: 200%'>";
                    body += "您尚未购买过商品"
                    body += "</td>";
                    body += "</tr>";
                }
                jQuery("#tbody").html(body)
            }, "json")
        }
    }
}
function getorderInfo() {
        jQuery.post("/getOrderInfo", {"user_id": cur_user_id}, function (NamePriceList) {
            OrderInfo = NamePriceList
            var body = ""
            body = setTableHeader(body)
            if (NamePriceList.length != 0) {
                for (var i = 0; i < NamePriceList.length; i++) {
                    var json = NamePriceList[i];
                    //开始添加
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
                    body += "<td style='vertical-align: center; text-align: center;background-color: #FFFFFF'>" +
                        "<a href='#' onclick='showComment(\""+json.pro_id+"\",\""+json.user_id+"\")'>评论</a>" + "</td>"
                    //添加商品状态
                    body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.status + "</td>"
                    //添加下单时间
                    body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.time + "</td>"
                    //添加商品
                    body += "</tr>";
                }
            } else {
                body += "<tr>";
                body += "<td style='font-size: 200%'>";
                body += "您尚未购买过商品"
                body += "</td>";
                body += "</tr>";
            }
            jQuery("#tbody").html(body)
        })
    }

//根据商品名称查询订单
    jQuery(function () {
        jQuery("#searchbutton").click(function () {
            var body = ""
            var wantedName = jQuery('#searchbar').val()
            body = setTableHeader(body)
            for (var i = 0; i < OrderInfo.length; i++) {
                var json = OrderInfo[i]
                console.log(OrderInfo)
                //如果输入的值和返回来的订单中的商品名相同,则展示其信息
                if (json.pname == wantedName) {
                    console.log("correspond")
                    body += "<tr>";
                    //添加商品名字和图片信息
                    body += "<td class='table_product_des'>";
                    //添加商品图片信息
                    body += "<img src=" + json.photo +  " alt='图片一' class='product_img'>"
                    body += json.pname;
                    body += "</td>";
                    //添加商品单价信息
                    body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.pro_price + "</td>"
                    //添加商品数量信息
                    body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.pro_number + "</td>"
                    //添加商品操作信息
                    body += "<td style='vertical-align: center; text-align: center;background-color: #FFFFFF'>" +
                        "<a href='#' onclick='showComment(\""+json.pro_id+"\",\""+json.user_id+"\")'>评论</a>" + "</td>"
                    //添加商品状态
                    body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.status + "</td>"
                    //添加下单时间
                    body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.time + "</td>"
                    //添加商品
                    body += "</tr>";
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
            if (OrderInfo.length != 0) {
                for (var i = 0; i < OrderInfo.length; i++) {
                    var json = OrderInfo[i]
                    console.log("the status is : " + json.status)
                    //如果输入的值和返回来的订单中的商品名相同,则展示其信息
                    if (json.status == 0) {
                        console.log("correspond")
                        body += "<tr>";
                        //添加商品名字和图片信息
                        body += "<td class='table_product_des'>";
                        //添加商品图片信息
                        body += "<img src=" + json.photo +  " alt='图片一' class='product_img'>"
                        console.log("<img src=" + json.photo +  " alt='图片一' class='product_img'>")
                        body += json.pname;
                        body += "</td>";
                        //添加商品单价信息
                        body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.pro_price + "</td>"
                        //添加商品数量信息
                        body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.pro_number + "</td>"
                        //添加商品状态
                        body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.status + "</td>"
                        //添加下单时间
                        body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.time + "</td>"
                        //添加商品
                        body += "</tr>";
                    }
                }
            } else {
                body += "<tr>";
                body += "<td style='font-size: 200%'>";
                body += "您尚未购买过商品"
                body += "</td>";
                body += "</tr>";
            }
            jQuery("#tbody").html(body)
        })
    })