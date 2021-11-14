package com.comp259.ogunrinde;

public class DepartmentClass
{
    private int DepartmentNum;
    private double NetInvoice;
    private double Surcharge;
    private double TotalInvoice;




    public int getDepartmentNum() {
        return DepartmentNum;
    }

    public void setDepartmentNum(int departmentNum)
    {
        DepartmentNum = departmentNum;
    }

    public double getNetInvoice() {
        return NetInvoice;
    }

    public void setNetInvoice(double netInvoice) {
        NetInvoice = netInvoice;
    }





    public double getSurcharge() {
        return Surcharge;
    }

    public void setSurcharge() {
        if(DepartmentNum > 2500)
        {
            Surcharge = (NetInvoice * .25);

        }
        else {
            Surcharge = 0;
        }
    }

    public double getTotalInvoice() {
        return TotalInvoice;
    }

    public void setTotalInvoice() {
        TotalInvoice = NetInvoice + Surcharge;
    }
}
