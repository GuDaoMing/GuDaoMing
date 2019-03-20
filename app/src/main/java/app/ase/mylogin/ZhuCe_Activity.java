package app.ase.mylogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ZhuCe_Activity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 请输入用户名
     */
    private EditText mEtUserName;
    /**
     * 请输入密码
     */
    private EditText mEtPsw;
    /**
     * 请再次输入密码
     */
    private EditText mEtPswAgain;
    /**
     * 注 册
     */
    private Button mBtnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu_ce_);
        initView();

    }

    private void initView() {
        mEtUserName = (EditText) findViewById(R.id.et_user_name);
        mEtPsw = (EditText) findViewById(R.id.et_psw);
        mEtPswAgain = (EditText) findViewById(R.id.et_psw_again);
        mBtnRegister = (Button) findViewById(R.id.btn_register);
        mBtnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_register:
            startActivity(new Intent(ZhuCe_Activity.this,Login_Activity.class));
                break;
        }
    }
}
