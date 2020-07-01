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
            jQuery.post("/findIdByName",{"user_name":m},function (rst) {
                cur_user_id = rst;
            },"json");
            return;
        }
    }
}
