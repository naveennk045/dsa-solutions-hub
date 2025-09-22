package arrays.problems;


public class MaximumPopulationYear {

    public static int count(int[][] logs, int year,int ind){
        int count=0;
        for (int i=0; i < logs.length; i++) {
            int birth=logs[i][0];
            int death=logs[i][1];
            if (year>=birth && year<death){
                count++;
            }
        }
        return count;
    }
    public static int maximumPopulation(int[][] logs) {
        int max=-1;
        int maxYear=-1;
        for (int i = 0; i <logs.length ; i++) {
            for (int j = 0; j < logs[i].length; j++) {
                int year=logs[i][j];
                int count=count(logs,year,i);
                if(count>=max){
                    max=count;
                    maxYear=year;
                }
                System.out.println(year+" "+count);
            }

        }
        return maxYear;
    }

    public static void main(String[] args) {
        int[][] logs={
                {2033,2034},{2039,2047},{1998,2042},{2047,2048},{2025,2029},{2005,2044},{1990,1992},{1952,1956},{1984,2014}
        };
        int year=maximumPopulation(logs);
        System.out.println(year);
    }
}