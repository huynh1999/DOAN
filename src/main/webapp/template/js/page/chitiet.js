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
    root.innerText=content.des[0].replace(". ","\n");
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
function doWork() {
    axios.get(url).then(re=>{
        content=re.data;
        uploadContent();
    })
    $(btnadd).click(function () {
        addCart();
    });
}
doWork();