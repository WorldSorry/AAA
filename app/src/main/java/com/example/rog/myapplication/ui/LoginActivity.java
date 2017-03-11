package com.example.rog.myapplication.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.rog.myapplication.R;
import com.example.rog.myapplication.presenter.LoginPersenter;
import com.example.rog.myapplication.ui.view.ILoginVIew;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity implements ILoginVIew {

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private static final int REQUEST_READ_CONTACTS = 0;

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };
    @BindView(R.id.login_progress)
    ProgressBar loginProgress;
    @BindView(R.id.email)
    AutoCompleteTextView email;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.email_sign_in_button)
    Button emailSignInButton;
    @BindView(R.id.register)
    TextView register;
    @BindView(R.id.email_login_form)
    LinearLayout emailLoginForm;
    @BindView(R.id.login_form)
    ScrollView loginForm;

    private LoginPersenter loginPersenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loginPersenter = new LoginPersenter(this);
    }

    @OnClick({R.id.email_sign_in_button, R.id.register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.email_sign_in_button:
                loginPersenter.login();
                break;
            case R.id.register:
                startActivity(new Intent(LoginActivity.this, Register2Activity.class));
                break;
        }
    }

    @Override
    public String phone() {
        return email.getText().toString();
    }

    @Override
    public String password() {
        return password.getText().toString();
    }

    @Override
    public void exitActivity() {
        exitActivity();
    }
}

