package lab0;

import java.util.Arrays;

public class Var23 {

    public class My_Main {
        private int[] array;
        private int count;

        public My_Main() {
            array = new int[20];
            count = 20;
        }

        public My_Main(int size) {
            array = new int[size];
            count = 0;
        }

        public My_Main(int[] array, int count) {
            this.array = array.clone();
            this.count = count;
        }

        public int[] getArray() {
            return array.clone();
        }

        public void setArray(int[] array) {
            this.array = array.clone();
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getCount() {
            return count;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            My_Main my_main = (My_Main) o;
            return count == my_main.count &&
                    Arrays.equals(array, my_main.array);
        }







    }
    /**
     *
     * @param A is square side
     * @param B is square side
     * @param C is square side
     * @return perimeter
     */
    public int[] inputOutputTask(int A, int B, int C) {
        int[] array = new int[3];
        array[0]=C;
        array[1]=A;
        array[2]=B;
        return array;
    }

    /**
     *
     * @param k is distance in cm
     * @return distance in m
     */

    public int integerNumbersTask(int k) { return (int)((k % 3600)/60);
    }

    /**
     *
     * @param number1
     * @return true, if number is possitive
     */
    public boolean booleanTask(int number1) {
        String number;
        boolean rez = true;
        number = String.valueOf(number1);
        for(int i = 0; i < 2; i++)
        {
            if(number.charAt(i) != number.charAt(3-i))
                rez= false;
        }
        return rez;

    }


    /**
     *
     * @param P is integer number
     * @return transformed number
     */
    public int[] ifTask(int[][] P) {
        int[] array = new int[2];
        for(int j = 0; j < 2; j++)
        {

            for(int i = 0; i < 3; i++)
            {boolean flag = true;
                for(int k = 0; k < 3; k++)
                    if(i != k && P[i][j] == P[k][j])
                        flag = false;
                if(flag == true)
                    array[j] = P[i][j];

            }
        }
        return array;
    }


    /**
     *
     * @param month represents
     * @return day of week day represented number1
     */
    public String switchTask(int month) {
        switch(month){
            case 1:
            case 2:
            case 12: return "winter";

            case 3:
            case 4:
            case 5: return "spring";

            case 6:
            case 7:
            case 8: return "summer";

            case 9:
            case 10:
            case 11: return "autumn";

            default: return "error";
        }

    }


    /**
     *
     * @param n is integer number
     * @return approximated value of exp(1)
     */
    public double factorial(int n){
        assert n > 0: "Argument should be more than zero";
        double rez = 1;
        for(int i = 2; i <= n; i++)
            rez = rez * i;
        return rez;
    }
    public double forTask(int n) {
        assert n > 0: "Argument should be more than zero";
        double x = 1;
        for( int i = 2; i <= n; i++)
            x = x * i;
        x = Math.asin(x);
        double rez = x;
        for(int i = 2; i <= n; i++)
            rez=rez - Math.pow(x,i-1) * factorial(i-1) + Math.pow(x,i+1) * factorial(i+1) ;
        return rez;
    }


    public int whileTask(int a, int b) {
        assert (a >= b && b > 0): "Argument should be more than zero";
        int nsd;
        while (b != 0)
        {
            nsd = (a % b);

            a = b;
            b = nsd;
        }
        return a;
    }

    public double arrayTask(double[] array,int count, int k, int l) {
        assert (k >= 1 && l >= k && l <= count ):"Argument should be more than one and ..";
        int c = 0;
        double rez = 0;
        for(int i = 0; i < array.length ;i++)
        {
            if(i < k || i > l){
                rez = rez + array[i];
                c = c + 1;
            }
        }
        rez = rez / c ;
        return rez;
    }

    /**
     *
     * @param array
     * @param n
     * @param m
     * @return transformed array where row with indexes k1 and k2 was changed
     */
    public int[]  twoDimensionArrayTask(int[][] array, int n, int m) {
        int[] arr = new int[n];
        for(int i = 0; i < array.length; i++)
        {
            boolean c = true;
            for(int j = 0;j < array[0].length; j++)
            {
                if(c){
                    arr[i] = array[i][j];
                    c=false;
                }
                if(arr[i] > array[i][j])
                    arr[i] = array[i][j];

            }
        }
        return arr;
    }
}
