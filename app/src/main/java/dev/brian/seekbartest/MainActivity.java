package dev.brian.seekbartest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    private static final String TAG = "MainActivity";


    // 与系统默认SeekBar对应的TextView
    private TextView mTvDef;
    // 与自定义SeekBar对应的TextView
    private TextView mTvSelf;
    // 系统默认SeekBar
    private SeekBar mSeekBarDef;
    // 自定义SeekBar
    private SeekBar mSeekBarSelf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TextView显示直行速度
        mTvDef = (TextView) findViewById(R.id.tv_def);
        // 直行速度SeekBar
        mSeekBarDef = (SeekBar) findViewById(R.id.seekbar_def);
        mSeekBarDef.setOnSeekBarChangeListener(this);
        mSeekBarDef.setMax(100 * 30);
        mSeekBarDef.setProgress(10 * 200);

        // TextView显示旋转速度
        mTvSelf = (TextView) findViewById(R.id.tv_self);
        // 旋转速度SeekBar
        mSeekBarSelf = (SeekBar) findViewById(R.id.seekbar_self);
        mSeekBarSelf.setOnSeekBarChangeListener(this);
        mSeekBarSelf.setMax(100 * 10);
        mSeekBarSelf.setProgress(10 * 50);


    }

    /**
     * SeekBar滚动时的回调函数
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        switch (seekBar.getId()) {
            case R.id.seekbar_def:
                Log.d(TAG, "系统默认SeekBar: " + i);
                // 设置与系统默认SeekBar对应的TextView的值
                mTvDef.setText("直行速度:" + String.valueOf(seekBar.getProgress()));
                break;
            case R.id.seekbar_self:
                i = mSeekBarSelf.getProgress();
                Log.d(TAG, "自定义SeekBar: " + i);
                // 设置与自定义SeekBar对应的TextView的值
                mTvSelf.setText("旋转速度:" + String.valueOf(seekBar.getProgress()));
                break;
        }
    }

    /**
     * SeekBar开始滚动的回调函数
     */
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    /**
     * SeekBar停止滚动的回调函数
     */
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
