package lab0;

import org.testng.annotations.DataProvider;

import static org.testng.Assert.assertEquals;

public class Variant23Test {
    @org.testng.annotations.Test(dataProvider = "inputProvider")
    public void testInputOutputTask(int A,int B,int C, int[] expected) {
        assertEquals(new Var23().inputOutputTask(A, B, C), expected);
    }
    @DataProvider
    public Object[][] inputProvider() {
        return new Object[][] {{2, 3, 1, new int[]{1,2,3}},{5, 1, 8, new int[]{8, 5, 1}}};
    }


    @org.testng.annotations.Test(dataProvider = "integerProvider")
    public void testIntegerNumbersTask(int k, int expected) {
        assertEquals(new Var23().integerNumbersTask(k),expected);
    }
    @DataProvider
    public Object[][] integerProvider(){
        return new Object[][] {{60,1},{3720,2}};
    }

    @org.testng.annotations.Test(dataProvider = "boolProvider")
    public void testBooleanTask(int number1 ,boolean expected ) {
        assertEquals(new Var23().booleanTask(number1),expected);
    }
    @DataProvider
    public Object[][] boolProvider(){
        return new Object[][]{{2552,true},{5156,false}};
    }

    @org.testng.annotations.Test(dataProvider = "ifProvider")
    public void testIfTask(int[][] P, int[] expected) {
        assertEquals(new Var23().ifTask(P),expected);
    }
    @DataProvider
    public Object[][] ifProvider(){
        int[][] input1={
                {2,5},
                {2,1},
                {7,5}

        };
        int[][] input2={
                {10,1},
                {3,8},
                {10,8}
        };
        return new Object[][]{{input1,new int[]{7,1}},{input2,new int[]{3,1}}};
    }

    @org.testng.annotations.Test(dataProvider = "switchProvider")
    public void testSwitchTask(int month, String expected) {
        assertEquals(new Var23().switchTask(month),expected);
    }
    @DataProvider
    public Object[][] switchProvider(){
        return new Object[][]{{11,"autumn"},{13,"error"}};
    }


    @org.testng.annotations.Test(dataProvider ="forProvider")
    public void testForTask(int n, double expected) {
        assertEquals(new Var23().forTask(n), expected);
    }
    @DataProvider
    public Object[][] forProvider(){
        return new Object[][]{};
    }
    @org.testng.annotations.Test(dataProvider = "whileProvider")
    public void testWhileTask(int a, int b, int expected) {
        assertEquals(new Var23().whileTask(a,b), expected);
    }
    @DataProvider
    public Object[][] whileProvider(){
        return new Object[][]{{36,12,12},{48,36,12},{105,25,5}};
    }
    @org.testng.annotations.Test(dataProvider = "arrayProvider")
    public void testArrayTask(double[] array,int count, int k, int l,double expected) {
        assertEquals(new Var23().arrayTask(array,count,k,l),expected);
    }
    @DataProvider
    public Object[][] arrayProvider(){
        double[] input = {2,5,7,4,3,1,3};
        double[] input2 = {1,1,1,1,1,1,1,1,1,1};
        return new Object[][]{{input,7,2,4,2.75},{input2,10,1,9,1}};
    }

    @org.testng.annotations.Test(dataProvider = "twoProvider")
    public void testTwoDimensionArrayTask(int[][] array, int n, int m,int[] expected) {
        assertEquals(new Var23().twoDimensionArrayTask(array,n,m),expected);
    }
    @DataProvider
    public Object[][] twoProvider(){
        int[][] input=
                {
                        {3,1,6,7},
                        {6,9,6,8},
                        {7,5,1,7},
                };
        int[][] input2=
                {
                        {5,0,3,6,2},
                        {10,63,136,64,64},
                        {11,65,87,34,76},
                        {-3,-6,-75,63,1},
                        {6,8,2,78,9}
                };
        return new Object[][]{{input,3,4,new int[]{1,6,1}},{input2,5,5,new int[]{0,10,11,-75,2}}};
    }
}
