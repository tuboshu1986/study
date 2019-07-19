var addDataTemplate = function(){
    this.question="";
    this.answer="";
    this.markers = [];
};

var toPostData = function(data){
    return {
        question: data.question,
        answer: data.answer,
        markers: data.markers.join(",")
    };
};

var addData = Object.assign({}, new addDataTemplate());

$(function(){
    var html = document.getElementsByTagName("html");
    html[0].style.cssText = "height:" + window.innerHeight + "px;";
    var body = html[0].querySelector("body");
    body.style.cssText = "height:" + window.innerHeight + "px;";

    var addPanelVueObj = new Vue({
        el: "#add-panel",
        data: {
            formdata: addData,
            inputMarker: ""
        },
        methods:{
            submit: function(){
                console.log(this.formdata.question);
                if(!addData.question){
                    alert("必须输入问题");
                    return;
                }
                $.post(GlobalInfo.contextPath + "/vue/question", toPostData(addData), function(respData){
                    alert(respData);
                    window.close();
                });
            },
            reset: function(){
                addData = Object.assign(addData, new addDataTemplate());
            },
            addMarker:function(){
                var inputMarker = this.inputMarker;
                if(!this.formdata.markers.find(function(item){
                    if(item == inputMarker){
                        return true;
                    }
                    return false;
                })){
                    this.formdata.markers.push(inputMarker);
                }
                this.inputMarker = "";
            }
        }
    });

});
