import java.util.HashSet;

public class TaskTime {
    private int date;
    private int month;
    private int year;
    private int hours;
    private int minutes;
    TaskTime(String time){
        int date = Integer.parseInt(time.substring(0,2));
        int month = Integer.parseInt(time.substring(3,5));
        int year = Integer.parseInt(time.substring(6,10));
        int hours;
        int minutes;
        if(time.length()>10){
            hours = Integer.parseInt(time.substring(11,13));
            minutes = Integer.parseInt(time.substring(14,16));
        }
        else{
            hours = 0;
            minutes = 0;
        }
        if(isValidTime(minutes,hours,date,month,year)){
            this.minutes = minutes;
            this.hours = hours;
            this.date = date;
            this.month = month;
            this.year = year;
        }
        else{
            System.out.println("Invalid Time!!\nTask not Added");
        }
    }
    public int getDate(){
        return date;
    }
    public int getMonth(){
        return month;
    }
    public int getYear(){
        return year;
    }
    public int getHours(){
        return hours;
    }
    public int getMinutes(){
        return minutes;
    }
    public String getTime(){
        return (date<10?("0"+date):date)+"/"+(month<10?("0"+month):month)+"/"+year+"-"+(hours<10?("0"+hours):hours)+":"+(minutes<10?("0"+minutes):minutes);
    }
    public boolean isValidTime(int minutes,int hours,int date,int month,int year){
        return minutes>=0&&minutes<60&&hours>=0&&hours<=23&&month<=12&&month>=1&&year>=2026&&year<=9999&&isValidDate(date,month,year);
    }
    boolean isValidDate(int date,int month,int year){
        HashSet<Integer> h = new HashSet<>();
        h.add(1);
        h.add(3);
        h.add(5);
        h.add(7);
        h.add(8);
        h.add(10);
        h.add(12);
        if(month==2){
            if(isLeapYear(year)&&(date<1||date>29)){
                return false;
            }
            return !isLeapYear(year)&&date>0&&date<=28;
        }
        else if(h.contains(month)&&(date<1||date>31)){
            return false;
        }
        else{
            return !h.contains(month)&&(date>0&&date<=30);
        }
    }
    boolean isLeapYear(int year){
        return (year%400==0||(year%4==0&&year%100!=0));
    }
}