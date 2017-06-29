package soot.construct.di.ContextScope;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import soot.construct.utils.ConnectivityUtil;

/**
 * Created by Soot on 02/04/2017.
 */

@Module
public class ConnectivityModule {
    private ConnectivityUtil connectivityUtil;

    public ConnectivityModule(Context context) {
        this.connectivityUtil = new ConnectivityUtil(context);
    }

    @Provides
    @ContextScope
    public ConnectivityUtil providesConnectivityUtil() {
        return connectivityUtil;
    }
}
