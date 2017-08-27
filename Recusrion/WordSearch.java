//Given a 2D board and a word, find if the word exists in the grid.
class Solution {
    public boolean exist(char[][] board, String word) {
        int nRow = board.length;
        int nCol = board[0].length;
        boolean[][] visited = new boolean[nRow][nCol];
        for(int i=0;i<nRow;i++){
            for(int j=0;j<nCol;j++){
                if(exist(board, i, j, visited, 0, word, nRow, nCol)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean exist(char[][] board, int i, int j, boolean[][] visited, int pos, String word, int nRow, int nCol){
        boolean res = false;
        if(board[i][j]==word.charAt(pos)){
            visited[i][j]=true;
            if(pos+1==word.length())
                return true;
            if(i+1<nRow && visited[i+1][j]==false && res==false){
                res = exist(board, i+1, j, visited, pos+1, word, nRow, nCol);
            }
            if(j+1<nCol && visited[i][j+1]==false && res==false){
                res = exist(board, i, j+1, visited, pos+1, word, nRow, nCol);
            }
            if(i-1>=0 && visited[i-1][j]==false && res==false){
                res = exist(board, i-1, j, visited, pos+1, word, nRow, nCol);
            }
            if(j-1>=0 && visited[i][j-1]==false && res==false){
                res = exist(board, i, j-1, visited, pos+1, word, nRow, nCol);
            }
            
            visited[i][j]=false;
        }
        return res;
    }
}
