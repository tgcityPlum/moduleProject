# banner module使用说明
## 1 xml配置
```
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:banner="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="cn.liyula.chenw.testbanner.MainActivity">

    <com.youth.banner.Banner
        android:id="@+id/banner"
        android:layout_width="match_parent"
        android:layout_height="@dimen/dp_200"
        banner:indicator_width="8dp"
        banner:indicator_height="8dp"
        banner:indicator_margin="4dp"/>

</FrameLayout>

```
## 2 class配置
```
    Banner banner;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        banner = (Banner)findViewById(R.id.banner);

        List<String> url2 = new ArrayList<>();

        url2.add("https://wx.liyula.cn/storage/2018/04/04/1635/cxtmmOoGGvz6Cs4UUH9sDdGQMLTGgQczQ58iVMq2/3d25591b1afcff94772921770f78b344.jpeg");
        url2.add("https://wx.liyula.cn/storage/2018/04/04/1635/cxtmmOoGGvz6Cs4UUH9sDdGQMLTGgQczQ58iVMq2/3d25591b1afcff94772921770f78b344.jpeg");
        url2.add("https://wx.liyula.cn/storage/2018/04/04/1635/cxtmmOoGGvz6Cs4UUH9sDdGQMLTGgQczQ58iVMq2/3d25591b1afcff94772921770f78b344.jpeg");

        //设置banner属性
        //设置显示形状
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置显示位置
        banner.setIndicatorGravity(BannerConfig.RIGHT);
        //设置是否自动轮播
        banner.isAutoPlay(true);
        //设置点击后是否停止轮播
        banner.isDownStopAutoPlay(false);
        //设置加载图片
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                String url=(String) path;
                Glide.with(context)
                        .load(url)
                        .into(imageView);
            }
        });
        //设置图片集合
        banner.setImages(url2);

        banner.setOnBannerListener(this);
        //设置开启轮播控件
        banner.start();
    }
     
    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (banner != null){
            banner.releaseBanner();
        }
    }
```