import java.util.*;

public class PreemptiveProritySched {
    public static void main3() {
        Scanner s = new Scanner(System.in);

        int x,n,p[],pp[],bt[],w[],t[],awt,atat,i;
        System.out.print("Enter the number of process : ");
        n = s.nextInt();

        p = new int[n];
        pp = new int[n];
        bt = new int[n];
        w = new int[n];
        t = new int[n];

        //n is number of process
        //p is process
        //pp is process priority
        //bt is process burst time
        //w is wait time
        // t is turnaround time
        //awt is average waiting time
        //atat is average turnaround time




        for(i=0;i<n;i++)
        {
            System.out.println("Enter burst time of P"+ (i+1) +" :");
            bt[i] = s.nextInt();
            System.out.println("Enter time prioritiy of P"+ (i+1) +" :");
            pp[i] = s.nextInt();
            p[i]=i+1;
        }

//sorting on the basis of priority
        for(i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(pp[i]>pp[j])
                {
                    x=pp[i];
                    pp[i]=pp[j];
                    pp[j]=x;
                    x=bt[i];
                    bt[i]=bt[j];
                    bt[j]=x;
                    x=p[i];
                    p[i]=p[j];
                    p[j]=x;
                }
            }
        }
        w[0]=0;
        awt=0;
        t[0]=bt[0];
        atat=t[0];
        for(i=1;i<n;i++)
        {
            w[i]=t[i-1];
            awt+=w[i];
            t[i]=w[i]+bt[i];
            atat+=t[i];
        }

//Displaying the process

        System.out.println("Process     BT   WT TAT  Priority \n");
        for(i=0;i<n;i++)
            System.out.println("P"+p[i]+"          "+bt[i]+"   "+w[i]+"    "+t[i]+"    "+pp[i]);
        awt/=n;
        atat/=n;
        System.out.print("\n Average Wait Time : "+awt);
        System.out.print("\n Average Turn Around Time : "+atat);

    }
}
