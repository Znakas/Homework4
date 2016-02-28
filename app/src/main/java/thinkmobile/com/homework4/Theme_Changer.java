package thinkmobile.com.homework4;

import android.app.Activity;

/**
 * Created by Andrii on 22.02.2016.
 */
public class Theme_Changer {

    private static int current_Theme;
    public static boolean blueTheme;
    public final static int THEME_LIGHT = 0;
    public final static int THEME_BLUE = 1;


    public static void changeTheme(Activity activity, int theme)
    {
        current_Theme = theme;
        activity.recreate();
    }

    public static void onActivityCreateSetTheme(Activity activity)
    {
        switch (current_Theme)
        {
            default:
            case THEME_LIGHT:
                blueTheme = false;
                activity.setTheme(R.style.Theme_1);
                break;
            case THEME_BLUE:
                blueTheme = true;
                activity.setTheme(R.style.Theme_2);
                break;
        }
    }
}

