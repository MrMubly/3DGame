package muble.com.a3dgame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Toast;

import muble.com.a3dgame.services.DownLoadService;
import muble.com.a3dgame.utils.IsNetConnecteUtils;
import pl.droidsonroids.gif.GifImageView;

public class Welcome_Activity extends AppCompatActivity {
    GifImageView giv_welcome;
    Animation animation;
    boolean isConnet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_);
        //获取欢迎界面动画控件
        giv_welcome = (GifImageView) this.findViewById(R.id.giv_welcome);
        animation = new AlphaAnimation(0, 1.0f);
        animation.setDuration(3000);
        giv_welcome.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            //动画开启
            @Override
            public void onAnimationStart(Animation animation) {
                isConnet = IsNetConnecteUtils.isConnect(Welcome_Activity.this);
                //判断网络
                if (isConnet) {
                    //开启加载服务
                    Intent welcomeDownloadIntent = new Intent(Welcome_Activity.this, DownLoadService.class);
                    startService(welcomeDownloadIntent);
                }

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (!isConnet) {
                    Toast.makeText(Welcome_Activity.this, "主人，您还没有赐予小的网络", Toast.LENGTH_SHORT).show();
                }
                //判断是否是第一次登陆
                isFristLogin();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }

    //判断是否是第一登陆
    private void isFristLogin() {
        //创建sharedPreferences对象
        SharedPreferences sharePreference = getSharedPreferences("isFistLogin", Context.MODE_PRIVATE);
        //获得sharedPreferences对象中的isLogin属性
        boolean isLogin = sharePreference.getBoolean("isLogin", false);
        //如果是第一登陆,就跳转到引导界面，否则的话，跳转到主界面
        if (!isLogin) {
            Intent guideIntent = new Intent(Welcome_Activity.this, GuideActivity.class);
            startActivity(guideIntent);
            finish();
        } else {
            Intent mainIntent = new Intent(Welcome_Activity.this, MainActivity.class);
            startActivity(mainIntent);
            finish();
        }

    }
}
