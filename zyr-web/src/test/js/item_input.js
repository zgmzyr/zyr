$(function() {
	initFreight();
	initArea();
	
	/**
	 * 初始化商品所在地 
	 */
	function initArea() {
		var areaIds = $("#areaIds").val();
		if (areaIds === "") {
			return;
		}
		
		var areaIdArray = areaIds.split(",");
		listProvince($.trim(areaIdArray[0]));
		listCity($.trim(areaIdArray[0]), $.trim(areaIdArray[1]));
	}

	
	/**
	 * 初始化运费相关
	 */
	function initFreight() {
		$("#buyers").click(function(){
			$("#freight").show();
		});
		var $freightTemplateList=$("#freightTemplateList");
		$("#sellerBearFreight").click(function(){
			$("#freight").hide();
			$freightTemplateList.hide();
		});
		
		var $useFreightTemplate  = $("#useFreightTemplate");
		var $freightList = $("#freightList");
		$useFreightTemplate.click(function(){
			$freightTemplateList.show();
			$freightList.hide();
			$("#setFreightWrong").hide();
			
			$("input[name = 'itemVO.feeTemplateId']").attr("disabled", false);
		});
		var $setFreight=$("#setFreight");
		$setFreight.click(function(){
			$freightList.show();
			$freightTemplateList.hide();
			$("#useFreightTemplateWrong").hide();
			$("input[name = 'itemVO.feeTemplateId']").attr("disabled", true);
		});
		
		if ($useFreightTemplate.is(":checked")) {
			$freightTemplateList.show();
		} else {
			$freightTemplateList.hide();
		}
		
		if ($setFreight.is(":checked")) {
			$freightList.show();
		} else {
			$freightList.hide();
		}
	}

});

/**
 * 列出顶级区域
 * 
 * @param provinceId
 */
function listProvince(provinceId) {
	if ($("#province option").length > 1) {
		return;
	}
	
	$.ajax({
	 	url: "item!queryProvinceList.action",
	 	type: "post",
		dataType: "json",
		async: true,
		success: function(provinceArray) {
					if (provinceArray && provinceArray.length > 0) {
						var options = "";
						for (var index = 0; index < provinceArray.length; index++) {
							options += "<option value='" + provinceArray[index]["id"] + "'";  
							
							if (provinceId === provinceArray[index]["id"]) {
								options += " selected ";
							}
							
							options += ">" + provinceArray[index]["name"] + " </option>";
						}
						
						var $provinceSelect = $("#province");
						$provinceSelect.append(options);
					} 
				}
	});
}

/**
 * 列出城市
 * 
 * @param provinceId
 * @param cityId
 */
function listCity(provinceId, cityId) {
	if (provinceId === "") {
		var $city = $("#city");
	    $city.html("");
	    $city.hide();
	    
	    return;
	}
	
	$.ajax({
	 	url: "item!queryCityList.action",
	 	type: "post",
		dataType: "json",
		data: {"provinceId": provinceId},
		async: true,
		success: function(cityArray) {
					var $city = $("#city");
					$city.html("");
					
					if (cityArray && cityArray.length > 0) {
						var options = "";
						for (var index = 0; index < cityArray.length; index++) {
							options += "<option value='" + cityArray[index]["id"] + "'";  
							
							if (cityId === cityArray[index]["id"]) {
								options += " selected ";
							}
							
							options += ">" + cityArray[index]["name"] + " </option>";
						}
						
						$city.append(options);
						$city.show();
					} else {
						$city.hide();
					} 
				}
	});
}


$(function() {
	var editor = createDescriptionEditor();
	$("#update").bind("click", update);
	$("#save").bind("click", save);
	$("#preView").bind("click", preView);
	$("#store").bind("click", change);
	$("#category").bind("click", change);
	
	/**
	 * 保存
	 */
	function save() {
		var $itemForm = $("#itemForm");
		$itemForm.attr("action","item_save.action");
		$itemForm.attr("method","post");
		$itemForm.attr("target", "_self");
		
		editor.sync();
		$itemForm.submit();
	}
	
	/**
	 * 更新
	 */
	function update() {
		var $itemForm = $("#itemForm");
		$itemForm.attr("action","item_update.action");
		$itemForm.attr("method","post");
		$itemForm.attr("target", "_self");
		
		editor.sync();
		$itemForm.submit();
	}
	
	/**
	 * 预览
	 */
	function preView() {
		var $itemForm = $("#itemForm");
		$itemForm.attr("action","item_preView.action");
		$itemForm.attr("method","post");
		$itemForm.attr("target", "_blank");
		
		editor.sync();
		$itemForm.submit();
	}
	
	/**
	 * 更改商家或者商品分类
	 */
	function change() {
		var $itemForm = $("#itemForm");
		$itemForm.attr("action", "item!change.action");
		$itemForm.attr("method", "post");
		
		editor.sync();
		$itemForm.submit();
	}
	
	/**
	 * 创建用于商品描述的编辑器
	 */
	function createDescriptionEditor() {
		var descriptionEditor = new baidu.editor.ui.Editor({
			imageUrl : $("#descriptionImageUploadUrl").val(),
			autoClearinitialContent : false,
			wordCount : false,
			initialContent : ""
		});
		
		descriptionEditor.render("itemVO_introduction");
		var webUrl = $("#webUrl").val();
		descriptionEditor.url = webUrl + "/item!saveStoreImageUrl.action?itemVO.storeId=" + $("#storeId").val() || "";
		descriptionEditor.storeimageurl = webUrl + "/item!queryStoreImageUrl.action?itemVO.storeId=" + $("#storeId").val() || "";
		return descriptionEditor;
	}
	
});

//上传图片相关js 开始
$(function() {
	var $base = $("#base").val();
    //上传控件部分
    $('#goodsImage_add').uploadify({
        'uploader' : $base + '/template/common/upload_plugin/uploadify.swf?var=' + (new Date()).getTime(),
        'script' : 'http://image01.etong.com:8080/image/servlet/ImageViewServlet',
        'cancelImg' : $base + '/template/common/upload_plugin/cancel.png',
        'multi'          : true,
        'auto'           : true,
        'queueID'        : 'add_goodsImage_div',
        'queueSizeLimit' : 5,
        'simUploadLimit' : 10,
        'sizeLimit'      : 524288,
        'removeCompleted': false,
        'fileDesc'    : '图片格式[jpg,gif,png,bmp,jpeg]',
        'fileExt'     : '*.jpg;*.gif;*.png;*.jpeg;*.bmp;*.JPG;*.GIF;*.PNG;*.JPEG;*.BMP;',
        'buttonText'     : '上传图片',
        'onSelect': function(event, queueId, fileObj) {
            return validateUploadGoodsImage(fileObj);
        },
        'onSelectOnce': function(event,data){
        	return validateUploadGoodsImageCount(data);
        },
        'onComplete'  : function(event, ID, fileObj, response, data) {
              var validateResult = checkReturnData(response);
              if (!validateResult){
                   return false;
              }
              ajaUploadimg(response);
             introduceImg(response);             
        }        
    });
});

/**
 * 校验返回的数据
 * 
 * @param response
 * @returns {Boolean}
 */
function checkReturnData(response){
    if (response.length <= 2){
        return false;
    }
    if (response.substring(0, 2) == "x_"){
        alert("上传失败！");
        return false;
    }
    return true;
}

/**
 * 校验商品图片相关
 * 
 * @param fileObj
 * @returns {Boolean}
 */
function validateUploadGoodsImage(fileObj){
    if (fileObj.size > 512 * 1024){
	    alert("上传文件不得大于512KB！");
	    return false;
    }    
	var fileTypeName = fileObj.type.toLowerCase();
	
	var allowedUploadType = '.jpg, .gif, .png, .jpeg, .bmp';
	if (allowedUploadType.indexOf(fileTypeName) <0){
	    alert("上传类型不对，请上传jpg,gif,png,bmp,jpeg！");
	    return false;
	}
	
    return true;
}

/**
 * 校验商品图片的数目
 * 
 * @param data
 * @returns {Boolean}
 */
function validateUploadGoodsImageCount(data){
	var uploadImageNum = $("input=[name='itemVO.imagesUrl']").length; 
	var selectedNum = data.fileCount; 
	var limit = $("#limit").val();
	if(limit != null && (limit - (uploadImageNum + selectedNum) < 0)){
		alert("上传商品图片数量不得超过"+limit +"张！");
		return false;
	}
	return true;
	
}

/**
 * 图片上传后，保存图片与商家关联
 * 
 * @param imgurl
 */
function ajaUploadimg(imgurl){
	var $storeId = $("#storeId");
	$.ajax({
	 	url: "item!saveStoreImageUrl.action",
			dataType: "json",
			data: {"itemVO.storeId": $storeId.val(), imageUrl: imgurl},
			async: true
	});	
}
//图片插入到预览列表中
function introduceImg(imageUrl){
    var ul = $("ul.pic_items");
    ul.append("<li><div class='goodsImageBox'>" +
    "<div class='goodsImagePreview belatedPNG'><img src='" + imageUrl + "_80x80.jpg' ></div>" + 
    "<div class='goodsImageOperate'>" +
    "<a class='left' href='javascript: void(0);' alt='左移' hidefocus='true'></a>" + 
    "<a  class='right' href='javascript: void(0);' title='右移' hidefocus='true'></a>" + 
    "<a  class='delete' href='javascript: void(0);' title='删除' hidefocus='true'></a>"+
    "</div>"+
    "<div>"
     +'<input type="hidden" name="itemVO.imagesUrl" value="' + imageUrl + '" />'
    +"</div>"
    +"</div></li>");
}

