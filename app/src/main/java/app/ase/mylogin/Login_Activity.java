package app.ase.mylogin;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class Login_Activity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 用户名
     */
    private EditText mUser;
    /**
     * 密码
     */
    private EditText mPwd;
    /**
     * 记住密码
     */
    private CheckBox mInpwd;
    /**
     * 自动登录
     */
    private CheckBox mUnpwd;
    /**
     * 登录
     */
    private Button mLogin;
    /**
     * 注册
     */
    private Button mAddlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        initView();

    }

    private void initView() {
        mUser = (EditText) findViewById(R.id.user);
        mPwd = (EditText) findViewById(R.id.pwd);
        mInpwd = (CheckBox) findViewById(R.id.inpwd);
        mUnpwd = (CheckBox) findViewById(R.id.unpwd);
        mLogin = (Button) findViewById(R.id.login);
        mLogin.setOnClickListener(this);
        mAddlogin = (Button) findViewById(R.id.addlogin);
        mAddlogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.login:
                String musername=mLogin.getText().toString().trim();
                String mpasswd=mPwd.getText().toString().trim();
                if(TextUtils.isEmpty(musername)){
                    Toast.makeText(this,"账号不能为空且不能少于四位",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(mpasswd)){
                    Toast.makeText(this,"密码不能为空且不能少于六位",Toast.LENGTH_SHORT).show();
                    return;
                }
                RequestQueue requestQueue = Volley.newRequestQueue(this);
                JSONObject object = new JSONObject();
                try {
                    object.put("UserName",musername);
                    object.put("UserPwd",mpasswd);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "http://60.205.182.162:8080/transportservice/api/user_login?UserName=user10&UserPwd=123456",
                        object, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        startActivity(new Intent(Login_Activity.this,Login_Activity.class));
                        finish();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        startActivity(new Intent(Login_Activity.this,MainActivity.class));
                        finish();
                    }
                });
                requestQueue.add(jsonObjectRequest);
                break;
            case R.id.addlogin:
                startActivity(new Intent(Login_Activity.this,ZhuCe_Activity.class));
                finish();
                break;
        }
    }
}
