package io.github.justlikecheese.nextoast.app;

import android.app.Activity;
import android.os.Bundle;

import io.github.justlikecheese.nextoast.NexToast;

public class TestActivity2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        NexToast.makeText(this, "Toast before onCreate!", NexToast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
    }
}
