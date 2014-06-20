var Class = function() {
	var klass = function() {
		this.init.apply(this, arguments);
	};
	klass.prototype.init = function() {
	};
	return klass;
};
var Person = new Class;
Person.prototype.init = function() {
	// 基于 Person 的实例做初始化
};
// 用法 :
var person = new Person;

var person2 = new Person();
var person3 = new Person("ss");