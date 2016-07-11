package tomer.edu.dynamicfragmentexampledevcolibri;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

//AppCompatActivity
public class MainActivity extends FragmentActivity {

    private OneFragment oneFragment;
    private TwoFragment twoFragment;
    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();

        oneFragment = new OneFragment();
        twoFragment = new TwoFragment();
    }

    public  void OnClickFragment(View view){
        transaction = manager.beginTransaction();

        //to do
        switch (view.getId()){
            case R.id.btnAdd:
                transaction.add(R.id.container, oneFragment);
                break;
        }
        transaction.commit();

    }
}
