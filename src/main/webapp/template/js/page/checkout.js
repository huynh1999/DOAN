var listItem=JSON.parse(localStorage.getItem("cart_item"));
var root=document.getElementById("root");
async function LoadData() {
    for(var i=0;i<listItem.length;i++)
    {
        var data=listItem[i];
        await axios.get("/api/product/"+data.id).then(re=>{
            ShowData(i+1,re.data)
        })
    }
}
function ShowData(index,data) {
    root.innerHTML=root.innerHTML+"<tr class=\"mathang\">\n" +
        "                            <th scope=\"row\">"+index+"</th>\n" +
        "                            <td><img class=\"anhsanpham thugon\"\n" +
        "                                    src=\""+data.url1+"\"\n" +
        "                                    alt=\"anh sp\"></td>\n" +
        "                            <td>\n" +"<input class='idproduct' value='"+data.id+"' hidden>"+
        "                                <h6>"+data.name+"</h6>\n" +
        "                                <div class=\"form-group mycustomformgroup\">\n" +
        "                                    <div class=\"mycustomformgroup_c1\">\n" +
        "                                        <label class=\"lbsize\" for=\"size\">Size</label>\n" +
        "                                    </div>\n" +
        "                                    <div class=\"mycustomformgroup_c2\">\n" +
        "                                        <select class=\"form-control mycustomselect\" name=\"size\" >\n" +
        "                                            <option value=\"S\">S</option>\n" +
        "                                            <option value=\"XS\">XS</option>\n" +
        "                                            <option value=\"2XL\">2XL</option>\n" +
        "                                            <option value=\"M\">M</option>\n" +
        "                                            <option value=\"L\">L</option>\n" +
        "                                            <option value=\"XL\">XL</option>\n" +
        "                                        </select>\n" +
        "                                    </div>\n" +
        "                                </div>\n" +
        "                                <div class=\"form-group mycustomformgroup\">\n" +
        "                                    <div class=\"mycustomformgroup_c1\">\n" +
        "                                        <label class=\"lbsoluong\" >Số lượng</label>\n" +
        "                                    </div>\n" +
        "                                    <div class=\"mycustomformgroup_c2\">\n" +
        "                                        <select class=\"form-control mycustomselect mycustomselectsl\" name=\"amount\">\n" +
        "                                            <option value=\"1\">1</option>\n" +
        "                                            <option value=\"2\">2</option>\n" +
        "                                            <option value=\"3\">3</option>\n" +
        "                                            <option value=\"4\">4</option>\n" +
        "                                            <option value=\"5\">5</option>\n" +
        "                                            <option value=\"6\">6</option>\n" +
        "                                            <option value=\"7\">7</option>\n" +
        "                                            <option value=\"8\">8</option>\n" +
        "                                            <option value=\"9\">9</option>\n" +
        "                                            <option value=\"10\">10</option>\n" +
        "                                        </select>\n" +
        "                                    </div>\n" +
        "\n" +
        "                                </div>\n" +
        "                                <button type=\"button\" class=\"btn btn-danger deleteBtn\">Xóa</button>\n" +
        "                            </td>\n" +
        "                            <td>\n" +
        "                                <p class=\"gia\">"+data.price+"</p>\n" +
        "                            </td>\n" +
        "                        </tr>"
}
function deleteItemCart(id,index) {console.log(index)
    listItem=JSON.parse(localStorage.getItem("cart_item"));
    listItem= $.grep(listItem, function(e){
        return e.id != id;
    });
    console.log(listItem)
    localStorage.setItem("cart_item",JSON.stringify(listItem));
    $("th").each(function () {
        var indexid=parseInt(index);
        var indexnow=parseInt($(this).text());
        if(indexid<indexnow){$(this).text(--indexnow)};
    })
}
function ChangeSize(selectElement)
{
    selectElement.addEventListener("change",function(){
        var idproduct=$(this).parents("tr").find("input[hidden]").val();
        var option=$(this).find("option");
        for(var i=0;i<option.length;i++){
            if(option[i].selected){
                var listItem=JSON.parse(localStorage.getItem("cart_item"));
                listItem.find(e=>e.id==idproduct).size=option[i].value;
                localStorage.setItem("cart_item",JSON.stringify(listItem));
            }
        }
    })
}
function ChangeAmount(selectElement) {
    selectElement.addEventListener("change",function () {
        var idproduct=$(this).parents("tr").find("input[hidden]").val();
        var option=$(this).find("option");
        for(var i=0;i<option.length;i++){
            if(option[i].selected){
                var listItem=JSON.parse(localStorage.getItem("cart_item"));
                listItem.find(e=>e.id==idproduct).amount=parseInt(option[i].value);
                localStorage.setItem("cart_item",JSON.stringify(listItem));
            }
        }
        SetTotalPrice();
    })
}
function SetSizeAndAmount()
{
    var sizeSelect=$("select[name=size]");
    var amountSelect=$("select[name=amount]");
    for(var i=0;i<sizeSelect.length;i++)
    {
        ChangeSize(sizeSelect[i]);
        ChangeAmount(amountSelect[i]);
    }
}
function SetDefaultValue()
{
    var row=document.getElementsByClassName("mathang");
    for(var i=0;i<row.length;i++)
    {
        var size=$(row[i]).find("select[name=size]").find("option");
        var amount=$(row[i]).find("select[name=amount]").find("option");
        var listItem=JSON.parse(localStorage.getItem("cart_item"));
        var sizeInfo=listItem[i].size;
        var index=listItem[i].amount-1;
        for(var j=0;i<size.length;j++)
        {
            if(size[j].value===sizeInfo){
                size[j].setAttribute("selected","selected");
                break;
            }
        }
        amount[index].setAttribute("selected","selected");
    }
}
function SetTotalPrice()
{
    var element=document.getElementById("tong");
    var listItem=JSON.parse(localStorage.getItem("cart_item"));
    var total=0;
    for(var i=0;i<listItem.length;i++)
    {
        total+=parseInt(listItem[i].amount)*parseInt(listItem[i].price);
    }
    element.innerText=total+"đ";
}
async function doWork() {
    await LoadData();
    $(".deleteBtn").click(function()
    {
        var index=$(this).parents("tr").find("th").text();
        var idproduct=$(this).parents("tr").find("input.idproduct").val();
        $(this).parents("tr").remove();
        deleteItemCart(idproduct,index);
    });
    SetSizeAndAmount();
    SetDefaultValue();
    SetTotalPrice();
}
doWork();
