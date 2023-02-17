import java.io.*;
import java.util.*;

/*
Felis Sedano Luo
260897013
COMP251
a1 q1
02/12/2022
*/

public class Open_Addressing {
    public int m; // number of SLOTS AVAILABLE
    public int A; // the default random number
    int w;
    int r;
    public int[] Table;

    protected Open_Addressing(int w, int seed, int A) {

        this.w = w;
        this.r = (int) (w-1)/2 +1;
        this.m = power2(r);
        if (A==-1){
           this.A = generateRandom((int) power2(w-1), (int) power2(w),seed);
        }
       else{
           this.A = A;
       }
        this.Table = new int[m];
        for (int i =0; i<m; i++) {
            Table[i] = -1;
        }
        
    }
    
                /** Calculate 2^w*/
    public static int power2(int w) {
        return (int) Math.pow(2, w);
    }
    public static int generateRandom(int min, int max, int seed) {     
        Random generator = new Random(); 
                if(seed>=0){
                   generator.setSeed(seed);
                }
        int i = generator.nextInt(max-min-1);
        return i+min+1;
    }
       /**Implements the hash function g(k)*/
       public int probe(int key, int i) {
           //TODO: implement this function and change the return statement.
       	
       	int val; //to store result of hash function
       	int mod = power2(this.w); //steps to find the value of h(k) 
       	val = this.A * key; 
       	while (val >= mod) {
       		val = val - mod;
       	}
       	
       	val = val >> (this.w - this.r);
       	
       	//above is h(k) part, below is the g(k) part
       	
       	int nmod;
       	nmod = power2(r); //the mod used for linear mapping
       	
       	val = val + i; 
       	
       	while(val >= nmod) {
       		val = val - nmod; // find the actual location to store in linear mapping
       	} 
       		
           return val;
    }
    
    
    /**Inserts key k into hash table. Returns the number of collisions encountered*/
       public int insertKey(int key){
           //TODO : implement this and change the return statement.     	
       	int collision = 0;
       	for (int i = 0; i < this.m; i++) { //to be able to iterate the entire array
       		int location = this.probe(key, i); //find the location with each i value
       		if(this.Table[location] == -1 ) { //if the location is empty
       			this.Table[location] = key;
       			return collision; //return the value of collisions
       		}else {
       			collision++; //the location is not empty, collision + 1 and move on to the next i value
       		}
       	}
       	
       	return collision; //no spot to store key, giving up

       }
       
       /**Sequentially inserts a list of keys into the HashTable. Outputs total number of collisions */
       public int insertKeyArray (int[] keyArray){
             int collision = 0;
             for (int key: keyArray) {
                 collision += insertKey(key);
             }
             return collision;       
       }
           
        /**Inserts key k into hash table. Returns the number of collisions encountered*/
       public int removeKey(int key){
           //TODO: implement this and change the return statement
       	int collision = 0;
       	for (int i = 0; i < this.m; i++) { //to be able to iterate the entire array
       		int location = this.probe(key, i); //find the location with each i value
       		if(this.Table[location] == key ) { //if the location is empty
       			this.Table[location] = -1;
       			return collision; //return the value of collisions
       		}else {
       			collision++; //the location is not empty, collision + 1 and move on to the next i value
       		}
       	}
       	
       	return collision; //no spot to store key, giving up    
       }
    
       
       public static void main(String[] args) {

       	Open_Addressing test1 = new Open_Addressing(10,0,-1);

       	System.out.println(test1.probe(1,1));
       	
       	System.out.println(test1.insertKey(69));
       	System.out.println(test1.insertKey(89));
       	System.out.println(test1.insertKey(109));
       	System.out.println(test1.insertKey(129));
       	System.out.println(test1.removeKey(109));
       	
       }
       
       
}
