//工具方法模块
util = {
	/**
	 * [$ 标签选择器]
	 * @param  {[type]} selector [选择器]
	 * @param  {[type]} node     [dom节点]
	 * @return {[type]}          [$('selector')]
	 */
	$: (selector, node) => (node || document).querySelector(selector),

	//检测数组中是否有相同的值存在，并且返回它的位置；
	arrIndexOf: function(arr,v){
        for(var i=0;i<arr.length;i++){
            if(arr[i] == v){
                return i;
            }
        }
        return -1;
    },

    /**
     * [addClass 判断是否有class]
     * @param {[type]} obj [要添加classname的元素]
     * @param {[type]} cls [要添加的classname]
     */
	hasClass: function(obj,cls){
        var cls = cls || '';
        if( cls.replace(/\s/g,'').length == 0){
            return false;//当cls没有参数时,返回false;
        }else{
            return new RegExp(' ' + cls + '').test(' ' + obj.className);
        }
    },

    /**
     * [addClass 添加class]
     * @param {[type]} obj [要添加classname的元素]
     * @param {[type]} cls [要添加的classname]
     */
    addClass: function(obj,cls){//obj:，cls:;
    	//如果原来没有class：
        if(obj.className == ''){
            obj.className = cls;
        } else {
            //本来已经有class，新增class的情况：
            var arrclassname = obj.className.split(' ');//
            var index = util.arrIndexOf(arrclassname,cls);
            if(index == -1) {
                //如果要添加的class在原来的元素上不存在：
                obj.className += ' ' + cls;
            }
        }
    },

    /**
     * [addClass 删除class]
     * @param {[type]} obj [要添加classname的元素]
     * @param {[type]} cls [要添加的classname]
     */
    removeClass: function(obj,cls){
        //如果有class的话：
        if(obj.className != ''){
            var arrClassName = obj.className.split(' ');//对原有class进行拆分，看看是否包含需要移除的class，也就是传参cls的classname；
            var index = util.arrIndexOf(arrClassName,cls);
            //r如果有需要移除的class
            if(index != -1){
                arrClassName.splice(index,1);
                obj.className = arrClassName.join('');
            }
        }
    },

    /**
     * [addClass class开关]
     * @param {[type]} obj [要添加classname的元素]
     * @param {[type]} cls [要添加的classname]
     */
    toggleClass: function(obj,cls){
        util.hasClass(obj,cls) ? util.removeClass(obj,cls) : util.addClass(obj,cls);
    },
 
 	/**
 	 * [getByClass description]
 	 * @param  {[type]} oParent [description]
 	 * @param  {[type]} sClass  [description]
 	 * @return {[type]}         [description]
 	 */
    getByClass: function (oParent, sClass) {
        if (oParent.getElementsByClassName) {
            return oParent.getElementsByClassName(sClass);
        } else {  //IE 8 7 6
            var arr = [];
            var reg = new RegExp('\\b' + sClass + '\\b');
            var aEle = oParent.getElementsByTagName('*');
            for (var i = 0; i < aEle.length; i++) {
                if (reg.test(aEle[i].className)) {
                    arr.push(aEle[i]);
                }
            }
            return arr;
        }
    }
};