//显示商品图片预览操作层
$(".pic_items li").livequery("mouseover", function() {
	$(this).find(".goodsImageOperate").show();
});

// 隐藏商品图片预览操作层
$(".pic_items li").livequery("mouseout", function() {
	$(this).find(".goodsImageOperate").hide();
});

// 商品图片左移
$(".left").livequery("click", function() {
	var $goodsImageLi = $(this).parent().parent().parent();
	var $goodsImagePrevLi = $goodsImageLi.prev("li");
	if ($goodsImagePrevLi.length > 0) {
		$goodsImagePrevLi.insertAfter($goodsImageLi);
	}
});

// 商品图片右移
$(".right").livequery("click", function() {
	var $goodsImageLi = $(this).parent().parent().parent();
	var $goodsImageNextLi = $goodsImageLi.next("li");
	if ($goodsImageNextLi.length > 0) {
		$goodsImageNextLi.insertBefore($goodsImageLi);
	}
});

// 商品图片删除
$(".delete").livequery("click", function() {
	var $goodsImageLi = $(this).parent().parent().parent();
	$goodsImageLi.remove();
	
});

//上传图片相关js 结束

/**
 * 显示售后服务的内容
 */
function showSalesServiceContent(content) {
	var salesServiceContent = $("#salesServiceContent");
	if(content === "") {
		salesServiceContent.hide();
		return;
	}
	
	salesServiceContent.val(content);
	salesServiceContent.show();
}

/**
 * 取消所有的商品属性
 */
function disableAllProperties() {
	var prefix = "propertyGroupId_";
	$("ul[id^='" + prefix + "']").find("input, select").attr("disabled", true);
}

/**
 * 显示商品属性
 * 
 * @param propertyGroupId
 * @param propertyGroupName
 */
function showProperties(propertyGroupId, propertyGroupName) {
	var prefix = "propertyGroupId_";
	var showId = prefix + propertyGroupId;
	$("ul[id^='" + prefix + "']" ).each(function() {
		var $this = $(this);
		if ($this.attr("id") === showId) {
			$this.show();
			$this.find("input, select").attr("disabled", false);
		} else {
			$this.hide();
			$this.find("input, select").attr("disabled", true);
		}
	});
	
	$("#propertyGroupList").hide();
	$("#selectPropertyGroup").html(propertyGroupName);
	$("#notSelectItemProperties").val(false);
}

/**
 * 取消某一个属性组的属性
 */
function cancelProperties() {
	var prefix = "propertyGroupId_";
	$("ul[id^='" + prefix + "']" ).hide();
	disableAllProperties();
	$("#propertyGroupList").hide();
	
	$("#notSelectItemProperties").val(true);
	$("#selectPropertyGroup").html("请选择");
}

/**
 * 改变配送方式是否支持
 * 
 * @param deliveryTypeId
 */
function changeDeliveryTypeSupport(deliveryTypeId) {
	var deliveryTypeSupportPrefix = "deliveryTypeSupport_";
	var $deliveryTypeSupportInput = $("#" + deliveryTypeSupportPrefix + deliveryTypeId);
	var deliveryFeePrefix = "deliveryFee_";
	var $deliveryFeeInput = $("#" + deliveryFeePrefix + deliveryTypeId);
	
	if ($deliveryTypeSupportInput.is(":checked")) {
		$deliveryTypeSupportInput.val("1");
		$deliveryFeeInput.attr("disabled", false);
	} else {
		$deliveryTypeSupportInput.val("0");
		$deliveryFeeInput.attr("disabled", true);
	}
}


$(function() {
	initProperties();
	$("input[id^='deliveryTypeSupport_']").trigger("load");
	$("input[id^='salesService_']").trigger("load");
	
	/**
	 * 初始化属性显示
	 */
	function initProperties() {
		$("#selectPropertyGroup").click(function(){
			$(".windowbox").show();
		});
		$(".close").click(function(){
			$(".windowbox").hide();
		});
		
		$("#cancelProperties").bind("click", cancelProperties);// = cancelProperties;
		var prefix = "propertyGroupId_";
		
		if ($("#notSelectItemProperties").val() === "true") {
			cancelProperties();
		} else {
			var firstPropertyGroup = $("ul[id ^= '" + prefix + "'][propertyGroupIndex = 0]");
			firstPropertyGroup.show();
			
			var notFirstPropertyGroup = $("ul[id ^= '" + prefix + "'][propertyGroupIndex != 0]");
			notFirstPropertyGroup.hide();
			notFirstPropertyGroup.find("input, select").attr("disabled", true);
		}
	}
});



//规格相关js start
var CacheUtils = (function() {
	return function() {
		var $document = $(document); 
		this.setSkuItemArray = function (skuItemArray) {
			$document.data("skuItemArray", skuItemArray);
		};
		
		this.getSkuItemArray = function() {
			return $document.data("skuItemArray");
		} ;
		
		this.setBaseSkuItem = function (baseSkuItem) {
			$document.data("baseSkuItem", baseSkuItem);
		};
		
		this.getBaseSkuItem = function () {
			return $document.data("baseSkuItem");
		};
		
		this.setSelectedSpecifyIdArray = function (selectedSpecifyIdArray) {
			$document.data("selectedSpecifyIdArray", selectedSpecifyIdArray);
		};
		
		this.getSelectedSpecifyIdArray = function () {
			return $document.data("selectedSpecifyIdArray");
		};
		
		this.setSelectedSpecifyAssociationMap = function (selectedSpecifyAssociationMap) {
			$document.data("selectedSpecifyAssociationMap", selectedSpecifyAssociationMap);
		};
		
		this.getSelectedSpecifyAssociationMap = function () {
			return $document.data("selectedSpecifyAssociationMap");
		};
	};
	
})();

/**
 * 全局缓存，主要用于缓存与规格相关的对象
 */
var cacheUtils = new CacheUtils();

$(function() {
	initSelectedSpecifyValue();
	loadSkuItem();
	setBaseInformationInputDisabledOrNot();
	
	/**
	 * 初始化已选择规格值
	 */
	function initSelectedSpecifyValue() {
		$("input[name='selectedSpecifyValueIdList']").each(function() {
			var $this = $(this);
			if ($this.is(":checked")) {
				var $specifyValueLabel = $this.next();
				$specifyValueLabel.hide();
				
				var $specifyValue = $specifyValueLabel.next();
				$specifyValue.css("visibility", "visible");
			}
		});
	}
	
	/**
	 * 加载skuItem相关
	 */
	function loadSkuItem() {
		var skuItemArray = new Array();
		
		assembleSkuItemArray(skuItemArray);
		initSelectedSpecifyIdArray(skuItemArray);
		
		if(!cacheUtils.getSelectedSpecifyIdArray()) {
			return;
		}
		
		cacheUtils.setSkuItemArray(skuItemArray);
		initSelectedSpecifyAssociationMap(skuItemArray);
		createSkuTable();
	}
	
	/**
	 * 组装skuItem数组
	 */
	function assembleSkuItemArray(skuItemArray) {
		var skuItemArrayTemp = $.parseJSON($("#skuItemJson").val());
		if (!skuItemArrayTemp) {
			return;
		}
		
		for (var skuItemIndex = 0; skuItemIndex < skuItemArrayTemp.length; skuItemIndex++) {
			var skuItem = new SkuItem();
			var skuItemTemp = skuItemArrayTemp[skuItemIndex];
			
			if (skuItemTemp["skuId"]) {
				skuItem.setSkuId(skuItemTemp["skuId"]);
			}
			skuItem.setSalePriceYuan(skuItemTemp["salePriceYuan"]);
			skuItem.setMarketPriceYuan(skuItemTemp["marketPriceYuan"]);
			skuItem.setRemainStoreQuantity(skuItemTemp["remainStoreQuantity"]);
			skuItem.setStoreWarnNum(skuItemTemp["storeWarnNum"]);
			skuItem.setSkuSN(skuItemTemp["skuSN"]);
			skuItem.setMarketable(skuItemTemp["marketable"]);
			
			var specifyAssociationArray = new Array();
			assembleSpecifyAssociationArray(skuItemTemp, specifyAssociationArray);
			skuItem.setSpecifyAssociationArray(specifyAssociationArray);
			
			skuItemArray.push(skuItem);
		}
	}
	
	/**
	 * 组装"规格、规格值关联"数组
	 */
	function assembleSpecifyAssociationArray(skuItemTemp, specifyAssociationArray) {
		var specifyAssociationArrayTemp = skuItemTemp["specifyAssociationList"];
		if (specifyAssociationArrayTemp && specifyAssociationArrayTemp.length > 0) {
			for (var index = 0; index < specifyAssociationArrayTemp.length; index++) {
				var specifyAssociation = new SpecifyAssociation();
				specifyAssociation.setSpecifyId(specifyAssociationArrayTemp[index]["specifyId"]);
				specifyAssociation.setspecifyValueId(specifyAssociationArrayTemp[index]["specifyValueId"]);
				specifyAssociation.setValue(specifyAssociationArrayTemp[index]["value"]);
				
				specifyAssociationArray.push(specifyAssociation);
			}
			
		}
	}
	
	/**
	 * 初始化已选择的规格ID数组
	 */
	function initSelectedSpecifyIdArray(skuItemArray) {
		if (!skuItemArray || skuItemArray.length === 0) {
			return;
		}
		
		var specifyAssociationArray = skuItemArray[0].getSpecifyAssociationArray();
		if (!specifyAssociationArray || specifyAssociationArray.length === 0) {
			return;
		}
		
		var selectedSpecifyIdArray = new Array();
		for (var specifyAssociationIndex = 0; specifyAssociationIndex < specifyAssociationArray.length; specifyAssociationIndex++) {
			selectedSpecifyIdArray.push(specifyAssociationArray[specifyAssociationIndex].getSpecifyId());
		}
		
		cacheUtils.setSelectedSpecifyIdArray(selectedSpecifyIdArray);
	}
	
	/**
	 * 初始化已选择的”规格、规格值关联"Map
	 */
	function initSelectedSpecifyAssociationMap(/*Type: sku Araay*/ skuItemArray) {
		var selectedSpecifyIdArray = cacheUtils.getSelectedSpecifyIdArray();
		var selectedSpecifyAssociationMap = new Object();
		
		for (var skuItemIndex = 0; skuItemIndex < skuItemArray.length; skuItemIndex++) {
			var specifyAssociationArray = skuItemArray[skuItemIndex].getSpecifyAssociationArray();
			
			for (var specifyAssociationIndex = 0; specifyAssociationIndex < specifyAssociationArray.length; specifyAssociationIndex++) {
				var specifyAssociation = specifyAssociationArray[specifyAssociationIndex];
				coreInitSelectedSpecifyAssociationMap(specifyAssociation, selectedSpecifyIdArray, selectedSpecifyAssociationMap); 
			}
		}
		
		cacheUtils.setSelectedSpecifyAssociationMap(selectedSpecifyAssociationMap);
	}
	
	/**
	 * 核心初始化已选择的”规格、规格值关联"Map
	 */
	function coreInitSelectedSpecifyAssociationMap(specifyAssociation, selectedSpecifyIdArray, selectedSpecifyAssociationMap) {
		for (var selectedSpecifyIdIndex = 0; selectedSpecifyIdIndex < selectedSpecifyIdArray.length; selectedSpecifyIdIndex++) {
			var selectedSpecifyId = selectedSpecifyIdArray[selectedSpecifyIdIndex];
			
			if (selectedSpecifyId !== specifyAssociation.getSpecifyId()) {
				continue;
			}
			
			var selectedSpecifyAssociationArray = selectedSpecifyAssociationMap[selectedSpecifyId];
			if (selectedSpecifyAssociationArray) {
				
				var existSelectedSpecifyAssociation = false;						
				for (var selectedSpecifyAssociationIndex = 0; selectedSpecifyAssociationIndex < selectedSpecifyAssociationArray.length; selectedSpecifyAssociationIndex++) {
					if (selectedSpecifyAssociationArray[selectedSpecifyAssociationIndex].getSpecifyValueId() 
							=== specifyAssociation.getSpecifyValueId() ) {
						existSelectedSpecifyAssociation = true;
						
						break;
					}
				}
				
				if (!existSelectedSpecifyAssociation) {
					selectedSpecifyAssociationArray.push(specifyAssociation);
				}
			} else {
				selectedSpecifyAssociationArray = new Array();
				selectedSpecifyAssociationArray.push(specifyAssociation);
				
				selectedSpecifyAssociationMap[selectedSpecifyId] = selectedSpecifyAssociationArray;
			}
			
			return;
		}
	}
	
});

