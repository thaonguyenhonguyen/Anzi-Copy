package kimhieu.me.anzi;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import kimhieu.me.anzi.dummy.DummyContent.DummyItem;
import kimhieu.me.anzi.models.foursquare.Venue;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class FoursquareResultRecyclerViewAdapter extends RecyclerView.Adapter<FoursquareResultRecyclerViewAdapter.ViewHolder> {



    private final List<Venue> mValues;
    private final OnListFragmentInteractionListener mListener;


    public FoursquareResultRecyclerViewAdapter(List<Venue> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_foursquare_result, parent, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).getName());
        //holder.mContentView.setText(mValues.get(position).getLocation().toString());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
//                    mListener.onListFragmentInteraction(holder.mItem);
                    PlaceDetailsFragment a = new PlaceDetailsFragment();
                    FragmentManager fragmentManager = ((FragmentActivity)(v.getContext())).getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container, a);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                }
            }
        });



    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final View mView;
        public final TextView mIdView;
        //public final TextView mContentView;
        public Venue mItem;

        public ViewHolder(View view) {
            super(view);
            itemView.setOnClickListener(this);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            //mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public void onClick(View view) {
            PlaceDetailsFragment a = new PlaceDetailsFragment();
            FragmentManager fragmentManager = ((FragmentActivity)(view.getContext())).getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, a);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

//        @Override
//        public String toString() {
//            return super.toString() + " '" + mContentView.getText() + "'";
//        }
    }


}
