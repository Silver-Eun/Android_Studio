package ddazua.hs.my_pager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Page extends Fragment {

    int cnt;

    public static  Page create(int count){
        Page fragment = new Page();
        Bundle bundle = new Bundle();
        bundle.putInt("cnt", count);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cnt = getArguments().getInt("cnt");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        LinearLayout layout = (LinearLayout)inflater.inflate(R.layout.fragment_page, container, false);

        TextView text = layout.findViewById(R.id.text);
        text.setText("page : " +cnt);
        return layout;
    }
}