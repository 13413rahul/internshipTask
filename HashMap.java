import java.util.*;

// it is not clear which value is search in hashMap
// so i am assuming user enter key and on the basis of the value we search key is in the map or not 

class HashMap1 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
    
           //creating hashmap
           Map<String, Integer> map = new HashMap<>();
           
           System.out.print("enter no of record you want to enter: ");
           int noOfRecord = 0;
           try {
                noOfRecord = sc.nextInt();
           } catch(InputMismatchException e) {
               System.out.println(e);
               return;
           }
           
           System.out.println("please Enter key as String and value as Integer and for stop inputing enter stop: ");
           System.out.println("key   value");
    
           while(noOfRecord-- > 0) {
               String key = "";
               int value = 0;
               try {
                   key = sc.next();
                   value = sc.nextInt();
               }catch(InputMismatchException ex) {
                   System.out.println("please enter key as String and value as integer");
                   noOfRecord++;
                   continue;
               }
    
               map.put(key, value);
           }
    
           if(map.isEmpty()) {
               System.out.println("please enter some pair key and value");
               return ;
           }
           
           System.out.println("\nplease enter key for search in hashMap");
           //searching logic
           while(sc.hasNext()) {
               
               String enterKey = "";
               try {
                   enterKey = sc.next();
               }catch(InputMismatchException ex) {
                   System.out.println("please enter key as String\n");
                   continue;
               }
               searchKey(map, enterKey);
               System.out.println("\nplease enter key for search in hashMap");
           }
    
       }
       
       static void searchKey(Map<String, Integer> map, String enterKey) {
           //searching key present or not
           if(map.containsKey(enterKey)) {
                   System.out.println("key : " + enterKey + " value : " + map.get(enterKey));
           }else {
                   System.out.println("key not present in hashMap");
           }
       }
}