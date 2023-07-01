import java.util.*;

public class ShortestJobFirstSched {
    public static void main2()
    {
        Scanner input = new Scanner(System.in);
        int number_process; // number of process
        int[][] matrix = new int[100][4];// Matrix for storing Process Id, Burst
        int total = 0;// Average
        float avg_wt, avg_tat;// Time, Average Waiting Time & Turn Around Time.
        System.out.println("Enter number of process:");
        number_process = input.nextInt();
        System.out.println("Enter Burst Time:");
        for (int i = 0; i < number_process; i++) {
            // User Input Burst Time and alloting
            // Process Id.
            System.out.print("P" + (i + 1) + ": ");
            matrix[i][1] = input.nextInt();
            matrix[i][0] = i + 1;
        }
        for (int i = 0; i < number_process; i++) {
            // Sorting process according to their
            // Burst Time.
            int index = i;
            for (int j = i + 1; j < number_process; j++) {
                if (matrix[j][1] < matrix[index][1]) {
                    index = j;
                }
            }
            int temp = matrix[i][1];
            matrix[i][1] = matrix[index][1];
            matrix[index][1] = temp;
            temp = matrix[i][0];
            matrix[i][0] = matrix[index][0];
            matrix[index][0] = temp;
        }
        matrix[0][2] = 0;
        // Calculation of Waiting Times
        for (int i = 1; i < number_process; i++) {
            matrix[i][2] = 0;
            for (int j = 0; j < i; j++) {
                matrix[i][2] += matrix[j][1];
            }
            total += matrix[i][2];
        }
        avg_wt = (float)total / number_process;
        total = 0;
        // Calculation of Turn Around Time and printing the
        // data.
        System.out.println("P\tBT\tWT\tTAT");
        for (int i = 0; i < number_process; i++) {
            matrix[i][3] = matrix[i][1] + matrix[i][2];
            total += matrix[i][3];
            System.out.println("P" + matrix[i][0] + "\t" + matrix[i][1] + "\t" + matrix[i][2] + "\t" + matrix[i][3]);
        }
        avg_tat = (float)total / number_process;
        System.out.println("Average Waiting Time= "
                + avg_wt);
        System.out.println("Average Turnaround Time= "
                + avg_tat);
    }
}