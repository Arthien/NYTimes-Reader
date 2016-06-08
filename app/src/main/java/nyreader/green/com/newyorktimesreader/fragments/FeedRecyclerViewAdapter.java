package nyreader.green.com.newyorktimesreader.fragments;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nyreader.green.com.newyorktimesreader.R;
import nyreader.green.com.newyorktimesreader.fragments.FeedFragment.OnListFragmentInteractionListener;
import nyreader.green.com.newyorktimesreader.fragments.dummy.DummyContent.DummyItem;

import java.util.List;


public class FeedRecyclerViewAdapter extends RecyclerView.Adapter<FeedRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public FeedRecyclerViewAdapter(List<DummyItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_feed, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(null);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
        }
    }
}
