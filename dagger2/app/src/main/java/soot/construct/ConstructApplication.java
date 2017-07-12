package soot.construct;

import android.app.Application;

import com.facebook.stetho.Stetho;

import soot.construct.di.ApplicationComponent;
import soot.construct.di.ContextScope.ApplicationModule;
import soot.construct.di.DaggerApplicationComponent;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Soot on 01/04/2017.
 */

public class ConstructApplication extends Application {
    public static final String PREFERENCES_NAME = "asi.preferences";
    public ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        // initalize Calligraphy
        CalligraphyConfig.initDefault(
                new CalligraphyConfig.Builder()
                        .setDefaultFontPath("SourceSansPro-Regular.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );



    }



}
