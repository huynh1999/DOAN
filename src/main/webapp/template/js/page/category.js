var data;
var root;
var max=12;
var now=0;
root=document.getElementById("box_item");
axios.get("/api/findAllNike").then(re=>{data=re.data;upload()});
function upload()
{
    for(var i=now;i<max;i++)
    {
        var htmlNow=root.innerHTML;
        root.innerHTML=htmlNow+"<div class=\"_1sanpham\" role=\"listitem\">\n" +
            "                <a href=\""+"product/"+data[i].id +"\"><img alt=\"sanpham1\" class=\"anhsanpham\"\n" +
            "                        src="+data[i].url1 +
            "                        alt=\"\"></a>\n" +
            "                <p style=\" margin-top: 10px;\">"+data[i].name+"</p>\n" +
            "                <p>"+data[i].price+"</p>\n" +
            "            </div>"
    }
    now=max;
}
window.addEventListener("scroll",function(){
    var maxY;
    if(window.scrollMaxY!==undefined){maxY=window.scrollMaxY}
    else maxY=document.documentElement.scrollHeight;
    console.log(maxY-scrollY);
    if(maxY-scrollY<1500){
        if(max+12>data.length){
            max=data.length;
        }
        else max+=12;
        upload();
    }
})