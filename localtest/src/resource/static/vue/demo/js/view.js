var dataItem = {};
var questionId = null;
var dataViewVueObj = null;


    function addMarkerForQuestion(){
        var marker = window.prompt("输入标签");
        if(marker){
            $.post(GlobalInfo.contextPath + "/vue/question/addMarkerForQuestion", {
                 questionId: dataItem.id,
                 markerContent: marker
            }, function(resp){
                console.log(resp);
                if(!resp)
                    return;
                if(!dataItem.marker){
                    dataItem.marker = [];
                }
                dataItem.marker.push(resp);
            });
        }else{
            alert("输入点什么");
        }
    }

    function addAnswerForQuestion(){
        var answer = window.prompt("输入答案");
        if(answer){
            $.post(GlobalInfo.contextPath + "/vue/question/addAnswerForQuestion", {
                 questionId: dataItem.id,
                 answerContent: answer
            }, function(resp){
                if(!resp)
                    return;
                dataItem.answers.push(resp);
            });
        }else{
            alert("输入点什么");
        }
    }

    function addMarkerForAnswer(answerId){
        var marker = window.prompt("输入标签");
        if(marker){
            $.post(GlobalInfo.contextPath + "/vue/question/addMarkerForAnswer", {
                 answerId: answerId,
                 markerContent: marker
            }, function(resp){
                if(!resp)
                    return;
                dataItem.answers.forEach(function(item){
                    if(answerId == item.id){
                        item.markers.push(resp);
                    }
                });
            });
        }else{
            alert("输入点什么");
        }
    }


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