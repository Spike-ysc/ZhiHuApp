package com.example.yan.zhihuapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by XLy on 2017/6/9.
 */

public class ForgetPwd extends AppCompatActivity {

    Button findpassword, findback;
    EditText et_email_address, et_findpwd;
    private MyDatabaseHelper helper;
    String name, mykey, mypwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        et_email_address = (EditText) findViewById(R.id.forget_username);
        et_findpwd = (EditText) findViewById(R.id.et_key);
        findpassword = (Button) findViewById(R.id.find_pwd);
        findback = (Button) findViewById(R.id.find_back_login);

        findpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String address = et_email_address.getText().toString();
                String findpwd = et_findpwd.getText().toString();

                if (address.equals("") || findpwd.equals("")) {
                    et_email_address.setText("");
                    et_findpwd.setText("");
                    Toast.makeText(ForgetPwd.this, "请填写完整，不能为空!", Toast.LENGTH_SHORT).show();
                }
                else if (!isEmail(address))
                {
                    et_email_address.setText("");
                    et_findpwd.setText("");
                    et_email_address.setError("邮箱格式错误!");
                }
                else
                {
                    helper = new MyDatabaseHelper(getApplicationContext());
                    SQLiteDatabase db = helper.getWritableDatabase();

                    String sql1 = "select * from users";

                    Cursor cursor = db.rawQuery(sql1, null);
                    while (cursor.moveToNext()) {
                        name = cursor.getString(1);
                        mypwd = cursor.getString(2);
                        mykey = cursor.getString(3);

                        if ((address.equals(name)) && (findpwd.equals(mykey))) {
                            Toast.makeText(ForgetPwd.this, "您的账号:"+name+"的密码为:"+"\n"+mypwd, Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            et_email_address.setText("");
                            et_findpwd.setText("");
                            Toast.makeText(ForgetPwd.this, "用户不存在或信息填写有误!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        findback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgetPwd.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ForgetPwd.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    public boolean isEmail(String strEmail)
    {
        String regix =  "^[a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\\.[a-zA-Z]{1,3})+$";
        Pattern p = Pattern.compile(regix);
        Matcher m = p.matcher(strEmail);
        return  m.matches();
    }
}

