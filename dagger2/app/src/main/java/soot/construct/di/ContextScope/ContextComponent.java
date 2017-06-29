package soot.construct.di.ContextScope;

import dagger.Subcomponent;
import soot.construct.activities.LoginActivity;
import soot.construct.activities.SplashActivity;

/**
 * Created by Soot on 01/04/2017.
 */
@ContextScope
@Subcomponent(modules = {ConnectivityModule.class})
public interface ContextComponent {

    void inject(SplashActivity splashActivity);

    void inject(LoginActivity loginActivity);

}
