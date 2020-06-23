function uploadBrand(data) {
    var root = document.getElementById("categoryCode");
    var options="";
    for (var i = 1; i < data.length; i++)
    {
        options+="<option value='"+data[i]+"'>"+data[i]+"</option>";
    }
    root.innerHTML=options;
}
async function doWork() {
    await axios.get("/admin/api/getCategory").then(re=>{uploadBrand(re.data.split("|"))});

}
doWork();