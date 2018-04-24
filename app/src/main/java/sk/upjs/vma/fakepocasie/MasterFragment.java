package sk.upjs.vma.fakepocasie;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MasterFragment extends Fragment {

    private OnCityClickListener listener;

    public void setListener(OnCityClickListener listener) {
        this.listener = listener;
    }

    public MasterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_master, container, false);

        ListView citListView = view.findViewById(R.id.citiesListView);
        citListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // alebo toString namiesto castovania
                String city = (String) adapterView.getAdapter().getItem(i);
                listener.onCityClicked(city);
            }
        });

        return view;
    }

}
