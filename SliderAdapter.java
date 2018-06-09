package germany.helfen.ir.helfen;


import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SliderAdapter extends PagerAdapter {


    Context context;
    LayoutInflater layoutInflater;


    public SliderAdapter (Context context){
        this.context = context;
    }


    //defining Arrays for SlidePager


    public int[] slide_image = {
            R.drawable.deutschland_botschaft,
            R.drawable.helfen_pay,
            R.drawable.requirements,
            R.drawable.germany_flag_logo,
            R.drawable.about_us,
    };

    public String[] slide_headings= {
             "سفارت",
             "هلفن پی",
           "نیازمندی ها",
            "درباره آلمان ",
            "درباره هلفن ",

    };

    public String[] slide_descriptions = {
            " راهنمایی های قبل و بعد از دریافت ویزای تحصیلی آلمان " ,
            "آگهی های خرید و فروش بدون واسطه ارز در ایران و آلمان",
            "نیازمندی های ایرانیان مقیم آلمان و اروپا",
            "اطلاعات جامع و بروز در رابطه با فرهنگ و زندگی در کشور آلمان ",
            "ارتباط با تیم هلفن در شبکه های اجتماعی ",
    };


    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view ==(RelativeLayout) object ;
    }
    public Object instantiateItem(ViewGroup contrainer, int position){
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,contrainer,false);

        ImageView slideImageVIew = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeadings = (TextView) view.findViewById(R.id.slide_headings);
        TextView slideDescriptions= (TextView) view.findViewById(R.id.slide_descriptions);



        slideImageVIew.setImageResource(slide_image[position]);
        slideHeadings.setText(slide_headings[position]);
        slideDescriptions.setText(slide_descriptions[position]);

        contrainer.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
         container.removeView((RelativeLayout)object);
    }
}
