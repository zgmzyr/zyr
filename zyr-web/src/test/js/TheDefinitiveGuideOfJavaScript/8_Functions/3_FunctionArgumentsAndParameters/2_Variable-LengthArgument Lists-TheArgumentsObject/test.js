//"use strict";

// 在非严格模式下：可以认为是相同变量的不同命名
function f(x) {
	console.log("x : " + x); // Displays the initial value of the argument

	console.log("arguments[0] : " + arguments[0]);
	arguments[0] = null; // Changing the array element also changes x!
	console.log("arguments[0] : " + arguments[0]);

	console.log("x : " + x); // Now displays "null"

	x = 6;
	console.log("arguments[0] : " + arguments[0]);
	// arguments = null; // 严格模式下，arguments是保留字，不能给它赋值，所以报：SyntaxError: can't
	// assign to arguments in strict mode
}

f(5);

//
var factorial = function(x) {
	if (x <= 1)
		return 1;
	return x * arguments.callee(x - 1);
};

