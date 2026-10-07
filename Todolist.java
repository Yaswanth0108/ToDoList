import java.util.*;
public class Todolist{
    static LinkedHashMap<String,Task> tasks = new LinkedHashMap<>();
    static void addTask(String name,String time){
        tasks.put(name,new Task(name,time));
    }
    static void clearAllTasks(){
        tasks.clear();
    }
    static void search(String task){
        if(tasks.containsKey(task)){
            System.out.println(tasks.get(task).getTaskName()+" "+tasks.get(task).getTaskTime()+" "+tasks.get(task).getTaskStatus());
        }
        else{
            System.out.println(task+" not Found!");
        }
    }
    static void deleteTask(String task){
        tasks.remove(task);
    }
    static String deleteTask(int idx){
        if(idx>0&&idx<=tasks.size()){
            String task="";
            for(String s : tasks.keySet()){
                if(idx==1){
                    task = s;
                    break;
                }
                idx--;
            }
            tasks.remove(task);
            return task;
        }
        return "";
    }
    static void mark(String task){
        if(tasks.containsKey(task)){
            tasks.get(task).setTaskStatus(!tasks.get(task).getTaskStatus());
            System.out.println("Marked Successfully");
        }
        else{
            System.out.println(task+" Not Found!");
        }
    }
    static void mark(int idx){
        if(idx>0&&idx<=tasks.size()){
            String task="";
            for(String s : tasks.keySet()){
                if(idx==1){
                    task = s;
                    break;
                }
                idx--;
            }
            if(tasks.containsKey(task)){
                tasks.get(task).setTaskStatus(!tasks.get(task).getTaskStatus());
                System.out.println("Marked Successfully");
            }
            else{
                System.out.println("Task Not Found!");
            }
        }
        else{
            System.out.println("Invalid Index!");
        }
    }
    static void sortByTime() {
        List<Map.Entry<String,Task>> list = new ArrayList<>(tasks.entrySet());
        list.sort(Comparator.comparingInt((Map.Entry<String,Task> e)->e.getValue().getYear())
                        .thenComparingInt(e->e.getValue().getMonth())
                        .thenComparingInt(e->e.getValue().getDate())
                        .thenComparingInt(e->e.getValue().getHours())
                        .thenComparingInt(e->e.getValue().getMinutes()));
        tasks.clear();
        for(Map.Entry<String,Task> e : list){
            tasks.put(e.getKey(),e.getValue());
        }
    }
    static void show(){
        sortByTime();
        int i=1;
        for(Task task : tasks.values()){
            System.out.println(i+" "+task.getTaskName()+" "+task.getTaskTime()+" "+task.getTaskStatus());
            i++;
        }
        if(i==1){
            System.out.println("There are no tasks");
        }
    }
    static void showCompletedTasks(){
        int i=1;
        boolean flag = false;
        for(Task task : tasks.values()){
            if(task.getTaskStatus()){
                System.out.println(i+" "+task.getTaskName()+" "+task.getTaskTime()+" "+task.getTaskStatus());
                flag = true;
            }
            i++;
        }
        if(!flag){
            System.out.println("There are no Completed tasks");
        }
    }
    static void showPendingTasks(){
        int i=1;
        boolean flag = false;
        for(Task task : tasks.values()){
            if(!task.getTaskStatus()){
                System.out.println(i+" "+task.getTaskName()+" "+task.getTaskTime()+" "+task.getTaskStatus());
                flag = true;
            }
            i++;
        }
        if(!flag){
            System.out.println("There are no pending tasks");
        }
    }
    static void taskCount(){
        System.out.println(tasks.size()+" Tasks Found");
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String task;
        String time;
        int choice;
        int c;
        System.out.println("****************************************************************");
        System.out.println("                     TODO LIST APPLICATION                   ");
        boolean flag = true;
        while(flag){
            System.out.println("****************************************************************");
            System.out.println("1.ADD TASK              2.MODIFY TASK          3.DELETE TASK  ");
            System.out.println("4.SHOW ALL TASKS        5.SHOW PENDING TASKS   6.TASK COUNT   ");
            System.out.println("7.SHOW COMPLETED TASKS  8.MARK A TASK          9.CLEAR All TASKS");
            System.out.println("10.SEARCH TASK          11.EXIT");
            System.out.println("****************************************************************");
            System.out.print("Enter Your Choice : ");
            choice = sc.nextInt();
            sc.nextLine();
            switch(choice) {
                case 1:
                    System.out.print("Enter Task Name to Add : ");
                    task = sc.nextLine();
                    if(tasks.containsKey(task)){
                        System.out.println("Task Already Exists");
                    }
                    else{
                        System.out.print("Enter Task Deadline(DD/MM/YYYY-HH:MM)(HH:MM is Optional): ");
                        time = sc.nextLine();
                        addTask(task,time);
                    }
                    break;
                case 2:
                    System.out.print("Enter Task Name to Modify : ");
                    task = sc.nextLine();
                    if(!tasks.containsKey(task)) {
                        System.out.println("Task is not in the TODO-LIST");
                    }
                    else {
                        System.out.print("Enter Task Deadline(DD/MM/YYYY-HH:MM)(HH:MM is Optional) : ");
                        time = sc.nextLine();
                        addTask(task,time);
                    }
                    break;
                case 3:
                    System.out.println("1.DELETE TASK USING NAME       2.DELETE TASK USING INDEX");
                    System.out.print("Enter Your choice : ");
                    c = sc.nextInt();
                    sc.nextLine();
                    switch(c){
                        case 1 :
                            System.out.print("Enter Task Name : ");
                            task = sc.nextLine();
                            if(!tasks.containsKey(task)){
                                System.out.println(task+" Not Found");
                            }
                            else{
                                deleteTask(task);
                                System.out.println(task+" Deleted Successfully");
                            }
                            break;
                        case 2 :
                            System.out.print("Enter Task Index : ");
                            int idx = sc.nextInt();
                            sc.nextLine();
                            task = deleteTask(idx);
                            if(task.isEmpty()){
                                System.out.println("Invalid Index!");
                            }
                            else{
                                System.out.println(task+" Deleted Successfully");
                            }
                            break;
                        default :
                            System.out.println("Invalid Request!!");
                    }
                    break;
                case 4:
                    show();
                    break;
                case 5:
                    showPendingTasks();
                    break;
                case 6:
                    taskCount();
                    break;
                case 7:
                    showCompletedTasks();
                    break;
                case 8:
                    System.out.println("1.MARK USING NAME       2.MARK USING INDEX");
                    System.out.print("Enter Your choice : ");
                    c = sc.nextInt();
                    sc.nextLine();
                    switch(c){
                        case 1 :
                            System.out.print("Enter Task Name : ");
                            task = sc.nextLine();
                            if(!tasks.containsKey(task)){
                                System.out.println("Task Not Found");
                            }
                            else{
                                mark(task);
                            }
                            break;
                        case 2 :
                            System.out.print("Enter Task Index : ");
                            int idx = sc.nextInt();
                            sc.nextLine();
                            mark(idx);
                            break;
                        default :
                            System.out.println("Invalid Request!!");
                    }
                    break;
                case 9:
                    clearAllTasks();
                    break;
                case 10:
                    System.out.print("Enter Task Name to Search : ");
                    task = sc.nextLine();
                    search(task);
                    break;
                case 11:
                    flag = false;
                    break;
                default:
                    System.out.println("Enter a Valid Option!!");
            }
        }
        System.out.println("**********************************************************");
        System.out.println("              THANKS FOR USING TODO LIST                ");
        System.out.println("**********************************************************");
    }
}
