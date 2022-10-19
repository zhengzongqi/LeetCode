import java.util.*;

class 广联达{
    static int[][] record = new int[10][10];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int res = 0;
        int prev = s.charAt(0)-'0';
        init();
        for(int i = 1;i<s.length();i++){
            char c = s.charAt(i);
            res+=record[prev][c-'0'];
            prev = c-'0';
        }
        char cc = s.charAt(0);
        if(cc=='0'){res+=6;}
        if(cc=='1'){res+=2;}
        if(cc=='2'){res+=5;}
        if(cc=='3'){res+=5;}
        if(cc=='4'){res+=4;}
        if(cc=='5'){res+=5;}
        if(cc=='6'){res+=6;}
        if(cc=='7'){res+=3;}
        if(cc=='8'){res+=7;}
        if(cc=='9'){res+=6;}
        System.out.println(res);
    }

    static void init(){
        record[0][0] = 0;
        record[0][1] = 4;
        record[0][2] = 3;
        record[0][3] = 3;
        record[0][4] = 4;
        record[0][5] = 3;
        record[0][6] = 2;
        record[0][7] = 3;
        record[0][8] = 1;
        record[0][9] = 2;
        record[1][0] = 4;
        record[1][1] = 0;
        record[1][2] = 5;
        record[1][3] = 3;
        record[1][4] = 2;
        record[1][5] = 5;
        record[1][6] = 6;
        record[1][7] = 1;
        record[1][8] = 5;
        record[1][9] = 4;
        record[2][0] = record[0][2];
        record[2][1] = record[1][2];
        record[2][2] = 0;
        record[2][3] = 3;
        record[2][4] = 5;
        record[2][5] = 4;
        record[2][6] = 3;
        record[2][7] = 4;
        record[2][8] = 2;
        record[2][9] = 3;
        record[3][0] = record[0][3];
        record[3][1] = record[1][3];
        record[3][2] = record[2][3];
        record[3][3] = 0;
        record[3][4] = 3;
        record[3][5] = 3;
        record[3][6] = 3;
        record[3][7] = 3;
        record[3][8] = 2;
        record[3][9] = 1;
        record[4][0] = record[0][4];
        record[4][1] = record[1][4];
        record[4][2] = record[2][4];
        record[4][3] = record[3][4];
        record[4][4] = 0;
        record[4][5] = 3;
        record[4][6] = 4;
        record[4][7] = 3;
        record[4][8] = 3;
        record[4][9] = 2;
        record[5][0] = record[0][5];
        record[5][1] = record[1][5];
        record[5][2] = record[2][5];
        record[5][3] = record[3][5];
        record[5][4] = record[4][5];
        record[5][5] = 0;
        record[5][6] = 1;
        record[5][7] = 4;
        record[5][8] = 2;
        record[5][9] = 1;
        record[6][0] = record[0][6];
        record[6][1] = record[1][6];
        record[6][2] = record[2][6];
        record[6][3] =record[3][6];
        record[6][4] = record[4][6];
        record[6][5] = record[5][6];
        record[6][6] = 0;
        record[6][7] = 5;
        record[6][8] = 1;
        record[6][9] = 2;
        record[7][0] = record[0][7];
        record[7][1] = record[1][7];
        record[7][2] = record[2][7];
        record[7][3] = record[3][7];
        record[7][4] = record[4][7];
        record[7][5] = record[5][7];
        record[7][6] = record[6][7];
        record[7][7] = 0;
        record[7][8] = 4;
        record[7][9] = 3;
        record[8][0] = record[0][8];
        record[8][1] = record[1][8];
        record[8][2] = record[2][8];
        record[8][3] = record[3][8];
        record[8][4] = record[4][8];
        record[8][5] = record[5][8];
        record[8][6] = record[6][8];
        record[8][7] = record[7][8];
        record[8][8] = 0;
        record[8][9] = 1;
        record[9][0] = record[0][9];
        record[9][1] = record[1][9];
        record[9][2] = record[2][9];
        record[9][3] = record[3][9];
        record[9][4] = record[4][9];
        record[9][5] = record[5][9];
        record[9][6] = record[6][9];
        record[9][7] = record[7][9];
        record[9][8] = record[8][9];
        record[9][9] = 0;
    }
}