package Solutions;
import java.util.*;
import java.io.*;


public class D2{
    public static void main(String [] args){
        File file = new File("D2-Puzzle");
        ArrayList<ArrayList<Integer>> data = new ArrayList<>();
        try{
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                
                String [] splitData = scan.nextLine().split("\\s+");
                ArrayList<Integer> parsedData = new ArrayList<>();
                for(String part: splitData){
                    parsedData.add(Integer.parseInt(part));
                }
                data.add(parsedData);
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        System.out.println("number of safe reports: " + safetyCheck(data));
    }
    public static int safetyCheck(ArrayList<ArrayList<Integer>> temp){
        int numSafe = 0;
        for(ArrayList<Integer> currentList: temp){
            boolean safe = isInitialSafe(currentList);
            if(safe){
                numSafe++;
                continue;
            }
            for(int i = 0; i<currentList.size(); i++){
                ArrayList<Integer> modifiedList = new ArrayList<>();
                modifiedList.addAll(currentList);
                modifiedList.remove(i);
                if(isInitialSafe(modifiedList)){
                    numSafe++;
                    break;
                }
            }  
            
        }
        return numSafe;
    }
    public static boolean isInitialSafe(ArrayList<Integer> temp){
        boolean increasingOrDecreasing = false;
        boolean correctIntervals = true;
        int numIncreases = 0;
        int numDecreases = 0;
        for(int i = 0; i<temp.size()-1; i++){
        int diff = Math.abs(temp.get(i) - temp.get(i + 1));
            if(temp.get(i)<temp.get(i+1)){
                numDecreases ++;
            }else if(temp.get(i)> temp.get(i+1)){
                numIncreases ++;
            }
            if (diff < 1 || diff > 3) {
                correctIntervals = false;
            }
        }
        if(numIncreases == temp.size()-1 || numDecreases == temp.size()-1){
            increasingOrDecreasing = true;
        }
        return (increasingOrDecreasing&&correctIntervals);
    }
}