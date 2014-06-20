var User = function(atts) {
	//实例属性
	this.attributes = atts || {};
};

//实例函数
User.prototype.destroy = function() {
	/* ... */
};
	
//静态函数
User.fetchRemote = function() {
	/* ... */
};