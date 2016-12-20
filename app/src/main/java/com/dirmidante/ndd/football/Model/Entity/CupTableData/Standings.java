
package com.dirmidante.ndd.football.Model.Entity.CupTableData;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Standings {

    @SerializedName("A")
    @Expose
    private List<A> a = null;
    @SerializedName("B")
    @Expose
    private List<A> b = null;
    @SerializedName("C")
    @Expose
    private List<A> c = null;
    @SerializedName("D")
    @Expose
    private List<A> d = null;
    @SerializedName("E")
    @Expose
    private List<A> e = null;
    @SerializedName("F")
    @Expose
    private List<A> f = null;
    @SerializedName("G")
    @Expose
    private List<A> g = null;
    @SerializedName("H")
    @Expose
    private List<A> h = null;

    public List<A> getA() {
        return a;
    }

    public void setA(List<A> a) {
        this.a = a;
    }

    public List<A> getB() {
        return b;
    }

    public void setB(List<A> b) {
        this.b = b;
    }

    public List<A> getC() {
        return c;
    }

    public void setC(List<A> c) {
        this.c = c;
    }

    public List<A> getD() {
        return d;
    }

    public void setD(List<A> d) {
        this.d = d;
    }

    public List<A> getE() {
        return e;
    }

    public void setE(List<A> e) {
        this.e = e;
    }

    public List<A> getF() {
        return f;
    }

    public void setF(List<A> f) {
        this.f = f;
    }

    public List<A> getG() {
        return g;
    }

    public void setG(List<A> g) {
        this.g = g;
    }

    public List<A> getH() {
        return h;
    }

    public void setH(List<A> h) {
        this.h = h;
    }

}
