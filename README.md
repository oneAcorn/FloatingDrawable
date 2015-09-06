# FloatingDrawable
<h3>圆形悬浮按钮</h3>

<h3>效果图</h3>
正常
![github](https://github.com/oneAcorn/FloatingDrawable/blob/master/effect_normal.png)
按下
![github](https://github.com/oneAcorn/FloatingDrawable/blob/master/effect_press.png)


<h3>使用方法</h3>
xml中直接写明控件大小,并且clickable=true;
![github](https://github.com/oneAcorn/FloatingDrawable/blob/master/code1.png)
代码
![github](https://github.com/oneAcorn/FloatingDrawable/blob/master/code2.png)

若xml中写的是wrap_content或match_parent
需要加一行代码:
drawable.setBounds(0,0,width,height);
