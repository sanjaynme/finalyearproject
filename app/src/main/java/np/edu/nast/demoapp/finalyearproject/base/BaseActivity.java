package np.edu.nast.demoapp.finalyearproject.base;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import np.edu.nast.demoapp.finalyearproject.R;
import np.edu.nast.demoapp.finalyearproject.customViews.NastAlertDialog;
import np.edu.nast.demoapp.finalyearproject.data.local.SharedPreferenceManager;
import np.edu.nast.demoapp.finalyearproject.helpers.ViewUtils;


/**
 * Created by Sanjay on 28/03/2017.
 */

public abstract class BaseActivity extends AppCompatActivity implements IBaseView {
    protected static String TAG = BaseActivity.class.getSimpleName();
    protected AlertDialog alertDialog;
    protected SharedPreferenceManager preferenceManager;
    private boolean hasLayout = true;
    private ProgressDialog mProgressDialog;
    private Unbinder unbinder;

    @LayoutRes
    protected abstract int getLayout();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProgressDialog = new ProgressDialog(this);
        if (hasLayout) {
            setContentView(getLayout());
            unbinder = ButterKnife.bind(this);
        }
        preferenceManager = new SharedPreferenceManager(this);
        setupToolbar();

    }

    protected void setHasLayout(boolean hasLayout) {
        this.hasLayout = hasLayout;
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    public void onDestroy() {
        if (unbinder != null) {
            unbinder.unbind();
        }
        super.onDestroy();
    }

    protected void transitionBackPressed() {
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    protected void transitionFadeOut() {
        overridePendingTransition(0, R.anim.fade_out);
    }

    protected void transitionActivityOpen() {
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    protected void noTransition() {
        overridePendingTransition(0, 0);
    }

    protected void showBaseToastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void showProgressDialog(@StringRes int message) {
        if (mProgressDialog != null) {
            hideProgressDialog();
            mProgressDialog.setIndeterminate(true);
            mProgressDialog.setCancelable(false);
            mProgressDialog.setTitle(getMessage(R.string.app_name));
            mProgressDialog.setMessage(getMessage(message));
            mProgressDialog.show();
        }
    }


    @Override
    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    protected String getMessage(@StringRes int message) {
        return getString(message);
    }

    @Override
    public void showToastMessage(int message) {
        ViewUtils.showToastMessage(this, getMessage(message));
    }

    @Override
    public void showAlertDialog(int message) {
        NastAlertDialog.showAlertDialog(this, getMessage(message));
    }


    private void showDialog(AlertDialog.Builder builder) {
        if (alertDialog != null && alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
        alertDialog = builder.create();
        alertDialog.show();
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void dismissAlertDialog() {
        if (!isDestroyed() && !isFinishing() && alertDialog != null && alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
    }
}
