var content;
var idproduct=location.href.split("/")[4];
var btnadd=document.getElementById("add_cart");
var url="/api/content/"+location.href.split("/")[4];
axios.get(url).then(re=>{
    content=re.data;
    uploadContent();
})
function addCart() {
    var listItem=[];
    var item={
        id:idproduct,
        amount:1
    };
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
            return;
        }
        listItem.push(item);
        localStorage.setItem("cart_item",JSON.stringify(listItem));
    }
}
$(btnadd).click(function () {
    addCart();
});
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