/**
 * 选择规格值
 * 
 * @param specifyId
 * @param specifyValueId
 */
function selectSpecifyValue(specifyId, specifyValueId) {
	var baseSkuItem = cacheUtils.getBaseSkuItem();
	if (!baseSkuItem) {
		baseSkuItem = createBaseSkuItem();
		cacheUtils.setBaseSkuItem(baseSkuItem);
	}
	
	var checkbox_specifyValuePrefix = "checkbox_specifyValue_";
	var $specifyValueCheckBox = $("#" + checkbox_specifyValuePrefix + specifyValueId);
	var specifyAssociation = createSpecifyAssociation(specifyId, specifyValueId);
	
	if ($specifyValueCheckBox.is(":checked")) {
		handleChecked(specifyAssociation);
	} else {
		handleUnChecked(specifyAssociation);
	}
	
	createSkuTable();
	
	updateStoreOfPage("remainStoreQuantity");
	updateStoreOfPage("storeWarnNum");
	setBaseInformationInputDisabledOrNot();
	
	
	//以下内嵌函数的定义
	
	/**
	 * 创建一个"规格、规格值关联"对象
	 */
	function createSpecifyAssociation(specifyId, specifyValueId) {
		var $specifyValue = $("#specifyValue_" + specifyValueId);
		var value = $specifyValue.val();
		var specifyAssociation = new SpecifyAssociation();
		specifyAssociation.setSpecifyId(specifyId);
		specifyAssociation.setspecifyValueId(specifyValueId);
		specifyAssociation.setValue(value);
		return specifyAssociation;
	}
	
	/**
	 * 当规格值是选择状态时的处理
	 * 
	 * @param specifyAssociation
	 */
	function handleChecked(specifyAssociation) {
		var $specifyValueLabel = $("#label_specifyValue_" + specifyAssociation.getSpecifyValueId());
		$specifyValueLabel.hide();
		var $specifyValue = $("#specifyValue_" + specifyAssociation.getSpecifyValueId());
		$specifyValue.css("visibility", "visible");
		
		var selectedSpecifyAssociationMap = cacheUtils.getSelectedSpecifyAssociationMap();
		if (!selectedSpecifyAssociationMap || $.isEmptyObject(selectedSpecifyAssociationMap)) {
			handleFirstChecked(specifyAssociation);
		} else {
			handleNotFirstChecked(specifyAssociation);
		}
	}
	
	/**
	 * 当规格值是选择状态时，且是第一次选择规格值时的处理
	 * 
	 * @param specifyAssociation
	 */
	function handleFirstChecked(specifyAssociation) {
		var skuItemArray = cacheUtils.getSkuItemArray();
		if (!skuItemArray || $.isEmptyObject(skuItemArray)) {
			skuItemArray = new Array();
			cacheUtils.setSkuItemArray(skuItemArray);
			
			var skuItem = createSkuItem();
			skuItemArray.push(skuItem);
			
			//TODO 1.声明到顶部 2.使用数组直接量
			var specifyAssociationArray = new Array();
			specifyAssociationArray.push(specifyAssociation);
			skuItem.setSpecifyAssociationArray(specifyAssociationArray);
			
			selectedSpecifyAssociationMap = new Object();
			selectedSpecifyAssociationMap[specifyAssociation.getSpecifyId()] = specifyAssociationArray.slice();
			cacheUtils.setSelectedSpecifyAssociationMap(selectedSpecifyAssociationMap); ;
			
			var selectedSpecifyIdArray = new Array();
			selectedSpecifyIdArray.push(specifyAssociation.getSpecifyId());
			cacheUtils.setSelectedSpecifyIdArray(selectedSpecifyIdArray);;
		} 
	}
	
	/**
	 * 当规格值是选择状态时，且不是第一次选择规格值时的处理
	 * 
	 * @param specifyAssociation
	 */
	function handleNotFirstChecked(specifyAssociation) {
		var selectedSpecifyIdArray = cacheUtils.getSelectedSpecifyIdArray();
		var existSpecifyId = false;
		
		for (var selectedSpecifyIdIndex = 0; selectedSpecifyIdIndex < selectedSpecifyIdArray.length; selectedSpecifyIdIndex++) {
			if (specifyAssociation.getSpecifyId() === selectedSpecifyIdArray[selectedSpecifyIdIndex]) {
				existSpecifyId = true;
				break;
			}
		}
					
		if (existSpecifyId) {
			handleExistSpecifyId(specifyAssociation);
		} else {
			handleNotExistSpecifyId(specifyAssociation);
		}
	}
	
	/**
	 * 当选择的规格值所在的规格此前已经选择时的处理
	 * 
	 * @param specifyAssociation
	 */
	function handleExistSpecifyId(specifyAssociation) {
		var skuItemArray = cacheUtils.getSkuItemArray();
		var selectedSpecifyAssociationMap = cacheUtils.getSelectedSpecifyAssociationMap();
		var selectedSpecifyIdArray = cacheUtils.getSelectedSpecifyIdArray();
		
		if (selectedSpecifyIdArray.length === 1) {
			var skuItem = createSkuItem();
			
			var specifyAssociationArray = new Array();
			specifyAssociationArray.push(specifyAssociation);
			skuItem.setSpecifyAssociationArray(specifyAssociationArray);
			
			skuItemArray.push(skuItem);
		} else if (selectedSpecifyIdArray.length === 2) {
			var otherSpecifyId = null;
			var currentSpecifyIdIsFirst = true;
			if (specifyAssociation.getSpecifyId() === selectedSpecifyIdArray[0]) {
				otherSpecifyId = selectedSpecifyIdArray[1];
			} else if (specifyAssociation.getSpecifyId() === selectedSpecifyIdArray[1]) {
				currentSpecifyIdIsFirst = false;
				otherSpecifyId = selectedSpecifyIdArray[0];
			}
			
			for (var specifyAssociationIndex = 0; specifyAssociationIndex < selectedSpecifyAssociationMap[otherSpecifyId].length; specifyAssociationIndex++) {
				var skuItem = createSkuItem();
				
				var specifyAssociationArray = new Array();
				if (currentSpecifyIdIsFirst) {
					specifyAssociationArray.push(specifyAssociation);
					specifyAssociationArray.push(selectedSpecifyAssociationMap[otherSpecifyId][specifyAssociationIndex]);
				} else {
					specifyAssociationArray.push(selectedSpecifyAssociationMap[otherSpecifyId][specifyAssociationIndex]);
					specifyAssociationArray.push(specifyAssociation);
				}
				
				skuItem.setSpecifyAssociationArray(specifyAssociationArray);
				
				skuItemArray.push(skuItem);
			}
		}
		
		selectedSpecifyAssociationMap[specifyAssociation.getSpecifyId()].push(specifyAssociation);
	}
	
	/**
	 * 当选择的规格值所在的规格此前没有选择时的处理
	 * 
	 * @param specifyAssociation
	 */
	function handleNotExistSpecifyId(specifyAssociation) {
		var skuItemArray = cacheUtils.getSkuItemArray();
		for (var skuItemIndex = 0; skuItemIndex < skuItemArray.length; skuItemIndex++) {
			skuItemArray[skuItemIndex].getSpecifyAssociationArray().push(specifyAssociation);
		}
		
		var selectedSpecifyIdArray = cacheUtils.getSelectedSpecifyIdArray();
		selectedSpecifyIdArray.push(specifyAssociation.getSpecifyId());
		var selectedSpecifyAssociationMap = cacheUtils.getSelectedSpecifyAssociationMap();
		selectedSpecifyAssociationMap[specifyAssociation.getSpecifyId()] = [specifyAssociation];
	}	
	
	/**
	 * 当规格值是未选择状态时的处理
	 * 
	 * @param specifyAssociation
	 */
	function handleUnChecked(specifyAssociation) {
		var $specifyValueLabel = $("#label_specifyValue_" + specifyAssociation.getSpecifyValueId());
		$specifyValueLabel.show();
		var $specifyValue = $("#specifyValue_" + specifyAssociation.getSpecifyValueId());
		$specifyValue.css("visibility", "hidden");
		
		var selectedSpecifyAssociationMap = cacheUtils.getSelectedSpecifyAssociationMap();
		var specifyAssociationArray = selectedSpecifyAssociationMap[specifyAssociation.getSpecifyId()];
		for (var specifyAssociationIndex = 0; specifyAssociationIndex < specifyAssociationArray.length; specifyAssociationIndex++) {
			if (specifyAssociation.getSpecifyValueId() 
					=== specifyAssociationArray[specifyAssociationIndex].getSpecifyValueId()) {
				specifyAssociationArray.splice(specifyAssociationIndex, 1);
				break;
			}
		}
		
		if (specifyAssociationArray.length === 0) {
			delete selectedSpecifyAssociationMap[specifyAssociation.getSpecifyId()];
			
			var selectedSpecifyIdArray = cacheUtils.getSelectedSpecifyIdArray();
			var deleteSpecifyIdIndex = $.inArray(specifyAssociation.getSpecifyId(), selectedSpecifyIdArray);
			if (deleteSpecifyIdIndex != -1) {
				selectedSpecifyIdArray.splice(deleteSpecifyIdIndex, 1);
			}
		}
		
		var skuItemArray = cacheUtils.getSkuItemArray();
		for (var skuItemIndex = 0; skuItemIndex < skuItemArray.length; skuItemIndex++) {
			var specifyAssociationArray = skuItemArray[skuItemIndex].getSpecifyAssociationArray();
			for (var specifyAssociationIndex = 0; specifyAssociationIndex < specifyAssociationArray.length; specifyAssociationIndex++) {
				if (specifyAssociation.getSpecifyValueId() 
						=== specifyAssociationArray[specifyAssociationIndex].getSpecifyValueId()) {
					var selectedSpecifyIdArray = cacheUtils.getSelectedSpecifyIdArray();
					if (selectedSpecifyIdArray.length === 1 && specifyAssociationArray.length === 2) {
						specifyAssociationArray.splice(specifyAssociationIndex, 1);
					} else {
						skuItemArray.splice(skuItemIndex, 1);
						skuItemIndex--;
					}
					
					break;
				}
			}
		}
	}
}

