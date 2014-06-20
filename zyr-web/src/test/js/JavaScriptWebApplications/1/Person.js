var Person = function(name) {
	this.name = name;
};
// 实例化一个 Person
var alice = new Person('alice');
var p1 = new Person("abc");

alert(p1);
alert(Person("abc"));
// 检查这个实例
//assert(alice instanceof Person);