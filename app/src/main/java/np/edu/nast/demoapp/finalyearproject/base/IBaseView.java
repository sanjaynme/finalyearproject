package np.edu.nast.demoapp.finalyearproject.base;

import android.support.annotation.StringRes;

/**
 * Created on 13/11/2017.
 *
 * @author Sanjay Tamata
 */
public interface IBaseView {
    void showProgressDialog(@StringRes int message);

    void hideProgressDialog();

    void showToastMessage(@StringRes int message);

    void showAlertDialog(@StringRes int message);

    void showAlertDialog(String message);

    void showAlertDialogFinishActivity(@StringRes int message);

    void showAlertDialogFinishActivity(String message);

    void setupToolbar();
}
