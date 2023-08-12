package com.example.examendiagnostico.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.examendiagnostico.R;

import org.w3c.dom.Text;

public class MainFragment extends Fragment {

    private TextView textFragment;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);

        textFragment = view.findViewById(R.id.textFragment);

        // Obtén los argumentos pasados
        if (getArguments() != null) {
            String username = getArguments().getString("username");
            // Ahora puedes utilizar el valor de username en este fragmento
            textFragment.setText("Bienvenido " + username);
        }

        return view;
    }

    // Método para crear una nueva instancia del fragmento MainFragment con argumentos
    public static MainFragment newInstance(String username) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString("username", username); // Aquí agregamos el dato que deseamos pasar
        fragment.setArguments(args);
        return fragment;
    }
}
