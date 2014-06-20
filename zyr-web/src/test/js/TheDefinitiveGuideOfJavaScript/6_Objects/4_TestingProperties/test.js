var o = {
	x : 1
};
console.log("x" in o);
console.log("y" in o);
console.log("toString" in o);

//
var o2 = {
	x : 1
};
console.log(o2.hasOwnProperty("x"));
console.log(o2.hasOwnProperty("y"));
console.log(o2.hasOwnProperty("toString")); // false: toString is an inherited
											// property

//
var o3 = Object.create({
	y : 2
});
o3.x = 1;
console.log(o3.propertyIsEnumerable("x")); // true: o has an own enumerable
											// property x
console.log(o3.propertyIsEnumerable("y")); // false: y is inherited, not own
console.log(Object.prototype.propertyIsEnumerable("toString")); // false: not
																// enumerable

//
var o = {
	x : undefined
};

console.log(o.x !== undefined);
console.log(o.y !== undefined);
console.log("x" in o);
console.log("y" in o);
console.log(delete o.x);
console.log("x" in o);


//
function Test() {
	
};
console.log("Test:" + Test.valueOf());
console.log("Test.toString():" + Test.toString());
console.log("Test.toLocaleString():" + Test.toLocaleString());

var test = new Test();
console.log("test:" + test.valueOf());
console.log("test.toString():" + test.toString());
console.log("test.toLocaleString():" + test.toLocaleString());

function Test2() {
	return 1111;
};
console.log("Test2:" + Test2.valueOf());
console.log("Test2.toString():" + Test2.toString());
console.log("Test2.toLocaleString():" + Test2.toLocaleString());

var test2 = new Test2();
console.log("test2:" + test2.valueOf());
console.log("test2.toString():" + test2.toString());
console.log("test2.toLocaleString():" + test2.toLocaleString());