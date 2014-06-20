//"use strict";

// A verbose and explicit technique
var len = undefined;
// book; //firefox :error
var book;
// var book = {};
// book = {};
if (book) {
	if (book.subtitle)
		len = book.subtitle.length;
}
// A concise and idiomatic alternative to get subtitle length or undefined
var len = book && book.subtitle && book.subtitle.length;

console.log(len);

// =============
// The prototype properties of built-in constructors are read-only.
// Object.prototype是只读属性
// "use strict"; //严格模式指令不放在文件或者函数的顶端无效
Object.prototype = 0; // Assignment fails silently; Object.prototype unchanged
console.log(Object.prototype);

// ------------------
(function() {
// "use strict";
	
	var obj = {
			get x() {return 0;}
	};
	
	obj.x = 1; // 严格模式下：TypeError: setting a property that has only a  getter;普通模式下，设置不成功而已
	console.log(obj.x);
}());

// ------------------
(function() {
//	"use strict";
	
	var parent = {
			get x() {return 0;}
	};
	
	var sub = Object.create(parent);
	/*
	 * 1.严格模式下：TypeError: setting a property that has only a  getter;普通模式下，设置不成功而已 <p>
	 * 2.x是继承属性，且是只读的，不可以覆盖继承属性x 
	 * 3.不能再添加自有属性x
	 */
	sub.x = 1;  
	
	console.log("parent.x : " + parent.x);
	console.log("sub.x : " + sub.x);
	
	var parent2 = {
			x : 0
	};
	
	var sub2 = Object.create(parent2);
	sub2.x = 1; // 当x是数据属性时，自有属性x可以覆盖继承属性x
	
	console.log("parent2.x : " + parent2.x);
	console.log("sub2.x : " + sub2.x);
}());