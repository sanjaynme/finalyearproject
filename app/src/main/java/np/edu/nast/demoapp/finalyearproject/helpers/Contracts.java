package np.edu.nast.demoapp.finalyearproject.helpers;

/**
 * Created by sanjay on 12/26/2014.
 */
public final class Contracts {
    public static boolean FROMLOGIN = false;
    public static boolean FROMMENU = true;
    public static int SOCKET_TIME_OUT = 8000;
    public final static int PROCESS_LOGIN = 1;
    public final static int REQUEST_LOGIN = 1;

    public static class SharedPrefKeys {
        public static final String FACEBOOK_TOKEN = "facebook_token";
        public static final String FACEBOOK_ID = "facebook_id";
        public static final String IS_LOGGED_IN = "isLoggedIn";

        //Profile
        public static final String IS_PROFILE_COMPLETE = "is_profile_complete";
        public static final String PROFILE_FIRST_NAME = "profile_first_name";
        public static final String PROFILE_LAST_NAME = "profile_last_name";
        public static final String PROFILE_EMAIL = "profile_email";
        public static final String PROFILE_AGE = "profile_age";
        public static final String PROFILE_GENDER = "profile_gender";
        public static final String PROFILE_INCOME = "profile_income";
        public static final String PROFILE_OCCUPATION = "profile_occupation";
        public static final String PROFILE_POSTCODE = "profile_postcode";


        public static String AUTHENTICATION_KEY = "authentication_key";
        public static String EMAIL = "email";
    }

    public static class Messages {
        public static final String NO_INTERNET_CONNECTION = "No Internet Connection";
    }

    public static class HttpStatusCodes {
        public static final String STATUS_OK = "200";
        public static final String USER_NOT_FOUND = "404";
        public static final String FB_USER_NOT_FOUND = "403";
        public static final String INVALIDCREDENTAILS = "401";
        public static final String SERVER_ERROR = "500";
    }

    public static class Errors {
        public static final String ERROR = "Unable to process request, please try again.";
        public static final String NO_INTERNET_AVAILABLE = "No internet available.";
        public static final String INTERNET_REQUEST_TIMEOUT = "Request Timeout Error.";
    }

    public static class ProfileLoginStatus {
        public static final int FIRSTLOGIN = 1;
        public static final int PROFILECOMPLETE = 1;
    }

    public static class AttitudeType {
        public static final int SCALETYPE = 1;
        public static final int MULTIPLECHOICETYPE = 2;
        public static final int SINGLECHOICETYPE = 3;
        public static final int OPENTEXTTYPE = 4;
    }

    public static class ACTIVITYDATA {
        public static final String SURVEYID = "survey_id";
        public static final String SURVEYNAME = "survey_name";
        public static final String SURVEY_TOTAL_PAGES = "survey_total_pages";
        public static final String SURVEY_PAGES_LEFT = "survey_pages_left";
    }

    public static class Extras {
        public static final String EXTRA_DATA = "extra_data";
    }

    public static class SurveyTypes {
        public static final int DCE_SURVEY_TYPE = 1;
        public static final int BWS_SURVEY_TYPE = 2;
    }
}
