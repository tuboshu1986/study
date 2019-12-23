
/**
 * 数据处理，可以把数据存储在文件系统或浏览器缓存中
 */
var DataProxy = function(fileNameSuf){
	var that = this;
	this.fileNameSuf = fileNameSuf ? fileNameSuf : "文件";
	this.data = {
		list:[]
	};
	this.loadFromCache();
	this.timerId = setInterval(function(){
		that.saveToCache();
	}, 100);
};

/**
 * 移除一条数据
 */
DataProxy.prototype.removeRecord = function(index){
	this.getMainList().aplice(index, 1);
};

/**
 * 追加一条数据
 */
DataProxy.prototype.addRecord = function(record){
	this.getMainList().splice(0, 0, record);
};

/**
 * 替换显示的数据
 */
DataProxy.prototype.replaceViewerDataModel = function(data){};

/**
 * 在数据中查询符合查询条件的数据并返回
 * @param condition 查询条件
 */
DataProxy.prototype.filter = function(condition){
	var that = this;
	var list = this.getMainList();
	if(!condition){
		return list;
	}
	var filterData = list.filter(function(record){
		return that.filterRecord(record, condition);
	});
	return filterData;
};

/**
 * 【子类实现】
 * 获取显示的数据的过滤条件
 * @param record 数据项
 * @param condition 条件，如果record复核condition，则返回true
 */
DataProxy.prototype.filterRecord = function(record, condition){
	return true;
};

/**
 * 打开本地文件并加载到数据
 */
DataProxy.prototype.open = function(){
	var that = this;
	var input = document.createElement("input");
	input.type="file";
	input.addEventListener("change", function(){
		var file = input.files[0];
		var reader = new FileReader();
		reader.onload = function(){
			var dataJson = JSON.parse(this.result);
			that.setData(dataJson);
		};
		reader.readAsText(file);
	});
	input.click();
};

/**
 * 将数据保存为本地文件
 */
DataProxy.prototype.save = function(){
	var dataStr = JSON.stringify(this.data);
	var dataURL = window.URL.createObjectURL(new Blob([dataStr]));
	
	var a = document.createElement("a");
	a.download = this.fileName();
	a.href = dataURL;
	
	a.click();
};

/**
 * 保存至本地时所用的文件名称
 */
DataProxy.prototype.fileName = function(){
	return this.fileNameSuf + "_" + this.currentTimeStr() + ".json";
};

/**
 * 将数据保存至浏览器缓存
 */
DataProxy.prototype.saveToCache = function(){
	var dataStr = JSON.stringify(this.data);
	window.localStorage.setItem(this.fileNameSuf + "_cache", dataStr);
};

/**
 * 将数据从浏览器缓存中加载
 */
DataProxy.prototype.loadFromCache = function(){
	var dataStr = window.localStorage.getItem(this.fileNameSuf + "_cache");
	if(!dataStr){
		return;
	}
	var data = JSON.parse(this.data);
	if(data){
		this.setData(data);
	}
};

/**
 * 当前时间戳字符串
 */
DataProxy.prototype.currentTimeStr = function(){
	return new Date().toJSONString();
};

/**
 * 清空数据
 */
DataProxy.prototype.clearData = function(){
	
};

/**
 * 获取所有数据
 */
DataProxy.prototype.getData = function(){
	return this.data;
};

/**
 * 设置所有数据
 */
DataProxy.prototype.setData = function(dataJson){
	this.data = dataJson;
};

/**
 * 获取主数据
 */
DataProxy.prototype.getMainList = function(){
	return this.data.list;
};
