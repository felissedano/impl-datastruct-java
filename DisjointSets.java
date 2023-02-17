import java.io.*;
import java.util.*;


/****************************
*
* COMP251 template file
*
* Assignment 1, Question 2
*
*Felis Sedano Luo
*260897013
*02/12/2022
*
*****************************/


public class DisjointSets {

    private int[] par;
    private int[] rank;

    /* contructor: creates a partition of n elements. */
    /* Each element is in a separate disjoint set */
    DisjointSets(int n) {
        if (n>0) {
            par = new int[n];
            rank = new int[n];
            for (int i=0; i<this.par.length; i++) {
                par[i] = i;
            }
        }
    }

    public String toString(){
        int pari,countsets=0;
        String output = "";
        String[] setstrings = new String[this.par.length];
        /* build string for each set */
        for (int i=0; i<this.par.length; i++) {
            pari = find(i);
            if (setstrings[pari]==null) {
                setstrings[pari] = String.valueOf(i);
                countsets+=1;
            } else {
                setstrings[pari] += "," + i;
            }
        }
        /* print strings */
        output = countsets + " set(s):\n";
        for (int i=0; i<this.par.length; i++) {
            if (setstrings[i] != null) {
                output += i + " : " + setstrings[i] + "\n";
            }
        }
        return output;
    }

    /* find resentative of element i */
    public int find(int i) {

        /* Fill this method (The statement return 0 is here only to compile) */ 
    	
    	int root;
    	
    	if(par[i] == i) {  		// if not in root
    		return i; 		//recursion until root
    	}else {    		
    		root = find(par[i]); //recursion until finding the root
    		par[i] = root;  //path optimization by assigning all leaves parent to root
    		return root;
    	}


    }

    /* merge sets containing elements i and j */
    public int union(int i, int j) {

        /* Fill this method (The statement return 0 is here only to compile) */
    	
    	int iRoot = this.find(i);
    	
    	int jRoot = this.find(j);
    	
    	int uRoot;
    	
    	
    	
    	if(iRoot != jRoot) {   //if not the same tree
    		
    	//	System.out.println("root is diffenrent");
    		
    		//compare rank of roots and decide what to do
    		if(this.rank[iRoot] < this.rank[jRoot]) {
    			par[iRoot] = jRoot;
    			uRoot = jRoot;  //the new root
    		}else if(this.rank[iRoot] == this.rank[jRoot]) {
    			
    	//		System.out.println("root rank the same");
    			this.rank[jRoot] = this.rank[jRoot] + 1; //if rank is the same increase the rank of jRoot
    			par[iRoot] = jRoot;
    	//		System.out.println("the root of index2 is" + this.par[i]);
    			uRoot = jRoot;
    	//		System.out.println("the rank of 3 is" + rank[3]);
    		}else {
    			par[jRoot] = iRoot;
    			uRoot = iRoot;
    		}
    		
    	//	System.out.println("index 2 par is" + this.par[2] + " 0 is" + par[0]);
    		return uRoot;
    	}
    	
    	uRoot = iRoot;
    	
    	

    	
        return uRoot;

    }

    public static void main(String[] args) {

        DisjointSets myset = new DisjointSets(6);
    //    System.out.println(myset.rank[0]); //
        System.out.println(myset);
        System.out.println("-> Union 2 and 3");
        myset.union(2,3);
        System.out.println(myset);
        System.out.println("-> Union 2 and 3");
        myset.union(2,3);
        System.out.println(myset);
        System.out.println("-> Union 2 and 1");
        myset.union(2,1);
        System.out.println(myset);
        System.out.println("-> Union 4 and 5");
        myset.union(4,5);
        System.out.println(myset);
        System.out.println("-> Union 3 and 1");
        myset.union(3,1);
        System.out.println(myset);
        System.out.println("-> Union 2 and 4");
        myset.union(2,4);
        System.out.println(myset);

    }

}

