package germany.helfen.ir.helfen;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {
    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;
    private SliderAdapter sliderAdapter;
    private TextView[] mDots;
    private Button mNxtButton;
    private int myCurrentPage;
    private Button mPreButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mSlideViewPager =(ViewPager) findViewById(R.id.view_pager);
        mDotLayout = (LinearLayout)findViewById(R.id.dotsLayout);

        sliderAdapter = new SliderAdapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);
        addDotsIndicator(0);
        mNxtButton =(Button)findViewById(R.id.next_button);
        mPreButton =(Button)findViewById(R.id.previous_button);
        mSlideViewPager.addOnPageChangeListener(viewListener);





        mNxtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(myCurrentPage+1);
            }
        });
        mPreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(myCurrentPage-1);
            }
        });
    }

    public void addDotsIndicator(int position){
        mDots = new TextView[5];
        mDotLayout.removeAllViews();
        for(int i =0 ; i <mDots.length;i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.whitecolor));
            mDotLayout.addView(mDots[i]);
        }
        if(mDots.length> 0 ){
            mDots[position].setTextColor(getResources().getColor((R.color.redcolor)));
        }

    }
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener(){

        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int position) {
        addDotsIndicator(position);
            myCurrentPage=position;
            if(position==0){
                mNxtButton.setEnabled(true);
                mPreButton.setEnabled(false);
                mPreButton.setVisibility(View.INVISIBLE);
                mNxtButton.setText("بعدی");
                mPreButton.setText("");
            }
            else if(position==mDots.length-1){
                mNxtButton.setEnabled(false);
                mPreButton.setEnabled(true);
                mPreButton.setVisibility(View.VISIBLE);
                mNxtButton.setText("");
                mPreButton.setText("قبلی");
            }
            else {
                mNxtButton.setEnabled(true);
                mPreButton.setEnabled(true);
                mPreButton.setVisibility(View.VISIBLE);
                mNxtButton.setText("بعدی");
                mPreButton.setText("قبلی");
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
