package soot.construct.activities;

/**
 * Created by Kuba on 24.05.2017.
 */

public abstract class BaseController<T> {
    private T nView;
    public BaseController(){}

    public void onCreate(T nView){
        this.nView = nView;
    }

    public void onDestroy(){
        this.nView = null;
    }

    public T getView(){
        return nView;
    }

    public boolean isViewPresent(){
        return nView != null;
    }
}