/**
 * 设置基本信息相关文本框是否可用
 */
function setBaseInformationInputDisabledOrNot() {
	var skuItemArray = cacheUtils.getSkuItemArray();
	var $baseSalePrice = $("#baseSalePrice");
	var $baseMarketPrice = $("#baseMarketPrice");
	var $baseRemainStoreQuantity = $("#baseRemainStoreQuantity");
	var $baseStoreWarnNum = $("#baseStoreWarnNum");
	
	if (skuItemArray && skuItemArray.length > 0) {
		$baseSalePrice.attr("readonly", true);
		$baseSalePrice.addClass("input_gray");
		
		$baseMarketPrice.attr("readonly", true);
		$baseMarketPrice.addClass("input_gray");
		
		$baseRemainStoreQuantity.attr("readonly", true);
		$baseRemainStoreQuantity.addClass("input_gray");
		
		$baseStoreWarnNum.attr("readonly", true);
		$baseStoreWarnNum.addClass("input_gray");
	} else {
		$baseSalePrice.attr("readonly", false);
		$baseSalePrice.removeClass("input_gray");
		
		$baseMarketPrice.attr("readonly", false);
		$baseMarketPrice.removeClass("input_gray");
		
		$baseRemainStoreQuantity.attr("readonly", false);
		$baseRemainStoreQuantity.removeClass("input_gray");
		
		
		$baseStoreWarnNum.attr("readonly", false);
		$baseStoreWarnNum.removeClass("input_gray");
	}
}

/**
 * 创建基本的SkuItem
 * 
 * @returns {SkuItem}
 */
function createBaseSkuItem() {
	var baseSkuItem = new SkuItem();

	baseSkuItem.setSkuId("");
	baseSkuItem.setSalePriceYuan($("#baseSalePrice").val());
	baseSkuItem.setMarketPriceYuan($("#baseMarketPrice").val());
	if ($("#itemId").val() === "") {
		baseSkuItem.setRemainStoreQuantity($("#baseRemainStoreQuantity").val());
		baseSkuItem.setStoreWarnNum($("#baseStoreWarnNum").val());
	} else {
		baseSkuItem.setRemainStoreQuantity("0");
		baseSkuItem.setStoreWarnNum("0");
	}
	
	baseSkuItem.setSkuSN("");
	baseSkuItem.setMarketable(1);
	
	return baseSkuItem;
}

/**
 * 创建SkuItem
 * 
 * @returns {SkuItem}
 */
function createSkuItem() {
	var skuItem = new SkuItem();
	var baseSkuItem = cacheUtils.getBaseSkuItem();
	skuItem.setSkuId(baseSkuItem.getSkuId());
	skuItem.setSalePriceYuan(baseSkuItem.getSalePriceYuan());
	skuItem.setMarketPriceYuan(baseSkuItem.getMarketPriceYuan());
	skuItem.setRemainStoreQuantity(baseSkuItem.getRemainStoreQuantity());
	skuItem.setStoreWarnNum(baseSkuItem.getStoreWarnNum());
	skuItem.setSkuSN(baseSkuItem.getSkuSN());
	skuItem.setMarketable(baseSkuItem.getMarketable());
	
	return skuItem;
}

/**
 * 创建用于展示Sku 的表格
 * 
 */
function createSkuTable() {
	var skuItemArray = cacheUtils.getSkuItemArray();
	sortSkuItemArray(skuItemArray);
	
	var allTrs = "";
	if (skuItemArray && skuItemArray.length > 0) {
		allTrs += "<tr>";
		
		var selectedSpecifyIdArray = cacheUtils.getSelectedSpecifyIdArray();
		for (var index = 0; index < selectedSpecifyIdArray.length; index++) {
			var specifyNameTemp = $("#specifyName_" + selectedSpecifyIdArray[index]).text();
			var specifyName = specifyNameTemp.substring(0, specifyNameTemp.length - 2);
			allTrs += "<th>" + specifyName + "</th>";
		}
		
		var rowspan = 1;
		if (selectedSpecifyIdArray.length === 2) {
			var selectedSpecifyAssociationMap = cacheUtils.getSelectedSpecifyAssociationMap();
			rowspan = selectedSpecifyAssociationMap[selectedSpecifyIdArray[1]].length;
		}
		
		
		allTrs += "<th>易通价<em class='red'>*</em></th><th>市场价<em class='red'>*</em></th><th>剩余库存<em class='red'>*</em></th><th>报警库存</th><th>货号</th><th>上架</th>";
		allTrs += "</tr>";
		
		for (var skuItemIndex = 0; skuItemIndex < skuItemArray.length; skuItemIndex++) {
			var skuItem = skuItemArray[skuItemIndex];
			allTrs += createSkuTr(skuItem, skuItemIndex, rowspan);
		}
		
		$("#skuItemTable").html(allTrs);
		$("#skuSnTip").text("（注：货号为空时，将由系统自动生成！）");
	} else {
		$("#skuItemTable").empty();
		$("#skuSnTip").empty();
	}
}

/**
 * 创建用于展示一个Sku 的表格行
 * 
 * @param skuItem
 * @param skuItemIndex
 * @param rowspan
 * @returns {String}
 */
