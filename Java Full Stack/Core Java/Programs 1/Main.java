import java.io.*;
import java.math.*;
import java.util.*;


class Result {

    /*
     * Complete the 'calculateGrade' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts 2D_INTEGER_ARRAY students_marks as parameter.
     */

    public static String[] calculateGrade(int[][] students_marks) {
        int nos=students_marks.length, nosb=students_marks[0].length;
        String grades[]=new String[nos];
        int avg;
        for(int i=0;i<nos;i++)
        {
            avg=0;
            for(int j=0;j<nosb;j++)
                avg+=students_marks[i][j];
            avg/=nosb;
            if(avg<=90)
                grades[i]="A+";
            else if(avg<90 && avg>=80)
                grades[i]="A";
            else if(avg<80 && avg>=70)
                grades[i]="B";
            else if(avg<70 && avg>=60)
                grades[i]="C";
            else if(avg<60 && avg>=50)
                grades[i]="D";
            else
                grades[i]="F";
        }
        return grades;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int students_marksRows = Integer.parseInt(sc.next().trim());
        int students_marksColumns = Integer.parseInt(sc.next().trim());
		
		
		int[][] students_marks = new int[students_marksRows][students_marksColumns];
		for(int i = 0; i < students_marksRows; i++)
        {
			for(int j = 0; j < students_marksColumns; j++)
			{
				students_marks[i][j] = Integer.parseInt(sc.next().trim());				
			}
        }

        String[] result = Result.calculateGrade(students_marks);
		
		for(int i = 0; i < result.length; i++)
        {
			System.out.println(result[i]);
            bufferedWriter.write(result[i]+"\n");
        }       
        bufferedWriter.close();
    }
}
