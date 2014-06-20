"use strict"


var a = NaN;
if (a == NaN) {
	alert("a == NaN : true");
} else {
	alert("a == NaN : false");
}

if (a === NaN) {
	alert("a === NaN : true");
} else {
	alert("a === NaN : false");
}

// TODO
if (a == a) {
	alert("a == a : true");
} else {
	alert("a == a : false");
}

if (a === a) {
	alert("a === a : true");
} else {
	alert("a === a : false");
}

//
if (a != a) {
	alert("a != a : true");
} else {
	alert("a != a : false");
}

if (a !== a) {
	alert("a !== a : true");
} else {
	alert("a !== a : false");
}

//isNaN()
if (isNaN(a)) {
	alert("isNaN(a) : true");
} else {
	alert("isNaN(a) : false");
}

//isFinite

if (isFinite(a)) {
	alert("isFinite(a) : true");
} else {
	alert("isFinite(a) : false");
}

//
var b = Infinity;
if (isFinite(b)) {
	alert("isFinite(b) : true");
} else {
	alert("isFinite(b) : false");
}

//
var zero = 0,
	negz = -0;

if (zero == negz) {
	alert("zero == negz : true");
} else {
	alert("zero == negz : false");
}

if (zero === negz) {
	alert("zero === negz : true");
} else {
	alert("zero === negz : false");
}

if (1 / zero == 1 / negz) {
	alert("1/zero == 1/negz : true");
} else {
	alert("1/zero == 1/negz : false");
}

if (1 / zero === 1 / negz) {
	alert("1/zero === 1/negz : true");
} else {
	alert("1/zero === 1/negz : false");
}

//
var p = "a";
var e = "e";
alert("a : " + p.length);
alert("e : " + e.length);

//只在ECMAScript5可用
/*
var str = "aaa\ 
		   sss\
		   bbb;
*/
var str = "aaa\nsss"; 


//
alert("null == null : " +  (null == null));
alert("null === null : " +  (null === null));
var nullA = null;
var nullB = null;
alert("nullA == nullB : " +  (nullA == nullB));
alert("nullA === nullB : " +  (nullA === nullB));

alert("undefined == undefined : " +  (undefined == undefined));
alert("undefined === undefined : " +  (undefined === undefined));
var undefinedA, undefinedB; 
alert("undefinedA == undefinedB : " +  (undefinedA == undefinedB));
alert("undefinedA === undefinedB : " +  (undefinedA === undefinedB));

alert("null == undefined : " +  (null == undefined));
alert("null === undefined : " +  (null === undefined));

alert("false == undefined : " +  (false == undefined)); //false 

alert("typeof null : " + typeof null);
var c = null;
var d;
alert("typeof c : " + typeof c);
alert("typeof d : " + typeof d);


//

alert(1 + "2");
alert(1 + "aa");