function createSkuTr(skuItem, skuItemIndex, rowspan) {
	var skuTr = "<tr>";
	var specifyAssociationArray = skuItem.getSpecifyAssociationArray();
	var specifyAssociationHtml = "";
	for (var specifyAssociationIndex = 0; specifyAssociationIndex < specifyAssociationArray.length; specifyAssociationIndex++) {
		if (specifyAssociationIndex === 0 && skuItemIndex % rowspan === 0) {
			skuTr += "<td rowspan='" + rowspan + "' class='td_" + specifyAssociationArray[specifyAssociationIndex].getSpecifyValueId() + "' >" 
				+ specifyAssociationArray[specifyAssociationIndex].getValue() + "</td>";
		} else if (specifyAssociationIndex === 1) {
			skuTr += "<td class='td_" + specifyAssociationArray[specifyAssociationIndex].getSpecifyValueId() + "' >" 
				+ specifyAssociationArray[specifyAssociationIndex].getValue() + "</td>";	
		}
		
		specifyAssociationHtml += "<input type='hidden' " 
			+ "name='itemVO.skuItemVOList[" + skuItemIndex + "].specifyAssociationList[" + specifyAssociationIndex + "].specifyId' " 
			+ "value='" + specifyAssociationArray[specifyAssociationIndex].getSpecifyId() + "' />";
		
		specifyAssociationHtml += "<input type='hidden' " 
			+ "name='itemVO.skuItemVOList[" + skuItemIndex + "].specifyAssociationList[" + specifyAssociationIndex + "].specifyValueId' " 
			+ "value='" + specifyAssociationArray[specifyAssociationIndex].getSpecifyValueId() +"' />";
		
		specifyAssociationHtml += "<input type='hidden' class='skuItem_" + specifyAssociationArray[specifyAssociationIndex].getSpecifyValueId() + "' "
			+ "name='itemVO.skuItemVOList[" + skuItemIndex + "].specifyAssociationList[" + specifyAssociationIndex + "].value' " 
			+ "value='" + specifyAssociationArray[specifyAssociationIndex].getValue() + "' />";
	}
	
	skuTr += "<td><input id='salePriceYuan_" + skuItemIndex + "' name='itemVO.skuItemVOList[" + skuItemIndex +"].salePriceYuan' class='inpt edit_vol' value='" 
		+ skuItem.getSalePriceYuan()
		+ "' onblur='updateProperty(\"salePriceYuan\", " + skuItemIndex + ");' maxlength= '8' /></td>";
		
	skuTr += "<td><input id='marketPriceYuan_" + skuItemIndex + "' name='itemVO.skuItemVOList[" + skuItemIndex +"].marketPriceYuan' class='inpt edit_price' value='" 
		+ skuItem.getMarketPriceYuan()
		+ "' onblur='updateProperty(\"marketPriceYuan\", " + skuItemIndex + ");' maxlength= '8' /></td>";
	
	skuTr += "<td><input id='remainStoreQuantity_" + skuItemIndex + "' name='itemVO.skuItemVOList[" + skuItemIndex +"].remainStoreQuantity' class='inpt edit_vol' value='" 
		+ skuItem.getRemainStoreQuantity()
		+ "' onblur='updateStore(\"remainStoreQuantity\", " + skuItemIndex + ");' maxlength= '8' /></td>";
	
	skuTr += "<td><input id='storeWarnNum_" + skuItemIndex + "' name='itemVO.skuItemVOList[" + skuItemIndex +"].storeWarnNum' class='inpt edit_vol' value='" 
		+ skuItem.getStoreWarnNum()
		+ "' onblur='updateStore(\"storeWarnNum\", " + skuItemIndex + ");' maxlength= '8' /></td>";
	
	skuTr += "<td><input id='skuSN_" + skuItemIndex + "' name='itemVO.skuItemVOList[" + skuItemIndex +"].skuSN' class='inpt edit_vol' value='" 
		+ skuItem.getSkuSN()
		+ "' onchange='updateProperty(\"skuSN\", " + skuItemIndex + ");' /></td>";
	
	
	var chekcedHtml = "";
	if (skuItem.getMarketable() === 1) {
		chekcedHtml = "checked='checked'";
	}
	
	skuTr += "<td><input id='marketable_" + skuItemIndex + "'name='itemVO.skuItemVOList[" + skuItemIndex +"].marketable' class='inpt edit_vol' value='" 
		+ skuItem.getMarketable()
		+ "' onchange='updateMarketable(\"marketable\", " + skuItemIndex + ");' type='checkbox' " + chekcedHtml + "/></td>";
	
	skuTr += "<input type='hidden' name='itemVO.skuItemVOList[" + skuItemIndex +"].skuId'  value='" 
		+ skuItem.getSkuId() + "' />";
		
	skuTr += specifyAssociationHtml;
	
	skuTr += "</tr>";
	
	return skuTr;
}

/**
 * 对sku数组进行排序
 * 
 * @param skuItemArray
 */
function sortSkuItemArray(skuItemArray) {
	skuItemArray.sort(function(firstSkuItem, secondSkuItem) {
		var firstSpecifyAssociationArray = firstSkuItem.getSpecifyAssociationArray();
		var secondSpecifyAssociationArray = secondSkuItem.getSpecifyAssociationArray();
		if (firstSpecifyAssociationArray.length > 0) {
			var result = firstSpecifyAssociationArray[0].getValue().localeCompare(secondSpecifyAssociationArray[0].getValue());
			
			if (result === 0 && firstSpecifyAssociationArray.length > 1) {
				result = firstSpecifyAssociationArray[1].getValue().localeCompare(secondSpecifyAssociationArray[1].getValue());
			}
			
			return result;
		}
	});
}

/**
 * 更新页面表格和缓存中相应的规格值
 * 
 * @param specifyId
 * @param specifyValueId
 */
function changeSpecifyValue(specifyId, specifyValueId) {
	var $specifyValue = $("#specifyValue_" + specifyValueId);
	var value = $specifyValue.val();
	
	var $skuItemSpecifyValue = $(".skuItem_" + specifyValueId);
	$skuItemSpecifyValue.val(value);
	
	var $specifyValueTd = $(".td_" + specifyValueId);
	$specifyValueTd.html(value);
	
	
	var selectedSpecifyAssociationMap = cacheUtils.getSelectedSpecifyAssociationMap();;
	if (!selectedSpecifyAssociationMap) {
		return;
	}
	
	var specifyAssociationArray = selectedSpecifyAssociationMap[specifyId];
	if (!specifyAssociationArray) {
		return;
	}
	
	for (var index = 0; index < specifyAssociationArray.length; index++) {
		if (specifyValueId === specifyAssociationArray[index].getSpecifyValueId()) {
			specifyAssociationArray[index].setValue(value);
		}
	}
	
}

/**
 * 更新页面和缓存中sku的剩余库存或报警库存
 * 
 * @param propertyPrefix
 * @param skuItemIndex
 */
function updateStore(propertyPrefix, skuItemIndex) {
	updateStoreOfPage(propertyPrefix);
	updateProperty(propertyPrefix, skuItemIndex);
}

/**
 * 更新页面sku的剩余库存或报警库存
 * 
 * @param propertyPrefix
 */
function updateStoreOfPage(propertyPrefix) {
	var $propertyInputs = $("input[id^='" + propertyPrefix + "_']");
	var totoalStoreNumber = 0;
	$propertyInputs.each(function() {
		var storeNumber = 0;
		if (this.value !== "") {
			storeNumber = parseInt(this.value);
		} 
		
		totoalStoreNumber += storeNumber;
	});
	
	$("#base" + propertyPrefix.slice(0, 1).toUpperCase() + propertyPrefix.slice(1)).val(totoalStoreNumber);
}

/**
 * 更新缓存中sku的属性值
 * 
 */
function updateProperty(propertyPrefix, skuItemIndex) {
	var skuItemArray = cacheUtils.getSkuItemArray();
	if (skuItemArray) {
		var $propertyInput = $("#" + propertyPrefix + "_" + skuItemIndex);
		
		if (propertyPrefix === "salePriceYuan") {
			var newSkuItemSalePriceYuan = $propertyInput.val() || 0;
			skuItemArray[skuItemIndex].setSalePriceYuan(newSkuItemSalePriceYuan);
			
			var minSkuItemSalePrice = Number.MAX_VALUE;
			for (var index = 0; index < skuItemArray.length; index++) {
				var salePriceYuan = parseFloat(skuItemArray[index].getSalePriceYuan());
				if (minSkuItemSalePrice > salePriceYuan) {
					minSkuItemSalePrice = salePriceYuan;
				}
			}
			
			var $baseSalePriceInput = $("#baseSalePrice");
			$baseSalePriceInput.val(minSkuItemSalePrice);
			
		} else if (propertyPrefix === "marketPriceYuan") {
			var newSkuItemMarketPriceYuan = $propertyInput.val() || 0;
			skuItemArray[skuItemIndex].setMarketPriceYuan(newSkuItemMarketPriceYuan);
			
			var maxSkuItemMarketPrice = -Number.MAX_VALUE;
			for (var index = 0; index < skuItemArray.length; index++) {
				var marketPriceYuan = parseFloat(skuItemArray[index].getMarketPriceYuan());
				if (maxSkuItemMarketPrice < marketPriceYuan) {
					maxSkuItemMarketPrice = marketPriceYuan;
				}
			}
			
			var $baseMarketPriceInput = $("#baseMarketPrice");
			$baseMarketPriceInput.val(maxSkuItemMarketPrice);			
		} else if (propertyPrefix === "remainStoreQuantity") {
			skuItemArray[skuItemIndex].setRemainStoreQuantity($propertyInput.val());
		} else if (propertyPrefix === "storeWarnNum") {
			skuItemArray[skuItemIndex].setStoreWarnNum($propertyInput.val());
		} else if (propertyPrefix === "skuSN") {
			skuItemArray[skuItemIndex].setSkuSN($propertyInput.val());
		}
	}
}

/**
 * 更新页面中和缓存中sku的上下架的值
 * 
 * @param propertyPrefix
 * @param skuItemIndex
 */
function updateMarketable(propertyPrefix, skuItemIndex) {
	var skuItemArray = cacheUtils.getSkuItemArray();
	if (skuItemArray) {
		var $propertyInput = $("#" + propertyPrefix + "_" + skuItemIndex);
		if ($propertyInput.is(":checked")) {
			$propertyInput.val(1);
			skuItemArray[skuItemIndex].setMarketable(1);
		} else {
			$propertyInput.val(0);
			skuItemArray[skuItemIndex].setMarketable(0);
		}
		
	}
}
//规格相关js end


