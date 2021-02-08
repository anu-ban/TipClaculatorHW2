package com.missouristate.arrafi.tipclaculator;

public class TipCalculator extends MainActivity {
    private float tip;
    private float bill;

    public TipCalculator(float newTip, float newBill) {
        setTip (newTip);
        this.bill = newBill;
    }

    public float getTip() {
        return tip;
    }

    public void setTip(float newTip) {
        if(newTip > 0){
            tip = newTip;

        }

    }

    public float getBill() {
        return bill;
    }

    public void setBill(float newBill) {
        if(newBill > 0){
            this.bill = newBill/100;
        }
    }
    public float tipAmount(){
        return bill * tip;
    }
    public float totalAmount(){
        return bill + tipAmount();
    }
}
