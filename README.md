# AndroidDemo
Android learning demo collection

---

## MainActivity Screenshot
![1](/screenshots/Screenshot_main.png)

---

## BottomNavigationDemo
基于官方的BottomNavigationView 搭配 ViewPager + Fragment 使用；  
目前的这个官方库还不能支持切换当前选中的Item,所以在4个TAB以上，并且通过ViewPager切换时就有坑了  
更新： 通过反射去掉了默认的切换效果，完美支持ViewPager联动。  

### 参考
1. [Android流行UI布局——底部导航BottomNavigationView+ViewPager+Fragment](https://www.jianshu.com/p/0ba25cc65889)  
2. [BottomNavigationView](https://github.com/brucevanfdm/BottomNavigationView)  

### Screenshots
![1](/screenshots/BottomNavigationView/Screenshot_1539261621.png)
![2](/screenshots/BottomNavigationView/Screenshot_1539261625.png)
![3](/screenshots/BottomNavigationView/Screenshot_1539261627.png)
![4](/screenshots/BottomNavigationView/Screenshot_1539261629.png)

---

## PagerSlidingTab
基于 PagerSlidingTabStrip源码地址：https://github.com/astuetz/PagerSlidingTabStrip  
使用 PagerSlidingTabStrip + ViewPager + Fragment  

**这里的ViewPager的适配器必须是继承的FragmentPagerAdapter，并重写getPageIconResId(int position)或者getPageTitle(int position)方法**

### 参考
1. [PagerSlidingTabStrip从头到脚](https://www.jianshu.com/p/dfc83ea3d476)

### Screenshots
![1](/screenshots/PagerSlidingTab/Screenshot_1541379667.png)
![2](/screenshots/PagerSlidingTab/Screenshot_1541379669.png)
![3](/screenshots/PagerSlidingTab/Screenshot_1541379671.png)
![4](/screenshots/PagerSlidingTab/Screenshot_1541379673.png)

---

## 轮播Banner  

Android广告图片轮播控件，支持无限循环和多种主题，可以灵活设置轮播样式、动画、轮播和切换时间、位置、图片加载框架等！ 

![](/screenshots/Banner/Screenshot_1541401597.png)
![](/screenshots/Banner/Screenshot_1541401598.png)
![](/screenshots/Banner/Screenshot_1541401599.png)
![](/screenshots/Banner/Screenshot_1541401608.png)

### 参考  
1. [Android图片轮播控件](https://github.com/youth5201314/banner)  

---

## RecyclerView  

RecyclerView用于在有限的窗口展现大量的数据，其实早已经有了类似的控件，如ListView、GridView，那么相比它们，RecyclerView有什么样优势呢？
RecyclerView标准化了ViewHolder，而且异常的灵活，可以轻松实现ListView实现不了的样式和功能，通过布局管理器LayoutManager可控制Item的布局方式，通过设置Item操作动画自定义Item添加和删除的动画，通过设置Item之间的间隔样式，自定义间隔。

- 设置布局管理器以控制Item的布局方式，横向、竖向以及瀑布流方式。  
- 可设置Item操作的动画（删除或者添加等)  
- 可设置Item的间隔样式（可绘制）  

但是关于Item的点击和长按事件，需要用户自己去实现。  
在使用RecyclerView时候，必须指定一个适配器Adapter和一个布局管理器LayoutManager。适配器继承RecyclerView.Adapter类。  
![](/screenshots/RecyclerView_1.png)

### 参考 
1. [RecyclerView使用完全指南，是时候体验新控件了](https://www.jianshu.com/p/4fc6164e4709)
2. [Android RecyclerView 使用完全解析 体验艺术般的控件](https://blog.csdn.net/lmj623565791/article/details/45059587)

---

## SwipeRefreshLayout + RecyclerView 上拉加载，下拉刷新  
SwipeRefrshLayout是Google官方更新的一个Widget,可以实现下拉刷新的效果。  
- setOnRefreshListener(OnRefreshListener):添加下拉刷新监听器  
- setRefreshing(boolean):显示或者隐藏刷新进度条  
- isRefreshing():检查是否处于刷新状态  
- setColorSchemeResources():设置进度条的颜色主题，最多设置四种，以前的setColorScheme()方法已经弃用了。  

RecyclerView设置滚动事件加入上拉加载更多功能  
LayoutManger给我们提供了以下几个方法来让开发者方便的获取到屏幕上面的顶部item和顶部item相关的信息:  

- findFirstVisibleItemPosition()
- findFirstCompletlyVisibleItemPosition()
- findLastVisibleItemPosition()
- findLastCompletlyVisibleItemPosition()  

同时通过Recycler.Adapter的getItemCount()方法可以轻松获取到RecyclerView列表中Item View的个数。
那么通过监听滑动(滚动)事件addOnScrollListener，然后在里边判断是否已经滑动到最底部来加载更多的数据.

升级SwipeRefreshLayout+RecyclerView加入FootView实现上拉加载

![](/screenshots/SwipeRefreshLayout/Screenshot_1542954278.png)
![](/screenshots/SwipeRefreshLayout/Screenshot_1542954280.png)

![](/screenshots/SwipeRefreshLayout/Screenshot_1542954289.png)
![](/screenshots/SwipeRefreshLayout/Screenshot_1542954292.png)
### 参考 
1. [RecyclerView完全解析之下拉刷新与上拉加载SwipeRefreshLayout](https://www.kancloud.cn/digest/fastdev4android/109670)  

---

## TabLayout 实现顶部标签栏
通常在ViewPager的上方，我们都会放一个标签指示器与ViewPager进行联动。
以前，我们大多使用的是GitHub上的开源框架PagerSlidingTabTrip，
具体的可以参见https://github.com/astuetz/PagerSlidingTabStrip。
而现在，我们可以使用Android自带的控件TabLayout来实现这个效果了，
而且TabLayout更为强大，因为Tab标签可以使用自定义View。

通过TabLayout+ViewPager来展示顶部标题栏。使用官方的support:design支持库

新增ViewPager+TabLayout+Fragment 懒加载机制

![](/screenshots/tablayout/Screenshot_1542698461.png)
![](/screenshots/tablayout/Screenshot_1542698468.png)

### 参考
1. [Tablayout使用全解，一篇就够了](https://www.jianshu.com/p/fde38f367019)
2. [ViewPager+TabLayout+Fragment 懒加载机制](https://cdn2.jianshu.io/p/0eaa65e5bad2)

---

## startActivityForResult实现Activity间的跳转，带有返回值给调用Activity

---




