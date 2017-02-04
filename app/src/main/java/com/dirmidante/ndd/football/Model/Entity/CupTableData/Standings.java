
package com.dirmidante.ndd.football.Model.Entity.CupTableData;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Standings extends RealmObject{

    private static final String GROUP_A = "A";
    private static final String GROUP_B = "B";
    private static final String GROUP_C = "C";
    private static final String GROUP_D = "D";
    private static final String GROUP_E = "E";
    private static final String GROUP_F = "F";
    private static final String GROUP_G = "G";
    private static final String GROUP_H = "H";


    @SerializedName(GROUP_A)
    @Expose
    private RealmList<Group> a = null;
    @SerializedName(GROUP_B)
    @Expose
    private RealmList<Group> b = null;
    @SerializedName(GROUP_C)
    @Expose
    private RealmList<Group> c = null;
    @SerializedName(GROUP_D)
    @Expose
    private RealmList<Group> d = null;
    @SerializedName(GROUP_E)
    @Expose
    private RealmList<Group> e = null;
    @SerializedName(GROUP_F)
    @Expose
    private RealmList<Group> f = null;
    @SerializedName(GROUP_G)
    @Expose
    private RealmList<Group> g = null;
    @SerializedName(GROUP_H)
    @Expose
    private RealmList<Group> h = null;

    public RealmList<Group> getA() {
        return a;
    }

    public void setA(RealmList<Group> a) {
        this.a = a;
    }

    public RealmList<Group> getB() {
        return b;
    }

    public void setB(RealmList<Group> b) {
        this.b = b;
    }

    public RealmList<Group> getC() {
        return c;
    }

    public void setC(RealmList<Group> c) {
        this.c = c;
    }

    public RealmList<Group> getD() {
        return d;
    }

    public void setD(RealmList<Group> d) {
        this.d = d;
    }

    public RealmList<Group> getE() {
        return e;
    }

    public void setE(RealmList<Group> e) {
        this.e = e;
    }

    public RealmList<Group> getF() {
        return f;
    }

    public void setF(RealmList<Group> f) {
        this.f = f;
    }

    public RealmList<Group> getG() {
        return g;
    }

    public void setG(RealmList<Group> g) {
        this.g = g;
    }

    public RealmList<Group> getH() {
        return h;
    }

    public void setH(RealmList<Group> h) {
        this.h = h;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Standings)) return false;

        Standings standings = (Standings) o;

        if (a != null ? !a.equals(standings.a) : standings.a != null) return false;
        if (b != null ? !b.equals(standings.b) : standings.b != null) return false;
        if (c != null ? !c.equals(standings.c) : standings.c != null) return false;
        if (d != null ? !d.equals(standings.d) : standings.d != null) return false;
        if (e != null ? !e.equals(standings.e) : standings.e != null) return false;
        if (f != null ? !f.equals(standings.f) : standings.f != null) return false;
        if (g != null ? !g.equals(standings.g) : standings.g != null) return false;
        return h != null ? h.equals(standings.h) : standings.h == null;

    }

    @Override
    public int hashCode() {
        int result = a != null ? a.hashCode() : 0;
        result = 31 * result + (b != null ? b.hashCode() : 0);
        result = 31 * result + (c != null ? c.hashCode() : 0);
        result = 31 * result + (d != null ? d.hashCode() : 0);
        result = 31 * result + (e != null ? e.hashCode() : 0);
        result = 31 * result + (f != null ? f.hashCode() : 0);
        result = 31 * result + (g != null ? g.hashCode() : 0);
        result = 31 * result + (h != null ? h.hashCode() : 0);
        return result;
    }
}
