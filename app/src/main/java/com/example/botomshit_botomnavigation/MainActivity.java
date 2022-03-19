package com.example.botomshit_botomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {

    private BottomSheetBehavior bottomSheetBehavior;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View bottomSheet=findViewById(R.id.booto_sheet);
        bottomSheetBehavior=BottomSheetBehavior.from(bottomSheet);
        textView=findViewById(R.id.tv_stat);

        Button buttonExpand=findViewById(R.id.btn_expnd);
        Button buttonCollaps=findViewById(R.id.btn_cpllaps);

        buttonExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });
        buttonCollaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });

        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int newState) {
                switch (newState){
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        textView.setText("Collapsed");
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        textView.setText("Draging...");
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        textView.setText("Expanded");
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        textView.setText("Hiden");
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        textView.setText("Settling...");
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View view, float v) {

            }
        });
    }
}
