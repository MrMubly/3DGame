package muble.com.a3dgame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import muble.com.a3dgame.adapter.GuideViewPagerAdpater;

public class GuideActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{
    List<View> views;
    ViewPager guidViewPager;
    LayoutInflater inflater;
    ImageView[] dots;
    GuideViewPagerAdpater guideViewPagerAdpater;
    int currentIndex; //当前的页面的索引
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        inView();
        initDot();
    }
    //初始化所有的点
    private void initDot() {
        LinearLayout ll = (LinearLayout)findViewById(R.id.guide_dot_ll);
        dots = new ImageView[views.size()];
        //得到线性布局下面的所有的点对象
        for(int i=0;i<views.size();i++){
            dots[i]= (ImageView) ll.getChildAt(i);
            dots[i].setEnabled(true);
        }
        //初始化当前所在page的索引值
        currentIndex =0;
        //设置当前的Pager是白色
        dots[currentIndex].setEnabled(false);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
if (position<0||position>views.size()){
    return;
}
        //设置选中状态
        dots[position].setEnabled(false);
        dots[currentIndex].setEnabled(true);
        currentIndex=position;
        //最后一个引导界面的监听
        if (position==views.size()-1){
            Button btn=(Button)views.get(position).findViewById(R.id.guid_main_btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setGuide();
                    Intent mainIntent=new Intent(GuideActivity.this,MainActivity.class);
                    startActivity(mainIntent);
                    finish();
                }
            });
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
    private void inView(){
       guidViewPager=(ViewPager) this.findViewById(R.id.guid_viewpager);
        inflater=LayoutInflater.from(this);
        views=new ArrayList<View>();
        View view1=inflater.inflate(R.layout.guid_imag1,null);
        View view2=inflater.inflate(R.layout.guid_imag2,null);
        View view3=inflater.inflate(R.layout.guid_imag3,null);
        views.add(view1);
        views.add(view2);
        views.add(view3);
        guideViewPagerAdpater=new GuideViewPagerAdpater(views);
        guidViewPager.setAdapter(guideViewPagerAdpater);
        guidViewPager.addOnPageChangeListener(this);

    }
    //保存登陆过的信息
    private void setGuide() {
        SharedPreferences sharedPreferences = getSharedPreferences("isFistLogin", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =  sharedPreferences.edit();
        editor.putBoolean("isLogin",true);
        editor.commit();
    }
}
