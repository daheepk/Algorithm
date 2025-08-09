import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] triangle) {

        int size = triangle.length;
        
        for (int i=size-1; i>0; i--){
            for (int j=0; j<i; j++){
                int left = triangle[i][j];
                int right = triangle[i][j+1];
                triangle[i-1][j] = triangle[i-1][j] + Math.max(left, right);
            }
        }
        return triangle[0][0];
    }
}