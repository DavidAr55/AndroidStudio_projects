package com.example.examendiagnostico.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.examendiagnostico.R;

public class LoginFragment extends Fragment {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);

        usernameEditText = view.findViewById(R.id.textUser);
        passwordEditText = view.findViewById(R.id.textPassword);
        loginButton = view.findViewById(R.id.btnLogin);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (isValidCredentials(username, password)) {
                    MainFragment mainFragment = MainFragment.newInstance(username); // Pasamos el username como argumento
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.containerMain, mainFragment)
                            .commit();
                    Toast.makeText(getActivity(), "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Credenciales inválidas", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    private boolean isValidCredentials(String username, String password) {

        return (username.equals("David") && password.equals("1234")) ? true : false;
    }
}
