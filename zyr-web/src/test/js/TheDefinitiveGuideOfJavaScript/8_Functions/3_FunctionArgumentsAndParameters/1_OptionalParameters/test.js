//"use strict";

// Append the names of the enumerable properties of object o to the
// array a, and return a. If a is omitted, create and return a new array.
function getPropertyNames(o, /* optional */a) {
	if (a === undefined) {
		a = []; // If undefined, use a new array
	}
	// a = a || [];
	
	for ( var property in o) {
		a.push(property);
	}
	
	return a;
}
// This function can be invoked with 1 or 2 arguments:
var a = getPropertyNames({}); // Get o's properties into a new array
getPropertyNames({}, a);
// append p's properties to that array

//
//var bb;
var b = bb || []; //变量bb如果没定义，则报错
