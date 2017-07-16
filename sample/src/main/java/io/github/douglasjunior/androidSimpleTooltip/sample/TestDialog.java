package io.github.douglasjunior.androidSimpleTooltip.sample;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltip;

import static io.github.douglasjunior.androidSimpleTooltip.OverlayView.HIGHLIGHT_SHAPE_RECTANGULAR;

public class TestDialog extends DialogFragment {


    ImageButton button;


    public TestDialog() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.test_dialog, container, false);
        button = (ImageButton) rootView.findViewById(R.id.image);
        initTutorialButton();
        return rootView;
    }


    private void initTutorialButton() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeTooltip(button, "Test");
            }
        });
    }


    private void makeTooltip(View v, String text) {
        new SimpleTooltip.Builder(getContext())
                .anchorView(v)
                .text(text)
                .gravity(Gravity.BOTTOM)
                .animated(true)
                .textColor(Color.WHITE)
                .highlightShape(HIGHLIGHT_SHAPE_RECTANGULAR)
                .modal(true)
                .transparentOverlay(true)
                .build()
                .show();
    }
}
