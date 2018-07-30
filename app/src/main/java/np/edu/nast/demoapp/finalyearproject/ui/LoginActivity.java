package np.edu.nast.demoapp.finalyearproject.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import butterknife.BindView;
import np.edu.nast.demoapp.finalyearproject.R;
import np.edu.nast.demoapp.finalyearproject.base.BaseActivity;
import np.edu.nast.demoapp.finalyearproject.contracts.AppContract;
import np.edu.nast.demoapp.finalyearproject.data.ApiService;
import np.edu.nast.demoapp.finalyearproject.data.local.SharedPreferenceManager;
import np.edu.nast.demoapp.finalyearproject.helpers.ViewUtils;
import np.edu.nast.demoapp.finalyearproject.home.HomeActivity;

public class LoginActivity extends BaseActivity {
    EditText etEmail;
    String url;
    EditText etPassword;
    Button btnLogin;
    ApiService apiService;
    SharedPreferenceManager sharedPreferenceManager;
    ImageButton btnShowHidePassword;

    @BindView(R.id.login_toolbar)
    Toolbar toolbar;

    @BindView(R.id.tv_toolbar_title)
    TextView tvTitle;

    public static void start(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        btnLogin = findViewById(R.id.btn_login);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);

        sharedPreferenceManager = new SharedPreferenceManager(this);
        ViewUtils.setupUI(findViewById(R.id.activity_login), this);
        btnShowHidePassword = findViewById(R.id.btn_show_hide_login_password);
        btnShowHidePassword.setImageResource(R.drawable.ic_eye);
        btnShowHidePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etPassword.getTransformationMethod() == PasswordTransformationMethod.getInstance()) {
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    btnShowHidePassword.setImageResource(R.drawable.ic_eye_slash);
                } else if (etPassword.getTransformationMethod() == HideReturnsTransformationMethod.getInstance()) {
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    btnShowHidePassword.setImageResource(R.drawable.ic_eye);
                }
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                if (isValid(email, password)) {
                    showProgressDialog(R.string.logging_in);
                    if (email.equalsIgnoreCase("sanjay@gmail.com") && password.equalsIgnoreCase("sanjay123")) {
                        hideProgressDialog();
                        sharedPreferenceManager.setKeyValues(AppContract.Preferences.IS_LOGGED_IN, true);
                        sharedPreferenceManager.setKeyValues(AppContract.Preferences.EMAIL, email);
                        startHomeActivity();
                    } else {
                        hideProgressDialog();
                        showAlertDialog(R.string.error_occured);
                    }
                }
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                LandingActivity.start(this);
                transitionBackPressed();
                etEmail.getText().clear();
                etPassword.getText().clear();
                break;
        }
        return true;
    }

    private void startHomeActivity() {
        HomeActivity.start(LoginActivity.this);
        finishAffinity();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    private boolean isValid(String username, String password) {
        if (username.isEmpty()) {
            showAlertDialog(R.string.err_email_empty);
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(username).matches()) {
            showAlertDialog(R.string.err_email_invalid);
            return false;
        } else if (password.isEmpty()) {
            showAlertDialog(R.string.err_password);
            return false;
        } /*else if (password.length() < 8) {
            showAlertDialog(R.string.err_password_invalid);
            return false;
        } else if (password.equals(password.toLowerCase())) {
            showAlertDialog(R.string.err_password_capital);
            return false;
        } */ else {
            return true;
        }
    }


    @Override
    public void showAlertDialog(String message) {

    }

    @Override
    public void showAlertDialogFinishActivity(int message) {

    }

    @Override
    public void showAlertDialogFinishActivity(String message) {

    }


    @Override
    public void setupToolbar() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            tvTitle.setText(getResources().getText(R.string.tv_login));
        }
    }

}
