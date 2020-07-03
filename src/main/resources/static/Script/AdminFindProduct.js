jQuery(function () {
    jQuery("#ProductName").click(function () {
        console.log("click")
        jQuery.post("/AdminFindDetailByNameOrClass2",{"id": jQuery("#searchbar").val()},function (result) {
            console.log(result)
            var body = "";
            for(var i = 0; i < result.length; i++)
            {
                var json=result[i];
                //开始添加
                body+="<tr>";
                //添加商品名字和图片信息
                body += "<td class='table_product_des'>";
                //添加商品图片信息
                body += "<img src=" + json.photo + " class='product_img'>"
                body += "</td>";
                //添加商品名
                body+="<td>";
                body += json.name;
                body += "</td>";
                //添加用大类别
                body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.name1 + "</td>"
                //添加小类别
                body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.name2 + "</td>"
                //添加商品价格
                body += "<td style='vertical-align: center; text-align: center; background-color: #FFFFFF'>" + json.price + "</td>"


                //添加商品
                body+="</tr>";
            }
            console.log(body)
            jQuery("#tbody1").html(body)
        })
    })
})
