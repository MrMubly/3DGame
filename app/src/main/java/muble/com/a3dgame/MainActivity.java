package muble.com.a3dgame;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import muble.com.a3dgame.adapter.MainArticleFramentViewPagerAdapter;
import muble.com.a3dgame.adapter.MainFragmentPagerAdapter;
import muble.com.a3dgame.frament.MainChapterFrament;

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {
    HorizontalScrollView horizontalScrollView;
    RadioGroup radioGroup_top, radioGroup_bottom;
    RadioButton top1, top2, top3, top4, top5, top6, top7, top8, top9, top10;
    ViewPager viewPager_center1;
    RadioButton bottom1, bottom2, bottom3;
    List<Fragment> framents;
//    MainArticleFramentViewPagerAdapter mainArticleFramentViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        innView();
        innClick();
        addDatas();

    }

    //初始化main碎片资源
    private void addDatas() {
        framents=new ArrayList<Fragment>();
        MainChapterFrament frament1=new MainChapterFrament(1);
        MainChapterFrament frament2=new MainChapterFrament(2);
        MainChapterFrament frament3=new MainChapterFrament(3);
        MainChapterFrament frament4=new MainChapterFrament(4);
        MainChapterFrament frament5=new MainChapterFrament(5);
        MainChapterFrament frament6=new MainChapterFrament(6);
        MainChapterFrament frament7=new MainChapterFrament(7);
        MainChapterFrament frament8=new MainChapterFrament(8);
        MainChapterFrament frament9=new MainChapterFrament(9);
        MainChapterFrament frament10=new MainChapterFrament(10);
        framents.add(frament1);
        framents.add(frament2);
        framents.add(frament3);
        framents.add(frament4);
        framents.add(frament5);
        framents.add(frament6);
        framents.add(frament7);
        framents.add(frament8);
        framents.add(frament9);
        framents.add(frament10);
       MainFragmentPagerAdapter mainFragmentPagerAdapter=new MainFragmentPagerAdapter(getSupportFragmentManager(),framents);
        viewPager_center1.setAdapter(mainFragmentPagerAdapter);
    }

    //初始化监听
    private void innClick() {
        radioGroup_top.setOnCheckedChangeListener(this);
        radioGroup_bottom.setOnCheckedChangeListener(this);
        viewPager_center1.addOnPageChangeListener(this);
    }

    //初始化控件
    private void innView() {
        horizontalScrollView = (HorizontalScrollView) findViewById(R.id.main_horizontalscroll);
        radioGroup_top = (RadioGroup) findViewById(R.id.main_top_rg);
        radioGroup_bottom = (RadioGroup) findViewById(R.id.main_bottom_rg);
        top1 = (RadioButton) findViewById(R.id.main_top_tittle1);
        top2 = (RadioButton) findViewById(R.id.main_top_tittle2);
        top3 = (RadioButton) findViewById(R.id.main_top_tittle3);
        top4 = (RadioButton) findViewById(R.id.main_top_tittle4);
        top5 = (RadioButton) findViewById(R.id.main_top_tittle5);
        top6 = (RadioButton) findViewById(R.id.main_top_tittle6);
        top7 = (RadioButton) findViewById(R.id.main_top_tittle7);
        top8 = (RadioButton) findViewById(R.id.main_top_tittle8);
        top9 = (RadioButton) findViewById(R.id.main_top_tittle9);
        top10 = (RadioButton) findViewById(R.id.main_top_tittle10);
        viewPager_center1 = (ViewPager) findViewById(R.id.main_center_viewpager1);
        bottom1 = (RadioButton) findViewById(R.id.main_bottom_chapter);
        bottom2 = (RadioButton) findViewById(R.id.main_bottom_forum);
        bottom3 = (RadioButton) findViewById(R.id.main_mottom_game);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.main_top_tittle1:
                viewPager_center1.setCurrentItem(0);
                break;
            case R.id.main_top_tittle2:
                viewPager_center1.setCurrentItem(1);
                break;
            case R.id.main_top_tittle3:
                viewPager_center1.setCurrentItem(2);
                break;
            case R.id.main_bottom_chapter:
                viewPager_center1.setCurrentItem(3);
                break;
        }

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        //顶部的滚动条出现移动效果
        horizontalScrollView.setVisibility(View.VISIBLE);
        radioGroup_top.setVisibility(View.VISIBLE);
//获得当前ViewPager对应的RadioButton
        RadioButton radioButton = (RadioButton)radioGroup_top.getChildAt(position);
        radioButton.setChecked(true);
        //让顶部的RadioButton随着ViewPager一起滚动
        int left=radioButton.getLeft();
        horizontalScrollView.smoothScrollTo(left,0);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
