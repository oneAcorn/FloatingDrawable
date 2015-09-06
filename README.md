# FloatingDrawable
<h3>圆形悬浮按钮</h3>

<h3>效果图</h3>
正常</br>
![github](https://github.com/oneAcorn/FloatingDrawable/blob/master/effect_normal.png)
</br>
按下</br>
![github](https://github.com/oneAcorn/FloatingDrawable/blob/master/effect_press.png)



<h3>使用方法</h3>
随便一个View,并写明控件大小,clickable=true;</br>
![github](https://github.com/oneAcorn/FloatingDrawable/blob/master/code1.png)
</br>
代码</br>
![github](https://github.com/oneAcorn/FloatingDrawable/blob/master/code2.png)
</br>
若xml中写的是wrap_content或match_parent
需要加一行代码:
drawable.setBounds(0,0,width,height);
