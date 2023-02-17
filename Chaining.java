import java.io.*;
import java.util.*;

/*
Felis Sedano Luo
260897013
COMP251
a1 q1
02/12/2022
*/
public class Chaining {
    
     public int m; // number of SLOTS 
     public int A; // the default random number
     int w;
     int r;
     public ArrayList<ArrayList<Integer>>  Table;

    // if A==-1, then a random A is generated. else, input A is used.
    protected Chaining(int w, int seed, int A){
         this.w = w;
         this.r = (int) (w-1)/2 +1;
         this.m = power2(r);
         this.Table = new ArrayList<ArrayList<Integer>>(m);
         for (int i=0; i<m; i++) {
             Table.add(new ArrayList<Integer>());
         }
         if (A==-1){
         this.A = generateRandom((int) power2(w-1), (int) power2(w),seed);
        }
        else{
            this.A = A;
        }

     }
    /** Calculate 2^w*/
     public static int power2(int w) {
         return (int) Math.pow(2, w);
     }
     //generate a random number in a range (for A)
     public static int generateRandom(int min, int max, int seed) {     
         Random generator = new Random(); 
                 if(seed>=0){
                    generator.setSeed(seed);
                 }
         int i = generator.nextInt(max-min-1);
         return i+min+1;     
    }




    /**Implements the hash function h(k)*/
    public int chain (int key) {
        // TODO: implement this and change the return statement
    	int val; // to store result of the hash function
    	int mod = power2(this.w); //calculate what mod to use
    	val = this.A * key; 
    	while (val >= mod) { //to find out the value in that mod
    		val = val - mod;
    	}
    	
    	val = val >> (this.w - this.r);
    	
        return val;
        
    	
    }
        
    
    /**Inserts key k into hash table. Returns the number of collisions encountered*/
    public int insertKey(int key){
        //TODO: implement this and change the return statement
    	
    	int location = this.chain(key); //use chain to find where to store key
    	int collision = 0;
    	
    	this.Table.get(location).add(key); //add key to the arraylist
    	collision = this.Table.get(location).size() -1; //find out collision by finding the size of arraylist - 1(the key itself)    	
    	
        return collision;
        

    }

    
    
    /**Sequentially inserts a list of keys into the HashTable. Outputs total number of collisions */
    public int insertKeyArray (int[] keyArray){
        int collision = 0;
        for (int key: keyArray) {
            collision += insertKey(key);
        }
        return collision;
    }
    
    
    
    public static void main(String[] args) {
    	Chaining test1 = new Chaining(10,0,-1);

    	System.out.println("the location will be " + test1.chain(1));
    	System.out.println("collision of insert is " + test1.insertKey(1));

    	System.out.println("the location will be " + test1.chain(4));
    	System.out.println("collision of 4 is " + test1.insertKey(4));
    	
    	
    }
    


}import java.io.*;
import java.util.*;

/*
Felis Sedano Luo
260897013
COMP251
a1 q1
02/12/2022
*/
public class Chaining {
    
     public int m; // number of SLOTS 
     public int A; // the default random number
     int w;
     int r;
     public ArrayList<ArrayList<Integer>>  Table;

    // if A==-1, then a random A is generated. else, input A is used.
    protected Chaining(int w, int seed, int A){
         this.w = w;
         this.r = (int) (w-1)/2 +1;
         this.m = power2(r);
         this.Table = new ArrayList<ArrayList<Integer>>(m);
         for (int i=0; i<m; i++) {
             Table.add(new ArrayList<Integer>());
         }
         if (A==-1){
         this.A = generateRandom((int) power2(w-1), (int) power2(w),seed);
        }
        else{
            this.A = A;
        }

     }
    /** Calculate 2^w*/
     public static int power2(int w) {
         return (int) Math.pow(2, w);
     }
     //generate a random number in a range (for A)
     public static int generateRandom(int min, int max, int seed) {     
         Random generator = new Random(); 
                 if(seed>=0){
                    generator.setSeed(seed);
                 }
         int i = generator.nextInt(max-min-1);
         return i+min+1;     
    }




    /**Implements the hash function h(k)*/
    public int chain (int key) {
        // TODO: implement this and change the return statement
    	int val; // to store result of the hash function
    	int mod = power2(this.w); //calculate what mod to use
    	val = this.A * key; 
    	while (val >= mod) { //to find out the value in that mod
    		val = val - mod;
    	}
    	
    	val = val >> (this.w - this.r);
    	
        return val;
        
    	
    }
        
    
    /**Inserts key k into hash table. Returns the number of collisions encountered*/
    public int insertKey(int key){
        //TODO: implement this and change the return statement
    	
    	int location = this.chain(key); //use chain to find where to store key
    	int collision = 0;
    	
    	this.Table.get(location).add(key); //add key to the arraylist
    	collision = this.Table.get(location).size() -1; //find out collision by finding the size of arraylist - 1(the key itself)    	
    	
        return collision;
        

    }

    
    
    /**Sequentially inserts a list of keys into the HashTable. Outputs total number of collisions */
    public int insertKeyArray (int[] keyArray){
        int collision = 0;
        for (int key: keyArray) {
            collision += insertKey(key);
        }
        return collision;
    }
    
    
    
    public static void main(String[] args) {
    	Chaining test1 = new Chaining(10,0,-1);

    	System.out.println("the location will be " + test1.chain(1));
    	System.out.println("collision of insert is " + test1.insertKey(1));

    	System.out.println("the location will be " + test1.chain(4));
    	System.out.println("collision of 4 is " + test1.insertKey(4));
    	
    	
    }
    


}
