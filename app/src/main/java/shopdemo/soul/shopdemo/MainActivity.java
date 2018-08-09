package shopdemo.soul.shopdemo;

import android.app.ActivityGroup;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private static final String TAG = "DepartmentStoreActivity";
    private Bundle mBundle = new Bundle();
    private LinearLayout ll_container, ll_first, ll_second, ll_third;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // App Logo
        toolbar.setLogo(R.mipmap.ic_launcher);
        // Title
        toolbar.setTitle("Zc_Soul");
        // Sub Title
        //toolbar.setSubtitle("Sub title");

        setSupportActionBar(toolbar);

        toolbar.setOnMenuItemClickListener(onMenuItemClick);
        // Navigation Icon 要設定在 setSupoortActionBar 才有作用
        // 否則會出現 back button
        //toolbar.setNavigationIcon(R.mipmap.ic_launcher);

            ll_container = (LinearLayout) findViewById(R.id.ll_container);
            ll_first = (LinearLayout) findViewById(R.id.ll_first);
            ll_second = (LinearLayout) findViewById(R.id.ll_second);
            ll_third = (LinearLayout) findViewById(R.id.ll_third);
            ll_first.setOnClickListener(this);
            ll_second.setOnClickListener(this);
            ll_third.setOnClickListener(this);
            mBundle.putString("tag", TAG);
            changeContainerView(ll_first);
        }

        @Override
        public void onClick(View v) {
            if (v.getId()==R.id.ll_first || v.getId()==R.id.ll_second || v.getId()==R.id.ll_third) {
                changeContainerView(v);
            }
        }

        private void changeContainerView(View v) {
            ll_first.setSelected(false);
            ll_second.setSelected(false);
            ll_third.setSelected(false);
            v.setSelected(true);
            if (v == ll_first) {
              //  toActivity("first", DepartmentHomeActivity.class);
            } else if (v == ll_second) {
              //  toActivity("second", DepartmentClassActivity.class);
            } else if (v == ll_third) {
              //  toActivity("third", DepartmentCartActivity.class);
            }
        }

//        private void toActivity(String label, Class<?> cls) {
//            Intent intent = new Intent(this, cls).putExtras(mBundle) ;
//            ll_container.removeAllViews();
//            View v = getLocalActivityManager().startActivity(label, intent).getDecorView();
//            v.setLayoutParams(new ViewGroup.LayoutParams(
//                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//            ll_container.addView(v);
//        }

        private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                String msg = "";
                switch (menuItem.getItemId()) {
                    case R.id.action_edit:
                        msg += "Click edit";
                        break;
                    case R.id.action_share:
                        msg += "Click share";
                        break;
                    case R.id.action_settings:
                        msg += "Click setting";
                        break;
                }

                if(!msg.equals("")) {
                    Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
