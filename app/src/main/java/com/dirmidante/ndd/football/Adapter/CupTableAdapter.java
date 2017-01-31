package com.dirmidante.ndd.football.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dirmidante.ndd.football.Model.Entity.CupTableData.CupTableData;
import com.dirmidante.ndd.football.R;


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



        GroupAdapter groupAdapter = null;


        switch (position){
            case 0: groupTitle.setText(Group.GROUP_A.getName());
                groupAdapter = new GroupAdapter(cupTableData.getStandings().getA());
                break;
            case 1: groupTitle.setText("Group B");
                groupAdapter = new GroupAdapter(cupTableData.getStandings().getB());
                break;
            case 2: groupTitle.setText("Group C");
                groupAdapter = new GroupAdapter(cupTableData.getStandings().getC());
                break;
            case 3: groupTitle.setText("Group D");
                groupAdapter = new GroupAdapter(cupTableData.getStandings().getD());
                break;
            case 4: groupTitle.setText("Group E");
                groupAdapter = new GroupAdapter(cupTableData.getStandings().getE());
                break;
            case 5: groupTitle.setText("Group F");
                groupAdapter = new GroupAdapter(cupTableData.getStandings().getF());
                break;
            case 6: groupTitle.setText("Group G");
                groupAdapter = new GroupAdapter(cupTableData.getStandings().getG());
                break;
            case 7: groupTitle.setText("Group H");
                groupAdapter = new GroupAdapter(cupTableData.getStandings().getH());
                break;
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        groupList.setLayoutManager(layoutManager);
        groupList.setAdapter(groupAdapter);


    }

    private static enum Group{
        GROUP_A("Group A"),
        GROUP_B("Group B"),
        GROUP_C("Group C"),
        GROUP_D("Group D"),
        GROUP_E("Group E"),
        GROUP_F("Group F"),
        GROUP_G("Group G"),
        GROUP_H("Group H"),
        ;
        private final String mName;

        private Group(String name){
            mName = name;
        }

        public String getName() {
            return mName;
        }
    }

    @Override
    public int getItemCount() {
        int count = getCount();
        return count;
    }

    private int getCount() {
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
