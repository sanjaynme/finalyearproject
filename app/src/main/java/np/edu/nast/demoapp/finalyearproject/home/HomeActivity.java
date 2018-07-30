package np.edu.nast.demoapp.finalyearproject.home;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import np.edu.nast.demoapp.finalyearproject.R;
import np.edu.nast.demoapp.finalyearproject.base.BaseActivity;
import np.edu.nast.demoapp.finalyearproject.ui.LandingActivity;


public class HomeActivity extends BaseActivity {
    Button firstFragment, secondFragment;
    BottomNavigationView bottomNavigationView;
    @BindView(R.id.home_toolbar)
    Toolbar toolbar;

    @BindView(R.id.tv_toolbar_title)
    TextView tvTitle;

    public static void start(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_home;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finishAffinity();
                transitionBackPressed();
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bottomNavigationView = findViewById(R.id.bottom_nav_bar);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_search:
                        loadFragment(new FirstFragment());
                        break;

                    case R.id.menu_saved_lists:
                        loadFragment(new SecondFragment());
                        break;

                    case R.id.menu_applications:
                        loadFragment(new FirstFragment());
                        break;

                    case R.id.menu_job_alerts:
                        loadFragment(new SecondFragment());
                        break;
                    case R.id.menu_profile:
                        loadFragment(new FirstFragment());
                        break;
                }
                return true;
            }
        });
//        firstFragment = findViewById(R.id.firstFragment);
//        secondFragment = findViewById(R.id.secondFragment);

     /*   // perform setOnClickListener event on First Button
        firstFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // load First Fragment
                loadFragment(new FirstFragment());
            }
        });
        // perform setOnClickListener event on Second Button
        secondFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // load Second Fragment
                loadFragment(new SecondFragment());
            }
        });*/


    }

    private void loadFragment(Fragment fragment) {
        // create a FragmentManager
        FragmentManager fm = getFragmentManager();
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        // replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit(); // save the changes
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
            tvTitle.setText(getResources().getText(R.string.tv_home));
        }
    }
}
