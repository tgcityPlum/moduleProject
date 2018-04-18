package com.anw.tgcity.share;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

/**
 * @describe 用于分享的弹框
 */

public class RecyclerViewPopupWindow extends PopupWindow {
    public static final float POPUPWINDOW_ALPHA = 0.8f;

    public static final int VERTICAL = 0;
    public static final int HORIZONTAL = 1;
    public static final int GRID = 2;

    private Activity mActivity;
    private View mParentView;
    private View mContentView;
    private boolean mIsOutsideTouch;
    private boolean mIsFocus;
    private float mAlpha = 0.8f;
    private int mOritation = VERTICAL;
    private int mSpanCount;
    private int mItemSpacing;
    private Drawable mBackgroundDrawable = new ColorDrawable(0x00000000);// 默认为透明;
    private CommonAdapter mAdapter;

    private RecyclerViewPopupWindow() {

    }

    private RecyclerViewPopupWindow(RecyclerViewPopupWindow.Builder builder) {
        this.mActivity = builder.mActivity;
        this.mParentView = builder.mParentView;
        this.mIsOutsideTouch = builder.mIsOutsideTouch;
        this.mIsFocus = builder.mIsFocus;
        this.mAlpha = builder.mAlpha;
        this.mAdapter = builder.mAdapter;
        this.mOritation = builder.mOritation;
        this.mSpanCount = builder.mSpanCount;
        this.mItemSpacing = builder.mItemSpacing;
        initView();
    }

    private void initView() {
        initLayout();
        setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        setFocusable(mIsFocus);
        setOutsideTouchable(mIsOutsideTouch);
        setBackgroundDrawable(mBackgroundDrawable);
        setAnimationStyle(R.style.style_actionPopupAnimation);
        setContentView(mContentView);
    }

    private void initLayout() {
        mContentView = LayoutInflater.from(mActivity).inflate(R.layout.view_recycler_view_popup_window, null);
        RecyclerView recyclerView = (RecyclerView) mContentView.findViewById(R.id
                .rv_popup_window);
        // 设置布局管理器
        switch (mOritation) {
            case VERTICAL:
                LinearLayoutManager verticalManager = new LinearLayoutManager(mActivity);
                verticalManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(verticalManager);
                break;
            case HORIZONTAL:
                LinearLayoutManager horizontalManager = new LinearLayoutManager(mActivity);
                horizontalManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(horizontalManager);
                break;
            case GRID:
                GridLayoutManager gridLayoutManager = new GridLayoutManager(mActivity, mSpanCount);
                recyclerView.addItemDecoration(new ShareDecoration(mItemSpacing));
                recyclerView.setLayoutManager(gridLayoutManager);
                break;
                default:
        }

        recyclerView.setAdapter(mAdapter);
        setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                setWindowAlpha(1.0f);
            }
        });
    }

    private void setWindowAlpha(float alpha) {
        WindowManager.LayoutParams params = mActivity.getWindow().getAttributes();
        params.alpha = alpha;
        params.verticalMargin = 100;
        mActivity.getWindow().setAttributes(params);
    }

    public void show() {
        setWindowAlpha(mAlpha);
        showAtLocation(mParentView == null ? mContentView : mParentView, Gravity.BOTTOM, 0, 0);
    }

    public void hide() {
        Observable.just(0)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        dismiss();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                        dismiss();
                    }
                });


    }

    public static RecyclerViewPopupWindow.Builder Builder() {
        return new RecyclerViewPopupWindow.Builder();
    }

    public static final class Builder {
        private Activity mActivity;
        private View mParentView;
        private boolean mIsOutsideTouch = true;
        private boolean mIsFocus = true;
        private float mAlpha = POPUPWINDOW_ALPHA;
        private CommonAdapter mAdapter;
        private int mOritation = VERTICAL;
        private int mSpanCount;
        private int mItemSpacing;

        private Builder() {
        }

        public RecyclerViewPopupWindow.Builder with(Activity mActivity) {
            this.mActivity = mActivity;
            return this;
        }

        public RecyclerViewPopupWindow.Builder adapter(CommonAdapter adapter) {
            this.mAdapter = adapter;
            return this;
        }

        public RecyclerViewPopupWindow.Builder parentView(View parentView) {
            this.mParentView = parentView;
            return this;
        }

        public RecyclerViewPopupWindow.Builder isOutsideTouch(boolean isOutsideTouch) {
            this.mIsOutsideTouch = isOutsideTouch;
            return this;
        }

        public RecyclerViewPopupWindow.Builder iFocus(boolean isFocus) {
            this.mIsFocus = isFocus;
            return this;
        }

        public RecyclerViewPopupWindow.Builder alpha(float alpha) {
            this.mAlpha = alpha;
            return this;
        }

        public RecyclerViewPopupWindow.Builder asVertical() {
            mOritation = VERTICAL;
            return this;
        }

        public RecyclerViewPopupWindow.Builder asHorizontal() {
            mOritation = HORIZONTAL;
            return this;
        }

        public RecyclerViewPopupWindow.Builder asGrid(int spanCount) {
            mOritation = GRID;
            this.mSpanCount = spanCount;
            return this;
        }

        public RecyclerViewPopupWindow.Builder itemSpacing(int mItemSpacing) {
            this.mItemSpacing = mItemSpacing;
            return this;
        }


        public RecyclerViewPopupWindow build() {
            return new RecyclerViewPopupWindow(this);
        }
    }

}
