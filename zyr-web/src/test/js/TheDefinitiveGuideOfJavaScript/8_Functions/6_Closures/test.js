//"use strict";

//1
(function() {
	var scope = "global scope";
	function checkscope() {
		var scope = "local scope";
		function f() {
			return scope;
		}
		return f();
	}

	var result = checkscope();
	console.log("checkscope() : " + result); // checkscope() : local scope
}());

(function() {
	var scope = "global scope";
	function checkscope() {
		var scope = "local scope";
		function f() {
			return scope;
		}

		return f;
	}

	var result = checkscope()();
	console.log("checkscope()() : " + result); // checkscope()() : local scope
}());

// 2
(function() {
	uniqueInteger.counter = 0;
	// This function returns a different integer each time it is called.
	// It uses a property of itself to remember the next value to be returned.
	function uniqueInteger() {
		return uniqueInteger.counter++; // Increment and return counter property
	}

	console.log("uniqueInteger1 : " + uniqueInteger());
	console.log("uniqueInteger1 : " + uniqueInteger());
}());

(function() {
	var uniqueInteger = (function() {
		// Define and invoke
		var counter = 0; // Private state of function below
		return function() {
			return counter++;
		};
	}());

	console.log("uniqueInteger2 : " + uniqueInteger());
	console.log("uniqueInteger2 : " + uniqueInteger());
}());

// 3
(function() {
	function counter() {
		var n = 0;
		return {
			count : function() {
				return n++;
			},
			reset : function() {
				n = 0;
			}
		};
	}
	var c = counter(), d = counter();
	console.log("c.count() : " + c.count());
	console.log("d.count() : " + d.count());
	
	console.log("c.reset() : " + c.reset());
	
	console.log("c.count() : " + c.count());
	console.log("d.count() : " + d.count());
}());


// 4
(function() {
	function counter(n) { // Function argument n is the private variable
		return {
			get count() { return n++; }, // Property getter method returns
											// and increments private counter
											// var.
			set count(m) { // Property setter doesn't allow the value of n to
							// decrease
				if (m >= n) {
					n = m;
				} else {
					throw Error("count can only be set to a larger value");
				}
			}
		};
	}
	
	var c = counter(1000);
	c.count; // => 1000
	c.count; // => 1001
	c.count = 2000;
	c.count; // => 2001
// c.count = 2000; // => Error!
}());

// 5
// This function adds property accessor methods for a property with
// the specified name to the object o. The methods are named get<name>
// and set<name>. If a predicate function is supplied, the setter
// method uses it to test its argument for validity before storing it.
// If the predicate returns false, the setter method throws an exception.
//
// The unusual thing about this function is that the property value
// that is manipulated by the getter and setter methods is not stored in
// the object o. Instead, the value is stored only in a local variable
// in this function. The getter and setter methods are also defined
// locally to this function and therefore have access to this local variable.
// This means that the value is private to the two accessor methods, and it
// cannot be set or modified except through the setter method.

(function() {
	function addPrivateProperty(o, name, predicate) {
		 var value;  // This is the property value
		
		 // The getter method simply returns the value.
		 o["get" + name] = function() { return value; };
		
		 // The setter method stores the value or throws an exception if
		 // the predicate rejects the value.
		 o["set" + name] = function(v) {
		     if (predicate && !predicate(v))
		         throw Error("set" + name + ": invalid value " + v);
		     else
		         value = v;
		 };
	}
	
	// The following code demonstrates the addPrivateProperty() method.
	var o = {};  // Here is an empty object
	
	// Add property accessor methods getName and setName()
	// Ensure that only string values are allowed
	addPrivateProperty(o, "Name", function(x) { return typeof x == "string"; });
	
	o.setName("Frank");       // Set the property value
	console.log(o.getName()); // Get the property value
//	o.setName(0);             // Try to set a value of the wrong type
}());


// 6
// This function returns a function that always returns v

(function() {
	function constfunc(v) {
		return function() { return v; }; 
	}
	
	// Create an array of constant functions:
	var funcs = [];
	for (var i = 0; i < 10; i++) {
		funcs[i] = constfunc(i);
	}
	
	// The function at array element 5 returns the value 5.
	console.log("funcs[5]() : " + funcs[5]()); // => 5
}());

(function() {
	// Return an array of functions that return the values 0-9
	function constfuncs() {
		var funcs = [];
		for (var i = 0; i < 10; i++) {
			funcs[i] = function() { 
				return i; 
			};
		}
		
		return funcs;
	}
	
	var funcs = constfuncs();
	console.log("funcs[5]() : " + funcs[5]());  // What does this return?
}());
