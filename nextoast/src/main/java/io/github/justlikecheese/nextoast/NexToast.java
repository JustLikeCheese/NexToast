package io.github.justlikecheese.nextoast;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A toast is a view containing a quick little message for the user.  The toast class
 * helps you create and show those.
 * {&#064;more }
 *
 * <p>
 * When the view is shown to the user, appears as a floating view over the
 * application.  It will never receive focus.  The user will probably be in the
 * middle of typing something else.  The idea is to be as unobtrusive as
 * possible, while still showing the user the information you want them to see.
 * Two examples are the volume control, and the brief message saying that your
 * settings have been saved.
 * <p>
 * The easiest way to use this class is to call one of the static methods that constructs
 * everything you need and returns a new Toast object.
 * <p>
 * Note that
 * <a href="{@docRoot}reference/com/google/android/material/snackbar/Snackbar">Snackbars</a> are
 * preferred for brief messages while the app is in the foreground.
 * <p>
 * Note that toasts being sent from the background are rate limited, so avoid sending such toasts
 * in quick succession.
 * <p>
 * Starting with Android 12 (API level 31), apps targeting Android 12 or newer will have
 * their toasts limited to two lines.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For information about creating Toast notifications, read the
 * <a href="{@docRoot}guide/topics/ui/notifiers/toasts.html">Toast Notifications</a> developer
 * guide.</p>
 * </div>
 */
@SuppressWarnings("unused")
public class NexToast {
    /**
     * Show the view or text notification for a short period of time.  This time
     * could be user-definable.  This is the default.
     *
     * @see #setDuration
     */
    public static final int LENGTH_SHORT = 0;

    /**
     * Show the view or text notification for a long period of time.  This time
     * could be user-definable.
     *
     * @see #setDuration
     */
    public static final int LENGTH_LONG = 1;
    @SuppressLint("AnnotateVersionCheck")
    public final static boolean hasSystemLimit = Build.VERSION.SDK_INT >= 30;
    private final Context context;
    private final Toast toast;
    private View view = null;
    private TextView message = null;

    /**
     * Construct an empty Toast object.  You must call {@link #setView} before you
     * can call {@link #show}.
     *
     * @param context The context to use.  Usually your {@link Activity} object.
     */
    public NexToast(Context context) {
        this(context, new Toast(context));
    }

    private NexToast(Context context, Toast toast) {
        this.toast = toast;
        this.context = context;
    }

    private NexToast(Context context, Toast toast, View view) {
        this(context, toast);
        setView(view);
    }

    /**
     * Show the view for the specified duration.
     *
     * <p>Note that toasts being sent from the background are rate limited, so avoid sending such
     * toasts in quick succession.
     */
    public void show() {
        toast.show();
    }

    /**
     * Close the view if it's showing, or don't show it if it isn't showing yet.
     * You do not normally have to call this.  Normally view will disappear on its own
     * after the appropriate duration.
     */
    public void cancel() {
        toast.cancel();
    }

    /**
     * Set the view to show.
     *
     * @see #getView
     */
    public void setView(View view) {
        toast.setView(view);
        this.view = view;
        this.message = view.findViewById(ID_MESSAGE);
    }

    /**
     * Set the default view to show.
     *
     * @see #getView
     */
    public void setView() {
        setView(getTextToastView(context, null));
    }

    /**
     * Return the view.
     *
     * <p>Toasts constructed with {@link #NexToast(Context)} that haven't called {@link #setView(View)}
     * with a non-{@code null} view will return {@code null} here.
     *
     * <p>Starting from Android {@link Build.VERSION_CODES#R}, in apps targeting API level {@link
     * Build.VERSION_CODES#R} or higher, toasts constructed with {@link #makeText(Context,
     * CharSequence, int)} or its variants will also return {@code null} here unless they had called
     * {@link #setView(View)} with a non-{@code null} view. If you want to be notified when the
     * toast is shown or hidden, use {@link #addCallback(Toast.Callback)}.
     *
     * @see #setView
     */
    public View getView() {
        if (view != null) {
            return view;
        }
        return toast.getView();
    }

    /**
     * Set how long to show the view for.
     *
     * @see #LENGTH_SHORT
     * @see #LENGTH_LONG
     */
    public void setDuration(int duration) {
        toast.setDuration(duration);
    }

    /**
     * Return the duration.
     *
     * @see #setDuration
     */
    public void getDuration() {
        toast.getDuration();
    }

    /**
     * Set the margins of the view.
     *
     * <p><strong>Warning:</strong> Starting from Android {@link Build.VERSION_CODES#R}, for apps
     * targeting API level {@link Build.VERSION_CODES#R} or higher, this method is a no-op when
     * called on text toasts.
     *
     * @param horizontalMargin The horizontal margin, in percentage of the
     *                         container width, between the container's edges and the
     *                         notification
     * @param verticalMargin   The vertical margin, in percentage of the
     *                         container height, between the container's edges and the
     *                         notification
     */
    public void setMargin(float horizontalMargin, float verticalMargin) {
        toast.setMargin(horizontalMargin, verticalMargin);
    }

    /**
     * Return the horizontal margin.
     *
     * <p><strong>Warning:</strong> Starting from Android {@link Build.VERSION_CODES#R}, for apps
     * targeting API level {@link Build.VERSION_CODES#R} or higher, this method shouldn't be called
     * on text toasts as its return value may not reflect actual value since text toasts are not
     * rendered by the app anymore.
     */
    public float getHorizontalMargin() {
        return toast.getHorizontalMargin();
    }

    /**
     * Return the vertical margin.
     *
     * <p><strong>Warning:</strong> Starting from Android {@link Build.VERSION_CODES#R}, for apps
     * targeting API level {@link Build.VERSION_CODES#R} or higher, this method shouldn't be called
     * on text toasts as its return value may not reflect actual value since text toasts are not
     * rendered by the app anymore.
     */
    public float getVerticalMargin() {
        return toast.getVerticalMargin();
    }

    /**
     * Set the location at which the notification should appear on the screen.
     *
     * <p><strong>Warning:</strong> Starting from Android {@link Build.VERSION_CODES#R}, for apps
     * targeting API level {@link Build.VERSION_CODES#R} or higher, this method is a no-op when
     * called on text toasts.
     *
     * @see Gravity
     * @see #getGravity
     */
    public void setGravity(int gravity, int xOffset, int yOffset) {
        toast.setGravity(gravity, xOffset, yOffset);
    }

    /**
     * Get the location at which the notification should appear on the screen.
     *
     * <p><strong>Warning:</strong> Starting from Android {@link Build.VERSION_CODES#R}, for apps
     * targeting API level {@link Build.VERSION_CODES#R} or higher, this method shouldn't be called
     * on text toasts as its return value may not reflect actual value since text toasts are not
     * rendered by the app anymore.
     *
     * @see Gravity
     * @see #getGravity
     */
    public int getGravity() {
        return toast.getGravity();
    }

    /**
     * Return the X offset in pixels to apply to the gravity's location.
     *
     * <p><strong>Warning:</strong> Starting from Android {@link Build.VERSION_CODES#R}, for apps
     * targeting API level {@link Build.VERSION_CODES#R} or higher, this method shouldn't be called
     * on text toasts as its return value may not reflect actual value since text toasts are not
     * rendered by the app anymore.
     */
    public int getXOffset() {
        return toast.getXOffset();
    }

    /**
     * Return the Y offset in pixels to apply to the gravity's location.
     *
     * <p><strong>Warning:</strong> Starting from Android {@link Build.VERSION_CODES#R}, for apps
     * targeting API level {@link Build.VERSION_CODES#R} or higher, this method shouldn't be called
     * on text toasts as its return value may not reflect actual value since text toasts are not
     * rendered by the app anymore.
     */
    public int getYOffset() {
        return toast.getYOffset();
    }

    public boolean isSystemRenderedTextToast() {
        return view == null;
    }

    /**
     * Adds a callback to be notified when the toast is shown or hidden.
     * <p>
     * Note that if the toast is blocked for some reason you won't get a call back.
     *
     * @see #removeCallback(Toast.Callback)
     */
    @SuppressLint("UseRequiresApi")
    @TargetApi(Build.VERSION_CODES.R)
    public void addCallback(Toast.Callback callback) {
        toast.addCallback(callback);
    }

    /**
     * Removes a callback previously added with {@link #addCallback(Toast.Callback)}.
     */
    @SuppressLint("UseRequiresApi")
    @TargetApi(Build.VERSION_CODES.R)
    public void removeCallback(Toast.Callback callback) {
        toast.removeCallback(callback);
    }

    /**
     * Make a standard toast that just contains text.
     *
     * @param context  The context to use.  Usually your {@link Activity} object.
     * @param text     The text to show.  Can be formatted text.
     * @param duration How long to display the message.  Either {@link #LENGTH_SHORT} or
     *                 {@link #LENGTH_LONG}
     *
     */
    public static NexToast makeText(Context context, CharSequence text, int duration) {
        Toast toast = Toast.makeText(context, text, duration);
        if (hasSystemLimit) {
            return new NexToast(context, toast, getTextToastView(context, text));
        }
        return new NexToast(context, toast);
    }

    /**
     * Make a standard toast that just contains text.
     *
     * @param context  The context to use.  Usually your {@link Activity} object.
     * @param resId    The resource id of the string resource to use. Can be formatted text.
     * @param duration How long to display the message.  Either {@link #LENGTH_SHORT} or
     *                 {@link #LENGTH_LONG}
     *
     */
    public static NexToast makeText(Context context, int resId, int duration) throws Resources.NotFoundException {
        return makeText(context, context.getText(resId), duration);
    }

    /**
     * Update the text in a Toast that was previously created using one of the makeText() methods.
     *
     * @param resId The new text for the Toast.
     */
    public void setText(int resId) {
        setText(context.getText(resId));
    }

    /**
     * Update the text in a Toast that was previously created using one of the makeText() methods.
     *
     * @param s The new text for the Toast.
     */
    public void setText(CharSequence s) {
        if (message != null) {
            message.setText(s);
            return;
        }
        toast.setText(s);
    }

    public TextView getTextView() {
        return message;
    }

    private static int dp2px(Context context, int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    private final static Resources androidResources = Resources.getSystem();
    @SuppressLint("DiscouragedApi")
    private final static int TEXT_TOAST_LAYOUT = androidResources.getIdentifier("transient_notification", "layout", "android");

    @SuppressLint("DiscouragedApi")
    private final static int ID_MESSAGE = androidResources.getIdentifier("message", "id", "android");

    @SuppressLint("DiscouragedApi")
    private final static int ID_TOAST_FRAME_BACKGROUND = androidResources.getIdentifier("toast_frame", "drawable", "android");

    @SuppressLint("DiscouragedApi")
    private final static int ID_TOAST_ELEVATION = androidResources.getIdentifier("toast_elevation", "dimen", "android");

    @SuppressLint("DiscouragedApi")
    private final static int ID_TEXT_APPEARANCE_TOAST = androidResources.getIdentifier("TextAppearance.Toast", "style", "android");

    public static View getTextToastView(Context context, CharSequence text) {
        if (TEXT_TOAST_LAYOUT != 0) {
            try {
                View view = LayoutInflater.from(context).inflate(TEXT_TOAST_LAYOUT, null);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    if (view.getBackground() != null) {
                        Drawable drawable = androidResources.getDrawable(ID_TOAST_FRAME_BACKGROUND, context.getTheme());
                        if (drawable != null) {
                            view.setBackground(drawable);
                        }
                    }
                }
                TextView textView = view.findViewById(ID_MESSAGE);
                textView.setMaxLines(Integer.MAX_VALUE);
                if (text != null) {
                    textView.setText(text);
                }
                return view;
            } catch (Exception ignored) {
            }
        }
        return inflateTextToastView(context, text);
    }

    public static View inflateTextToastView(Context context, CharSequence text) {
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

        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(dpValue16);
            layoutParams.setMarginEnd(dpValue16);
            if (Build.VERSION.SDK_INT >= 21) {
                if (ID_TOAST_FRAME_BACKGROUND != 0) {
                    Drawable drawable = androidResources.getDrawable(ID_TOAST_FRAME_BACKGROUND, context.getTheme());
                    if (drawable != null) {
                        layout.setBackground(drawable);
                    }
                }
                if (ID_TOAST_ELEVATION != 0) {
                    try {
                        layout.setElevation(androidResources.getDimension(ID_TOAST_ELEVATION));
                    } catch (Resources.NotFoundException ignored) {
                    }
                }
            }
        }
        layout.setLayoutParams(layoutParams);

        TextView textView = new TextView(context);
        textView.setId(android.R.id.message);
        textView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setPadding(0, dpValue12, 0, dpValue12);

        if (Build.VERSION.SDK_INT >= 23 && ID_TEXT_APPEARANCE_TOAST != 0) {
            textView.setTextAppearance(ID_TEXT_APPEARANCE_TOAST);
        }

        if (text != null) {
            textView.setText(text);
        }

        layout.addView(textView);
        return layout;
    }
}