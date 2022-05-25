package com.example.g8s21navigetor.ui.Multiplicacion;

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

public class MultiplicarFragment extends Fragment implements View.OnClickListener {

    TextView lblMultiplicacion;
    EditText num1, num2;
    Button btnMultiplicar;

    private MultiplicarViewModel mViewModel;

    public static MultiplicarFragment newInstance() {
        return new MultiplicarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_multiplicar, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MultiplicarViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel = new ViewModelProvider(this).get(MultiplicarViewModel.class);

        num1 = view.findViewById(R.id.num1M);
        num2 = view.findViewById(R.id.num2M);
        btnMultiplicar = view.findViewById(R.id.btnMultiplicar);
        lblMultiplicacion = view.findViewById(R.id.resultMultiplicacion);

        btnMultiplicar.setOnClickListener(this);

        lblMultiplicacion.setText(String.valueOf(mViewModel.getResultado()));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnMultiplicar:
                int numero1 = Integer.parseInt(num1.getText().toString());
                int numero2 = Integer.parseInt(num2.getText().toString());
                int resul = numero1 * numero2;
                mViewModel.setResultado(resul);
                lblMultiplicacion.setText(String.valueOf(mViewModel.getResultado()));
                break;
        }
    }

}