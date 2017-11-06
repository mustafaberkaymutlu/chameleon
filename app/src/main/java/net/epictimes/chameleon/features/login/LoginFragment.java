package net.epictimes.chameleon.features.login;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.epictimes.chameleon.R;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class LoginFragment extends Fragment implements LoginContract.View {

    @Inject
    LoginContract.Presenter presenter;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.login_button).setOnClickListener(v -> presenter.clickLogin());
    }

    @Override
    public void openLoginPage() {
//        Intent intent = new Intent(
//                Intent.ACTION_VIEW,
//                Uri.parse(Services.BASE_URL + "/login" + "?client_id=" + Services.CONSUMER_KEY + "&redirect_uri=" + redirectUri));
//        startActivity(intent);
    }
}
