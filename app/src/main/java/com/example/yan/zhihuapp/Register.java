package com.example.yan.zhihuapp;

import android.content.ContentValues;
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

import static com.example.yan.zhihuapp.R.id.login;

/**
 * Created by XLy on 2017/6/9.
 */

public class Register extends AppCompatActivity {
    private EditText mEmail, mPassword, pwd_again, mKeyWord;
    private Button btn, backbtn;
    private MyDatabaseHelper helper;
    String name;
    int userflag;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mEmail = (EditText) findViewById(R.id.et_username);
        mPassword = (EditText) findViewById(R.id.et_password);
        pwd_again = (EditText) findViewById(R.id.et_password_again);
        mKeyWord = (EditText) findViewById(R.id.et_keyword);

        btn = (Button) findViewById(R.id.register);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mEmail.getText().toString();
                String password = mPassword.getText().toString();
                String pwdagain = pwd_again.getText().toString();
                String keyWord = mKeyWord.getText().toString();

                if (username.equals("") || password.equals("") || pwdagain.equals("") || keyWord.equals(""))
                {
                    Toast.makeText(Register.this, "以上信息均需填写，不能为空!",Toast.LENGTH_SHORT).show();
                }
                else if (!(password.equals(pwdagain))){
                    mPassword.setText("");
                    pwd_again.setText("");
                    Toast.makeText(Register.this, "两次密码输入不一致，请重新输入!",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (!isEmail(username))
                {
                    mEmail.setText("");
                    mPassword.setText("");
                    pwd_again.setText("");

                    mEmail.setError("邮箱格式错误!");
                    return;
                }
                else
                {
                    helper = new MyDatabaseHelper(getApplicationContext());
                    SQLiteDatabase db = helper.getWritableDatabase();
                    Cursor cursor = db.query("users", null, null, null, null, null, null);
                    while (cursor.moveToNext())
                    {
                        name = cursor.getString(1);

                        userflag = 1;

                        Toast.makeText(Register.this, "aaaaa！", Toast.LENGTH_SHORT).show();
                        if(username.equals(name))
                        {
                            Toast.makeText(Register.this, "已存在此用户，请重新注册", Toast.LENGTH_SHORT).show();
                            mEmail.setText("");
                            mPassword.setText("");
                            pwd_again.setText("");
                            userflag = 0;
                            break;
                        }
                    }

                    ContentValues values = new ContentValues();
                    values.put("email", username);
                    values.put("password", password);
                    values.put("keyword", keyWord);
                    db.insert("users",null,values);
                    Toast.makeText(Register.this, "注册成功！", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Register.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    LoginActivity.instance.finish();
                    AllTag.isLogin = true;
                }
            }
        });

        backbtn = (Button) findViewById(R.id.back_login);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Register.this, LoginActivity.class);
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

