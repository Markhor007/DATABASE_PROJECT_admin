package com.example.database_project_admin.fragments;


import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.database_project_admin.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;

/**
 * A simple {@link Fragment} subclass.
 */
public class add_samesman_fragment extends Fragment
{



    public add_samesman_fragment()
    {
        // Required empty public constructor
    }

    private FirebaseAuth mAuth;
    RelativeLayout rellay1,rally2,rellay2;
    TextView bottomTextView;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {

            rellay1.setVisibility(View.VISIBLE);
            rally2.setVisibility(View.VISIBLE);
            rellay2.setVisibility(View.VISIBLE);

        }
    };
    EditText usernameTf,passeordTf;

    ProgressBar progressBar;
    Handler progressBarh=new Handler();
    Runnable runnable1=new Runnable()
    {
        @Override
        public void run()
        {

            progressBar.setVisibility(View.GONE);
        }
    };

    Button login;

    EditText emailTf,passwordTf,confirmPasswordTf;
    TextView message;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_add_samesman_fragment, container, false);

        rellay1 = v.findViewById(R.id.add_salesman_rellay1);
        rally2=v.findViewById(R.id.add_salesman_bottom_rally2);
        rellay2=v.findViewById(R.id.add_salesman_rellay2);

        handler.postDelayed(runnable, 2000); //2000 is the timeout for the splash
        progressBar=v.findViewById(R.id.add_salesman_my_progress_bar);
        progressBarh.postDelayed(runnable1,100);
        login=v.findViewById(R.id.add_salesman_login_button);
        emailTf=v.findViewById(R.id.add_salesman_username_tf);
        passwordTf=v.findViewById(R.id.add_salesman_password_tf);
        confirmPasswordTf=v.findViewById(R.id.add_salesman_confirm_password_tf);
        message=v.findViewById(R.id.add_salesman_message_text_view);
        mAuth = FirebaseAuth.getInstance();
        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String email=emailTf.getText().toString();
                String password=passwordTf.getText().toString();
                String confirmPassword=confirmPasswordTf.getText().toString();
                if(password.equals(confirmPassword))
                {
                    if(password.length()>=6)
                    {
                        signupFunc(email,password);
                        progressBar.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        message.setText("passsword length must be greater than or equal than 6!!!!");
                    }
                }else
                {
                    message.setText("password donot match!!!!");
                }
            }
        });
        return v;
    }

    public void signupFunc(String email,String password)
    {

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener((Activity) getContext(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            progressBarh.postDelayed(runnable1,100);
                            Toast.makeText(getActivity(), "user created successfully",
                                    Toast.LENGTH_SHORT).show();

                        } else {
                            // If sign in fails, display a message to the user.
                            progressBarh.postDelayed(runnable1,100);

                            Toast.makeText(getActivity(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }

}
