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
