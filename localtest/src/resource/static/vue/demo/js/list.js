
$(function(){
    var listData = null;
    var listVueObj = null;

    var conditionItemTemplate = {
        index:0,
        question: "",
        answer:"",
        marker:"",
        beginTime:"",
        endTime:"",
        answered:0,
        isMain:0
    };

    var conditions = [Object.assign({}, conditionItemTemplate)];
    var conditionVueObj = new Vue({
        el: "#condition-panel",
        data: {
            conditions: conditions
        },
        updated:function(){
            console.log(this.conditions[0]);
        }
    });

    function initData(data){
        listData = data;
        listVueObj = new Vue({
            el: "#data-list",
            data: {
                records: listData
            },
            methods:{
                view:function(event){
                    window.localStorage.setItem("questionId", event.target.dataset.key);
                    window.open("view.html");
                }
            }
        });
    }

    function refreshData(data){
        if(!data)
            return;
        var len = listData.length;
        for(var i = 0; i < len; i++){
            listData.pop();
        }
        for(var i = 0; i < data.length; i++){
            listData.push(data[i]);
        }
    }

    $.get(GlobalInfo.contextPath + "/vue/question/list", function(resp){
        initData(resp);

        $("#condition-opt .search").click(function(){
            // $.post(GlobalInfo.contextPath + "/vue/question/list", conditions, function(data){
            //     console.log(data);
            // });
            $.ajax({
                type: "post",
                url: GlobalInfo.contextPath + "/vue/question/list",
                beforeSend: function(request) {
                    request.setRequestHeader("Content-Type","application/json");
                },
                data: JSON.stringify(conditions),
                success: function(result) {
                    console.log(result);
                    refreshData(result);
                },
                dataType:"json"
            });
        });

        $("#condition-opt .addcondition").click(function(){
            conditions.push(Object.assign({}, conditionItemTemplate));
        });

        $("#condition-opt .toadd").click(function(){
            window.open("add.html");
        });
    });

});