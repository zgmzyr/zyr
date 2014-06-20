//"use strict";

//
// Copy length elements of the array from to the array to.
// Begin copying with element from_start in the from array
// and copy that element to to_start in the to array.
// It is hard to remember the order of the arguments.
function arraycopy(/* array */from, /* index */from_start, /* array */to, /* index */ to_start, /* integer */length) {

	// code goes here
	
}

// This version is a little less efficient, but you don't have to
// remember the order of the arguments, and from_start and to_start
// default to 0.
function easycopy(args) {
	arraycopy(args.from, 
			args.from_start || 0, // Note default value provided
			args.to,
			args.to_start || 0, 
			args.length);
}

// Here is how you might invoke easycopy():
var a = [ 1, 2, 3, 4 ], b = [];
easycopy({
	from : a,
	to : b,
	length : 4
});