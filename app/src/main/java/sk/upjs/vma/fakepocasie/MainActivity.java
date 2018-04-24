package sk.upjs.vma.fakepocasie;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
        implements OnCityClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (isTabletMode()) {
            MasterFragment masterFragment =
                    (MasterFragment) getFragmentManager().findFragmentById(R.id.masterFragment);
            masterFragment.setListener(this);
        } else {
            MasterFragment masterFragment = new MasterFragment();
            masterFragment.setListener(this);

            getFragmentManager().beginTransaction()
                    .replace(R.id.activity_main, masterFragment)
                    .commit();
        }
    }

    private boolean isTabletMode() {
        return findViewById(R.id.activity_main) == null;
    }

    private int getTemperatureForCity(String city) {
        return city.length();
    }

    @Override
    public void onCityClicked(String city) {
        if (isTabletMode()) {
            DetailFragment detailFragment =
                    (DetailFragment) getFragmentManager().findFragmentById(R.id.detailFragment);
            detailFragment.setTemperature(getTemperatureForCity(city));
        } else {
            DetailFragment detailFragment = DetailFragment.newDetailFragment(
                    getTemperatureForCity(city));

            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.activity_main, detailFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}
