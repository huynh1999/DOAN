function SetupDefault()
{
    $(".loginclick").click(function () {
        event.preventDefault();
        $("#btshowlog").click();
    })
    $("#signuplink").click(function () {
        event.preventDefault();
        $("#btshowlogsignup").click();
    })
    if ($("a.logintextsc").text() != "Login") {
        $("a.logintextsc").addClass("dropdown-toggle");

        $("a.logintextsc").mouseenter(function () {
            $(".hidemydropdown").show();
        })
        $("a.logintextsc").mouseleave(function () {
            $(".hidemydropdown").mouseleave(function () {
                $(".hidemydropdown").hide();
            })
        })
    }
    //Check Username when Login
    async function apiUsername() {
        var redata="";
        var userName=$("[name=username]").val();
        await axios.post("/api/checkUsername",{
            username:userName
        }).then(re=>{
            redata=re.data;
        });
        return redata==="ok";
    }
    async function CheckUserName() {
        var t=await apiUsername();
        console.log(t);
        if(!t){
            $("#error-alert-register").show();
        }
        else {
            $("#error-alert-register").hide();
        }
    }
    $("#form_register").on('submit',async function (e) {
        e.preventDefault();
        var t=await apiUsername();
        if(t)
        {
            $("#form_register")[0].submit();
        }
    });
    $("[name=username]").change(function () {
        CheckUserName();
    });
    //Set value input in order to get css label login and register
    $("input").keyup(function () {
        $(this).attr("value",$(this).val());
    });
}
async function HtmlMenuType(type)
{
    var dataType;
    await axios.get("/api/getTypeNameMenu/"+type).then(re=>{
        dataType=re.data;
    });
    var html="<li class=\"menu_item\" id='type"+type+"' role=\"listitem\">" +
        "          <div class=\"list_down\">\n" +
        "              <a href=\"#\">"+dataType.nameType+"</a>\n" +
        "              <div class=\"dropdown_content\">\n" +
        "              </div>\n" +
        "          </div>\n" +
        "   </li>";
    $("ul.menu_list").append(html);
}
async function LoadMenu()
{
    var dataMenuApi;
    await axios.get("/api/getMenu").then(re=>dataMenuApi=re.data);
    var dataMenu=[];
    for(var i=0;i<dataMenuApi.length;i++)
    {
        var type=dataMenuApi[i].type;
        if(dataMenu[type-1]===undefined)dataMenu[type-1]="";
        dataMenu[type-1]+="<a class=\"sm_item\" href=\"/category/"+dataMenuApi[i].nameCategory+"\">"+dataMenuApi[i].nameMenu+"</a>";
    }
    for(var i=0;i<dataMenu.length;i++)
    {
        if(dataMenu[i]!==undefined)
        {
            var id="#type"+(i+1);
            await HtmlMenuType(i+1);
            $(id).find("div.dropdown_content").append(dataMenu[i]);
        }
    }
}
$(document).ready(function () {
    SetupDefault();
    LoadMenu();
});