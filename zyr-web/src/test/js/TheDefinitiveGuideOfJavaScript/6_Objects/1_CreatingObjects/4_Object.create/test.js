/*
 * Object.create() is a static function, not a method invoked on individual objects. 
 * To use it, simply pass the desired prototype object:
 */
var o1 = Object.create({
	x : 1,
	y : 2
});

alert(o1.x + o1.y); // 3

// ECMAScript 3:
// o1 inherits properties x and y.
// inherit() returns a newly created object that inherits properties from the
// prototype object p. It uses the ECMAScript 5 function Object.create() if
// it is defined, and otherwise falls back to an older technique.
function inherit(p) {
	if (p == null)
		throw TypeError(); // p must be a non-null object
	if (Object.create)
		// If Object.create() is defined...
		return Object.create(p);
	// then just use it.
	var t = typeof p;
	// Otherwise do some more type checking
	if (t !== "object" && t !== "function")
		throw TypeError();

	function f() {
	}

	// Define a dummy constructor function.
	f.prototype = p;
	// Set its prototype property to p.
	return new f();
	// Use f() to create an "heir" of p.
}

var o2 = {
	x : 1,
	y : 2
};

var o3 = inherit(o2);
alert(o3.x + o3.y); // 3

o3.x = 0;
o3.y = 0;

alert(o3.x + o3.y); // 0
alert(o2.x + o2.y); // 3


var o4 = inherit(o2);
alert(o4.x + o4.y); // 3


//------------
var o5 = {
	x : '1',
	y : '1'	
};

var o6 = inherit(o5);
console.log("o6.x:" + o6.x + " o6.y:" + o6.y);
o6.x = 2;
o6.y = 2;
console.log("o5.x:" + o5.x + " o5.y:" + o5.y);
console.log("o6.x:" + o6.x + " o6.y:" + o6.y);

//------------
var o7 = {
	x : '1',
	y : '1'	
};

var o8 = inherit(o7);
console.log("o8.x:" + o8.x + " o8.y:" + o8.y);
o7.x = 2;
o7.y = 2;
console.log("o8.x:" + o8.x + " o8.y:" + o8.y);
o8.x = 3;
o8.y = 3;
console.log("o7.x:" + o7.x + " o7.y:" + o7.y);
console.log("o8.x:" + o8.x + " o8.y:" + o8.y);