var content;
var idproduct=parseInt(location.href.split("/")[4]);
var btnadd=document.getElementById("add_cart");
var url="/api/content/"+location.href.split("/")[4];
var listSize=document.getElementsByName("optradio");
function addCart() {
    var listItem=[];
    var item={
        id:idproduct,
        amount:1,
        size:"S",
        price:parseInt(document.getElementById("price").innerText.replace(/,/g,""))
    };
    for(var i=0;i<listSize.length;i++)
    {
        if(listSize[i].checked===true){item.size=listSize[i].value};
    }
    if(localStorage.getItem("cart_item")===null)
    {
        listItem.push(item);
        localStorage.setItem("cart_item",JSON.stringify(listItem));
    }
    else
    {
        listItem=JSON.parse(localStorage.getItem("cart_item"));
        if(listItem.find(e=>e.id==idproduct))
        {
            listItem.find(e=>e.id==idproduct).size=item.size;
            localStorage.setItem("cart_item",JSON.stringify(listItem));
            return;
        }
        listItem.push(item);
        localStorage.setItem("cart_item",JSON.stringify(listItem));
    }
}
function uploadContent() {
    var root=document.getElementById("des");
    var des=Array.isArray(content.des)?content.des[0]:content.des;
    root.innerText=des.replace(". ","\n");
    var img=document.getElementById("lsimg");
    var htmlImg="";
    for(var i=0;i<content.img.length;i++)
    {
        htmlImg+=" <img\n" +
            "            src=\""+content.img[i]+"\"" +
            "            alt=\"\">"
    }
    img.innerHTML=htmlImg;
}
function uploadSize(data) {
    var root=document.getElementById("size");
    var body="";
    body+=HtmlRadioButton("XL",data.XL);
    body+=HtmlRadioButton("XS",data.XS);
    body+=HtmlRadioButton("L",data.L);
    body+=HtmlRadioButton("M",data.M);
    body+=HtmlRadioButton("S",data.S);
    body+=HtmlRadioButton("2XL",data["2XL"]);
    root.innerHTML=body;
}
function HtmlRadioButton(size,sl) {
    var re="";
    if(sl>0){
        re="<div class=\"form-check\">\n" +
            "            <label class=\"form-check-label\">\n" +
            "              <input type=\"radio\" checked class=\"form-check-input\" name=\"optradio\" value=\""+size+"\">"+size+"\n" +
            "            </label>\n" +
            "          </div>";
    }
    else re="<div class=\"form-check\">\n" +
        "            <label class=\"form-check-label\">\n" +
        "              <input type=\"radio\" disabled='true' class=\"form-check-input\" name=\"optradio\" value=\""+size+"\">"+size+"\n" +
        "            </label>\n" +
        "          </div>";
    return re;
}
function doWork() {
    axios.get(url).then(re=>{
        content=re.data;
        uploadContent();
    });
    axios.get("/api/size/"+location.href.split("/")[4]).then(
        re=>uploadSize(re.data)
    );
    $(btnadd).click(function () {
        addCart();
    });
    console.log("test")
}
doWork();