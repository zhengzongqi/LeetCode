package BFS;

import java.util.*;

public class T2045 {

    //这道题求最短路径可以先忽略红绿灯带来的影响
    //因为所有的边花费一样，因此对于两条不同的路径D1 D2，只要两条边A1i，A2i在D1 D2中的序号相同，那它们的花销也相同
    //所以可以先直接求1到n最短和次短需要经过几条边,再根据边数计算时间花销
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<Integer>[] graph = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        // path[i][0] 表示从 1 到 i 的最短路长度，path[i][1] 表示从 1 到 i 的严格次短路长度
        int[][] path = new int[n + 1][2];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(path[i], Integer.MAX_VALUE);
        }
        path[1][0] = 0;
        //queue中的int[],[0]代表当前的节点，[1]代表走到当前节点已经经过的边数
        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{1, 0});
        while (path[n][1] == Integer.MAX_VALUE) {
            int[] arr = queue.poll();
            int cur = arr[0], len = arr[1];
            for (int next : graph[cur]) {
                if (len + 1 < path[next][0]) {
                    path[next][0] = len + 1;
                    queue.offer(new int[]{next, len + 1});
                } else if (len + 1 > path[next][0] && len + 1 < path[next][1]) {
                    path[next][1] = len + 1;
                    queue.offer(new int[]{next, len + 1});
                }
            }
        }

        int ret = 0;
        for (int i = 0; i < path[n][1]; i++) {
            if (ret % (2 * change) >= change) {
                ret = ret + (2 * change - ret % (2 * change));
            }
            ret = ret + time;
        }
        return ret;
    }




    static int N = 10010, M = 4 * N, INF = 0x3f3f3f3f, idx = 0;

    static int[] he = new int[N], e = new int[M], ne = new int[M];
    //dist1记录最短路径，dist2记录次短路径
    static int[] dist1 = new int[N], dist2 = new int[N];
    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx;
        idx++;
    }
    public int secondMinimum1(int n, int[][] edges, int time, int change) {
        Arrays.fill(dist1, INF);
        Arrays.fill(dist2, INF);
        Arrays.fill(he, -1);
        idx = 0;
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            add(u, v); add(v, u);
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[1]-b[1]);
        q.add(new int[]{1, 0});
        dist1[1] = 0;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int u = poll[0], step = poll[1];
            for (int i = he[u]; i != -1; i = ne[i]) {
                int j = e[i];
                int a = step / change, b = step % change;
                int wait = a % 2 == 0 ? 0 : change - b;
                int dist = step + time + wait;
                if (dist1[j] > dist) {
                    dist2[j] = dist1[j];
                    dist1[j] = dist;
                    q.add(new int[]{j, dist1[j]});
                    q.add(new int[]{j, dist2[j]});
                } else if (dist1[j] < dist && dist < dist2[j]) {
                    dist2[j] = dist;
                    q.add(new int[]{j, dist2[j]});
                }
            }
        }
        return dist2[n];
    }
}
