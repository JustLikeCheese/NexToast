package io.github.justlikecheese.nextoast.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import io.github.justlikecheese.nextoast.NexToast;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button nextoast1 = findViewById(R.id.nextoast1);
        Button nextoast2 = findViewById(R.id.nextoast2);
        Button nextoast3_custom_text_color = findViewById(R.id.nextoast3_custom_text_color);
        Button nextoast4_custom_layout = findViewById(R.id.nextoast4_custom_layout);
        Button nextoast5_custom_text = findViewById(R.id.nextoast5_custom_text);
        Button toast1 = findViewById(R.id.toast1);
        Button toast2 = findViewById(R.id.toast2);
        final String string1 = "Talk is cheap. Show me the code.\n-- Linus Torvalds";
        final String string2 = "Hello, World!\n你好, 世界!\nहैलो वर्ल्ड!\nمرحبا بالعالم!\nこんにちは世界！\n안녕하세요, 세상아!\nПривет, мир!\nOlá, mundo!";
        nextoast1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NexToast.makeText(MainActivity.this, string1, NexToast.LENGTH_SHORT).show();
            }
        });
        nextoast2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                NexToast.makeText(MainActivity.this, string2, NexToast.LENGTH_SHORT).show();
            }
        });
        nextoast2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                NexToast.makeText(MainActivity.this, "YOOOOOOOO~ YOU FOUND ME :)", NexToast.LENGTH_SHORT).show();
                return true;
            }
        });
        nextoast3_custom_text_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NexToast.makeText(MainActivity.this, toColorfulSpannable("Welcome to use NexToast!"), NexToast.LENGTH_SHORT).show();
            }
        });
        nextoast4_custom_layout.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                NexToast toast = new NexToast(MainActivity.this);
                Button btn = new Button(MainActivity.this);
                toast.setView(btn);
                toast.show();
            }
        });
        nextoast5_custom_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NexToast toast = new NexToast(MainActivity.this);
                toast.setView();
                toast.setText(toColorfulSpannable("Welcome to use NexToast!"));
                toast.getTextView().setTextSize(64);
                toast.show();
            }
        });
        toast1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, string1, NexToast.LENGTH_SHORT).show();
            }
        });
        toast2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, string2, NexToast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("GitHub").setIcon(R.drawable.github).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://github.com/JustLikeCheese/NexToast"));
                startActivity(intent);
                return true;
            }
        }).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menu.add("About").setIcon(R.drawable.info).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("About")
                        .setMessage("In Android 12, Google added an icon to Toast and limited message length to two lines, forcing us to use Snackbar and AlertDialog. I can understand adding an icon for security reasons, but isn't the two-line limit annoying? Even when writing small applications, do we have to import Snackbar? Android Toast is the most convenient way to output logs; NexToast aims to allow developers to use Toast to output messages as easily as ever. NexToast is compatible with all Android versions, and it works fine on Android versions below 12.\n\n在 Android 12 中，谷歌为 Toast 添加了图标，并将消息长度限制为两行，迫使我们使用 Snackbar 和 AlertDialog。我可以理解出于安全考虑添加图标，但两行的限制难道不令人恼火吗？即使是编写小型应用程序，我们也必须导入 Snackbar 吗？Android Toast 是输出日志最便捷的方式；NexToast 的目标是让开发者能够像以往一样轻松地使用 Toast 输出消息。NexToast 兼容所有 Android 版本，并且在 Android 12 以下的版本上也能正常运行。")
                        .setPositiveButton("OK", null)
                        .show();
                return true;
            }
        }).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return super.onCreateOptionsMenu(menu);
    }

    public SpannableString toColorfulSpannable(String text) {
        SpannableString spannable = new SpannableString(text);
        int[] rainbowColors = {
                Color.RED,
                Color.rgb(255, 165, 0),
                Color.YELLOW,
                Color.GREEN,
                Color.BLUE,
                Color.rgb(75, 0, 130),
                Color.MAGENTA
        };
        for (int i = 0; i < text.length(); i++) {
            int colorIndex = i % rainbowColors.length;
            ForegroundColorSpan span = new ForegroundColorSpan(rainbowColors[colorIndex]);
            spannable.setSpan(span, i, i + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return spannable;
    }
}