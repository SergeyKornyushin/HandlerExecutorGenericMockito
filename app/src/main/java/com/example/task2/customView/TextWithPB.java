package com.example.task2.customView;

import static com.example.task2.VariableStorage.NA;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.task2.R;

public class TextWithPB extends FrameLayout {
    private final TextView textView;
    private final ProgressBar progressBar;

    public TextWithPB(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_view, null);
        addView(view);
        textView = view.findViewById(R.id.tv_xml);
        progressBar = view.findViewById(R.id.pb_xml);
        progressBar.setVisibility(INVISIBLE);
    }

    public void setResult(String result) {
        textView.setText(result);
        progressBar.setVisibility(INVISIBLE);
    }

    public void setPBVisibility(Boolean visibility) {
        if (visibility) {
            progressBar.setVisibility(VISIBLE);
            textView.setText(NA);
        } else {
            progressBar.setVisibility(INVISIBLE);
        }
    }
}