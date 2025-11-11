<div align="right">
  Language:
  English
  <a title="Chinese" href="./README.zh-CN.md">简体中文</a>
</div>

[![Maven Central Version](https://img.shields.io/maven-central/v/io.github.justlikecheese.nextoast/NexToast)](https://repo1.maven.org/maven2/io/github/justlikecheese/nextoast/NexToast/)
[![GitHub Release](https://img.shields.io/github/v/release/JustLikeCheese/NexToast)](https://github.com/JustLikeCheese/NexToast/releases/latest)
[![GitHub License](https://img.shields.io/github/license/JustLikeCheese/NexToast)](https://github.com/JustLikeCheese/NexToast/blob/main/LICENSE)

# What's this?

This is a simple library to bypass the icon and two-line text limitations added by Android 12 Toast.

## How to use?

### Gradle

```gradle
dependencies {
    implementation 'io.github.justlikecheese.nextoast:NexToast:1.2.1'
}
```

### Manual

1. Move the [NexToast.java](nextoast/src/main/java/io/github/justlikecheese/nextoast/NexToast.java) file to your project.
2. Change the package name if you like.
3. Use the NexToast like Toast.

## Examples

Use NexToast like Toast.

```java
NexToast.makeText(this, "Hello World!", Toast.LENGTH_SHORT).show();
```

## Screenshots

<div style="overflow: hidden">
<img src="preview/image1.png" alt="Preview1" width="30%" align="bottom" />
<img src="preview/image2.png" alt="Preview2" width="30%" align="bottom" />
<img src="preview/image3.png" alt="Preview3" width="30%" align="bottom" />
<img src="preview/image4.png" alt="Preview4" width="30%" align="bottom" />
<img src="preview/image5.png" alt="Preview5" width="30%" align="bottom" />
</div>

## Feature API

NexToast has added the following extended useful methods.

### TextView getTextView()

Returns the TextView of the Toast.

```java
NexToast toast = NexToast.makeText(this, "Hello World!", Toast.LENGTH_SHORT);
toast.getTextView().setTextColor(0xFF555555); // Change text color
toast.show();
```

## Comtribution

If you have any ideas or issues, you can create an issue or pull request.

## License

What, License? It's just a simple library bro. [DO WHAT THE FUCK YOU WANT](LICENSE)
