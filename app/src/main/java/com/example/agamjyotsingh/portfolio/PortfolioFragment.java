package com.example.agamjyotsingh.portfolio;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.agamjyotsingh.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PortfolioFragment extends Fragment implements PortfolioCallback {

    List<PortfolioItems> mdata;
    RecyclerView rv_portfolio;
    PortfolioAdapter portfolioAdapter ;



    public PortfolioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_portfolio, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rv_portfolio = view.findViewById(R.id.rv_portfolio);
        // create a list of portfolio items
        mdata = new ArrayList<>();





        mdata.add(new PortfolioItems(R.drawable.project7));
        mdata.add(new PortfolioItems(R.drawable.project3));
        mdata.add(new PortfolioItems(R.drawable.project5));
        mdata.add(new PortfolioItems(R.drawable.project5));
        mdata.add(new PortfolioItems(R.drawable.project0));
        mdata.add(new PortfolioItems(R.drawable.project2));
        mdata.add(new PortfolioItems(R.drawable.project3));
        mdata.add(new PortfolioItems(R.drawable.project7));
        mdata.add(new PortfolioItems(R.drawable.project1));


        portfolioAdapter = new PortfolioAdapter(mdata,this);

        // setup grid recyclerview
        rv_portfolio.setLayoutManager(new GridLayoutManager(getActivity(),3));
        rv_portfolio.setAdapter(portfolioAdapter);

    }

    @Override
    public void onPortfolioItemClick(int pos) {

        //handle click listener event when portfolio item clicked

        // firstly, creating a fragment bottom sheet instance

        PortfolioFragmentDetails portfolioFragmentDetails =
                new PortfolioFragmentDetails();

        // Now, using bundle to send portfolio items to the portfolio dialog fragment
        // also, need the portfolio item data class to implement serializable interface so as to send it

        Bundle bundle = new Bundle();
        bundle.putSerializable("object",mdata.get(pos));
        portfolioFragmentDetails.setArguments(bundle);

        portfolioFragmentDetails.show(getActivity().getSupportFragmentManager(),"tagname");

    }
}
