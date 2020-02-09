package com.revolve44.fragment15.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.revolve44.fragment15.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private TextView newera;
    private TextView newera2;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        //textView=(TextView)view.findViewById(R.id.message);
        final TextView newera = view.findViewById(R.id.NewEra);
        final TextView newera2 = view.findViewById(R.id.NewEra2);

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        ViewModelProviders.of(getActivity()).get(HomeViewModel.class).getMessage().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String message) {
                newera.setText(message);

                Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();

            }
        });


        return  view;
    }
}