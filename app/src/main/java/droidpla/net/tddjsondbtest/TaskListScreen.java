package droidpla.net.tddjsondbtest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.DynamicLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class TaskListScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.noinclude_layout);
        //setContentView(R.layout.my_layout);
        setContentView(R.layout.activity_task_list_screen);

        /*
        ViewGroup inclusionViewGroup = (ViewGroup)findViewById(R.id.inclusionlayout);

        View child1 = LayoutInflater.from(this).inflate(
                R.layout.child_layout1, null);
        View child2 = LayoutInflater.from(this).inflate(
                R.layout.child_layout2, null);
        inclusionViewGroup.addView(child1);
        inclusionViewGroup.addView(child2);

        View v = findViewById(R.id.mbutton);
        System.out.println(v == null);
        System.out.println(v.getClass().getName());
        */



        createLayoutDynamically(4);
    }

    private void createLayoutDynamically(int n) {

        for (int i = 0; i < n; i++) {
            Button myButton = new Button(this);
            myButton.setText("Button :"+i);
            myButton.setId(i);
            final int id_ = myButton.getId();

            LinearLayout layout = (LinearLayout) findViewById(R.id.myLayoutId);
            layout.addView(myButton);

            myButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),
                            "Button clicked index = " + id_, Toast.LENGTH_SHORT)
                            .show();
                }
            });
        }}

}
