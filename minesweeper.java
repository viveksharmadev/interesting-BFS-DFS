// https://leetcode.com/problems/minesweeper/
class minesweeper {
    // tc -> m*n, sc-> m*n
    public char[][] updateBoard(char[][] board, int[] click) {
        //Base conditions
        if(board==null || board.length==0 || click==null || click.length==0) return board;
        if(board[click[0]][click[1]]=='M'){
            board[click[0]][click[1]] = 'X';
            return board;
        }
        
        int m = board.length, n = board[0].length;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,1},{1,-1},{-1,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(click);
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currX = curr[0];
            int currY = curr[1];
            int count = 0;
            for(int[] dir : dirs){
                int x = currX + dir[0];
                int y = currY + dir[1];
                if(x<0 || x>m-1 || y<0 || y>n-1) continue;
                if(board[x][y]=='M') count++;
            }
            if(count > 0){
                board[currX][currY] = (char)(count+'0');
            }else{
                board[currX][currY] = 'B';
                for(int[] dir : dirs){
                    int x = currX + dir[0];
                    int y = currY + dir[1];
                    if(x<0 || x>m-1 || y<0 || y>n-1) continue;
                    if(board[x][y] == 'E'){
                        board[x][y] = 'B';
                        q.offer(new int[]{x,y});
                    }
                }
            }
        }
        return board;
    }
}
