var data;
var root;
var max=12;
var now=0;
root=$("#box_item");
var body=document.getElementsByTagName("body")[0];
axios.get("/api/category/"+window.location.href.split("/").slice(-1)[0])
    .then(re=>{data=re.data;upload()})
    .catch(error=>{root.innerHTML="Đã có lỗi xảy ra"});
function upload()
{
    for(var i=now;i<max;i++)
    {
           root.append("<div class=\"_1sanpham\" role=\"listitem\">\n" +
                    "                <a href=\""+"product/"+data[i].id +"\"><img alt=\"sanpham1\" class=\"anhsanpham\"\n" +
                    "                        src="+data[i].url1 +
                    "                        alt=\"\"></a>\n" +
                    "                <p style=\" margin-top: 10px;\">"+data[i].name+"</p>\n" +
                    "                <p>"+data[i].price+"</p>\n" +
                    "            </div>");
    }
    now=max;
}
console.log("test");
window.addEventListener("scroll", function(){
    var maxY;
    if(window.scrollMaxY!==undefined){maxY=window.scrollMaxY}
    else maxY=document.documentElement.scrollHeight;
    if(maxY-scrollY<1500&&max===now&&max<data.length){
        if(max+12>data.length){
            max=data.length;
            document.getElementById("loadingGif").innerHTML="";
        }
        else max+=12;
        timer=setInterval(function () {
            if(document.getElementsByClassName("anhsanpham")[now-1].complete)
            {
                upload();
                clearInterval(timer);
            }
        })
    }
});