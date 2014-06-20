//"use strict";

o = {
	x : 1
};

delete o.x;
delete o.x;
delete o.toString;
delete 1;

// ---------------
delete Object.prototype;
var x = 1;
delete this.x;

function f() {
}

delete this.f;


// -------------
this.x = 1;
//delete x;

// -------------
//delete x;
delete this.x;
