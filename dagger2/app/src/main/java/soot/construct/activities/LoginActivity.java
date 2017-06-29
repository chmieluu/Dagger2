package soot.construct.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import soot.construct.ConstructApplication;
import soot.construct.R;
import soot.construct.activities.MedicamentActivity.MedicamentAcitvity;
import soot.construct.activities.controller.LoginController;
import soot.construct.activities.interfaces.LoginInterface;
import soot.construct.databinding.ActivityLoginBinding;
import soot.construct.di.ContextScope.ConnectivityModule;

public class LoginActivity extends AppCompatActivity implements LoginInterface {
    @Inject
    protected LoginController mController;
    private ActivityLoginBinding mLoginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((ConstructApplication) getApplication()).mApplicationComponent
                .newContextComponent(new ConnectivityModule(this))
                .inject(this);

        mLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        mController.onCreate(this);
    }

    @Override
    public void onLoginSuccess() {
        showToast(this.getResources().getString(R.string.login_success));
    }

    @Override
    public void onLoginError() {
        showToast(this.getResources().getString(R.string.login_incorrect_message));
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void loginClick(View v) {
            if (mLoginBinding.loginInputText != null && !mLoginBinding.loginInputText.getText().toString().isEmpty()) {
                if (mLoginBinding.passwordInputText != null && !mLoginBinding.passwordInputText.getText().toString().isEmpty()) {
                    mController.login(mLoginBinding.loginInputText.getText().toString(), mLoginBinding.passwordInputText.getText().toString());
                    Intent i = new Intent(LoginActivity.this, MedicamentAcitvity.class);
                    startActivity(i);
                }
                    else {
                    showToast(this.getResources().getString(R.string.empty_password));
                    mLoginBinding.passwordInputText.setError("puste haslo");
                }
            } else {
                showToast(this.getResources().getString(R.string.empty_login));
                mLoginBinding.loginInputText.setError("pusty login");
            }

    }


    public void registerClick(View v){

            mLoginBinding.password2InputText.setVisibility(View.VISIBLE);
            mLoginBinding.password2Label.setVisibility(View.VISIBLE);
            mLoginBinding.Registerbutton.setVisibility(View.GONE);
            mLoginBinding.Registerbutton2.setVisibility(View.VISIBLE);


    }

    @Override
    //OnBackPressed pozwala obłużyć zdarzenie cofnięcia w telefonie.
    // W tym wypadku przywraca widok apki do stanu przed kliknięciem rejetruj, lub gdy już tam jest pozwala wyjść
    public void onBackPressed() {

        if (View.GONE != mLoginBinding.password2InputText.getVisibility()) {
            mLoginBinding.password2InputText.setVisibility(View.GONE);
            mLoginBinding.password2Label.setVisibility(View.GONE);
            mLoginBinding.Registerbutton.setVisibility(View.VISIBLE);
            mLoginBinding.Registerbutton2.setVisibility(View.GONE);
        }
        else{
            super.onBackPressed();
        }
    }

    public void registerAccountClick(View v){

        if (mLoginBinding.loginInputText != null && !mLoginBinding.loginInputText.getText().toString().isEmpty()) {
            if (mLoginBinding.passwordInputText != null && !mLoginBinding.passwordInputText.getText().toString().isEmpty() &&
                    !mLoginBinding.password2InputText.getText().toString().isEmpty() ) {
                if ( mLoginBinding.passwordInputText.getText().toString().equals(mLoginBinding.password2InputText.getText().toString())) {
                    mController.login(mLoginBinding.loginInputText.getText().toString(), mLoginBinding.passwordInputText.getText().toString());
                    Intent i = new Intent(LoginActivity.this, MedicamentAcitvity.class);
                    startActivity(i);
                }
                else {
                    showToast(this.getResources().getString(R.string.different_password));
                }
            }
            else if (mLoginBinding.passwordInputText.getText().toString().isEmpty()){
                showToast(this.getResources().getString(R.string.empty_password));
                mLoginBinding.passwordInputText.setError("puste haslo");
            }
            else {
                showToast(this.getResources().getString(R.string.empty_password));
                mLoginBinding.password2InputText.setError("puste haslo");
            }
        } else {
            showToast(this.getResources().getString(R.string.empty_login));
            mLoginBinding.loginInputText.setError("pusty login");
        }
    }
}
