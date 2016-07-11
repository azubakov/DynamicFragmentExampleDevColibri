package tomer.edu.dynamicfragmentexampledevcolibri;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

//AppCompatActivity
public class MainActivity extends FragmentActivity {

    private OneFragment oneFragment;
    private TwoFragment twoFragment;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private Switch isBackStack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();

        oneFragment = new OneFragment();
        twoFragment = new TwoFragment();

        isBackStack = (Switch) findViewById(R.id.switchBackStack);
    }

    public  void OnClickFragment(View view){
        transaction = manager.beginTransaction();


        //to do tttt
        switch (view.getId()){
            case R.id.btnAdd:
                if (manager.findFragmentByTag(OneFragment.TAG) == null)
                   transaction.add(R.id.container, oneFragment, OneFragment.TAG);
                break;
            case R.id.btnRemove:
                if (manager.findFragmentByTag(OneFragment.TAG) != null)
                   transaction.remove(oneFragment);
                if (manager.findFragmentByTag(TwoFragment.TAG) != null)
                    transaction.remove(twoFragment);
                break;

            case R.id.btnReplace:
                if (manager.findFragmentByTag(OneFragment.TAG) != null)
                    transaction.replace(R.id.container, twoFragment, TwoFragment.TAG);
                if (manager.findFragmentByTag(TwoFragment.TAG) != null)
                    transaction.replace(R.id.container, oneFragment, OneFragment.TAG);
                break;
        }
       if (isBackStack.isChecked()) {
           transaction.addToBackStack(null);
       }

        transaction.commit();

    }
}
