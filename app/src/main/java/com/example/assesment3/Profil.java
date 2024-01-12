package com.example.assesment3;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.ncorti.slidetoact.SlideToActView;

public class Profil extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profil, container, false);

        Button buttonShowBottomSheet = view.findViewById(R.id.buttonShow);
        buttonShowBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheet();
            }
        });

        SlideToActView slideToActView = view.findViewById(R.id.slideToActView);
        slideToActView.setOnSlideCompleteListener(new SlideToActView.OnSlideCompleteListener() {
            @Override
            public void onSlideComplete(SlideToActView slideToActView) {
                exitApplication();
            }
        });

        return view;
    }

    private void showBottomSheet() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                getActivity(), R.style.BottomSheetDialogTheme
        );
        View bottomSheetView = LayoutInflater.from(getActivity())
                .inflate(
                        R.layout.layout_bottom_sheet,
                        (LinearLayout) getActivity().findViewById(R.id.bottomSheetContainer)
                );

        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void exitApplication() {
        // Pindah ke Activity login
        Intent intent = new Intent(getActivity(), MainActivity3.class);
        startActivity(intent);

        // Menutup fragment atau aktivitas saat ini jika perlu
        getActivity().finish();
    }
}
