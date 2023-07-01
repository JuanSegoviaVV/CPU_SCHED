import java.util.*;
public class RoundRobinSchedule {
    // Method to find the waiting time for all
    // processes
    static void findWaitingTime(int processes[], int n,
                                int final_bursttime[], int final_waitTime[], int quantum)
    {
        // Make a copy of burst times final_bursttime[] to store remaining
        // burst times.
        int rem_bt[] = new int[n];
        for (int i = 0 ; i < n ; i++)
            rem_bt[i] =  final_bursttime[i];

        int t = 0; // Current time

        // Keep traversing processes in round robin manner
        // until all of them are not done.
        while(true)
        {
            boolean done = true;

            // Traverse all processes one by one repeatedly
            for (int i = 0 ; i < n; i++)
            {
                // If burst time of a process is greater than 0
                // then only need to process further
                if (rem_bt[i] > 0)
                {
                    done = false; // There is a pending process

                    if (rem_bt[i] > quantum)
                    {
                        // Increase the value of t i.e. shows
                        // how much time a process has been processed
                        t += quantum;

                        // Decrease the burst_time of current process
                        // by quantum
                        rem_bt[i] -= quantum;
                    }

                    // If burst time is smaller than or equal to
                    // quantum. Last cycle for this process
                    else
                    {
                        // Increase the value of t i.e. shows
                        // how much time a process has been processed
                        t = t + rem_bt[i];

                        // Waiting time is current time minus time
                        // used by this process
                        final_waitTime[i] = t - final_bursttime[i];

                        // As the process gets fully executed
                        // make its remaining burst time = 0
                        rem_bt[i] = 0;
                    }
                }
            }

            // If all processes are done
            if (done == true)
                break;
        }
    }

    // Method to calculate turn around time
    static void findTurnAroundTime(int processes[], int n,
                                   int final_bursttime[], int final_waitTime[], int tat[])
    {
        // calculating turnaround time by adding
        // bt[i] + final_waitTime[i]
        for (int i = 0; i < n ; i++)
            tat[i] = final_bursttime[i] + final_waitTime[i];
    }

    // Method to calculate average time
    static void findavgTime(int processes[], int n, int final_bursttime[],
                            int quantum)
    {
        int final_waitTime[] = new int[n], tat[] = new int[n];
        int total_waitTime = 0, total_tat = 0;

        // Function to find waiting time of all processes
        findWaitingTime(processes, n, final_bursttime, final_waitTime, quantum);

        // Function to find turn around time for all processes
        findTurnAroundTime(processes, n, final_bursttime, final_waitTime, tat);

        // Display processes along with all details
        System.out.println("PN " + " B " + " final_waitTime " + " TAT");

        // Calculate total waiting time and total turn
        // around time
        for (int i=0; i<n; i++)
        {
            total_waitTime = total_waitTime + final_waitTime[i];
            total_tat = total_tat + tat[i];
            System.out.println(" " + (i+1) + "\t\t" + final_bursttime[i] +"\t " +
                    final_waitTime[i] +"\t\t " + tat[i]);
        }

        System.out.println("Average waiting time = " +
                (float)total_waitTime / (float)n);
        System.out.println("Average turn around time = " +
                (float)total_tat / (float)n);
    }

    // Driver Method
    public static void main1()
    {
        // process id's
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of process:");
        int n = input.nextInt();
        int processes[] = new int[n];
        int burst_time[]= new int[n];
        int quantum;
        System.out.println("Enter Process Time:");
        for (int i = 0; i < n; i++) {
            // User Input Burst Time and alloting
            // Process Id.
            System.out.print("P" + (i + 1) + ": ");
            processes[i] = input.nextInt();
        }
        // Burst time of all processes
        System.out.println("Enter Burst Time:");
        for (int i = 0; i < n; i++) {
            // User Input Burst Time and alloting
            // Process Id.
            System.out.print("P" + (i + 1) + ": ");
            burst_time[i] = input.nextInt();
        }
        // Time quantum
        System.out.println("Enter Time Quantum:");
        quantum = input.nextInt();

        findavgTime(processes, n, burst_time, quantum);
    }
}
