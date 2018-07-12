package com.steven.spanntextview;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.URLSpan;
import android.widget.TextView;

import com.steven.spanntextview.widget.CenterAlignImageSpan;

//https://blog.csdn.net/richardli1228/article/details/51180253

/**
 * SpannableString其实和String一样，都是一种字符串类型，SpannableString可以直接作为TextView的显示文本，
 * 不同的是SpannableString可以通过使用其方法setSpan方法实现字符串各种形式风格的显示,重要的是可以指定设置的区间，
 * 也就是为字符串指定下标区间内的子字符串设置格式。
 * <p>
 * setSpan(Object what, int start, int end, int flags)方法需要用户输入四个参数，what表示设置的格式是什么，可以是前景色、背景色也可以是可点击的文本等等
 * start表示需要设置格式的子字符串的起始下标，同理end表示终了下标，flags属性就有意思了，共有四种属性：
 * <p>
 * Spanned.SPAN_INCLUSIVE_EXCLUSIVE 从起始下标到终了下标，包括起始下标
 * Spanned.SPAN_INCLUSIVE_INCLUSIVE 从起始下标到终了下标，同时包括起始下标和终了下标
 * Spanned.SPAN_EXCLUSIVE_EXCLUSIVE 从起始下标到终了下标，但都不包括起始下标和终了下标
 * Spanned.SPAN_EXCLUSIVE_INCLUSIVE 从起始下标到终了下标，包括终了下标
 * <p>
 * SpannableString的setSpan()方法可以同时使用多个，实现多种效果叠加。
 */
public class MainActivity extends AppCompatActivity {
    private TextView mIconSpan;
    private TextView mMultiIconSpan;
    private TextView mVerticalCenterIcon;
    private TextView mUrlSpan;
    private TextView mForegroundColorSpan;
    private TextView mBackgroundColorSpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIconSpan = findViewById(R.id.tv1);
        mMultiIconSpan = findViewById(R.id.tv2);
        mVerticalCenterIcon = findViewById(R.id.tv3);
        mUrlSpan = findViewById(R.id.tv4);
        mForegroundColorSpan = findViewById(R.id.tv5);
        mBackgroundColorSpan = findViewById(R.id.tv6);
        setIconSpan(mIconSpan.getText());
        setMultiIconSpan(mMultiIconSpan.getText());
        setVerticalCenterIconSpan(mVerticalCenterIcon.getText());
        setUrlSpan(mUrlSpan.getText());
        setForegroundColorSpan(mForegroundColorSpan.getText());
        setBackgroundColorSpan(mBackgroundColorSpan.getText());
    }

    private void setIconSpan(CharSequence charSequence) {

        String text = "[icon] " + charSequence;
        SpannableString spannable = new SpannableString(text);
        Drawable drawable = this.getResources().getDrawable(R.mipmap.umeng_socialize_qq);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        //第一个参数drawable 第二个参数对齐方式
        ImageSpan imageSpan = new ImageSpan(drawable, ImageSpan.ALIGN_BASELINE);
        spannable.setSpan(imageSpan, 0, 6, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        mIconSpan.setText(spannable);
    }

    private void setMultiIconSpan(CharSequence charSequence) {
        String text = "[icon] ";
        SpannableStringBuilder spannable = new SpannableStringBuilder(text);

        Drawable drawable1 = this.getResources().getDrawable(R.mipmap.umeng_socialize_qq);
        drawable1.setBounds(0, 0, drawable1.getIntrinsicWidth(), drawable1.getIntrinsicHeight());
        ImageSpan imageSpan1 = new ImageSpan(drawable1, ImageSpan.ALIGN_BASELINE);
        spannable.setSpan(imageSpan1, 0, 6, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        //追加一个icon
        spannable.append("[icon] " + charSequence);
        Drawable drawable2 = this.getResources().getDrawable(R.mipmap.umeng_socialize_wechat);
        drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable1.getIntrinsicHeight());
        ImageSpan imageSpan2 = new ImageSpan(drawable2, ImageSpan.ALIGN_BASELINE);
        spannable.setSpan(imageSpan2, 7, 13, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        mMultiIconSpan.setText(spannable);

    }

    private void setVerticalCenterIconSpan(CharSequence charSequence) {
        String text = "[icon] " + charSequence;
        SpannableString spannable = new SpannableString(text);
        Drawable drawable = this.getResources().getDrawable(R.mipmap.umeng_socialize_qzone);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        //图片居中
        CenterAlignImageSpan imageSpan = new CenterAlignImageSpan(drawable, ImageSpan.ALIGN_BASELINE);
        spannable.setSpan(imageSpan, 0, 6, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        mVerticalCenterIcon.setText(spannable);
    }

    private void setUrlSpan(CharSequence charSequence) {
        SpannableString spannableString = new SpannableString(charSequence);
        //URLSpan
        URLSpan urlSpan = new URLSpan("https://www.jianshu.com/u/9006081639f4");
        spannableString.setSpan(urlSpan, 4, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        mUrlSpan.setMovementMethod(LinkMovementMethod.getInstance());
        mUrlSpan.setHighlightColor(ContextCompat.getColor(this, R.color.colorAccent));
        mUrlSpan.setText(spannableString);
    }

    private void setForegroundColorSpan(CharSequence charSequence) {
        SpannableString spannableString = new SpannableString(charSequence);
        //ForegroundColorSpan
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        spannableString.setSpan(colorSpan, 5, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        mForegroundColorSpan.setText(spannableString);
    }

    private void setBackgroundColorSpan(CharSequence charSequence) {
        SpannableString spannableString = new SpannableString(charSequence);
        BackgroundColorSpan colorSpan = new BackgroundColorSpan(ContextCompat.getColor(this, R.color.colorAccent));
        spannableString.setSpan(colorSpan, 5, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        mBackgroundColorSpan.setText(spannableString);
    }
}
