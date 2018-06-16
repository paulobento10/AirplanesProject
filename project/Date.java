package edu.ufp.inf.aed2_1617.project;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date implements Comparable<Date> {

    private int sec;
    
    private int min;
    
    private int hour;
    
    private int dd;

    private int mm;

    private int yy;

    public Date(int sec, int min, int hour, int dd, int mm, int yy) {
        this.sec=sec;
        this.min=min;
        this.hour=hour;
        this.dd = dd;
        this.mm = mm;
        this.yy = yy;
    }

    //Calendario gregoriano 0...11 meses daí ter de adicionar +1 aos meses para ter 1..12 meses
    public Date() {
        Calendar calendar = new GregorianCalendar();
        this.sec=calendar.get(Calendar.SECOND);
        this.min=calendar.get(Calendar.MINUTE);
        this.hour=calendar.get(Calendar.HOUR_OF_DAY);
        this.dd = calendar.get(Calendar.DAY_OF_MONTH);
        this.mm = calendar.get(Calendar.MONTH) + 1;
        this.yy = calendar.get(Calendar.YEAR);

    }

    @Override
    public int compareTo(Date d) {
        if (this.yy == d.getYy() && this.mm == d.getMm() && this.dd == d.getDd()) {
            return 0;
        }
        return (this.beforeDate(d) ? -1 : 1);
    }

    public int diferenceyear(Date d) {
        return java.lang.Math.abs(this.getYy() - d.getYy());

    }

    public int diferencemm(Date d) {

        int dyy, dmm;

        dyy = java.lang.Math.abs(this.getYy() - d.getYy());
        dyy = dyy * 12;
        dmm = java.lang.Math.abs(this.getMm() - d.getMm());
        return dyy + dmm;

    }

    public int diferencedays(Date d) {
        int dyy, dmm, ddd;
        dyy = java.lang.Math.abs(this.getYy() - d.getYy());
        if (this.leapYear() == true) {
            dyy = dyy * 356;
        } else {
            dyy = dyy * 355;
        }
        dmm = java.lang.Math.abs(this.getMm() - d.getMm());
        dmm = dmm * 31;
        ddd = java.lang.Math.abs(this.getDd() - d.getDd());
        return dyy + dmm + ddd;

    }

    public boolean beforeDate(Date d) {

        if (this.yy < d.yy) {
            return true;
        }
        if (this.yy == d.yy) {
            if (this.mm < d.mm) {
                return true;
            }
        }
        if (this.yy == d.yy) {
            if (this.mm == d.mm) {
                if (this.dd < d.dd) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean afterDate(Date d) {
        if (this.yy == d.yy && this.mm == d.mm && this.dd == d.dd) {
            return false;
        }

        return !this.beforeDate(d);

    }

    public boolean leapYear() {

        return ((this.yy % 4 == 0) && ((this.yy % 100 != 0) || (this.yy % 400 == 0)));
    }

    public static int leapYear(int yy) {
        if ((yy % 4 == 0) && ((yy % 100 != 0) || (yy % 400 == 0))) {
            return 29;
        }
        return 28;
    }

    public static int daysMonth(int mm, int yy) {
        if (mm > 0 && mm < 12) {
            switch (mm) {
                case (4):
                case (6):
                case (9):
                case (11):
                    return 30;
                case (2):
                    return leapYear(yy);
                default:
                    return 31;
            }
        } else {
            return -1;
        }

    }

    @Override
    public String toString() {

        return this.dd + "/" + this.mm + "/" + this.yy;
    }

    /**
     * @return the dd
     */
    public int getDd() {
        return dd;
    }

    /**
     * @param dd the dd to set
     */
    public void setDd(int dd) {
        this.dd = dd;
    }

    /**
     * @return the mm
     */
    public int getMm() {
        return mm;
    }

    /**
     * @param mm the mm to set
     */
    public void setMm(int mm) {
        this.mm = mm;
    }

    /**
     * @return the yy
     */
    public int getYy() {
        return yy;
    }

    /**
     * @param yy the yy to set
     */
    public void setYy(int yy) {
        this.yy = yy;
    }

    /**
     * @return the sec
     */
    public int getSec() {
        return sec;
    }

    /**
     * @param sec the sec to set
     */
    public void setSec(int sec) {
        this.sec = sec;
    }

    /**
     * @return the min
     */
    public int getMin() {
        return min;
    }

    /**
     * @param min the min to set
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * @return the hour
     */
    public int getHour() {
        return hour;
    }

    /**
     * @param hour the hour to set
     */
    public void setHour(int hour) {
        this.hour = hour;
    }

    
    
}
