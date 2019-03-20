package app.ase.mylogin;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Gulid_Activity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mVp;
    /**
     * 下一步
     */
    private Button mBtn;
    private LinearLayout mLl;
    private List<View> vpViews;
    private PagerAdapter myPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gulid_);
        initView();
        initListener();
        initData();
        mBtn.setVisibility(View.GONE);
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(this);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Gulid_Activity.this,Login_Activity.class));
            }
        });
        mLl = (LinearLayout) findViewById(R.id.ll);
    }
    public void initListener() {

    }

    public void initData() {

        initViewPage();

        setDot(0);

        mVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                setDot(position);

                if (position == (vpViews.size() - 1)) {
                    mBtn.setVisibility(View.VISIBLE);
                } else {
                    mBtn.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setDot(int i1) {
        mLl.removeAllViews();
        for (int i = 0; i < vpViews.size(); i++) {
            TextView textView = new TextView(this);
            textView.setText("。");
            if(i != i1) {
                textView.setTextColor(Color.WHITE);
            }else {
                textView.setTextColor(Color.RED);
            }
            mLl.addView(textView);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.ll:
                mVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int i, float v, int i1) {

                    }

                    @Override
                    public void onPageSelected(int i) {
                        if(i == (vpViews.size()-1)){
                            mBtn.setVisibility(View.VISIBLE);
                        }else {
                            mBtn.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onPageScrollStateChanged(int i) {

                    }
                });
                break;
        }

    }
    private void initViewPage() {
        vpViews = new ArrayList<>();
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        vpViews.add(layoutInflater.inflate(R.layout.vp_layout4, null ));
        vpViews.add(layoutInflater.inflate(R.layout.vp_layout5, null));
        vpViews.add(layoutInflater.inflate(R.layout.vp_layout6, null));
        myPageAdapter = new MyPageAdapter(vpViews);
        mVp.setAdapter(myPageAdapter);
    }

    class MyPageAdapter extends PagerAdapter {
        List<View> mlist;
        public MyPageAdapter(List<View> mlist) {
            this.mlist = mlist;
        }

        @Override
        public int getCount() {
            return mlist.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return (view == object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = mlist.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mlist.get(position));
        }
    }
}
