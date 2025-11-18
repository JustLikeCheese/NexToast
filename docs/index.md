---
layout: home

hero:
  name: "NexToast"
  text: ""
  tagline: A free Android Toast library that removes the icon and two-line text restrictions from the original Toast
  actions:
    - theme: brand
      text: Get Started
      link: /#Introduction
    - theme: brand
      text: Preview
      link: /#preview
    - theme: alt
      text: View on GitHub
      link: https://github.com/JustLikeCheese/NexToast

features:
  - title: Open Source FTW~\(≧▽≦)/~
    details: We use the WTFPL license, which is extremely permissive.
  - title: Lightweight & Efficient
    details: The AAR library is only 3 KB in size and supports all Android versions.
  - title: Native Toast
    details: NexToast is fully compatible with native Toast, with identical UI and animation effects.
---

## Introduction
In Android 12, Google added limitations to Toast, restricting it to an icon and two lines of text. Google hoped that we would use Snackbar to replace Toast. However, the original Toast was obviously lighter and more convenient than Snackbar. Thus, NexToast was born. It removes the icon and two-line text restrictions of the original Toast, extends Toast's methods, and its display effect and usage are consistent with the original Toast.

## Usage

Add the following to your `build.gradle`:
```groovy
dependencies {
    implementation 'com.github.JustLikeCheese:NexToast:1.2.1'
}
```

## How to Use

### Use NexToast like Toast
```java
NexToast.makeText(this, "Hello World", Toast.LENGTH_SHORT).show()
```

### Customize Toast Text Style
```java
NexToast toast = NexToast.makeText(this, "Hello World", Toast.LENGTH_SHORT);
toast.getTextView().setTextColor(Color.WHITE);
toast.getTextView().setTextSize(20);
toast.show();
```

## Preview

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