var Model = {
	inherited : function() {
	}, // , 不是分号
	created : function() {
	},
	prototype : {
		init : function() {
		}
	},
	create : function() {
		var object = Object.create(this);
		object.parent = this;
		object.prototype = object.fn = Object.create(this.prototype);
		object.created();
		this.inherited(object);
		return object;
	},
	init : function() {
		var instance = Object.create(this.prototype);
		instance.parent = this;
		instance.init.apply(instance, arguments);
		return instance;
	},

	extend : function(o) {
		var extended = o.extended;
		jQuery.extend(this, o);
		if (extended)
			extended(this);
	},

	include : function(o) {
		var included = o.included;
		jQuery.extend(this.prototype, o);
		if (included)
			included(this);
	}

};

// test
/*
 * 如果你不熟悉 O bj ec t .c r ea t e( ) ,这段代码读起来会很晦涩,所以我把它分解来讲。 create()
 * 函数返回一个新对象,这个对象继承自 Model 对象,我们使用它来创建新模型。 init() 函数返回一个新对象,它继承自 Model.prototype
 * ——如 Model 对象的一个实例:
 */
var Asset = Model.create();
var User = Model.create();
var user = User.init();
// -----------------------

// 添加对象属性
Model.extend({
	find : function() {
	}
});

// 添加实例属性
Model.include({
	init : function(atts) { /* ... */
	},
	load : function(attributes) { /* ... */
	}
});

// 现在我们可以创建新的资源并设置一些属性 :
var asset = Asset.init({
	name : "foo.png"
});

// =======================
// 用来保存资源的对象
Model.records = {};
Model.include({
	newRecord : true,
	create : function() {
		this.newRecord = false;
		this.parent.records[this.id] = this;
	},
	destroy : function() {
		delete this.parent.records[this.id];
	}
});

// 如何更新一个已存在的实例呢?简单——只需更新对象引用即可 :
Model.include({
	update : function() {
		this.parent.records[this.id] = this;
	}
});

// 现在创建一个快捷函数来保存实例,这样就不用每次都检查这个实例是否已经保存过或 是否需要新创建实例了 :
// 将对象存入 hash 记录中,保持一个引用指向它
Model.include({
	save : function() {
		this.newRecord ? this.create() : this.update();
	}
});
// 如何实现一个用来根据 ID 查找资源的 find() 函数呢?
Model.extend({
	// 通过 ID 查找,找不到则抛出异常
	find : function(id) {
//		return this.records[id];// || throw("Unknown record");
//		return this.records[id] || throw "Unknown record";
//		return this.records[id] || throw new Error("Unknown record");
//		 throw new Error("Unknown record");
		throw "Unknown record";
	}
});

// 现在我们已经成功地创建了一个基本的 ORM,我们来运行一下 :
var asset = Asset.init();
asset.name = "same, same";
asset.id = 1;
asset.save();

var asset2 = Asset.init();
asset2.name = "but different";
asset2.id = 2;
asset2.save();
assertEqual(Asset.find(1).name, "same, same");
asset2.destroy();

// =================
// 增加 ID 支持
/*
 * 此时,每次我们保存一条记录都必须手动指定一个 ID。这实在是糟透,但幸运的是,我 们可以加入自动化处理。首先,我们需要一个方法来自动生成
 * ID,可以使用全局统一标 识(Globally Unique Identifier,简称 GUID)生成器来做这一步。从技术的角度讲,出 于 API
 * 的原因,JavaScript 无法友好正式地生成 128 位的 GUID,它只能生成伪随机数。 生成真正随机的 GUID
 * 是一个众所周知的难题,操作系统使用 MAC 地址、鼠标位置、 BIOS 的校验和、测量电信号的噪声或者检测放射性衰变来计算 GUID,甚至用上了熔 岩灯
 * 注 1 。虽然 JavaScript 中内置的 Math.random() 方法尽管产生的是伪随机数,但也足够 用了。 Robert Kieffer
 * 写了一个简单明了的 GUID 生成器,它使用 Math.random() 来产生一个伪 随机数的
 * GUID(http://goo.gl/0b0hu),代码也很简单 :
 */
Math.guid = function() {
	return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
		var r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
		return v.toString(16);
	}).toUpperCase();
};
// 现在我们有了生成 GUID 的方法,可以很容易将它集成到 ORM 里,剩下的只需修改 create() 函数了 :
Model.extend({
	create : function() {
		if (!this.id)
			this.id = Math.guid();
		this.newRecord = false;
		this.parent.records[this.id] = this;
	}
});
// 这样任何新创建的记录都包含一个随机的 GUID 作为它们的 ID :
var asset = Asset.init();
asset.save();
asset.id; // => "54E52592-313E-4F8B-869B-58D61F00DC74"
