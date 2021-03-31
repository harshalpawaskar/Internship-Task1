package com.example.task1.View.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task1.R;
import com.example.task1.View.Adapters.RecyclerAdapter;
import com.example.task1.View.MainActivity;
import com.example.task1.ViewModel.PhotoViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    public static List<String> imageUrls = new ArrayList<>();
    PhotoViewModel photoViewModel;
    public static RecyclerView recyclerView;
    public static RecyclerAdapter recyclerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        photoViewModel = new ViewModelProvider(this).get(PhotoViewModel.class);

        recyclerAdapter = new RecyclerAdapter(view.getContext());
        recyclerView = view.findViewById(R.id.recylerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(recyclerAdapter);
    }
}
