package com.dirmidante.ndd.football.Adapter;


import static com.dirmidante.ndd.football.utils.StringUtils.getStringArray;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dirmidante.ndd.football.FootballApplication;
import com.dirmidante.ndd.football.Model.Entity.CupTableData.CupTableData;
import com.dirmidante.ndd.football.Model.Entity.CupTableData.Group;
import com.dirmidante.ndd.football.R;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by Dima on 2016-12-20.
 */

public class CupTableAdapter extends RecyclerView.Adapter<CupTableAdapter.ViewHolder> {

    private static final int GROUP_A = 0;
    private static final int GROUP_B = 1;
    private static final int GROUP_C = 2;
    private static final int GROUP_D = 3;
    private static final int GROUP_E = 4;
    private static final int GROUP_F = 5;
    private static final int GROUP_G = 6;
    private static final int GROUP_H = 7;

    private CupTableData mCupTableData = new CupTableData();

    public void setCupTableData(@NonNull CupTableData cupTableData) {
        if (cupTableData!=null)
        mCupTableData = cupTableData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView groupItem = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.group_item, parent, false);
        return new ViewHolder(groupItem);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CardView groupItem = holder.mGroupItem;
        TextView groupTitle = (TextView) groupItem.findViewById(R.id.groupTitle);
        RecyclerView groupList = (RecyclerView) groupItem.findViewById(R.id.groupList);
        List<Group> group;

        group = getGroup(position);
        groupTitle.setText(getGroupTitle(position));

        LinearLayoutManager layoutManager = new LinearLayoutManager(FootballApplication.getCurrentApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        groupList.setLayoutManager(layoutManager);
        if (group!=null){
            GroupAdapter groupAdapter = new GroupAdapter();
            groupAdapter.setTeams(group);
            groupList.setAdapter(groupAdapter);
        }


    }

    private List<Group> getGroup(int position) {
        List<Group> group = new ArrayList<>();
        switch (position) {
            case GROUP_A:
                group = mCupTableData.getStandings().getA();
                break;
            case GROUP_B:
                group = mCupTableData.getStandings().getB();
                break;
            case GROUP_C:
                group = mCupTableData.getStandings().getC();
                break;
            case GROUP_D:
                group = mCupTableData.getStandings().getD();
                break;
            case GROUP_E:
                group = mCupTableData.getStandings().getE();
                break;
            case GROUP_F:
                group = mCupTableData.getStandings().getF();
                break;
            case GROUP_G:
                group = mCupTableData.getStandings().getG();
                break;
            case GROUP_H:
                group = mCupTableData.getStandings().getH();
                break;
        }
        return group;
    }

    @Override
    public int getItemCount() {
        return getCount(mCupTableData);
    }

    public int getCount(CupTableData cupTableData) {
        return getGroupCount(cupTableData);
    }

    private int getGroupCount(CupTableData cupTableData) {
        int count = 0;
        if (cupTableData.getStandings() != null) {
            if (cupTableData.getStandings().getA() != null && cupTableData.getStandings().getA().size() > 0)
                count++;
            if (cupTableData.getStandings().getB() != null && cupTableData.getStandings().getB().size() > 0)
                count++;
            if (cupTableData.getStandings().getC() != null && cupTableData.getStandings().getC().size() > 0)
                count++;
            if (cupTableData.getStandings().getD() != null && cupTableData.getStandings().getD().size() > 0)
                count++;
            if (cupTableData.getStandings().getE() != null && cupTableData.getStandings().getE().size() > 0)
                count++;
            if (cupTableData.getStandings().getF() != null && cupTableData.getStandings().getF().size() > 0)
                count++;
            if (cupTableData.getStandings().getG() != null && cupTableData.getStandings().getG().size() > 0)
                count++;
            if (cupTableData.getStandings().getH() != null && cupTableData.getStandings().getH().size() > 0)
                count++;
        }
        return count;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView mGroupItem;

        public ViewHolder(CardView groupItem) {
            super(groupItem);
            this.mGroupItem = groupItem;
        }
    }

    private String getGroupTitle(int i) {
        String[] groups = getStringArray(R.array.groups);
        String group = (i<groups.length)?groups[i]:"";
        return group;
    }
}
