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

public class ExamFragment extends Fragment {

    Button button;
    View vista;
    int option;

    @SuppressLint("ValidFragment")
    ExamFragment(int option)  {
        this.option = option;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_exam,container,false);;

        button = (Button)vista.findViewById(R.id.button_quiz);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),QuizActivity.class);
                intent.putExtra("option", option);
                getActivity().startActivity(intent);
            }
        });

        return vista;
    }

}
