# 普通计算器
## 介绍
垃圾软件，麻辣配色
## 截图
![这是图片](https://s1.328888.xyz/2022/09/04/1kI4n.png "screenshot")
## 说明
请确保电脑上已安装java，且支持javafx  
如果没有，推荐去https://bell-sw.com/pages/downloads/ 选择jdk8，选择full jdk
点击untitled.jar即可运行jar包
## 文件介绍
Caculate文件夹下
Add/Subtract/Multiplication/Divide分别对应加减乘除的运算
Calculate存储的是计算符号的信息
Checker文件夹下
DivideChecker是对除法的检验
isNumber检验一个字符串是不是数字
UI文件下
AppLoader用于启动程序
AppFrame用于生成界面
myAlert用于生成对话框，提示操作错误
fxml文件夹内存储了UI界面
controller文件夹存储UI控件，进行简单的事件处理

AppLoader->AppFrame->fxml(加载界面)->AppFrame->controller(处理事件，如点击按钮)->检验操作->执行操作
