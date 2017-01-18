package com.dirmidante.ndd.football.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dirmidante.ndd.football.Model.Entity.CupTableData.CupTableData;
import com.dirmidante.ndd.football.Model.Entity.CupTableData.Group;
import com.dirmidante.ndd.football.R;

import io.realm.RealmList;


/**
 * Created by Dima on 2016-12-20.
 */

public class CupTableAdapter extends RecyclerView.Adapter<CupTableAdapter.ViewHolder> {

    CupTableData cupTableData;
    Context context;

    public CupTableAdapter(CupTableData cupTableData, Context context) {
        this.cupTableData = cupTableData;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView groupItem = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.group_item, parent, false);
        return new ViewHolder(groupItem);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CardView groupItem = holder.groupItem;
        TextView groupTitle = (TextView) groupItem.findViewById(R.id.groupTitle);
        RecyclerView groupList = (RecyclerView) groupItem.findViewById(R.id.groupList);



        RealmList<Group> group = new RealmList<>();


        switch (position){
            case 0: groupTitle.setText("Group Group");
                group = cupTableData.getStandings().getA();
                break;
            case 1: groupTitle.setText("Group B");
                group = cupTableData.getStandings().getB();
                break;
            case 2: groupTitle.setText("Group C");
                group = cupTableData.getStandings().getC();
                break;
            case 3: groupTitle.setText("Group D");
                group = cupTableData.getStandings().getD();
                break;
            case 4: groupTitle.setText("Group E");
                group = cupTableData.getStandings().getE();
                break;
            case 5: groupTitle.setText("Group F");
                group = cupTableData.getStandings().getF();
                break;
            case 6: groupTitle.setText("Group G");
                group = cupTableData.getStandings().getG();
                break;
            case 7: groupTitle.setText("Group H");
                group = cupTableData.getStandings().getH();
                break;
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        groupList.setLayoutManager(layoutManager);
        groupList.setAdapter(new GroupAdapter(group));


    }

    @Override
    public int getItemCount() {
        return getCount(cupTableData);
    }

    public int getCount(CupTableData cupTableData) {
        int count = 0;
        if (cupTableData.getStandings()!=null)
        if (cupTableData.getStandings().getA()!=null) count++;
        if (cupTableData.getStandings().getB()!=null) count++;
        if (cupTableData.getStandings().getC()!=null) count++;
        if (cupTableData.getStandings().getD()!=null) count++;
        if (cupTableData.getStandings().getE()!=null) count++;
        if (cupTableData.getStandings().getF()!=null) count++;
        if (cupTableData.getStandings().getG()!=null) count++;
        if (cupTableData.getStandings().getH()!=null) count++;
        return count;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView groupItem;

        public ViewHolder(CardView groupItem) {
            super(groupItem);
            this.groupItem = groupItem;
        }
    }
}
