package hashtable;
import java.util.*;

public class P149_MaxPointsonaLine {

	public static void main(String[] args) {

		String str = "40,-23),(9,138),(429,115),(50,-17),(-3,80),(-10,33),(5,-21),(-3,80),(-6,-65),(-18,26),(-6,-65),(5,72),(0,77),(-9,86),(10,-2),(-8,85),(21,130),(18,-6),(-18,26),(-1,-15),(10,-2),(8,69),(-4,63),(0,3),(-4,40),(-7,84),(-8,7),(30,154),(16,-5),(6,90),(18,-6),(5,77),(-4,77),(7,-13),(-1,-45),(16,-5),(-9,86),(-16,11),(-7,84),(1,76),(3,77),(10,67),(1,-37),(-10,-81),(4,-11),(-20,13),(-10,77),(6,-17),(-27,2),(-10,-81),(10,-1),(-9,1),(-8,43),(2,2),(2,-21),(3,82),(8,-1),(10,-1),(-9,1),(-12,42),(16,-5),(-5,-61),(20,-7),(9,-35),(10,6),(12,106),(5,-21),(-5,82),(6,71),(-15,34),(-10,87),(-14,-12),(12,106),(-5,82),(-46,-45),(-4,63),(16,-5),(4,1),(-3,-53),(0,-17),(9,98),(-18,26),(-9,86),(2,77),(-2,-49),(1,76),(-3,-38),(-8,7),(-17,-37),(5,72),(10,-37),(-4,-57),(-3,-53),(3,74),(-3,-11),(-8,7),(1,88),(-12,42),(1,-37),(2,77),(-6,77),(5,72),(-4,-57),(-18,-33),(-12,42),(-9,86),(2,77),(-8,77),(-3,77),(9,-42),(16,41),(-29,-37),(0,-41),(-21,18),(-27,-34),(0,77),(3,74),(-7,-69),(-21,18),(27,146),(-20,13),(21,130),(-6,-65),(14,-4),(0,3),(9,-5),(6,-29),(-2,73),(-1,-15),(1,76),(-4,77),(6,-29";
		String[] s = str.split("\\),\\(");
		
		Point[] p = new Point[s.length];
		for(int i=0;i<p.length;i++) 
			p[i] = new Point(Integer.parseInt(s[i].split(",")[0]), Integer.parseInt(s[i].split(",")[1]));
		
		/*
		p[0] = new Point(0,0);
		p[1] = new Point(1,0);
		p[2] = new Point(0,1);
		p[3] = new Point(1,1);
		p[4] = new Point(6,6);
		*/
		
		System.out.println(maxPoints(p));
	}
	
	static class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
    }

    public static int maxPoints(Point[] points) {
    	int max = 0;
        int VK = 999999; //default k of vertical lines
        Map<String, Integer> numList = new HashMap<String, Integer>();
        Map<String, Set<String>> kbList = new HashMap<String, Set<String>>();
        
        for(int i=0;i<points.length;i++) {
            String p = points[i].x+","+points[i].y;
            if(numList.containsKey(p)) numList.put(p, numList.get(p)+1);
            else numList.put(p, 1);
            
            if(numList.get(p)>max)
            	max = numList.get(p);
        }
        
        //debug
        System.out.println(numList);
        
        for(int i=0;i<points.length;i++) {
            for(int j=i+1;j<points.length;j++) {
                int x1 = points[i].x, y1 = points[i].y;
                int x2 = points[j].x, y2 = points[j].y;
                int dx = x1 - x2, dy = y1 - y2; //k=dy/dx, b=(y1*dx-x1*dy)/dx
                int bTop = y1*dx - x1*dy;
                
                if(dx == 0 && dy == 0) continue;
                
                String kb = VK + "," + x1;
                if(dx != 0) {
                    double k = dy * 1.0 / dx;
                    double b = bTop * 1.0 / dx;
                    
                    String sk = "", sb = "";
                    if(k<0) sk = "-";
                    if(b<0) sb = "-";
                    
                    dx = Math.abs(dx);
                    dy = Math.abs(dy);
                    bTop = Math.abs(bTop);
                    
                    int f1 = gcd(dy, dx);
                    sk += dy/f1 + "/" + dx/f1;
                    
                    int f2 = gcd(bTop, dx);
                    sb += bTop/f2 + "/" + dx/f2;
                    
                    kb = sk + "," + sb;
                }
                
                if(kbList.containsKey(kb)) {
                    kbList.get(kb).add(x1+","+y1);
                    kbList.get(kb).add(x2+","+y2);
                } else {
                	Set<String> set = new HashSet<String>();
                	set.add(x1+","+y1);
                	set.add(x2+","+y2);
                    kbList.put(kb, set);
                }
            }
        }
        
        //debug
        System.out.println(kbList);
        
        for(String key : kbList.keySet()) {
        	Set<String> set = kbList.get(key);
        	int tmpMax = set.size();
        	for(String k : set) {
        		tmpMax += (numList.get(k) - 1);
        	}
        	if(tmpMax > max) {System.out.println(key+":"+tmpMax);max = tmpMax;}
        }
        return max;
    }
    
    public static int gcd(int x,int y) {
    	int r = 1, a = x, b = y;
    	while(r!=0){
    		r = a % b;
    		a = b;
    		b = r;
    	}
    	return a;
   }
}
