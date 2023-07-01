import java.util.*;

public class PreemptiveProritySched {
    public static void main3() {
        Scanner s = new Scanner(System.in);

        int x,n,process[], process_priority[],burst_time[],wait_time[],turnaround_time[],awt,atat,i;//awt is average waiting time and atat is average turnaround time
        System.out.print("Enter the number of process : ");
        n = s.nextInt();//n is number of process

        process = new int[n];//process is process
        process_priority = new int[n];//process_priority is process priority
        burst_time = new int[n];//burst_time is process burst time
        wait_time = new int[n];//w is wait time
        turnaround_time = new int[n];// t is turnaround time

        for(i=0;i<n;i++)
        {
            System.out.println("Enter burst time of P"+ (i+1) +" :");
            burst_time[i] = s.nextInt();
            System.out.println("Enter time prioritiy of P"+ (i+1) +" :");
            process_priority[i] = s.nextInt();
            process[i]=i+1;
        }

//sorting on the basis of priority
        for(i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(process_priority[i]>process_priority[j])
                {
                    x=process_priority[i];
                    process_priority[i]=process_priority[j];
                    process_priority[j]=x;
                    x=burst_time[i];
                    burst_time[i]=burst_time[j];
                    burst_time[j]=x;
                    x=process[i];
                    process[i]=process[j];
                    process[j]=x;
                }
            }
        }
        wait_time[0]=0;
        awt=0;
        turnaround_time[0]=burst_time[0];
        atat=turnaround_time[0];
        for(i=1;i<n;i++)
        {
            wait_time[i]=turnaround_time[i-1];
            awt+=wait_time[i];
            turnaround_time[i]=wait_time[i]+burst_time[i];
            atat+=turnaround_time[i];
        }

//Displaying the process

        System.out.println("Process     burst_time   WT TAT  Priority \n");
        for(i=0;i<n;i++)
            System.out.println("P"+process[i]+"          "+burst_time[i]+"   "+wait_time[i]+"    "+turnaround_time[i]+"    "+process_priority[i]);
        awt/=n;
        atat/=n;
        System.out.print("\n Average Wait Time : "+awt);
        System.out.print("\n Average Turn Around Time : "+atat);

    }
}
