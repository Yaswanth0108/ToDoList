import java.util.*;
public class Task{
    private String name;
    private TaskTime time;
    private boolean status;
    Task(String name,String time){
        this.name = name;
        this.time = new TaskTime(time);
        this.status = false;
    }
    public void setTaskStatus(Boolean status){
        this.status = status;
    }
    public int getDate(){
        return time.getDate();
    }
    public int getMonth(){
        return time.getMonth();
    }
    public int getYear(){
        return time.getYear();
    }
    public int getHours(){
        return time.getHours();
    }
    public int getMinutes(){
        return time.getMinutes();
    }
    public String getTaskName(){
        return this.name;
    }
    public String getTaskTime(){
        return time.getTime();
    }
    public boolean getTaskStatus(){
        return this.status;
    }
}
