jQuery(function () {
    jQuery("#confirmOrder").click(function () {
        getOrderId()
    })
})
function getOrderId() {
    var cookies=document.cookie.split(";");
    var menu_id
    var body = ""
    for(var i=0;i<cookies.length;i++) {
        var cookie = cookies[i].trim();
        if (cookie.indexOf("menu_id") == 0) {
            menu_id = cookie.substring("menu_id".length + 1);
        }
    }
    console.log("the menu_id is: " + menu_id)
    jQuery.post("/getCartInfo",{"menu_id":1},function (CartInfo) {
                console.log(CartInfo)
                var json = CartInfo[0]
                body += "<br/>"
                body += "<br/>"
                body +=  "<p style='font-size: 300%'>Thanks for your purchase! </p>"
                body += "<br/>"
                body += "<br/>"
                body += "<p style='font-size: 150%'>以下是您的订单信息请您确认:</p>"
                body += "<p style='font-size: 120%'>用户: " + json.uname + "</p>"
                body += "<p style='font-size: 120%'>收货地址: " + json.province + json.city + json.area + "</p>"
                body += "<p style='font-size: 120%'>电话: " + json.number + "</p>"
                for(var i = 0; i<CartInfo.length;i++)
                {
                    json = CartInfo[i]
                    body += "<p style='font-size: 120%'>商品: " + json.pname + "</p>"
                }
                body
    console.log(body)
        jQuery("#confirmOrder").html(body)
            })
}
