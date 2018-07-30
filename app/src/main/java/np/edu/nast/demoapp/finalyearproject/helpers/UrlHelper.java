package np.edu.nast.demoapp.finalyearproject.helpers;

/**
 * Created by sanjay on 7/17/2015.
 */
public class UrlHelper {

    public static String BASE_URL = "http://ci.draftserver.com/choiceapp/public/api/";
    public static String appFolder = "/sdcard/Mvp/";

    public final static String password_forgot = "password/forgot";
    public final static String change_password = "account/password";

    public static final String LOGIN = "auth/login";
    public static final String LOGOUT = "auth/logout";
    public static final String REGISTER = "auth/register";
    public static final String FACEBOOK_LOGIN = "auth/postLoginWithFacebook";
    public static final String UPDATE_PROFILE = "auth/updateProfile";
    public static final String FORGOT_PASSWORD = "password/forgot";
    public static final String CHANGE_PASSWORD = "auth/postChangePassword";
    public static final String GET_SURVEY = "survey/getSurveyList";
    public static final String GET_SURVEY_RROFILE = "survey/getSurveyProfile";
    public static final String GET_SURVEY_PAGES = "survey/getSurveyPage";
    public static final String SYNC_SERVER = "survey/sync_survey";
    public static final String GET_AUTHENTICATED_USER = "auth/getAuthenticatedUser";



    public static class ResponseCodes {
        public static final String OTHER_FAILURES = "0000";
        public static final String SUCCESS = "200";
        public static final String FB_USER_NOT_FOUND = "403";
        public static final String USER_NOT_FOUND = "404";
        public static final String INVALID_EMAIL_PASSWORD = "302";
        public static final String INVALID_CREDENTIALS = "401";
        public static final String CANNOT_CREATE_TOKEN = "500";
        public static final String INVALID_USERS = "404";

    }


}

