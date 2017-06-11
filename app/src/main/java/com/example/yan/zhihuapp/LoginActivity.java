package com.example.yan.zhihuapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity{
    public static LoginActivity instance = null;
    private Button loginbtn;
    private EditText userName, userPwd;
    private TextView forget, register, sercontent;
    private MyDatabaseHelper helper;
    String name, mypwd;
    int loginflag;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        instance = this;
        if (AllTag.isLogin)
        {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        loginbtn = (Button) findViewById(R.id.login_btn);
        forget = (TextView) findViewById(R.id.forgetPwd);
        register = (TextView) findViewById(R.id.newRegister);
        sercontent = (TextView) findViewById(R.id.serviceContent);

        userName = (EditText) findViewById(R.id.emailNum);
        userPwd = (EditText) findViewById(R.id.passwordNum);

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgetPwd.class);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, Register.class);
                startActivity(intent);
            }
        });

        sercontent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showServiceDialog();
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login()
    {
        ProgressDialog dialog = ProgressDialog.show(LoginActivity.this, "提示", "登陆中...");
        final String un = userName.getText().toString();
        final String up = userPwd.getText().toString();

        if (TextUtils.isEmpty(un) || TextUtils.isEmpty(up))
        {
            dialog.dismiss();
            userName.setError("账号不能为空!");
            userPwd.setError("密码不能为空!");
            return;
        }
        else if (!isEmail(un))
        {
            userName.setText("");
            userPwd.setText("");
            userName.setError("邮箱格式错误!");
        }

        helper = new MyDatabaseHelper(getApplicationContext());
        SQLiteDatabase db = helper.getWritableDatabase();

        Cursor cursor = db.query("users", null, null, null, null, null, null);
        while (cursor.moveToNext())
        {
            name =  cursor.getString(1);
            mypwd = cursor.getString(2);

            if ((un.equals(name)) && (up.equals(mypwd)))
            {
                Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                loginflag = 1;

                AllTag.isLogin = true;
                userName.setText("");
                userPwd.setText("");

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("user", un);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        }

        if (loginflag != 1)
        {
            dialog.dismiss();
            Toast.makeText(LoginActivity.this, "不存在此用户或登录信息有误,请重新输入!", Toast.LENGTH_SHORT).show();
            userPwd.setText("");
        }

        cursor.close();
        db.close();
    }

    public void showServiceDialog(){
        new AlertDialog.Builder(LoginActivity.this)
                .setTitle("服务条款")
                .setMessage("本APP根据本服务条款及对该条款的修改向用户提供服务。" +
                        "本服务条款具有合同法上的法律效力。" +
                        "如果您对协议的任何条款表示异议，您可以选择不注册，" +
                        "一旦您通过注册程序，即表示您自愿接受本协议之所有条款，并已成为潮App平台的注册用户。")
                .setPositiveButton("确定", null)
                .show();
    }

    @Override
    public void onBackPressed() {
        count ++;
        if (count == 1)
        {
            Toast.makeText(LoginActivity.this, "再按一次退出知乎!", Toast.LENGTH_SHORT).show();
        }
        if (count == 2)
        {
            this.finish();
        }
    }

    public boolean isEmail(String strEmail)
    {
        String regix =  "^[a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\\.[a-zA-Z]{1,3})+$";
        Pattern p = Pattern.compile(regix);
        Matcher m = p.matcher(strEmail);
        return  m.matches();
    }

}

