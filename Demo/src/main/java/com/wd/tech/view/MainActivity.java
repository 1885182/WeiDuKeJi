package com.wd.tech.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wd.tech.bean.PostBean;
import com.wd.tech.mvp.MyInterface;
import com.wd.tech.presenter.MyPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MyInterface.ViewInter.LoginInter {

    MyInterface.PresenterInter presenterInter;
    @BindView(R.id.login_phone_id)
    EditText phoneId;
    @BindView(R.id.login_pwd_id)
    EditText pwdId;
    @BindView(R.id.intent_login)
    Button intentLogin;
    @BindView(R.id.intent_register)
    Button intentRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenterInter = new MyPresenter<>(this);
    }

    @OnClick({R.id.intent_login, R.id.intent_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.intent_login:
                String phone = phoneId.getText().toString();
                String pwd = pwdId.getText().toString();
                presenterInter.toLogin(phone,pwd);
                break;
            case R.id.intent_register:
                String hone = phoneId.getText().toString();
                String wd = pwdId.getText().toString();
                presenterInter.toRegister(hone,wd);
                break;
        }
    }

    @Override
    public void showLogin(Object object) {

    }

    @Override
    public void showRegister(Object object) {
        PostBean bean = (PostBean) object;
        Toast.makeText(this,bean.getMessage(),Toast.LENGTH_SHORT).show();
    }
}
