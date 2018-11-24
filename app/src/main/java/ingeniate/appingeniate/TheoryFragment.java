package ingeniate.appingeniate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class TheoryFragment extends Fragment implements View.OnClickListener {

    View vista;
    LinearLayout linearLayout;
    Button button;
    int option;

    @SuppressLint("ValidFragment")
    TheoryFragment(int option) {
        this.option = option;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String[] buttonName;
        if (option == 0){
            buttonName = getResources().getStringArray(R.array.pm_theory_titles);
        } else if (option == 1){
            buttonName = getResources().getStringArray(R.array.pa_theory_titles);
        } else if (option == 2){
            buttonName = getResources().getStringArray(R.array.el_theory_titles);
        } else {
            buttonName = getResources().getStringArray(R.array.cl_theory_titles);
        }

        vista = inflater.inflate(R.layout.fragment_theory,container,false);
        linearLayout = (LinearLayout) vista.findViewById(R.id.buttons);

        for (int i=0; i<buttonName.length;i++){
            button = new Button(getActivity());
            button.setId(i);
            button.setText(buttonName[i]);
            button.setBackground(getResources().getDrawable(R.drawable.button));
            button.setTextColor(getResources().getColor(R.color.common_google_signin_btn_text_dark_default));
            linearLayout.addView(button);
            button.setOnClickListener(this);
        }

        /*
        * android:layout_width="300dp"
                android:layout_height="match_parent"
                android:background="@drawable/common_google_signin_btn_icon_light_normal_background"
                android:text="Fracciones"
                android:textAlignment="center"
                android:textSize="25dp" />
                */


        return vista;
    }

    @Override
    public void onClick(View v) {
        int topic = this.option;
        int option= (int) v.getId();
        Intent intent = new Intent(getActivity(),TopicActivity.class);
        intent.putExtra("option", option);
        intent.putExtra("topic", topic);
        getActivity().startActivity(intent);
    }
}
