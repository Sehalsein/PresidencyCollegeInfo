package com.sehalsein.presidencycollegeinfo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sehalsein.presidencycollegeinfo.Activity.Solutions;
import com.sehalsein.presidencycollegeinfo.Model.ListModel;
import com.sehalsein.presidencycollegeinfo.R;
import com.sehalsein.presidencycollegeinfo.UserData;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by sehalsein on 19/06/17.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private Context context;
    private List<ListModel> listModelList = new ArrayList<>();

    public ListAdapter(Context context, List<ListModel> listModelsList) {
        this.context = context;
        this.listModelList = listModelsList;
    }

    public ListAdapter() {
    }

    @Override
    public ListAdapter.ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_card, parent, false);
        ListAdapter.ListViewHolder searchViewHolder = new ListAdapter.ListViewHolder(view);
        return searchViewHolder;
    }

    @Override
    public void onBindViewHolder(ListAdapter.ListViewHolder listViewHolder, final int position) {

        final ListModel listModel = listModelList.get(position);
        Log.d("ADAPTER",listModel.getQuetions());
        listViewHolder.questions.setText(listModel.getQuetions().toUpperCase());
        listViewHolder.images.setBackgroundResource(listModel.getImages());

        listViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("TAG", "Model - "+position);

                Intent intent =  new Intent(context, Solutions.class);
                UserData.listModel = listModel;
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listModelList.size();
    }


    public class ListViewHolder extends RecyclerView.ViewHolder {

        TextView questions;
        ImageView images;

        public ListViewHolder(View itemView) {
            super(itemView);

            questions = (TextView) itemView.findViewById(R.id.questions);
            images = (ImageView) itemView.findViewById(R.id.images);

        }
    }

}

