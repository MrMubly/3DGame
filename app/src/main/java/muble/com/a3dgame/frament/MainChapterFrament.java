package muble.com.a3dgame.frament;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import muble.com.a3dgame.R;
import muble.com.a3dgame.adapter.MainArticleFramentViewPagerAdapter;

/**
 * Created by Administrator on 2016/7/7.
 */
public class MainChapterFrament extends Fragment {
    private int typeid;//定义文章的类型
    MainArticleFramentViewPagerAdapter  mainArticleFrementViewPagerAdapter;//碎片内部顶层适配器
public MainChapterFrament(){

}
    //强制设置构造
    //Annotation
    @SuppressLint("ValidFragment")
    public MainChapterFrament(int typeid) {
        this.typeid = typeid;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       //获得碎片中的整体布局
        View view=inflater.inflate(R.layout.main_view_frament,null);
        ViewPager mainTopFrament=(ViewPager)view.findViewById(R.id.main_top_frament_vp);
        int [] imageRsId={R.drawable.default1,R.drawable.default2,R.drawable.default3};
        List<ImageView> imageViews = new ArrayList<ImageView>();
        for (int i=0;i<3;i++){

            ImageView imageView=new ImageView(getActivity());
            //设置图片的缩放类型  铺满全屏
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(imageRsId[i]);
            imageViews.add(imageView);
        }
      mainArticleFrementViewPagerAdapter=new  MainArticleFramentViewPagerAdapter(imageViews);
        mainTopFrament.setAdapter(mainArticleFrementViewPagerAdapter);
        TextView tv=(TextView)view.findViewById(R.id.main_frament_tv);
        tv.setText("要杀你，我只出"+typeid+"刀");
        return view;
    }
}
