package org.evilbinary.tv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import org.evilbinary.tv.widget.BorderView;

public class MainActivity extends Activity implements View.OnClickListener {

    private RelativeLayout main;
    private BorderView border;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        border = new BorderView(this);
        border.setBackgroundResource(R.drawable.border_shadow);
        border.getEffect().setMargin(78);

        BorderView border2 = new BorderView(this);
        border2.setBackgroundResource(R.drawable.border_highlight);

        main = (RelativeLayout) findViewById(R.id.main);
        border.attachTo(main);
        border2.attachTo(main);

        for (int i = 0; i < main.getChildCount(); i++) {
            main.getChildAt(i).setOnClickListener(this);
        }


    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        if (v == main.getChildAt(0)) {
            intent.setClass(this, DemoRecyclerViewActivity.class);
            intent.putExtra("linerLayout", "");
            startActivity(intent);
        } else if (v == main.getChildAt(1)) {
            intent.setClass(this, DemoRecyclerViewActivity.class);
            intent.putExtra("gridLayout", "");
            startActivity(intent);
        }else if (v == main.getChildAt(2)) {
            intent.setClass(this, DemoGridViewActivity.class);
            startActivity(intent);
        }
        else if (v == main.getChildAt(3)) {
            intent.setClass(this, DemoListViewActivity.class);
            startActivity(intent);
        }

    }


}
