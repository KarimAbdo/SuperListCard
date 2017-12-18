package com.kabdo.uimix;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by karimabdo on 12/18/17.
 */

public class SuperCardView extends CardView {
    View view = inflate(getContext(), R.layout.super_card, null);
    public TextView titleTextView, subtitleTextView, descriptionTextView, expandIcon;
    public CircleImageView imageView;

    public SuperCardView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    public SuperCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public SuperCardView(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        addView(view);
        setRadius(40);
        titleTextView = view.findViewById(R.id.titleTextView);
        subtitleTextView = view.findViewById(R.id.subtitleTextView);
        descriptionTextView = view.findViewById(R.id.descriptionTextView);
        expandIcon = view.findViewById(R.id.expandIcon);
        imageView = view.findViewById(R.id.imageView);
    }

    public void setCardValues(
            boolean hasTitle, boolean hasSubtitle, boolean hasUrl, boolean hasDescription, boolean hasIcon,
            String title, String subtitle, String url, String description, int placeholder,
            int titleColor, int subtitleColor, int descriptionColor) {

        setCardValues(titleColor, subtitleColor, descriptionColor);
        setCardValues(title, subtitle, url, description, placeholder);
        setCardValues(hasTitle, hasSubtitle, hasUrl, hasDescription, hasIcon);
    }

    public void setCardValues(
            int titleColor, int subtitleColor, int descriptionColor) {
    }

    public void setCardValues(
            String title, String subtitle, String url, String description, int placeholder) {

        titleTextView.setText(title);
        subtitleTextView.setText(subtitle);
        descriptionTextView.setText(description);
        if (url.contains("http"))
            Glide.with(getContext())
                    .load(url)
                    .asBitmap()
                    .centerCrop()
                    .error(placeholder)
                    .placeholder(placeholder)
                    .into(imageView);
    }

    public void setTypeface(Typeface typeface) {
        descriptionTextView.setTypeface(typeface);
        expandIcon.setTypeface(typeface);
    }

    public class LoggingListener<T, R> implements RequestListener<T, R> {
        @Override
        public boolean onException(Exception e, Object model, Target target, boolean isFirstResource) {
            android.util.Log.d("GLIDE", String.format(Locale.ROOT,
                    "onException(%s, %s, %s, %s)", e, model, target, isFirstResource), e);
            return false;
        }

        @Override
        public boolean onResourceReady(Object resource, Object model, Target target, boolean isFromMemoryCache, boolean isFirstResource) {
            android.util.Log.d("GLIDE", String.format(Locale.ROOT,
                    "onResourceReady(%s, %s, %s, %s, %s)", resource, model, target, isFromMemoryCache, isFirstResource));
            return false;
        }
    }

    public void setCardValues(
            boolean hasTitle, boolean hasSubtitle, boolean hasUrl, boolean hasDescription, boolean hasIcon) {
        if (!hasTitle) titleTextView.setVisibility(View.GONE);
        if (!hasSubtitle) subtitleTextView.setVisibility(View.GONE);
        if (!hasUrl) imageView.setVisibility(View.GONE);
        if (!hasDescription) descriptionTextView.setVisibility(View.GONE);
        if (!hasIcon) expandIcon.setVisibility(View.GONE);
    }
}
