//"use strict";

var o = {
	m : function() {
		var self = this;
		console.log("this === o : " + (this === o));
		
		f();
		
		function f() {
			// A nested function f
			console.log("this === o : " + (this === o)); // "false": this is global or undefined
			console.log("self === o : " + (self === o)); // "true": self is the outer this value.
		}
	}
};

o.m(); // Invoke the method m on the object o. //上下文是o

new o.m(); //上下文不再是o，而是新创建的对象

//
var o = new Object();
var o = new Object; //	没有形参的构造函数可以省略圆括号

