import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class NexToast extends Toast {
    private final static boolean hasSystemLimit = Build.VERSION.SDK_INT >= 30;

    private final Context context;
    private final boolean hasLimit;
    private View view = null;

    public NexToast(Context context, boolean hasLimit) {
        super(context);
        this.context = context;
        this.hasLimit = hasLimit;
        if (hasLimit) {
            ViewGroup viewGroup = getSystemToastLayout(context);
            TextView textView = viewGroup.findViewById(android.R.id.message);
            textView.setMaxLines(Integer.MAX_VALUE);
            this.setView(viewGroup);
            getView();
        }
    }

    public NexToast(Context context) {
        this(context, hasSystemLimit);
    }

    public static Toast makeText(Context context, CharSequence text, int duration) {
        return makeText(context, text, duration, hasSystemLimit);
    }

    public static NexToast makeText(Context context, CharSequence text, int duration, boolean bypass) {
        NexToast toast = new NexToast(context, bypass);
        toast.setText(text);
        toast.setDuration(duration);
        return toast;
    }

    @Override
    public void setText(int resId) {
        setText(context.getText(resId));
    }

    @Override
    public void setText(CharSequence text) {
        if (hasLimit) {
            TextView tv = view.findViewById(android.R.id.message);
            tv.setText(text);
            return;
        }
        super.setText(text);
    }

    @Override
    public void setView(View view) {
        super.setView(view);
        this.view = view;
    }

    public static int dp2px(Context context, int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    public static ViewGroup getSystemToastLayout(Context context) {
        return getSystemToastLayout(context, null);
    }

    public static ViewGroup getSystemToastLayout(Context context, CharSequence message) {
        Resources androidResources = Resources.getSystem();
        int layoutId = androidResources.getIdentifier("transient_notification", "layout", "android");
        ViewGroup view = (ViewGroup) LayoutInflater.from(context).inflate(layoutId, null);
        if (view != null) {
            return view;
        }
        int dpValue16 = dp2px(context, 16);
        int dpValue12 = dp2px(context, 12);

        LinearLayout layout = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setGravity(Gravity.CENTER_VERTICAL);

        TypedValue colorBackground = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.colorBackground, colorBackground, true);
        layout.setBackgroundColor(colorBackground.data);

        if (Build.VERSION.SDK_INT == 31 || Build.VERSION.SDK_INT == 32) {
            int toastFrameBackground = androidResources.getIdentifier("toastFrameBackground", "attr", "android");
            if (toastFrameBackground != 0) {
                layout.setBackgroundResource(toastFrameBackground);
            }
        }

        int toastElevation = androidResources.getIdentifier("toast_elevation", "dimen", "android");
        if (toastElevation != 0) layout.setElevation(androidResources.getDimension(toastElevation));

        layoutParams.setMarginStart(dpValue16);
        layoutParams.setMarginEnd(dpValue16);
        layout.setLayoutParams(layoutParams);

        TextView textView = new TextView(context);
        textView.setId(android.R.id.message);
        textView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxLines(2);
        textView.setPadding(0, dpValue12, 0, dpValue12);
        if (message != null) {
            textView.setText(message);
        }

        int textAppearanceId = androidResources.getIdentifier("TextAppearance.Toast", "style", "android");
        if (textAppearanceId != 0) {
            textView.setTextAppearance(context, textAppearanceId);
        } else {
            textView.setTextColor(Color.WHITE);
        }

        layout.addView(textView);
        return layout;
    }
}