package bridgelabz.app.com.GridSwipe.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bridgelabz.app.com.listviewswipetest.R;

public class Fragmentlist extends Fragment  {
    AppCompatEditText fragmentlistview_EdittextView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.fragment_listviewdetails, container, false);
        fragmentlistview_EdittextView = (AppCompatEditText)view.findViewById(R.id.fragmentlistview_EdittextView);
        Bundle bundle = getArguments();
        if (bundle != null) {
            String data = (bundle.getString("text"));
            fragmentlistview_EdittextView.setText(data);
        }
        return view;
    }
}
