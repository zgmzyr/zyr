var p = {
	// x and y are regular read-write data properties.
	x: 1.0,
	y: 1.0,
	
	// r is a read-write accessor property with getter and setter.
	// Don't forget to put a comma after accessor methods.
	get r() { 
		return Math.sqrt(this.x * this.x + this.y * this.y); 
	},
	set r(newvalue) {
		var oldvalue = Math.sqrt(this.x*this.x + this.y*this.y);
		var ratio = newvalue / oldvalue;
		this.x *= ratio;
		this.y *= ratio;
	},
	
	// theta is a read-only accessor property with getter only.
	get theta() {
		return Math.atan2(this.y, this.x); 
	}
};

// var q = inherit(p); // Create a new object that inherits getters and setters
var q = Object.create(p); // Create a new object that inherits getters and // setters

// q.x = 0, q.y = 0;
q.x = 0;
q.y = 0;
// Create q's own data properties
console.log("q.r" + q.r);
// And use the inherited accessor properties
console.log("q.theta" + q.theta);

var q2 = Object.create(p);

q2.x = 2;
q2.y = 2;
console.log("q.r" + q.r);
console.log("q2.r" + q2.r);
console.log("q2.theta" + q2.theta);
q2.r = 4;
console.log("q.r" + q.r);
console.log("q2.r" + q2.r);

var q3 = Object.create(p);

//q3.x = 1;
//q3.y = 1;
q3.r = 4;
console.log("q3.r" + q3.r);
console.log("q3.x" + q3.x);
console.log("q3.y" + q3.y);
console.log("q3.theta" + q3.theta);

////-------

console.log("----------------------------");
var q4 = Object.create(p);

console.log("q4.r" + q4.r);
console.log("q4.x" + q4.x);
console.log("q4.y" + q4.y);
console.log("q4.theta" + q4.theta);


