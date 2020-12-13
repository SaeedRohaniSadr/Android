package com.saeed.best_banks;
/* Saeed */

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.RecyclerView;

public class listAdapter extends RecyclerView.Adapter<listAdapter.NumberViewHolder> {

    private static final String TAG = listAdapter.class.getSimpleName();
    final private ListItemClickListener mOnClickListener ;
    private static int viewHolderCount;
    private int mNumberItems;

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex , View itemView);
    }

    /**
     * Constructor for listAdapter that accepts a number of items to display and the specification
     * for the ListItemClickListener.
     *
     * @param numberOfItems Number of items to display in list
     */
    public listAdapter(int numberOfItems,  ListItemClickListener listener) {
        mNumberItems = numberOfItems;
        viewHolderCount = 0;
        mOnClickListener = listener;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.number_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        NumberViewHolder viewHolder = new NumberViewHolder(view);
        //This set the text to the viewHolderCount

       switch(viewHolderCount) {
           case 0:
               viewHolder.listItemNumberView.setText("Bank of America ");
               viewHolder.viewHolderIndex.setText("Credit Card ");
               viewHolder.viewHolderTv_3.setText("%12 " );
               viewHolder.viewHolderImage.setImageResource(R.drawable.bofa);

               break;
           case 1:
               viewHolder.listItemNumberView.setText("US Bank ");
               viewHolder.viewHolderIndex.setText("Credit Card ");
               viewHolder.viewHolderTv_3.setText("%11 ");
               viewHolder.viewHolderImage.setImageResource(R.drawable.us);
               break;
           case 2:
               viewHolder.listItemNumberView.setText("Chase Bank ");
               viewHolder.viewHolderIndex.setText("Credit Card ");
               viewHolder.viewHolderTv_3.setText("%13 ");
               viewHolder.viewHolderImage.setImageResource(R.drawable.chase);
               break;

           case 3:
               viewHolder.listItemNumberView.setText("Key Bank ");
               viewHolder.viewHolderIndex.setText("Credit Card ");
               viewHolder.viewHolderTv_3.setText("%9 ");
               viewHolder.viewHolderImage.setImageResource(R.drawable.key_bank);
               break;

           case 4:
               viewHolder.listItemNumberView.setText("Wells Fargo " );
               viewHolder.viewHolderIndex.setText("Credit Card " );
               viewHolder.viewHolderTv_3.setText("%11 ");
               viewHolder.viewHolderImage.setImageResource(R.drawable.wells_fargo);
               break;
           case 5:
               viewHolder.listItemNumberView.setText("BECU " );
               viewHolder.viewHolderIndex.setText("Credit Card ");
               viewHolder.viewHolderTv_3.setText("%8 ");
               viewHolder.viewHolderImage.setImageResource(R.drawable.becu_bank);
               break;

           case 6:
               viewHolder.listItemNumberView.setText("Capital One ");
               viewHolder.viewHolderIndex.setText("Credit Card " );
               viewHolder.viewHolderTv_3.setText("%14 ");
               viewHolder.viewHolderImage.setImageResource(R.drawable.capital_one);
               break;
           case 7:
               viewHolder.listItemNumberView.setText("Alaska ");
               viewHolder.viewHolderIndex.setText("Credit Card " );
               viewHolder.viewHolderTv_3.setText("%11 " );
               viewHolder.viewHolderImage.setImageResource(R.drawable.alaska);
               break;
           case 8:
               viewHolder.listItemNumberView.setText("Umpqua ");
               viewHolder.viewHolderIndex.setText("Credit Card " );
               viewHolder.viewHolderTv_3.setText("%11 " );
               viewHolder.viewHolderImage.setImageResource(R.drawable.umpquah);
               break;
           case 9:
               viewHolder.listItemNumberView.setText("Discovery " );
               viewHolder.viewHolderIndex.setText("Credit Card " );
               viewHolder.viewHolderTv_3.setText("%9 " );
               viewHolder.viewHolderImage.setImageResource(R.drawable.discovery);

       }
        viewHolderCount++;

        Log.d(TAG, "onCreateViewHolder: number of ViewHolders created: "
                + viewHolderCount);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {
        Log.d(TAG, "#" + position);
        // holder.bind(position);
        if((position%2) !=0)
            holder.itemView.setBackgroundColor(530000000);
        else
            holder.itemView.setBackgroundColor(300000777);

    }

    @Override

    public int getItemCount() {
        return  mNumberItems;
    }



    /**
     * Cache of the children views for a list item.
     */
    class NumberViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        // Will display the position in the list, ie 0 through getItemCount() - 1
        TextView listItemNumberView;
        // Will display which ViewHolder is displaying this data
        TextView viewHolderIndex;
        TextView viewHolderTv_3;
        ImageView viewHolderImage;

        /**
         * Constructor for our ViewHolder. Within this constructor, we get a reference to our
         * TextViews and set an onClickListener to listen for clicks. Those will be handled in the
         * onClick method below.
         * @param itemView The View that you inflated in
         *                 {@link listAdapter(ViewGroup, int)}
         */
        public NumberViewHolder(View itemView) {
            super(itemView);

            listItemNumberView = (TextView) itemView.findViewById(R.id.tv_item_number);
            viewHolderIndex = (TextView) itemView.findViewById(R.id.tv_view_holder_instance);
            viewHolderTv_3 = (TextView) itemView.findViewById(R.id.tv_3);
            viewHolderImage = (ImageView) itemView.findViewById(R.id.imageIcon);

            // COMPLETED (7) Call setOnClickListener on the View passed into the constructor (use 'this' as the OnClickListener)
            itemView.setOnClickListener(this);
        }
        /**
         * A method we wrote for convenience. This method will take an integer as input and
         * use that integer to display the appropriate text within a list item.
         * @param listIndex Position of the item in the list
         */
       /* void bind(int listIndex) {
            listItemNumberView.setText(String.valueOf(listIndex));
        }*/

        /**
         * Called whenever a user clicks on an item in the list.
         * @param v The View that was clicked
         */
        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition, v);
        }


    }
}
