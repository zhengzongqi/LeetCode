package 回溯法;

public class T37 {


    public void solveSudoku(char[][] board) {
        backTrack(0,0,board);
    }

    boolean findans = false;   //记录是否找到答案
    //先每一行每一个位置依次地尝试填入数字，当前行填完后，转到下一行（x+1）；
    public void backTrack(int x,int y,char[][] board){
        //如果x=9,说明board已经填完了（上一个填的是board[8][8]）
        if(x==9){
            findans = true;
            return;
        }
        //y=9说明当前行填完了，于是跳到下一行的第一个位置
        if(y==9){
            backTrack(x+1,0,board);
            return;
        }
        //不等于'.'说明当前位置已经有默认数字了，跳过这一个位置
        if(board[x][y]!='.'){
            backTrack(x,y+1,board);
            return;
        }
        //试一下当前所有可以填入的值
        for(char i = '1' ; i<= '9';i++){
            //isVaild判断当前位置能否填入i
            if(isVaild(x,y,i,board)){
                board[x][y] = i;
                backTrack(x,y+1,board);
                //如果找到答案了就不需要撤回成'.'，保持board当前的状态走完回溯就好
                if(findans==true){}
                else{board[x][y] = '.';}
            }
        }
    }


    public boolean isVaild(int x,int y,char num,char[][] board_){
        for(int i = 0 ; i < 9;i++){
            if(board_[x][i]==num){
                return false;
            }
            if(board_[i][y]==num){
                return false;
            }
            if(board_[(x/3)*3+i%3][(y/3)*3+i/3]==num){
                return false;
            }
        }

        return true;
    }

}
