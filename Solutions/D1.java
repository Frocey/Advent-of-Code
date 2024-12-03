package Solutions;
import java.util.*;
import java.io.*;
import java.util.ArrayList;


public class D1{
    public static void main (String [] args){
        File file = new File("Puzzle");
        PriorityQueue<Integer> pq1= new PriorityQueue<>();
        PriorityQueue<Integer> pq2= new PriorityQueue<>();
        String [] parsedData = null;
        try{
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                
                String data = scan.nextLine();
                parsedData = data.split("\\s+");
                for(int i = 0; i<parsedData.length; i ++){
                    if(i%2 == 0){
                        pq1.add(Integer.parseInt(parsedData[i]));
                    }else{
                        pq2.add(Integer.parseInt(parsedData[i]));
                    }
                }   
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        System.out.println(similarityScore(pq1, pq2));
    }
    public static int totalDifference(PriorityQueue<Integer> temp1, PriorityQueue<Integer> temp2){
        int total = 0;
        while(!temp1.isEmpty()){
            total += Math.abs(temp1.remove()-temp2.remove());
        }
        return total;
    }
    public static int similarityScore(PriorityQueue<Integer> temp1, PriorityQueue<Integer> temp2){
        int score = 0;
        int numDupes= 0; 
        while(!temp1.isEmpty()){
            numDupes=0;
            int current = temp1.remove();
            for(int i : temp2){
                if(current == i){
                    numDupes += 1;
                }
            }
            score += current*numDupes;
        }
        return score;
    }
}