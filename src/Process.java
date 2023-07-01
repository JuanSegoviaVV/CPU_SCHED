import java.util.Scanner;

public class Process {
    public static void main(String[] args) {

        // Note: ALL attributes are placed inside the functions themselves
        Scanner input = new Scanner(System.in);
        int op = 0;
        while(op != 4) {
            System.out.println("1. Round Robin");
            System.out.println("2. Shortest Job First");
            System.out.println("3. Preemtive Priority Sched");
            System.out.println("4. Exit");
            op = input.nextInt();

            switch (op)
            {
                case 1:
                    RoundRobinSchedule.main1();
                    break;
                case 2:
                    ShortestJobFirstSched.main2();
                    break;
                case 3:
                    PreemptiveProritySched.main3();
                    break;
                default:
                    break;
            }
        }


    }
}