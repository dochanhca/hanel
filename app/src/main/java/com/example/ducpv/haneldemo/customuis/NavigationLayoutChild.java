package com.example.ducpv.haneldemo.customuis;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ducpv.haneldemo.R;


/**
 * Created by thanglh on 01/12/14.
 */
public class NavigationLayoutChild extends LinearLayout {

    private ImageView imgIcon;
    private TextView txtValue;
    private TextView txtBoxValue;
    private View divider;

    private TypedArray typedArray;
    private String text;
    private int textColorSelected;
    private int iconSelected;
    private int textColorNormal;
    private int iconNormal;
    private String boxValue;
    private boolean showBoxValue;
    private boolean showDivider = false;
    private int dividerColor;

    private static final boolean SELECTED = true;
    private static final boolean NORMAL = false;

    private OnClickListener mOnViewClickListener;

    /**
     * if state =true -> Tab is selected
     */
    private boolean state;

    private OnClickListener mOnIconClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            state = !state;
            if (mOnViewClickListener != null)
                mOnViewClickListener.onClick(NavigationLayoutChild.this);
            reloadView();
        }
    };

    public void setmOnViewClickListener(OnClickListener mOnViewClickListener) {
        this.mOnViewClickListener = mOnViewClickListener;
    }

    public NavigationLayoutChild(Context context) {
        super(context);
    }

    public NavigationLayoutChild(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public NavigationLayoutChild(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        typedArray = getContext().obtainStyledAttributes(
                attrs,
                R.styleable.NavigationLayout);

        textColorNormal = typedArray.getColor(R.styleable.NavigationLayout_textColorNormal, Color.GRAY);
        iconNormal = typedArray.getResourceId(R.styleable.NavigationLayout_iconNormal, android.R.drawable.ic_delete);
        text = typedArray.getString(R.styleable.NavigationLayout_text);

        textColorSelected = textColorNormal;
        iconSelected = iconNormal;
        if (typedArray.hasValue(R.styleable.NavigationLayout_textColorSelected)) {
            textColorSelected = typedArray.getColor(R.styleable.NavigationLayout_textColorSelected, Color.BLUE);
        }

        if (typedArray.hasValue(R.styleable.NavigationLayout_iconSelected)) {
            iconSelected = typedArray.getResourceId(R.styleable.NavigationLayout_iconSelected, android.R.drawable.ic_delete);
        }

        showBoxValue = typedArray.getBoolean(R.styleable.NavigationLayout_showBoxValue, false);

        if (typedArray.hasValue(R.styleable.NavigationLayout_state)) {
            this.state = typedArray.getBoolean(R.styleable.NavigationLayout_state, false);
        }

        //Don't forget this
        typedArray.recycle();
        setGravity(Gravity.CENTER);
        setBackgroundColor(Color.TRANSPARENT);

        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.navigation_layout, this, true);

        imgIcon = findViewById(R.id.img);
        txtValue = findViewById(R.id.txt);
        txtValue.setText(text);
        txtBoxValue = findViewById(R.id.txt_box);
        divider = findViewById(R.id.divider);

        findViewById(R.id.container).setOnClickListener(mOnIconClickListener);

        reloadView();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void changeToSelectedTab() {
        if (this.state == NORMAL) {
            txtValue.setTextColor(textColorSelected);
            imgIcon.setImageResource(iconSelected);
            this.state = SELECTED;
        }
    }

    public void changeToNormalTab() {
        if (this.state == SELECTED) {
            txtValue.setTextColor(textColorNormal);
            imgIcon.setImageResource(iconNormal);
            this.state = NORMAL;
        }
    }

    private void reloadView() {
        if (state) {
            imgIcon.setImageResource(iconSelected);
            txtValue.setTextColor(textColorSelected);
        } else {
            imgIcon.setImageResource(iconNormal);
            txtValue.setTextColor(textColorNormal);
        }

        setShowBoxValue(showBoxValue);
    }

    public String getBoxValue() {
        return boxValue;
    }

    /**
     * need to call showBoxValue method to show box
     *
     * @param boxValue
     */
    public void setBoxValue(String boxValue) {
        this.boxValue = boxValue;
        txtBoxValue.setText(boxValue);
    }

    public void showBoxValue(String boxValue) {
        showBoxValue = true;
        setShowBoxValue(true);
        this.boxValue = boxValue;
        txtBoxValue.setText(String.valueOf(boxValue));
    }

    public boolean isShowBoxValue() {
        return showBoxValue;
    }

    public void setShowBoxValue(boolean isShow) {
        this.showBoxValue = isShow;
        txtBoxValue.setVisibility(isShow ? VISIBLE : GONE);
    }

    public boolean isShowDivider() {
        return showDivider;
    }

    public void setShowDivider(boolean showDivider) {
        this.showDivider = showDivider;
        if (showDivider) {
            divider.setVisibility(VISIBLE);
            divider.setBackgroundColor(dividerColor);
        } else {
            divider.setVisibility(GONE);
        }
    }

    public int getDividerColor() {
        return dividerColor;
    }

    public void setDividerColor(int dividerColor) {
        this.dividerColor = dividerColor;
    }
}
