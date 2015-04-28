"use strict";

// Define and invoke a function to determine if we're in strict mode.
var strict = (function() {
	return !this;
}());

console.log("strict:" + strict);