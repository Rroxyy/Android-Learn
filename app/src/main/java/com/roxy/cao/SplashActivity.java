package com.roxy.cao;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("CustomSplashScreen")  // 禁用与自定义闪屏相关的警告
public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);  // 设置闪屏界面的布局文件

        // 获取布局文件中的 ImageView 控件，用于展示闪屏图片
        ImageView img = findViewById(R.id.imageView2);

        // 定义三张图片的资源ID数组，用于轮换显示
        int[] imgs = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3};

        // 设置全屏模式，隐藏状态栏和其他界面元素
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // 使用 Handler 进行图片的延时切换
        for (int i = 0; i < 3; i++) {
            int finalI = i;  // 为了在延迟任务中使用当前的循环变量，必须将其声明为 final
            // 延迟设置图片，每隔 1 秒切换一次
            new Handler().postDelayed(() -> img.setImageResource(imgs[finalI]), 1000 * (i + 1));
        }

        // 使用 Handler 设置闪屏持续时间，3秒之后跳转到登录页面
        new Handler().postDelayed(() -> {
            // 创建一个 Intent，跳转到 LoginActivity
            Intent mainIntent = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(mainIntent);  // 启动 LoginActivity
            finish();  // 结束当前闪屏活动，防止用户返回到闪屏界面
        }, 4000);  // 延时 4 秒钟后执行
    }
}
