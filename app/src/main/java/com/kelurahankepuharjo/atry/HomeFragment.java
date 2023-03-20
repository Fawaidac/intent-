package com.kelurahankepuharjo.atry;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements RecyclerViewAdapter.ItemClickListener{
    private ArrayList<Model> list;
    RecyclerView recyclerview;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Object homeBinding;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initRecyclerView(view);
        return view;
    }
    private void initRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recycleView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);
        data();
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(list, this);
        recyclerView.setAdapter(adapter);
    }
    private void data() {
        list = new ArrayList<>();

        String[] titleModel = new String[]{
                getString(R.string.title1),
                getString(R.string.title2),
                getString(R.string.title3),
                getString(R.string.title4),
                getString(R.string.title5),
                getString(R.string.title6),
                getString(R.string.title7),
        };
        String[] subtitleModel = new String[]{
                getString(R.string.subtitle1),
                getString(R.string.subtitle2),
                getString(R.string.subtitle3),
                getString(R.string.subtitle4),
                getString(R.string.subtitle5),
                getString(R.string.subtitle4),
                getString(R.string.subtitle6),
        };
        int[] imageResource = new int[]{
                R.drawable.polije,
                R.drawable.polinema,
                R.drawable.semarang,
                R.drawable.pens,
                R.drawable.madiun,
                R.drawable.its,
                R.drawable.itb,
        };

        for (int i=0; i<titleModel.length; i++){
            Model model = new Model(titleModel[i],subtitleModel[i],imageResource[i]);
            list.add(model);
        }
    }
    @Override
    public void onItemClick(@NonNull Model model) {
        Fragment fragment = DetailFragment.newInstance(model.getTitle(),model.getSubtitle(), model.getImagetitle());
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_host_fragment_activity_homepage, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        homeBinding = null;
    }
}