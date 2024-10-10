package com.roxy.cao;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    // 定义私有的变量，用于输入用户名、密码、学历选择和爱好复选框
    private EditText nameET, pwdET, cfgET;
    private Spinner eduSpinner;
    private CheckBox singingCB, dancingCB, rapCB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 调用父类的 onCreate 方法，完成初始的 Activity 生命周期操作
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // 获取布局中的用户名和密码输入框
        nameET = findViewById(R.id.reg_name);
        pwdET = findViewById(R.id.reg_pwd);
        cfgET = findViewById(R.id.cfg_pwd);

        // 获取下拉框 (学历)
        eduSpinner = findViewById(R.id.edu_spinner);

        // 获取复选框 (爱好)
        singingCB = findViewById(R.id.checkBox2);
        dancingCB = findViewById(R.id.checkBox3);
        rapCB = findViewById(R.id.checkBox4);

        // 获取注册按钮并设置点击事件监听器
        Button regBt = findViewById(R.id.reg_bt);
        regBt.setOnClickListener(v -> {
            // 获取用户输入的密码和确认密码
            String password = pwdET.getText().toString();
            String passwordConfirm = cfgET.getText().toString();

            // 检查两次输入的密码是否一致
            if (!password.equals(passwordConfirm)) {
                // 密码不一致，显示提示信息
                Toast.makeText(RegisterActivity.this, "两次密码不一致", Toast.LENGTH_SHORT).show();
            } else {
                // 获取学历选择
                String education = eduSpinner.getSelectedItem().toString();

                // 获取复选框状态
                String hobbies = "";
                if (singingCB.isChecked()) hobbies += "唱歌 ";
                if (dancingCB.isChecked()) hobbies += "跳舞 ";
                if (rapCB.isChecked()) hobbies += "Rap ";

                // 如果没有选择任何爱好，提示未选择
                if (hobbies.isEmpty()) hobbies = "未选择";

                // 拼接提示信息
                String msg = "用户名: " + nameET.getText().toString() +
                        "\n密码: " + password +
                        "\n学历: " + education +
                        "\n爱好: " + hobbies;
                Log.d("RegisterInfo", msg);
                // 显示信息
                Toast.makeText(RegisterActivity.this, msg, Toast.LENGTH_LONG).show();

                // 跳转到登录页面
                Intent intent3 = new Intent(RegisterActivity.this, LoginActivity.class);
                intent3.putExtra("regName", nameET.getText().toString());
                intent3.putExtra("regPwd", pwdET.getText().toString());
                startActivity(intent3);
            }
        });
    }
}
