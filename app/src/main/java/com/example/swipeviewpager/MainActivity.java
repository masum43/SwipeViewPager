package com.example.swipeviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    List<Model> models;
    private String selectedOption;
    private Button confirmBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        confirmBtn = findViewById(R.id.btnOrder);

        models = new ArrayList<>();
        models.add(new Model(R.drawable.brochure,"Brochure","Brochure is an informative"));
        models.add(new Model(R.drawable.sticker,"Sticker","Sticker is an............"));
        models.add(new Model(R.drawable.poster,"Poster","Poster is a .........."));
        models.add(new Model(R.drawable.namecard,"Namecard","Namecard is a........"));

        adapter = new Adapter(models,this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);

        Integer[] colors_temp = {getResources().getColor(R.color.color1),
                                 getResources().getColor(R.color.colo2),
                                 getResources().getColor(R.color.color3),
                                 getResources().getColor(R.color.color4),


        };

        colors = colors_temp;
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position<(adapter.getCount()- 1) && position < (colors.length -1)){
                    viewPager.setBackgroundColor
                            (
                            (Integer)argbEvaluator.evaluate
                                    (
                                    positionOffset,
                                    colors[position],
                                    colors[position+1]
                                    )
                            );
                    if (position == 0)
                    {
                        selectedOption = "Teacher";
                    }
                    else if (position ==1)
                    {
                        selectedOption = "Student";
                    }
                    else if ((position == 2))
                    {
                        selectedOption = "Guardian";
                    }
                }
                else {
                    viewPager.setBackgroundColor(colors[colors.length -1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedOption.equals("Teacher"))
                {
                    Toast.makeText(MainActivity.this, ""+selectedOption, Toast.LENGTH_LONG).show();
                }

                else if(selectedOption.equals("Student"))
                {
                    Toast.makeText(MainActivity.this, ""+selectedOption, Toast.LENGTH_LONG).show();
                }
                else if(selectedOption.equals("Guardian"))
                {
                    Toast.makeText(MainActivity.this, ""+selectedOption, Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Null Value : "+selectedOption, Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
