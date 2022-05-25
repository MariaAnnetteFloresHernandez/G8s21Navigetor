package com.example.g8s21navigetor.ui.Resta;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.g8s21navigetor.R;

public class RestarFragment extends Fragment implements View.OnClickListener {

    private RestarViewModel mViewModel;

    TextView lblResta;
    EditText num1, num2;
    Button btnRestar;

    public static RestarFragment newInstance() {
        return new RestarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_restar, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
       super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RestarViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel = new ViewModelProvider(this).get(RestarViewModel.class);

        num1 = view.findViewById(R.id.num1R);
        num2 = view.findViewById(R.id.num2R);
        btnRestar = view.findViewById(R.id.btnRestar);
        lblResta = view.findViewById(R.id.resultResta);
        btnRestar.setOnClickListener(this);

        lblResta.setText(String.valueOf(mViewModel.getResultado()));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnRestar:
                int numero1 = Integer.parseInt(num1.getText().toString());
                int numero2 = Integer.parseInt(num2.getText().toString());
                int resul = numero1 - numero2;
                mViewModel.setResultado(resul);
                lblResta.setText(String.valueOf(mViewModel.getResultado()));
                break;
        }
    }

}