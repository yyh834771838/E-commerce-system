jQuery(function () {
    jQuery("#confirmorder").click(function () {

    })
})
function getOrderId() {
    var cookies=document.cookie.split(";");
    for(var i=0;i<cookies.length;i++)
    {
        var cookie=cookies[i].trim();
        if(cookie.indexOf("menu_id")==0)
        {
            var m=cookie.substring("menu_id".length+1);
            jQuery.post("/getCartInfo",{"menu_id":m},function (CartInfo) {
                console.log("the length of the CartInfo is: " + CartInfo.length)
                var body = ""
                body += "<br/>"
                body += "<br/>"
                body +=  "<p style='font-size: 300%'>Thanks for your purchase! </p>"
                body += "<br/>"
                body += "<br/>"
                for(var i = 0; i<CartInfo.length;i++)
                {
                    var json = CartInfo[i]
                    body += "<p style='font-size: 150%'>以下是您的订单信息请您确认:</p>"
                    body += "<p style='font-size: 120%'>用户: " + json."</p>"
                }
            },"json");
            return;
        }
    }
}
