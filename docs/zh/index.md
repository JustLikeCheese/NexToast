---
layout: home

hero:
  name: "NexToast"
  text: ""
  tagline: 一个自由的安卓 Toast 库，移除了原版 Toast 的图标和两行文本限制
  actions:
    - theme: brand
      text: 快速开始
      link: /zh/#在项目中使用
    - theme: brand
      text: 效果预览
      link: /zh/#效果预览
    - theme: alt
      text: 在 GitHub 上查看更多
      link: https://github.com/JustLikeCheese/NexToast

features:
  - title: 开源万岁~\(≧▽≦)/~
    details: 我们使用 WTFPL 开源协议，相当自由。
  - title: 轻量高效
    details: 本项目的 AAR 库大小仅有 3 KB，并且支持所有的安卓版本。
  - title: 原生 Toast
    details: NexToast 完全兼容原生 Toast，并且 Toast UI 和动画效果都与原生 Toast 完全一致。
---

## 在项目中使用

在你的 `build.gradle` 添加如下配置:

```groovy
dependencies {
    implementation 'com.github.JustLikeCheese:NexToast:1.2.1'
}
```

## 食用方法

### 像 Toast 一样使用 NexToast

```java
NexToast.makeText(this, "Hello World", Toast.LENGTH_SHORT).show()
```

### 自定义 Toast 文本样式

```java
NexToast toast = NexToast.makeText(this, "Hello World", Toast.LENGTH_SHORT);
toast.getTextView().setTextColor(Color.WHITE);
toast.getTextView().setTextSize(20);
toast.show();
```

## 效果预览

<div style="display: flex; flex-wrap: wrap; gap: 8px; justify-content: center; margin: 20px 0;">
  <img src="/preview/image1.png" alt="Preview1" style="width: 18%; border-radius: 8px; box-shadow: 0 2px 8px rgba(0,0,0,0.1);" />
  <img src="/preview/image2.png" alt="Preview2" style="width: 18%; border-radius: 8px; box-shadow: 0 2px 8px rgba(0,0,0,0.1);" />
  <img src="/preview/image3.png" alt="Preview3" style="width: 18%; border-radius: 8px; box-shadow: 0 2px 8px rgba(0,0,0,0.1);" />
  <img src="/preview/image4.png" alt="Preview4" style="width: 18%; border-radius: 8px; box-shadow: 0 2px 8px rgba(0,0,0,0.1);" />
  <img src="/preview/image5.png" alt="Preview5" style="width: 18%; border-radius: 8px; box-shadow: 0 2px 8px rgba(0,0,0,0.1);" />
</div>

### License

NexToast is licensed under the WTFPL license.

```
            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
                    Version 2, December 2004

 Copyright (C) 2025 JustLikeCheese

 Everyone is permitted to copy and distribute verbatim or modified
 copies of this license document, and changing it is allowed as long
 as the name is changed.

            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
   TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION

  0. You just DO WHAT THE FUCK YOU WANT TO.
```
