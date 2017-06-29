package soot.construct.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Util do sprawdzania dostępności internetu
 */
public class ConnectivityUtil {
    private ConnectivityManager mConnectivityManager;

    public ConnectivityUtil(Context context) {
        mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    /**
     * Testuje dostępność internetu
     * @return true/false
     */
    public boolean isNetworkAvailable() {
        NetworkInfo nInfo = mConnectivityManager.getActiveNetworkInfo();
        return nInfo != null && nInfo.isConnectedOrConnecting();
    }
}