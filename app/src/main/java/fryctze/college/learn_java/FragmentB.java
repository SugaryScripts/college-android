package fryctze.college.learn_java;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentB extends Fragment {
    private FragmentBListener fragmentBListener;
    private EditText inputText;
    private Button btnOk;

    public interface FragmentBListener {
        // must unique, to prevent multiple implement interface with the same func
        void onInputBSent(CharSequence input);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_second, container, false);

        inputText = v.findViewById(R.id.et_input_text);
        btnOk = v.findViewById(R.id.btn_ok);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence input = inputText.getText();
                fragmentBListener.onInputBSent(input);
            }
        });

        return v;
    }

    @Override
    public void onAttach(@NonNull Context context) { // called on fragment attach to activity
        super.onAttach(context);
        // Context is the activity
        // Check the activity implement the fragment listener or not
        if (context instanceof FragmentBListener) {
            fragmentBListener = (FragmentBListener) context;
        } else {
            throw new RuntimeException(context.toString() + " catch exception, must implement fragmentBListener");
        }
    }

    @Override
    public void onDetach() { // remove fragment from the activity
        super.onDetach();
        fragmentBListener = null;
    }

    public void updateEditText(CharSequence newText){
        inputText.setText(newText);
    }
}