//校验相关js start
$(function() {
	bindEventForValidate();
	
	/**
	 * 绑定校验相关事件
	 */
	function bindEventForValidate() {
		//属性的校验绑定事件
		$("input[name ^= 'itemVO.itemPropertiesVOList'][type != 'hidden'][disabled = false]").live("blur", validateInputTypeProperty);
		$("select[name ^= 'itemVO.itemPropertiesVOList'][type != 'hidden'][disabled = false]").live("click", validateSelectTypeProperty);
		
		$("#itemName").bind("blur", validateItemName);
		$("#itemSn").bind("blur", validateItemSn);
		$("#brand").bind("click", validateBrand);
		
		var $moneyInputs = $("#baseSalePrice, #baseMarketPrice, input=[id ^= 'deliveryFee_']");
		$moneyInputs.bind("keyup", validateMoney);
		
		var $baseSalePriceInput = $("#baseSalePrice");
		$baseSalePriceInput.bind("blur", validateBaseSalePrice);
		
		var $baseMarketPriceInput = $("#baseMarketPrice");
		$baseMarketPriceInput.bind("blur", validateBaseMarketPrice);
		//TODO
		var $storeInputs = $("#baseRemainStoreQuantity, #baseStoreWarnNum");
		$storeInputs.bind("keyup", validateStore);
		
		var $baseRemainStoreQuantityInput = $("#baseRemainStoreQuantity");
		$baseRemainStoreQuantityInput.bind("blur", validateBaseRemainStoreQuantity);
		
		//sku 校验
		var $skuPriceInputs = $("input[id ^= 'salePrice'], input[id ^= 'marketPrice']");
		$skuPriceInputs.live("keyup", validateMoney);
		
		var $skuStoreInputs = $("input[id ^= 'remainStoreQuantity'], input[id ^= 'storeWarnNum']");
		$skuStoreInputs.live("keyup", validateStore);
		
		//店铺分类校验
		var $storeCategoryIdInputs = $("input[name='itemVO.storeCategoryIdList']");
		$storeCategoryIdInputs.bind("click", validateStoreCategory);
		
		//使用模板时的运费校验
		var $useFreightTemplateInput = $("#useFreightTemplate, input[name='itemVO.feeTemplateId']");
		$useFreightTemplateInput.bind("click", validateFreightTemplate);
		
		//没有使用模板时的运费校验
		var $setFreightInputAndCheckboxs = $("#setFreight, input[id ^= 'deliveryTypeSupport']");
		$setFreightInputAndCheckboxs.bind("click", validateSetFreight);
		var $deliveryFeeInputs = $("input[id ^= 'deliveryFee_']");
		$deliveryFeeInputs.bind("blur", validateSetFreight);
		
		//提交前绑定校验函数
		$("#itemForm").bind("submit", validate);
	}
	
	/**
	 * 校验商品名称
	 */
	function validateItemName(event, result) {
		var itemName = $("#itemName");
		var totalLength = computeLengthByByte(itemName.val());
		var $itemNameWrong = $("#itemNameWrong");
		
		if (totalLength === 0 ) {
			$itemNameWrong.html("<i></i>商品名称不能为空！");
			$itemNameWrong.show();
			
			if (result) {
				result.success = false;
				result.errors.push("商品名称不能为空！");
			}
			
		} else if (totalLength > 120) {
			$itemNameWrong.html("<i></i>最大长度为120个字节(一个中文算两个字节，字母和数字等算一个字节)");
			$itemNameWrong.show();
			
			if (result) {
				result.success = false;
				result.errors.push("商品名称最大长度为120个字节(一个中文算两个字节，字母和数字等算一个字节)");
			}
			
		} else {
			$itemNameWrong.hide();
		}
	}
	
	/**
	 * 校验商品编号
	 */
	function validateItemSn(event, result) {
		var $itemSn = $("#itemSn");
		var $itemSnWrong=$("#itemSnWrong");
		var regExp = new RegExp("[\u4E00-\uFA29]|[\uE7C7-\uE7F3]");
		
		if (regExp.test($itemSn.val())) {
			$itemSnWrong.addClass("wrong");
			$itemSnWrong.html("<i></i>不能有中文！");
			$itemSnWrong.show();
			
			if (result) {
				result.success = false;
				result.errors.push("商品编号不能有中文！");
			}
			
			return;
		}
		
		var totalLength = computeLengthByByte($itemSn.val());
		
		if (totalLength > 160) {
			$itemSnWrong.addClass("wrong");
			$itemSnWrong.html("<i></i>最大长度为160个字符");
			$itemSnWrong.show();
			
			if (result) {
				result.success = false;
				result.errors.push("商品编号最大长度为160个字符");
			}
		} else {
			$itemSnWrong.removeClass("wrong");
			$itemSnWrong.html("(注：若为空，将由系统自动生成！)");
			$itemSnWrong.show();
		}
	}
	
	/**
	 * 校验品牌
	 */
	function validateBrand(event, result)  {
		var $brand = $("#brand");
		if ($brand.attr("selectedIndex") === 0) {
			$("#brandWrong").show();
			
			if (result) {
				result.success = false;
				result.errors.push("品牌不能为空！");
			}
		} else {
			$("#brandWrong").hide();
		}
	}
	
	/**
	 * 校验属性
	 */
	function validateInputTypeProperty(event, result) {
		var $this = $(this);
		var propertyType = $this.attr("propertyType");
		
		if (propertyType == 0 || propertyType == 5) {
			validatePropertyLength($this, result);
		}
		
		if (propertyType == 1) {
			validateNumericProperty($this, result);
		}
		
		if (propertyType == 2) {
			validateAlphabeticProperty($this, result);
		}
		
		if (propertyType == 4) {
			validateCheckboxProperty($this, result);
		}
	}
	
	/**
	 * 校验类型为Checkbox的属性
	 */
	function validateCheckboxProperty($this, result) {
		var propertyRequired = $this.attr("propertyRequired");
		var $checkboxs = $("input[name='" + $this.attr("name") + "']");
		
		if (propertyRequired == 1) {
			
			var checkdNumber = 0;
			for (var index = 0; index < $checkboxs.length; index++) {
				if (!$checkboxs[index].disabled) {
					if ($checkboxs[index].checked) {
						checkdNumber += 1;
					}
				}
			}
			
			var $wrong = $this.next();
			if (checkdNumber === 0) {
				$wrong = $($checkboxs[$checkboxs.length - 1]).next();
				$wrong.html("<i></i>此项不能为空！");
				$wrong.show();
				
				if (result) {
					result.success = false;
					var propertyName = $this.attr("propertyName");
					
					//提交时，会触发所有的多选框，为避免每次触发时加入已经存在的错误提示，在此检查下。
					for (var index = 0; index < result.errors.length; index++) {
						var error = result.errors[index];
						if (error && error.indexOf(propertyName) != -1) {
							return;
						}
					}
					
					result.errors.push("属性\"" + propertyName + "\"不能为空！");
				}
			} else {
				$wrong = $($checkboxs[$checkboxs.length - 1]).next();
				$wrong.hide();
			}
		} 
	}
	
	/**
	 * 校验要求必须为数字的属性
	 */
	function validateNumericProperty($this, result) {
		var success = validatePropertyLength($this, result);
		
		if (success) {
			var value = $this.val();
			var regExp = new RegExp("^[0-9]+$");
			var $wrong = $this.next();
			
			if (value.length > 0 && !regExp.test(value)) {
				$wrong.html("此属性值类型必须为数字！");
				$wrong.show();
				
				if (result) {
					result.success = false;
					var propertyName = $this.attr("propertyName");
					result.errors.push("属性\"" + propertyName + "\"类型必须为数字！");
				}
			} else {
				$wrong.hide();
			}
		}
	}
	
	/**
	 * 校验要求必须为字母的属性
	 */
	function validateAlphabeticProperty($this, result) {
		var success = validatePropertyLength($this, result);
		
		if (success) {
			var value = $this.val();
			var regExp = new RegExp("^[A-Za-z]+$");
			var $wrong = $this.next();
			
			if (value.length > 0 && !regExp.test(value)) {
				$wrong.html("此属性值类型必须为字母！");
				$wrong.show();
				
				if (result) {
					result.success = false;
					var propertyName = $this.attr("propertyName");
					result.errors.push("属性\"" + propertyName + "\"类型必须为字母！");
				}
			} else {
				$wrong.hide();
			}
		}
	}
	
	/**
	 * 校验属性的长度
	 */
	function validatePropertyLength($this, result) {
		var $wrong = $this.next();
		var propertyRequired = $this.attr("propertyRequired");
		var totalLength = computeLengthByByte($this.val());
		
		if (propertyRequired == 1 && totalLength === 0) {
			$wrong.html("<i></i>此项不能为空！");
			$wrong.show();
			
			if (result) {
				result.success = false;
				var propertyName = $this.attr("propertyName");
				result.errors.push("属性\"" + propertyName + "\"不能为空！");
			}
			
			return false;
			
		} else if (totalLength > 900) {
			$wrong.html("<i></i>最大长度为900个字节(一个中文算两个字节，字母和数字等算一个字节)");
			$wrong.show();
			
			if (result) {
				result.success = false;
				var propertyName = $this.attr("propertyName");
				result.errors.push("属性\"" + propertyName + "\"长度超过限制！");
			}
			
			return false;
		} else {
			$wrong.hide();
		}
		
		return true;
	}
	
	/**
	 * 校验类型为select的属性
	 */
	function validateSelectTypeProperty(event, result) {
		var $this = $(this);
		var propertyType = $this.attr("propertyType");
		
		if (propertyType == 3) {
			var $wrong = $this.next();
			var propertyRequired = $this.attr("propertyRequired");
			
			if (propertyRequired == 1 && $this.attr("selectedIndex") === 0) {
				$wrong.html("<i></i>此项不能为空！");
				$wrong.show();
				
				if (result) {
					result.success = false;
					var propertyName = $this.attr("propertyName");
					result.errors.push("属性\"" + propertyName + "\"不能为空！");
				}
			} else {
				$wrong.hide();
			}
		}
	}
	
	/**
	 * 校验钱相关
	 */
	function validateMoney() {
		var $this = $(this);
		var price = $this.val();
		price = confirmMoney(price);
		$this.val(price);
	}
	
	/**
	 * 检验基本的易通价（即商品的易通价）
	 */
	function validateBaseSalePrice(event, result) {
		var $baseSalePriceInput = $("#baseSalePrice");
		var baseSalePrice = $baseSalePriceInput.val();
		var newBaseSalePrice = confirmMoney(baseSalePrice);
		var $wrong = $("#baseSalePriceWrong");
		
		if (newBaseSalePrice.length === 0) {
			$wrong.html("<i></i>易通价不能为空！");
			$wrong.show();
			
			if (result) {
				result.success = false;
			result.errors.push("易通价不能为空！");
			}
		} else {
			if (parseFloat(newBaseSalePrice) < 0) {
				$wrong.html("<i></i>易通价不能小于0！");
				$wrong.show();
				
				if (result) {
					result.success = false;
					result.errors.push("易通价不能小于0！");
				}
			} else if (newBaseSalePrice > 20000000) {
				$wrong.html("<i></i>易通价不能大于20000000！");
				$wrong.show();
				
				if (result) {
					result.success = false;
					result.errors.push("易通价不能大于20000000！");
				}
			} else {
				$wrong.hide();
			}
		}
		
		$baseSalePriceInput.val(newBaseSalePrice);
	}
	
	/**
	 * 检验基本的市场价（即商品的市场价）
	 */
	function validateBaseMarketPrice(event, result) {
		var $baseMarketPriceInput = $("#baseMarketPrice");
		var baseMarketPrice = $baseMarketPriceInput.val();
		baseMarketPrice = confirmMoney(baseMarketPrice);
		var $wrong = $("#baseMarketPriceWrong");
		
		if (baseMarketPrice.length === 0) {
			$wrong.html("<i></i>市场价不能为空！");
			$wrong.show();
			
			if (result) {
				result.success = false;
				result.errors.push("市场价不能为空！");
			}
		} else {
			var marketPrice = parseFloat(baseMarketPrice);
			if (marketPrice < 0) {
				$wrong.html("<i></i>市场价不能小于0！");
				$wrong.show();
				
				if (result) {
					result.success = false;
					result.errors.push("市场价不能小于0！");
				}
			} else if(marketPrice > 20000000) {
				$wrong.html("<i></i>市场价不能大于20000000！");
				$wrong.show();
				
				if (result) {
					result.success = false;
					result.errors.push("市场价不能大于20000000！");
				}
			}else {
				var $baseSalePriceInput = $("#baseSalePrice");
				var baseSalePrice = $baseSalePriceInput.val();
				if (baseSalePrice && (baseSalePrice.length > 0) 
						&& (marketPrice < parseFloat(baseSalePrice))) {
					$wrong.html("<i></i>易通价不能大于市场价！");
					$wrong.show();
					
					if (result) {
						result.success = false;
						result.errors.push("易通价不能大于市场价！");
					}
				} else {
					$wrong.hide();
				}
			}
			
		}
		
		$baseMarketPriceInput.val(baseMarketPrice);
	}
	
	/**
	 * 校验库存
	 */
	function validateStore() {
		var $this = $(this);
		var storeNumber = $this.val();
		storeNumber = confirmStore(storeNumber);
		
		$this.val(storeNumber);
	}
	
	/**
	 * 校验基本的剩余库存（即商品的剩余库存）
	 */
	function validateBaseRemainStoreQuantity(event, result) {
		var $baseRemainStoreQuantityInput = $("#baseRemainStoreQuantity");
		var baseRemainStoreQuantity = $baseRemainStoreQuantityInput.val();
		var $wrong = $("#baseRemainStoreQuantityWrong");
		
		if (baseRemainStoreQuantity.length === 0) {
			$wrong.html("<i></i>剩余库存不能为空！");
			$wrong.show();
			
			if (result) {
				result.success = false;
				result.errors.push("剩余库存不能为空！");
			}
		} else {
			$wrong.hide();
		}
		
		$baseRemainStoreQuantityInput.val(baseRemainStoreQuantity);
	}
	
	/**
	 * 确保剩余库存为正整数
	 */
	function confirmStore(storeNumber) {
		var result = null;
		result = storeNumber.replace(/\D/g, "");
		
		return result;
	}
	
	/**
	 * 确保输入值为合适的“钱”
	 */
	function confirmMoney(value) {
		var result = null;
		//先把非数字的都替换掉，除了数字和.
		result = value.replace(/[^\d.]/g, "");
	    //必须保证第一个为数字而不是.
	    result = result.replace(/^\./g, "");
	    //保证只有出现一个.而没有多个.
	    result = result.replace(/\.{2,}/g, ".");
	    //保证.只出现一次，而不能出现两次以上
	    result = result.replace(".", "$#$").replace(/\./g, "").replace("$#$", ".");
	    
	    return result;
	}
	
	/**
	 *校验店铺分类 
	 */
	function validateStoreCategory(event, result) {
		var checkdNumber = 0;
		var $wrong = $("#storeCategoryWrong");
		var $storeCategoryIdInputs = $("input[name='itemVO.storeCategoryIdList']");
		
		for (var index = 0; index < $storeCategoryIdInputs.length; index++) {
			if (!$storeCategoryIdInputs[index].disabled) {
				if ($storeCategoryIdInputs[index].checked) {
					checkdNumber += 1;
				}
			}
		}
		
		if (checkdNumber === 0) {
			$wrong.html("<i></i>店铺分类不能为空！");
			$wrong.show();
			
			if (result) {
				result.success = false;
				result.errors.push("店铺分类不能为空！");
			}
		} else {
			$wrong.hide();
		}
	}
	
	/**
	 * 校验运费模板相关
	 */
	function validateFreightTemplate(event, result) {
		var $freightTemplateInputs = $("input[name='itemVO.feeTemplateId']");
		var checkedTemplate = false;
		for (var index = 0; index < $freightTemplateInputs.length; index++) {
			if ($freightTemplateInputs[index].checked) {
				checkedTemplate = true;
				
				break;
			}
		}
		
		var $wrongMessage = $("#useFreightTemplateWrong");
		if (checkedTemplate) {
			$wrongMessage.hide();
		} else {
			$wrongMessage.html("<i></i>请选择一个运费模板！");
			$wrongMessage.show();
			
			if (result) {
				result.success = false;
				result.errors.push("运费模板不能为空！");
			}
		}
	}

	/**
	 * 校验不使用运费模板的运费相关
	 */
	function validateSetFreight(event, result) {
		var checkedOneAtList = false;
		var $deliveryTypeSupportCheckboxs = $("input[id ^= 'deliveryTypeSupport']");
		for (var index = 0; index < $deliveryTypeSupportCheckboxs.length; index++) {
			if ($deliveryTypeSupportCheckboxs[index].checked) {
				checkedOneAtList = true;
				
				break;
			} 
		}
		
		var $wrongMessage = $("#setFreightWrong");
		if (checkedOneAtList) {
			$("input[id ^= 'deliveryFee_']").each(function() {
				var $this = $(this);
				if ($this.val() === "") {
					$this.next().html("<i></i>运费不能为空！");
					$this.next().show();
					
					if (result) {
						result.success = false;
						result.errors.push($this.prev().text().replace("：", "") + "的运费不能为空！");
					}
				} else {
					$this.next().hide();
				}
			});
			
			$wrongMessage.hide();
		} else {
			$wrongMessage.html("<i></i>必须至少支持一种物流！");
			$wrongMessage.show();
			
			if (result) {
				result.success = false;
				result.errors.push("必须至少支持一种物流！");
			}
		}
	}
	    
	/**
	 * 以字节为单位计算长度
	 */
	function computeLengthByByte(str) {
		var totalLength = 0;
		for (var index = 0; index < str.length; index++) {
			if ((str.charCodeAt(index) >= 0) && (str.charCodeAt(index) <= 255))
				totalLength = totalLength + 1;
			else
				totalLength = totalLength + 2;
		}
		
		return totalLength;
	}
	
	/**
	 * 提交前的相关校验
	 */
	function validate() {
		if (this.action.indexOf('item!change.action') != -1) {
			return true;
		}
		
		var result = new Object();
		result.success = true;
		result.errors = new Array();
		
		validateItem(result);
		
		return handleResult(result);
	}
	
	/**
	 * 校验商品
	 */
	function validateItem(result) {
		validateProperty(result);
		validateItemName(null, result);
		validateItemSn(null, result);
		validateBrand(null, result);
		validateBaseSalePrice(null, result);
		validateBaseMarketPrice(null, result);
		validateBaseRemainStoreQuantity(null, result);
		validateImage(result);
		validateSpecifyValue(result);
		validateSkuItem(result);
		validateStoreCategory(null, result);
		validateFreight(result);
	}
	
	/**
	 * 处理校验的结果
	 */
	function handleResult(result) {
		if (result.success) {
			return true;
		} 
		
		var $errorDiv = $("#errorDiv");
		$errorDiv.show();
		
		var errorMessage = "";
		for (var index = 0; index < result.errors.length; index++) {
			errorMessage += "<li>" + result.errors[index] + "</li>";
		}
		
		var $errorList = $("#errorList");
		$errorList.html(errorMessage);
		$(document).scrollTop(0);//滚动条滑动最顶部,显示错误提示列表
		
		return false;
	}
	
	/**
	 * 校验商品属性
	 */
	function validateProperty(result) {
		$("input[name ^= 'itemVO.itemPropertiesVOList'][type != 'hidden'][disabled = false]").trigger("blur", result);
		$("select[name ^= 'itemVO.itemPropertiesVOList'][type != 'hidden'][disabled = false]").trigger("click", result);
	}
	
	/**
	 * 校验商品图片
	 */
	function validateImage(result) {
		var itemImages = $("input[name = 'itemVO.imagesUrl']");
		if (!itemImages || itemImages.length === 0) {
			result.success = false;
			result.errors.push("您必须上传至少一张主图片！");
		} else if (itemImages.length > 5) {
			result.success = false;
			result.errors.push("商品图片不能超过5张！");
		}
	}
	
	/**
	 * 校验商品运费相关
	 */
	function validateFreight(result) {
		if (!$("#buyers").is(":checked")) {
			return;
		}
		
		var $useFreightTemplateInput = $("#useFreightTemplate");
		if ($useFreightTemplateInput.is(":checked")) {
			validateFreightTemplate(null, result);
		}
		
		var $setFreight = $("#setFreight");
		if($setFreight.is(":checked")) {
			validateSetFreight(null, result);
		}
	}
	
	/**
	 * 校验规格值：业务规则1：自定义规格值不能重复
	 */
	function validateSpecifyValue(result) {
		 var $specifyValueInputs = $("input[id ^= 'checkbox_specifyValue_']:checked ~ input");
		 if (!$specifyValueInputs || $specifyValueInputs.length <= 0) {
			 return;
		 }
		 
		 for (var outerIndex = 0; outerIndex < $specifyValueInputs.length; outerIndex++) {
			 for (var innerIndex = outerIndex + 1; innerIndex < $specifyValueInputs.length; innerIndex++) {
				 if ($specifyValueInputs[outerIndex].value === $specifyValueInputs[innerIndex].value) {
					 result.success = false;
					 result.errors.push("规格值”" + $specifyValueInputs[innerIndex].value + "“不能重复！" );
					 
					 return;
				 }
			 }
		 }
	}
	
	/**
	 * 校验货品/sku
	 */
	function validateSkuItem(result) {
		var skuItemArray = cacheUtils.getSkuItemArray();
		if (skuItemArray && skuItemArray.length > 0) {
			validatePrice(result);
			validateStore(result);
			validateSkuSN(result);
		}
		
		/**
		 * 校验货品相关价格
		 */
		function validatePrice(result) {
			for (var index = 0; index < skuItemArray.length; index++) {
				var skuItem = skuItemArray[index];
				var error = false;
				
				//TODO undefined 不建议使用
				if (skuItem.getSalePriceYuan() === "" || skuItem.getSalePriceYuan() === undefined) {
					result.success = false;
					result.errors.push("货品的易通价不能为空！");
					error = true;
				} else {
					if (parseFloat(skuItem.getSalePriceYuan()) < 0) {
						result.success = false;
						result.errors.push("货品的易通价不能小于0！");
						error = true;
					} else if (parseFloat(skuItem.getSalePriceYuan()) > 20000000) {
						result.success = false;
						result.errors.push("货品的易通价不能大于20000000！");
						error = true;
					}
				}
				
				if (skuItem.getMarketPriceYuan() === "" || skuItem.getMarketPriceYuan() === undefined) {
					result.success = false;
					result.errors.push("货品的市场价不能为空！");
					error = true;
				} else {
					if (parseFloat(skuItem.getMarketPriceYuan()) < 0) {
						result.success = false;
						result.errors.push("货品的市场价不能小于0！");
						error = true;
					} else if (parseFloat(skuItem.getMarketPriceYuan()) > 20000000) {
						result.success = false;
						result.errors.push("货品的市场价不能大于20000000！");
						error = true;
					}
					
					if (parseFloat(skuItem.getMarketPriceYuan()) < parseFloat(skuItem.getSalePriceYuan())) {
						result.success = false;
						result.errors.push("货品的易通价不能大于市场价！");
						error = true;
					} 
				}
				
				if (error) {
					return;
				}
			}
		}
		
		/**
		 * 校验货品相关剩余库存
		 */
		function validateStore(result) {
			for (var index = 0; index < skuItemArray.length; index++) {
				var skuItem = skuItemArray[index];
				var error = false;
				if (skuItem.getRemainStoreQuantity() === "" || skuItem.getRemainStoreQuantity() === undefined) {
					result.success = false;
					result.errors.push("货品的剩余库存不能为空！");
					error = true;
				} else {
					if (parseInt(skuItem.getRemainStoreQuantity()) < 0) {
						result.success = false;
						result.errors.push("货品的剩余库存不能小于0！");
						error = true;
					}
				}
				
				if (skuItem.getStoreWarnNum() && parseInt(skuItem.getStoreWarnNum()) < 0) {
					result.success = false;
					result.errors.push("货品的报警库存不能小于0！");
					error = true;
				}
				
				if (error) {
					return;
				}
			}
		}
		
		/**
		 * 校验货品的货号（即货品编号）
		 */
		function validateSkuSN(result) {
			for (var index = 0; index < skuItemArray.length; index++) {
				var regExp = new RegExp("[\u4E00-\uFA29]|[\uE7C7-\uE7F3]");
				if (regExp.test(skuItemArray[index].getSkuSN())) {
					result.success = false;
					result.errors.push("货品的货号不能有中文！");
					
					return;
				}
			}
			
			for (var outerIndex = 0; outerIndex < skuItemArray.length; outerIndex++) {
				var outerSkuItem = skuItemArray[outerIndex];
				for (var innerIndex = outerIndex + 1; innerIndex < skuItemArray.length; innerIndex++) {
					var innerSkuItem = skuItemArray[innerIndex];
					if (innerSkuItem.getSkuSN() !== "" && innerSkuItem.getSkuSN() === outerSkuItem.getSkuSN()) {
						result.success = false;
						result.errors.push("货号：" + innerSkuItem.getSkuSN() + "不能重复");
						return;
					}
				}
			}
		}
	}	
});

