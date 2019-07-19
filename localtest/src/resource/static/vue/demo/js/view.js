var dataItem = {};
var questionId = null;
var dataViewVueObj = null;

    $(function(){
    questionId = window.localStorage.getItem("questionId");

    $.get(GlobalInfo.contextPath + "/vue/question/" + questionId, function(respData){
        Object.assign(dataItem, respData);
        console.log(dataItem);
        init();
    }, "json");

    function init(){
        dataViewVueObj = new Vue({
            el: "#data-view",
            data: {
                record: dataItem
            }
        });
    }
});