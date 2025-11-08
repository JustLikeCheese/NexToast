package io.github.justlikecheese.nextoast.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import io.github.justlikecheese.nextoast.app.R;
import io.github.justlikecheese.nextoast.NexToast;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                NexToast.makeText(MainActivity.this, "Talk is cheap. Show me the code.\n-- Linus Torvalds", NexToast.LENGTH_SHORT).show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NexToast.makeText(MainActivity.this, "Hello, World!\n你好, 世界!\nहैलो वर्ल्ड!\nمرحبا بالعالم!\nこんにちは世界！\n안녕하세요, 세상아!\nПривет, мир!\nOlá, mundo!", NexToast.LENGTH_SHORT).show();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Talk is cheap. Show me the code.\n-- Linus Torvalds", NexToast.LENGTH_SHORT).show();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Hello, World!\n你好, 世界!\nहैलो वर्ल्ड!\nمرحبا بالعالم!\nこんにちは世界！\n안녕하세요, 세상아!\nПривет, мир!\nOlá, mundo!", NexToast.LENGTH_SHORT).show();
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
}