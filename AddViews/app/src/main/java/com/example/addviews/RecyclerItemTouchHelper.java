package com.example.firstapplication.Utils;


import android.graphics.Canvas;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstapplication.AdapterGeneral.GlobalAdapter;

public class RecyclerItemTouchHelper extends ItemTouchHelper.SimpleCallback {


    private RecyclerItemTouchHelperListener listener;


    public RecyclerItemTouchHelper(int dragDirs, int swipeDirs,
                                   RecyclerItemTouchHelperListener listener) {
        super(dragDirs, swipeDirs);
        this.listener = listener;
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView,
                          @NonNull RecyclerView.ViewHolder viewHolder,
                          @NonNull RecyclerView.ViewHolder viewHolder1) {
        return true;
    }

    @Override
    public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {

        if (viewHolder != null)
        {
            if (viewHolder instanceof GlobalAdapter.Product){
                View foregrountView = ((GlobalAdapter.Product) viewHolder).idlinear;
                getDefaultUIUtil().onSelected(foregrountView);
            }



        }
    }

    @Override
    public void onChildDrawOver(@NonNull Canvas c, @NonNull RecyclerView recyclerView,
                                RecyclerView.ViewHolder viewHolder, float dX, float dY,
                                int actionState, boolean isCurrentlyActive) {
if (viewHolder instanceof GlobalAdapter.Product){
    View foregrountView = ((GlobalAdapter.Product)viewHolder).idlinear;

    getDefaultUIUtil().onDrawOver(c,recyclerView, foregrountView , dX, dY,
            actionState,isCurrentlyActive);
}


    }

    @Override
    public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof GlobalAdapter.Product){
            View foregrountView = ((GlobalAdapter.Product)viewHolder).idlinear;
            getDefaultUIUtil().clearView(foregrountView);
        }

    }


    @Override
    public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView,
                            @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
if (viewHolder instanceof GlobalAdapter.Product){
    View foregrountView = ((GlobalAdapter.Product)viewHolder).idlinear;

    getDefaultUIUtil().onDraw(c,recyclerView, foregrountView ,dX,dY,
            actionState,isCurrentlyActive);
}


    }


    @Override
    public int convertToAbsoluteDirection(int flags, int layoutDirection) {


        return super.convertToAbsoluteDirection(flags, layoutDirection);
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        listener.onSwipe(viewHolder,direction, viewHolder.getAdapterPosition());
    }














    public interface RecyclerItemTouchHelperListener
    {
        void onSwipe(RecyclerView.ViewHolder viewHolder,int direction,int position);
    }
}
