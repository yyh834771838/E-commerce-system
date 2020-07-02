jQuery(function () {
    jQuery("#confirmOrder").click(function () {
        getOrderId()
    })
})
function getOrderId() {
    var menu_id
    var body = ""
    jQuery.post("/getMemuNum", function (menu) {
        menu_id = menu;
        console.log("the menu id is: " + menu_id);
    });
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
        body += "<div class='right'><a href='index.html' class='button'><span>确认</span></a></div>"
        jQuery("#confirmOrder").html(body)
            })
}
