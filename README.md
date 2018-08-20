# ZhiHuApp
模仿知乎App功能


# 前言

知乎是一个真实的网络问答社区，其主要内容为用户提问，邀请回答以及用户评论。其中内容主要为文字和图片。<br/>
知乎APP的风格为Material Design，其中多用到Design Support Library（材料设计兼容库）的控件。大多数控件都不是课本内容中的。很用挑战性。所以选择模仿知乎APP制作一款软件<br/>
设计这款软件的主要目的在于学习现有软件的功能，其实现功能并没有过多创新，以模仿学习为主。<br/>
因为知乎APP版本更迭很快，每个版本的功能都有不少更改，所以这里要提出一下。我们参考的知乎APP版本为知乎APP4.50.0版本。
<br/>登陆前需要注册，注册的账号为邮箱（有@和.com符号），密码不限


# 1.前期准备和网络资源使用

## 1.1前期准备
知乎APP的风格为Material Design，所以其中有很多控件和布局是Design Support Library中的。所以在真正开始写之前先学习了其中的部分功能。如CoordinatorLayout布局、AppBarLayout布局、Floating Action Button控件和Bottom Navigation Bar控件等。有些控件虽然不太了解，但是基本功能还是能够了解的。因为知乎的风格问题。也学习了部分Material Design的内容。因为原文档是英文的。能找到的翻译不全。只能大致了解了部分设计要求和要点。值得提一点的是，谷歌提供了很多系统的图标可供下载。让在前期找图标的时候减少了很多麻烦。 <br/>[Icons-Material Design](https://material.io/icons/)<br/>
## 1.2网络资源的使用
在做这款软件之前就在考虑，代码放到哪以及数据库怎么办。根据网上的一些推荐。我们选择了GitHub作为托管平台。<br/>云数据库方面。根据老师的推荐选择了bmob作为云数据库。在设计之初就先确定大致要建立几个表以及表之间的关系。不过并没有直接在bmob上直接建表。前期使用的是本地数据库。因为有些数据还不确定要不要。在项目的最后才开始使用bmob作为云数据库。


# 2.页面设计和功能实现说明

## 2.1主页面设
设计之初，就想好要用Bottom Navigation Bar来作为几个页面切换的底部导航栏。在学习这个控件时发现在CoordinatorLayout布局下非常好用，得力于谷歌推出的Design Support Library，我们不需要自己实现底部导航栏自动隐藏和实现的功能。Bottom Navigation Bar可以自动实现。<br/>首页的每个碎片切换是利用fragment作为容器的。在点击底部导航栏实现跳转。<br/>在设计页面切换部分时碰到了许多问题，其中有几个问题花了不少时间。一是在有的碎片有toolbar，有的没有，这里如果在碎片中写toolbar，第一个碎片的toolbar总是会出现。最后，我们是选择将第一个碎片的toolbar拿出来，写在主页面中。在点击切换的时候，让其隐藏。二是在切换每个碎片时如果按照书上的例子用replay()切换的话，会出现一个问题。每个碎片的界面都会重新加载，不能保存数据。在查询了一些资料后，我们用hide()和add()方法来代替replay()方法。解决了这个问题。<br/>登录功能参考Android studio的例子，实现不联网验证的登陆、注册功能（注册账号为邮箱）。

## 2.2碎片内容的实现
每个碎片内容的实现是花费事件最多的部分。但是到最后还有许多功能没有实现。主要完成了界面的设计和简单的后台逻辑。<br/><br/>
**基本页面实现情况**
碎片|内容|实现情况
-|-|-
碎片1|回答列表|基本实现
碎片2|编辑推荐回答|完成页面和逻辑部分
碎片3|通知和动态|完成页面和逻辑部分
碎片4|私信|完成页面和发送部分
碎片5|个人信息和设置|只完成页面部分
主要实现的是第一个碎片，回答列表的部分。这也是知乎APP浏览最多的部分。其中的内容是根据用户关注的人和话题推荐来的。每个用户关注的不同，推荐的内容也不同。<br/>
我们选择了ListView作为回答列表的容器。因为在NestedScrollView中ListViw不能正确的显示高度。我们写了一个MyListView类来继承ListView解决了这个问题。在适配器类中实现ListView中每个元素的点击事件。第一个碎片和第二个碎片界面布局大致相似。只是推荐的内容不同。我们在设计第二个碎片布局时的时候同样使用了第一个碎片的ListView。第三个碎片主要是TabLayout和ViewPager的结合。在参考网上的例子后我们大致写出了这个功能。四、五碎片的页面没有困难的部分。大部分参考前三个页面的功能实现。每个碎片的顶部菜单使用ToolBar控件实现。下拉刷新是用SwipeRefreshLayout异步加载数据实现的

## 2.3问题、回答以及评论页面的实现
问题页面是这三个页面中最麻烦的，因为不仅是要显示问题、问题描述以及关注人数等内容，还要显示回答的列表。这里我们是利用数据库查询回答表中的问题id，如果id符合就将回答列表添加到问题页面下的列表中。在知乎APP中回答页面的内容是通过WebView加载的，但是我们没有找到可用的接口，所以只能用TextView代替，但是也就不能加载文字以外的内容。评论详情页就是一个ListView。

# 3.数据库实现

## 3.1数据库表之间的关系
采用bmob作为云数据库，主要的表有四个

表名|内容
-|-
QuestionMessage|保存问题数据
AnswerMessage|保存回答数据以及对应的问题ID
CommentMessage|保存评论的数据
ListMessage|首页问题列表的数据，对应的问题、回答以及评论ID

前三个表关系如图<br/>![](https://github.com/Spike-ysc/ZhiHuApp/raw/master/introduce/data.png)

## 3.2数据库表的内容
**QuestionMessage**<br/>![](https://github.com/Spike-ysc/ZhiHuApp/raw/master/introduce/question.png)<br/><br/>
**AnswerMessage**<br/>![](https://github.com/Spike-ysc/ZhiHuApp/raw/master/introduce/answer.png)<br/><br/>
**CommentMessage**<br/>![](https://github.com/Spike-ysc/ZhiHuApp/raw/master/introduce/discuss.png)<br/><br/>
    
# 4.软件部分截图和功能介绍截图
## 4.1截图
![](https://github.com/Spike-ysc/ZhiHuApp/raw/master/introduce/工具.PNG)<br/><br/>
![](https://github.com/Spike-ysc/ZhiHuApp/raw/master/introduce/第三方类库.PNG)<br/><br/>
![](https://github.com/Spike-ysc/ZhiHuApp/raw/master/introduce/插件.PNG)<br/><br/>
![](https://github.com/Spike-ysc/ZhiHuApp/raw/master/introduce/界面设计.PNG)<br/><br/>
![](https://github.com/Spike-ysc/ZhiHuApp/raw/master/introduce/幻灯片10.PNG)<br/><br/>
![](https://github.com/Spike-ysc/ZhiHuApp/raw/master/introduce/幻灯片11.PNG)<br/><br/>
![](https://github.com/Spike-ysc/ZhiHuApp/raw/master/introduce/幻灯片12.PNG)<br/><br/>
![](https://github.com/Spike-ysc/ZhiHuApp/raw/master/introduce/幻灯片13.PNG)<br/><br/>
![](https://github.com/Spike-ysc/ZhiHuApp/raw/master/introduce/幻灯片19.PNG)<br/><br/>
![](https://github.com/Spike-ysc/ZhiHuApp/raw/master/introduce/幻灯片21.PNG)<br/><br/>
![](https://github.com/Spike-ysc/ZhiHuApp/raw/master/introduce/幻灯片23.PNG)<br/><br/>
![](https://github.com/Spike-ysc/ZhiHuApp/raw/master/introduce/幻灯片26.PNG)<br/><br/>
![](https://github.com/Spike-ysc/ZhiHuApp/raw/master/introduce/幻灯片27.PNG)<br/><br/>
<br/>
## 4.2动态图演示
<br/>

加载和刷新|基本功能演示
-|-
![](https://github.com/Spike-ysc/ZhiHuApp/raw/master/introduce/加载和刷新.gif)| ![](https://github.com/Spike-ysc/ZhiHuApp/raw/master/introduce/功能演示.gif)
在第一次加载时显示progressBar，<br/>并且在顶部下拉时实现刷新加载功能<br/>实现原理为<br/>1.首先在页面中写好progressBar，再异步加载数据，<br/>数据加载完成后progressBar消失<br/>2.利用SwipeRefreshLayout实现下拉刷新功能，<br/>再调用异步方法加载新数据，添加到第一行|**若无动态效果， [请点击](https://github.com/Spike-ysc/ZhiHuApp/blob/master/introduce/%E5%8A%9F%E8%83%BD%E6%BC%94%E7%A4%BA.gif)**<br/>主要实现的功能<br/>1.五个页面布局<br/>2.问题页面<br/>3.回答页面<br/>4.评论页面<br/>5.对话功能<br/>6.登陆功能



floating|基本功能演示
-|-
![](https://github.com/Spike-ysc/ZhiHuApp/raw/master/introduce/floating.gif)| ![](https://github.com/Spike-ysc/ZhiHuApp/raw/master/introduce/聊天功能.gif)
首页的悬浮按钮点击后弹出三个对话按钮，背景模糊化，<br/>顶部toolbar和底部BottomNavigationBar自动消失和出现<br/>实现原理为<br/>1.先写好三个对话按钮和白色半透明背景并隐藏，<br/>当FloatingActionButton点击时显示出来，再次点击消失<br/>2.在界面布局为CoordinatorLayout的情况下，将toolbar嵌套在AppbarLayout中，<br/>底部导航栏用BottomNavigationBar实现，<br/>就可以实现自动隐藏和出现<br/>|私信的对话功能<br/>点击私信中的信息，跳转到对话页面，<br/>可以在对话页面中实现发送消息功能。<br/>实现原理为<br/>对话功能是参考第一行代码，每一条消息实际上是一个ListView，<br/>在收发消息时判断是发送方还是接收方，<br/>选择不同的ListView页面来呈现。<br/>


# 5.总结
这款软件还有很多不足和缺点。但是在完成这款软件的过程中学到了很多。写一个比较完整的软件而不是简单的几个页面，对我们的也是很大的锻炼。也学到了许多课本上没有的内容，也培养了习惯碰到问题通过搜索工具检索解决问题的能力。受益良多。<br/>
软件大部分都用于前端和页面逻辑和数据传递方面，关于数据库和网络方面的内容非常少。
