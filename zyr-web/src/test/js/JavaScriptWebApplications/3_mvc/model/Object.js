/*
原型继承
这里使用 Object.create() 来构造我们的 ORM,这和在第 1 章中提到的基于类的例子
有一点不同。这里使用基于原型(prototype-based)的继承,而没有用到构造函数和 new
关键字。
Object.create() 只有一个参数即原型对象,它返回一个新对象,这个新对象的原型就
是传入的参数。换句话说,传入一个对象,返回一个继承了这个对象的新对象。
Object.create() 最近才添加进了 ECMAScript 第 5 版规范,因此在有些浏览器中并未
实现,比如 IE。但这并不是什么大问题,如果需要的话,我们可以很容易地模拟出这个
函数 :
 */
if (typeof Object.create !== "function")
	Object.create = function(o) {
		function F() {
		}
		F.prototype = o;
		return new F();
	};
	
// 这段示例代码摘自 Douglas Crockford 的文章《原型继承》( http://goo.gl/OLQhp )
