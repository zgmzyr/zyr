var Animal = function() {
};
Animal.prototype.breath = function() {
	console.log('breath');
};
var Dog = function() {
};
// Dog 继承了 Animal
Dog.prototype = new Animal;
Dog.prototype.wag = function() {
	console.log('wag tail');
};

// test
var dog = new Dog;
dog.wag();
dog.breath(); // 继承的属性
