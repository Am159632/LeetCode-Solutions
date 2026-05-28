class Solution {
    public int[][] kClosest(int[][] points, int k) {
       PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0]*b[0]+b[1]*b[1],a[0]*a[0]+a[1]*a[1]));
       for(int i=0;i<points.length;i++){
            maxHeap.offer(new int[]{points[i][0],points[i][1]});
            if(maxHeap.size()>k) maxHeap.poll();
       }
       int[][]res=new int[maxHeap.size()][2];
       for(int i=0;i<res.length;i++){
            int[]a=maxHeap.poll();
            res[i][0]=a[0]; res[i][1]=a[1];
       }
       return res;
    }
}