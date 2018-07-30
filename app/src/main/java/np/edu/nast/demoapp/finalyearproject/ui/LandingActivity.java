package np.edu.nast.demoapp.finalyearproject.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import butterknife.OnClick;
import np.edu.nast.demoapp.finalyearproject.R;
import np.edu.nast.demoapp.finalyearproject.base.BaseActivity;

public class LandingActivity extends BaseActivity {

    public static void start(Context context) {
        Intent intent = new Intent(context, LandingActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_landing;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

//        ApiService.getServiceClass().getAllPost().enqueue(new Callback<List<ApiObject>>() {
//            @Override
//            public void onResponse(Call<List<ApiObject>> call, Response<List<ApiObject>> response) {
//                if (response.isSuccessful()) {
//                    for (int i = 0; i < response.body().size(); i++) {
//                        int id = response.body().get(i).getId();
//                        String title = response.body().get(i).getTitle();
//                        String description = response.body().get(i).getDescription();
//                        Toast.makeText(LandingActivity.this, "my data is" + id + " " + title + " " + description, Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<ApiObject>> call, Throwable t) {
//                Log.d("", "Error msg is :::" + t.getMessage());
//            }
//        });

    }

    @OnClick(R.id.btn_landing_login)
    void loginClicked() {
        LoginActivity.start(LandingActivity.this);
        transitionActivityOpen();
    }

    @OnClick(R.id.btn_register)
    void createAccountClicked() {
//        RegisterActivity.start(LandingActivity.this);
//        transitionActivityOpen();
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
        super.onBackPressed();
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
