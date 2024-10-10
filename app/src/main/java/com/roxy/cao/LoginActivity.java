package com.roxy.cao;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    // 定义用户名和密码输入框
    private EditText nameET, userPassWd;
    // 保存(注册时)的用户名和密码
    private String userName = "Admin";  // 初始用户名为 "Admin"
    private String pw_msg = "Hello Android";   // 初始密码为 "Hello Android"
    // 保存用户输入的用户名和密码
    private String input_username, input_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);  // 绑定登录界面的布局文件

        Log.d("ActivityOut1234", "onCreate");

        // 获取用户名和密码输入框
        nameET = findViewById(R.id.username);
        userPassWd = findViewById(R.id.password);

        // 获取登录和注册按钮
        Button loginBt = findViewById(R.id.loginBt);
        Button registerBt = findViewById(R.id.registerBt);

        // 设置登录按钮点击事件
        loginBt.setOnClickListener(v -> {
            // 获取用户输入的用户名和密码
            input_username = nameET.getText().toString();
            input_pwd = userPassWd.getText().toString();

            // 检查输入的用户名和密码是否正确
            if(input_username.isEmpty() || input_pwd.isEmpty() || !input_username.equals(userName) || !input_pwd.equals(pw_msg)) {
                // 当用户名或密码为空，或不匹配保存的用户名和密码时，显示错误提示对话框
                new AlertDialog.Builder(LoginActivity.this)
                        .setTitle("登录信息有误")
                        .setMessage("请输入正确的用户名和密码")
                        .setPositiveButton("确定", (dialogInterface, i) -> {
                            // 对话框点击 "确定" 后，不执行其他操作
                        }).show();

                // 清空输入框并将焦点返回用户名输入框
                nameET.setText("");
                userPassWd.setText("");
                nameET.requestFocus(); // 获取焦点，光标出现
            } else {
                // 登录成功，显示欢迎信息
                String msg = "欢迎进入 DIY!! \n 您输入的用户名是:" + input_username + "\n 密码是： " + input_pwd;
                Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_LONG).show();
            }
        });

        // 设置注册按钮点击事件
        registerBt.setOnClickListener(v -> {
            // 点击注册按钮后，跳转到注册页面
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivityForResult(intent, 1);  // 使用 startActivityForResult 启动注册活动，并等待返回数据
        });
    }

    // 当 RegisterActivity 返回数据时，处理返回的注册信息
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 检查请求码是否为 1，即检查返回的数据是否来自注册页面
        if (requestCode == 1) {
            // 检查注册页面返回的结果是否成功
            if (resultCode == RESULT_OK) {
                // 更新保存的用户名和密码为用户注册时输入的值
                userName = data.getStringExtra("regName");
                pw_msg = data.getStringExtra("regPwd");
            }
        }
    }



    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent); // 更新 Intent
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ActivityOut1234", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ActivityOut1234", "onResume");
        super.onResume();
        Intent intent = getIntent();
        if (intent != null) {
            String regName = intent.getStringExtra("regName");
            String regPwd = intent.getStringExtra("regPwd");
            if (regName != null && regPwd != null) {
                // 使用注册信息进行登录验证
                userName = regName;
                pw_msg = regPwd;
            }
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ActivityOut1234", "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ActivityOut1234", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ActivityOut1234", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ActivityOut1234", "onDestroy");
    }
}
