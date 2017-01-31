
package com.dirmidante.ndd.football.Model.Entity.CupTableData;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Standings extends RealmObject{

    @Override
    public String toString() {
        return "Standings{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                ", e=" + e +
                ", f=" + f +
                ", g=" + g +
                ", h=" + h +
                '}';
    }

    @SerializedName("A")
    @Expose
    private RealmList<Group> a = null;
    @SerializedName("B")
    @Expose
    private RealmList<Group> b = null;
    @SerializedName("C")
    @Expose
    private RealmList<Group> c = null;
    @SerializedName("D")
    @Expose
    private RealmList<Group> d = null;
    @SerializedName("E")
    @Expose
    private RealmList<Group> e = null;
    @SerializedName("F")
    @Expose
    private RealmList<Group> f = null;
    @SerializedName("G")
    @Expose
    private RealmList<Group> g = null;
    @SerializedName("H")
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
}
