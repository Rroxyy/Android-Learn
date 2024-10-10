package com.roxy.cao;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    // 定义两个私有的 EditText 变量，用于输入用户名和密码
    private EditText nameET, pwdET, cfgET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 调用父类的 onCreate 方法，完成初始的 Activity 生命周期操作
        super.onCreate(savedInstanceState);
        // 设置当前 Activity 的布局为 activity_register.xml
        setContentView(R.layout.activity_register);

        // 通过 findViewById 获取布局中的用户名和密码输入框
        nameET = findViewById(R.id.reg_name);
        pwdET = findViewById(R.id.reg_pwd);
        cfgET = findViewById(R.id.cfg_pwd);

        // 获取注册按钮并设置点击事件监听器
        Button regBt = findViewById(R.id.reg_bt);
        regBt.setOnClickListener(v -> {
            // 在点击事件中获取最新的密码输入
            String password = pwdET.getText().toString();
            String passwordConfirm = cfgET.getText().toString();

            // 检查两次输入的密码是否一致
            if (!password.equals(passwordConfirm)) {
                // 如果不一致，使用 Toast 显示提示信息
                Toast.makeText(RegisterActivity.this, "两次密码不一致", Toast.LENGTH_SHORT).show();
            } else {
                // 打印密码日志信息、toast显示用户信息
                Log.d("RegisterActivity", "密码: " + password);
                Log.d("RegisterActivity", "确认密码: " + passwordConfirm);
                String msg = "您输入的用户名是:"+ nameET.getText().toString() + "\n 密码是： "+ password;
                Toast.makeText(RegisterActivity.this,msg,Toast.LENGTH_LONG).show();


//                // 创建一个新的 Intent，用于传递注册信息
//                Intent intent3 = new Intent(); // 该“意图”仅用于传递数据
//                // 将输入的用户名和密码通过 Intent 传递
//                intent3.putExtra("regName", nameET.getText().toString());
//                intent3.putExtra("regPwd", password);
//                // 设置返回结果为 RESULT_OK，并附带上 intent3 传递的数据
//                setResult(RESULT_OK, intent3); // 设置返回结果并传递参数
//                // 关闭当前的注册页面，返回到上一个页面
//                finish(); // 关闭当前页面
                Intent intent3 = new Intent(RegisterActivity.this, LoginActivity.class);
                intent3.putExtra("regName", nameET.getText().toString());
                intent3.putExtra("regPwd", pwdET.getText().toString());
                startActivity(intent3);

            }
        });
    }
}
