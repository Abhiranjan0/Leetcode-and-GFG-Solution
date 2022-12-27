class Solution {
    public static List<List<String>> solveNQueens(int n) {
     char[][] chess=new char[n][n];
	for(int i=0;i<n;i++) {
		for(int j=0;j<n;j++) {
			chess[i][j]='.';
		}
	}
	List<List<String>> ans=new ArrayList<>();
	NQueens(chess,ans,0);
	return ans;
		
		
	}
	public static void NQueens(char[][] chess,List<List<String>> ans,int row) {
		if(row==chess.length) {
			
			 ans.add(construct(chess));
		      return ;
		}
		
		
		for(int col=0;col<chess[0].length;col++) {
			if(isQueenSafe(chess,row,col)==true) {
			 chess[row][col]='Q';
			NQueens(chess,ans,row+1);
		    chess[row][col]='.';	}
		}
		
	}
	 public static List<String> construct(char[][] board) {
		    List<String> listBoard = new ArrayList<>();
		    for (int i = 0; i < board.length; ++i)
		      listBoard.add(String.valueOf(board[i]));
		    return listBoard;
		  }
	public static boolean isQueenSafe(char[][] chess,int row,int col) {
		//upward col
		for(int i=0;i<row;i++) {
			if(chess[i][col]=='Q') {
				return false;
			}
		}
		//Upper left
		int i=row,j=col;
		while(i>=0&&j>=0) {
			if(chess[i][j]=='Q') {
				return false;
			}
			i--;j--;
		}
		//Upper Right
		i=row;j=col;
		while(i>=0&&j<chess[0].length) {
			if(chess[i][j]=='Q') {
				return false;
			}
			i--;j++;
		}
		return true;
		
	}
}