package app.ase.mylogin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Skip_Activity extends AppCompatActivity {

    private TextView mTv;
    private CountDownTimer countDownTimer;
    public static final String SP_ISFRAIST = "SP_ISFRAIST";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_skip);
        initView();
        countDownTimer = new CountDownTimer(6000, 1000){

            private boolean user_first;
            private SharedPreferences setting;

            @Override
            public void onTick(long millisUntilFinished) {
                mTv.setText(millisUntilFinished/1000+"");
            }

            @Override
            public void onFinish() {
                setting = getSharedPreferences("setting", 0);
                user_first = setting.getBoolean("FIRST",true);
                if(user_first){
                    Intent intent = new Intent(Skip_Activity.this,Gulid_Activity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Intent intent = new Intent(Skip_Activity.this,Login_Activity.class);
                    startActivity(intent);
                    finish();
                }
                setting.edit().putBoolean("FIRST", false).commit();
            }
        }.start();
    }

    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
    }
}
