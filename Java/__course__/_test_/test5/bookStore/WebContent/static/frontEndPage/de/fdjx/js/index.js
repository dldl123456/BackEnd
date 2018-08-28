window.onload=function(){
     var smallBox=document.getElementById("smallBox");
     var bigBox=document.getElementById("bigBox");
     var floatBox=document.getElementById("floatBox");
     var bigImg=bigBox.getElementsByTagName("img")[0];
     smallBox.onmouseover=function(){
         floatBox.style.display = "block";
         bigBox.style.display = "block";
     }
     smallBox.onmouseout=function(){
         floatBox.style.display = "none";
         bigBox.style.display = "none";
     }
     smallBox.onmousemove=function(event){
         var e=event||window.event;
         var left= e.clientX-smallBox.offsetLeft-floatBox.offsetWidth/2;
         var top = e.clientY-smallBox.offsetTop-floatBox.offsetHeight/2;
         if (left < 0) {
             left = 0;
         } else if (left > (smallBox.offsetWidth - floatBox.offsetWidth)) {
             left = smallBox.offsetWidth - floatBox.offsetWidth;
         }

         if (top < 0) {
             top = 0;
         } else if (top > (smallBox.offsetHeight - floatBox.offsetHeight)) {
             top = smallBox.offsetHeight - floatBox.offsetHeight;
         }
         floatBox.style.left=left+"px";
         floatBox.style.top=top+"px";
         bigImg.style.left=-(left*bigBox.offsetWidth)/smallBox.offsetWidth+"px";
         bigImg.style.top=-(top*bigBox.offsetHeight)/smallBox.offsetHeight+"px";
     }
}