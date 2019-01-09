package com.zinc.class7_bezier.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

import com.zinc.class7_bezier.CircleBezierView;
import com.zinc.class7_bezier.R;

/**
 * @author Jiang zinc
 * @date 创建时间：2019/1/9
 * @description
 */
public class AnimBezierActivity extends AppCompatActivity {

    private CircleBezierView circleBezierView;
    private TextView tvRatio;
    private SeekBar ratioSeekBar;

    private static final int MAX = 100;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);

        circleBezierView = findViewById(R.id.circle_bezier_view);
        tvRatio = findViewById(R.id.tv_ratio);
        ratioSeekBar = findViewById(R.id.ratio_seek_bar);

        ratioSeekBar.setMax(MAX);
        circleBezierView.setRatio(0.55f);
        tvRatio.setText(String.format(getString(R.string.ratio), "0.55"));
        ratioSeekBar.setProgress(55);

        ratioSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float r = progress / (float) MAX;
                tvRatio.setText(String.format(getString(R.string.ratio), "" + r));

                circleBezierView.setRatio(r);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


}
