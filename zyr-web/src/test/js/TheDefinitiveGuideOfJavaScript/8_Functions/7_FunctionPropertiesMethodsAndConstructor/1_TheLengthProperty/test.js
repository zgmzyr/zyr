//"use strict";

//
// This function uses arguments.callee, so it won't work in strict mode.
function check(args) {
	var actual = args.length;
	// The actual number of arguments
	var expected = args.callee.length; // The expected number of arguments
	if (actual !== expected)
		// Throw an exception if they differ.
		throw Error("Expected " + expected + "args; got " + actual);
}

function f(x, y, z) {
	check(arguments);
	return x + y + z;
}


console.log("f(1, 2, 3) : " + f(1, 2, 3));
console.log("f(1, 2) : " + f(1, 2));