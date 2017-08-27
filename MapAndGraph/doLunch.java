package enSoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class doLunch{

	HashMap<String, List<String>> map; 
	List<String> avoid;
	List<String> peggy;
	List<String> sam;
	List<String> result;
	SortedSet<String> res;
	
	//constructor
	public doLunch(){
		map = new HashMap<String, List<String>>();
		avoid = new LinkedList<String>();
		peggy = new LinkedList<String>();	
		sam = new LinkedList<String>();	
		res = new TreeSet<String>();
	}
	//function to print list of meeting nodes
	public void printResult(){	
		Iterator<String> itr = res.iterator();
		System.out.println("Output:");
		while(itr.hasNext()){
			System.out.println((String)itr.next());
		}
	}
	
	//function to evaluate meeting nodes
	public void getMeetingNodes(){		
		Iterator<String> itr = peggy.iterator();
		String end = null;
		String start = null;
		int loopCount = 0;
		while(itr.hasNext()){
			start = (String)itr.next();
			Iterator<String> itr1 = sam.iterator();
			while(itr1.hasNext())
			{
				end = (String)itr1.next();
				List<String> temp = new LinkedList<String>();
				if(getMeetingNodesUtil(start,start,end,temp,loopCount)){
					Iterator<String> itr2 = temp.iterator();
					while(itr2.hasNext()){
						res.add((String) itr2.next());
					}
				}
			}
		}
	}
	
	//helper function for the evaluation of the meeting nodes. 
	public boolean getMeetingNodesUtil(String start_node, String start, String end, List<String> temp, int loopCount){
		//return false if starting location of either Peggy or Sam should be avoided
		if(avoid.contains(start) || avoid.contains(end)){
			return false;
		}	
		//return false if there is a loop i.e. we have reached the same location from where Peggy started without meeting Sam
		else if(start.equals(start_node) && loopCount>0){
			return false;
		}
		//return true if a location is available for Peggy and Sam to meet.
		else if(start.equals(end)){
			temp.add(start);
			return true;
		}
		
		else{
			if(map.containsKey(start)){	
				temp.add(start);
				List<String> list = new LinkedList<String>();					
				list =  map.get(start); 
				Iterator<String> itr = list.iterator();
				while(itr.hasNext()){
					String next = (String)itr.next();
					if(getMeetingNodesUtil(start_node,next,end,temp,loopCount+1))
						return true;
				}
				temp.remove(start);
			}
		}
		return false;			
	}
	
	public static void main(String[] args) {
		doLunch lunch = new doLunch();
		System.out.println("Enter the Input:");		
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		
		//Get values from the standard input using buffered reader.
		//enclosed in a try-catch to guard against bad input.
		try {
			while ((line = stdin.readLine()) != null) {
				if(line.equals("Map:")){
					line = stdin.readLine();
				    while(!(line.equals("Avoid:"))){
						String[] token = line.split(" ");
						List<String> nodelist = new LinkedList<String>();
						if(lunch.map.containsKey(token[0])){
							nodelist = lunch.map.get(token[0]);					
						}
						nodelist.add(token[1]);
						lunch.map.put(token[0], nodelist);
						line = stdin.readLine();;
					}
				}
				if(line.equals("Avoid:")){
					line = stdin.readLine();
					String[] token = line.split(" ");
					for(int i=0;i<token.length;i++){
						lunch.avoid.add(token[i]);
					}
					line = stdin.readLine();
				}
				if(line.equals("Peggy:")){
					line = stdin.readLine();
					String[] token = line.split(" ");
					for(int i=0;i<token.length;i++){
						lunch.peggy.add(token[i]);
					}
					line = stdin.readLine();
				}
				if(line.equals("Sam:")){
					line = stdin.readLine();
					String[] token = line.split(" ");
					for(int i=0;i<token.length;i++){
						lunch.sam.add(token[i]);
					}
				}
			    break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		lunch.getMeetingNodes();
		lunch.printResult();				
	}

}