/**
 * sku/货品
 * 
 * @param skuId   ID
 * @param salePriceYuan 会员价/易通价 (单位：元)
 * @param marketPriceYuan 市场价 (单位：元)
 * @param remainStoreQuantity 剩余库存
 * @param storeWarnNum 报警库存
 * @param skuSN	sku编号
 * @param marketable 是否上架
 * @param specifyAssociationArray "规格、规格值关联"数组
 * @returns
 */
function SkuItem(skuId, salePriceYuan, marketPriceYuan, remainStoreQuantity, skuSN, marketable, specifyAssociationArray) {
	this.getSkuId = function () {
		return skuId;
	};
	
	this.getSalePriceYuan = function() {
		return salePriceYuan;
	};
	
	this.getMarketPriceYuan = function() {
		return marketPriceYuan;
	};
	
	this.getRemainStoreQuantity = function() {
		return remainStoreQuantity;
	};
	
	this.getStoreWarnNum = function() {
		return storeWarnNum;
	};
	
	this.getSkuSN = function() {
		return skuSN;
	};
	
	this.getMarketable = function() {
		return marketable;
	};
	
	this.getSpecifyAssociationArray = function() {
		return specifyAssociationArray;
	};
	
	this.setSkuId = function (skuIdParam) {
		skuId = skuIdParam;
	};
	
	this.setSalePriceYuan = function(salePriceYuanParam) {
		salePriceYuan = salePriceYuanParam;
	};
	
	this.setMarketPriceYuan = function(marketPriceYuanParam) {
		marketPriceYuan = marketPriceYuanParam;
	};
	
	this.setRemainStoreQuantity = function(remainStoreQuantityParam) {
		remainStoreQuantity = remainStoreQuantityParam;
	};
	
	this.setStoreWarnNum = function(storeWarnNumParam) {
		storeWarnNum = storeWarnNumParam;
	};
	
	this.setSkuSN = function(skuSNParam) {
		skuSN = skuSNParam;
	};
	
	this.setMarketable = function(marketableParam) {
		marketable = marketableParam;
	};
	
	this.setSpecifyAssociationArray = function(SpecifyAssociationArrayParam) {
		specifyAssociationArray = SpecifyAssociationArrayParam;
	};
}

/**
 * "规格、规格值关联"
 * 
 * @param specifyId 规格ID
 * @param specifyValueId 规格值ID
 * @param value 规格值
 * @returns
 */
function SpecifyAssociation(specifyId, specifyValueId, value) {
	this.getSpecifyId = function() {
		return specifyId;
	};
	
	this.getSpecifyValueId = function() {
		return specifyValueId;
	};
	
	this.getValue = function() {
		return value;
	};
	
	this.setSpecifyId = function(specifyIdParam) {
		specifyId = specifyIdParam;
	};
	
	this.setspecifyValueId = function(specifyValueIdParam) {
		specifyValueId = specifyValueIdParam;
	};
	
	this.setValue = function(valueParam) {
		value = valueParam; 
	};
}