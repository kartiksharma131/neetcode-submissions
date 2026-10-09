class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowStart =0;
        int colStart =0;
        int rowEnd = matrix.length-1;
        int colEnd = matrix[0].length-1;
        List<Integer> ans = new ArrayList<>();
        while(rowStart<=rowEnd && colStart<=colEnd){
            for(int i=colStart;i<=colEnd;i++){
                ans.add(matrix[rowStart][i]);
            }

            for(int i = rowStart+1;i<=rowEnd;i++){
                ans.add(matrix[i][colEnd]);
            }

            for(int i = colEnd-1;i>=colStart;i--){
                if(rowStart==rowEnd){
                    break;
                }
                ans.add(matrix[rowEnd][i]);
            }

            for(int i=rowEnd-1;i>=rowStart+1;i--){
                if(colStart==colEnd){
                    break;
                }
                ans.add(matrix[i][colStart]);
            }
            rowStart++;
            colStart++;
            rowEnd--;
            colEnd--;
        }
        return ans;
    }
}
