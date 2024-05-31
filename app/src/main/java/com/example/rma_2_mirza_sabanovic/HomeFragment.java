package com.example.rma_2_mirza_sabanovic;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class HomeFragment extends Fragment {

    Button messagebtn;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        messagebtn = rootView.findViewById(R.id.message_btn);

        messagebtn.setTranslationY(300f);
        messagebtn.setAlpha(0f);

        messagebtn.animate()
                .translationY(0f)
                .alpha(1f)
                .setDuration(1000)
                .setStartDelay(500)
                .start();
        messagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startButtonAnimation(v);

                Intent intent = new Intent(getContext(), ChatBot.class);
                startActivity(intent);
            }
        });


        return  rootView;

    }

    private void startButtonAnimation(View view){
        Animation animation = AnimationUtils.loadAnimation(getContext(),R.anim.button_animation);
        view.startAnimation(animation);

    }
}
