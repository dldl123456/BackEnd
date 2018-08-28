/**
 * @fileoverview dangdang page
 * author zmx2321@163.com
 * data 2018/8/14
 */

//工具方法
var util = {
    tipInfo: function(str){
        var cont = "<span class='bubble f-dn l-bdru f-ptr2 f-fs1'>" + str +"</span>";

        $('body').append(cont);

        $(".bubble").fadeIn('slow').delay(200).fadeOut('slow');
    },

    //显示模态窗时公用
    show: function(){
        $('.m-modal').fadeIn();  //显示遮罩层
        $('body').addClass('f-oh');  //overflow
    },

    //隐藏模态窗时公用
    hide: function(){
        $('.m-modal').fadeOut();  //隐藏遮罩层
        $('body').removeClass('f-oh');  //overflow
    },

    //隐藏模态框所有内容
    hideAll: function(){
        this.hide();  //隐藏模态窗时公用
        $('.image_load').fadeOut();  //隐藏图片上传内容
        //++其他模态框
    },

    /**
     * [selMultiple 选择多个样式]
     * @param  {[type]} $ [clsaa]
     * @return {[type]}   [description]
     */
    selMultipleClass: function(sel_class){
        sel_class.click(function(){
            if($(this).hasClass('active')){
                $(this).removeClass('active');
            }else{
                $(this).addClass('active');
            }
        });
    },

    /**
     * [selSingleClass 选择单个样式]
     * @param  {[type]} $ [description]
     * @return {[type]}   [description]
     */
    selSingleClass: function(sel_class){
        sel_class.click(function(){
            $(this).addClass('active').siblings().removeClass('active');
        });
    },

    /**
     * [setnavscroll 浏览器滚动条位置]
     * @param  {[type]} navbar [nav上填充高度]
     * @param  {[type]} nav    [nav内容]
     * @param  {[type]} navfix [nav上添加的class]
     * @return {[type]}        0
     */
    setnavscroll: function(navbar, nav, navfix){
        var window_top = $(window).scrollTop();
        var div_top = navbar.offset().top;

        if (window_top > div_top) {
            nav.addClass(navfix);
            navbar.height(nav.height());
        } else {
            nav.removeClass(navfix);
            navbar.height(0);
        }
    },
};

//窗口大小改变时加载
$(window).on('resize', function(){
    
});

//load
$(function(){
    
});