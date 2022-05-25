package com.example.g8s21navigetor.ui.Division;

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

public class DividirFragment extends Fragment implements View.OnClickListener {

    TextView lblDivision;
    EditText num1, num2;
    Button btnDividir;

    private DividirViewModel mViewModel;

    public static DividirFragment newInstance() {
        return new DividirFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dividir, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DividirViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel = new ViewModelProvider(this).get(DividirViewModel.class);

        num1 = view.findViewById(R.id.num1D);
        num2 = view.findViewById(R.id.num2D);
        btnDividir = view.findViewById(R.id.btnDividir);
        lblDivision = view.findViewById(R.id.resultDividir);

        btnDividir.setOnClickListener(this);

        lblDivision.setText(String.valueOf(mViewModel.getResultado()));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnDividir:
                double numero1 = Double.parseDouble(num1.getText().toString());
                double numero2 = Double.parseDouble(num2.getText().toString());
                double resul = numero1 / numero2;
                mViewModel.setResultado(resul);
                lblDivision.setText(String.valueOf(mViewModel.getResultado()));
                break;
        }
    }


}