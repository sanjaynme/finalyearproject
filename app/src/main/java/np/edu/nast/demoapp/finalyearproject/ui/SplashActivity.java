package np.edu.nast.demoapp.finalyearproject.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import np.edu.nast.demoapp.finalyearproject.R;
import np.edu.nast.demoapp.finalyearproject.base.BaseActivity;
import np.edu.nast.demoapp.finalyearproject.contracts.AppContract;
import np.edu.nast.demoapp.finalyearproject.data.local.SharedPreferenceManager;
import np.edu.nast.demoapp.finalyearproject.home.HomeActivity;

public class SplashActivity extends BaseActivity {
    SharedPreferenceManager sharedPreferenceManager;


    @Override
    protected int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferenceManager = new SharedPreferenceManager(this);
        if (sharedPreferenceManager.getBoolValues(AppContract.Preferences.IS_LOGGED_IN)) {
            finish();
            HomeActivity.start(this);
        } else {
            finish();
            LandingActivity.start(this);
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

    }
}
