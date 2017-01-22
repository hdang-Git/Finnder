package edu.temple.finnder;


import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andtinder.model.CardModel;
import com.andtinder.model.Orientations;
import com.andtinder.view.CardContainer;
import com.andtinder.view.SimpleCardStackAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class FoodSwipe extends Fragment{
    CardContainer mCardContainer;

    public FoodSwipe() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("Test", "FoodSwipeFrag called");
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_food_swipe, container, false);
        Resources r = getResources();
        mCardContainer = (CardContainer) v.findViewById(R.id.layoutview);
        SimpleCardStackAdapter adapter = new SimpleCardStackAdapter(getContext().getApplicationContext());
        mCardContainer.setOrientation(Orientations.Orientation.Ordered);
        adapter.add(new CardModel("Title1", "Description goes here", ContextCompat.getDrawable(getActivity(),R.drawable.pizza_small)));

        adapter.add(new CardModel("Title1", "Description goes here", ContextCompat.getDrawable(getActivity(),R.drawable.fried_rice)));

        CardModel card = new CardModel("Title", "Description", ContextCompat.getDrawable(getActivity(), R.drawable.burgerfries));
        card.setOnCardDimissedListener(new CardModel.OnCardDimissedListener() {
            @Override
            public void onLike() {
                Log.d("Swipeable Card", "I liked it");
            }

            @Override
            public void onDislike() {
                Log.d("Swipeable Card", "I did not liked it");
            }

        });
        adapter.add(card);
        mCardContainer.setAdapter(adapter);
/*
        SimpleCardStackAdapter adapter = new SimpleCardStackAdapter(this);
        adapter.add(new CardModel("Title1", "Description goes here", r.getDrawable(R.drawable.picture1)));
        mCardContainer.setAdapter(adapter);*/


        return v;
    }

}
