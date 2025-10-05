import java.util.*;

class Solution {
		int[] dx = {1,0,0,-1};
		int[] dy = {0,-1,1,0};
		String[] dl = {"d","l","r","u"};
		int K;
		int n,m,r,c;
		String answer = null;
		public String solution(int n, int m, int x, int y, int r, int c, int k) {
			this.K = k;
			this.n = n;
			this.m = m;
			this.r =r;
			this.c= c;
			dfs(x,y,new StringBuilder());

			if(answer==null)
				return "impossible";

			return answer;
		}

		private void dfs(int x, int y,StringBuilder sb) {
            			int remain = Math.abs(x-r)+Math.abs(y-c);
			if(remain>K-sb.length()) return;
            	if(remain%2!=(K-sb.length())%2) return;
			if(sb.length()==K){
				if(y==c&&x==r){
					answer = sb.toString();
				}
				return;
			}

			for(int d=0;d<4;d++){
				int ny = y + dy[d];
				int nx = x+dx[d];

				if(ny<1||ny>m||nx<1||nx>n) continue;
				sb.append(dl[d]);
				dfs(nx,ny,sb);
				if(answer!=null) break;
				sb.setLength(sb.length()-1);
			}
		}
	}