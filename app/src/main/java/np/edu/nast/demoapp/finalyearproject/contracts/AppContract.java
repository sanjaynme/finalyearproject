package np.edu.nast.demoapp.finalyearproject.contracts;

/**
 * Created on 13/11/2017.
 *
 * @author Sanjay Tamata
 */

public class AppContract {
    private AppContract() {
    }


    public class Preferences {
        public final static String IS_LOGGED_IN = "is_logged_in";
        public final static String FIRST_NAME = "first_name";
        public final static String LAST_NAME = "last_name";
        public final static String EMAIL = "email";

    }

    public static class Extras {
        public final static String DATA = "data";
    }


    public class Errors {
        public static final String IMAGE_ERROR = "Image not found";
    }

    public class Permission {
        public static final int CAMERA = 0;
        public static final int GALLERY = 1;
        public static final int LOCATION = 2;
        public static final int CALL_PHONE = 3;
    }

    public class RequestCode {
        public static final int CAMERA = 100;
        public static final int GALLERY = 101;
        public static final int FILES = 102;

    }


    public class ActiveStatus {
        public static final int NOT_ACTIVE = 0;
        public static final int ACTIVE = 1;
    }
}
