package com.anw.tgcity.share;


import android.app.Activity;

/**
 * @Describe  分享方针
 */
public interface SharePolicy {
    /**
     * 分享朋友圈
     */
    void shareMoment(Activity activity, OnShareCallbackListener l);

    /**
     * 分享微信
     */
    void shareWechat(Activity activity, OnShareCallbackListener l);

    /**
     * 分享微博
     */
    void shareWeibo(Activity activity, OnShareCallbackListener l);

    /**
     * 分享qq
     */
    void shareQQ(Activity activity, OnShareCallbackListener l);

    /**
     * 分享qq空间
     */
    void shareZone(Activity activity, OnShareCallbackListener l);

    /**
     * 显示分享的弹框
     */
    void showShare(Activity activity);

    /**
     * 设置分享内容
     * @param shareContent
     */
    void setShareContent(ShareContent shareContent);
}
