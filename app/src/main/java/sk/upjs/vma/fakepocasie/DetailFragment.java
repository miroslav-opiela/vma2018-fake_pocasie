package sk.upjs.vma.fakepocasie;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {


    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newDetailFragment(int temperature) {
        DetailFragment detailFragment = new DetailFragment();

        Bundle arguments = new Bundle();
        arguments.putInt("temperature", temperature);

        detailFragment.setArguments(arguments);

        return detailFragment;
    }

    @Override
    public void onStart() {
        super.onStart();

        Bundle arguments = getArguments();
        if (arguments != null) {
            int temperature = arguments.getInt("temperature");
            setTemperature(temperature);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    public void setTemperature(int temperatureForCity) {
        TextView textView = getView().findViewById(R.id.temperatureTextView);
        textView.setText(temperatureForCity + "°C");
    }
}
