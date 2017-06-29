package soot.construct.di;

import javax.inject.Singleton;

import dagger.Component;
import soot.construct.ConstructApplication;
import soot.construct.di.ContextScope.ApplicationModule;
import soot.construct.di.ContextScope.ConnectivityModule;
import soot.construct.di.ContextScope.ContextComponent;

/**
 * Created by Soot on 01/04/2017.
 */
@Singleton
@Component(modules = {
        ApplicationModule.class,
        RepositoryModule.class
})
public interface ApplicationComponent {

    void inject(ConstructApplication Application);

    ContextComponent newContextComponent(ConnectivityModule connectivityModule);

}
