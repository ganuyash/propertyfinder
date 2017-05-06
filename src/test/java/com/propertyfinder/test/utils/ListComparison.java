package com.propertyfinder.test.utils;

import java.util.Collection;
import java.util.HashSet;

public class ListComparison {

	
	public static boolean ArraysEquals(Collection<String> listOne, Collection<String> listTwo) {
		
		Collection<String> similar = new HashSet<String>( listOne );
        Collection<String> different = new HashSet<String>();
        System.out.println(listOne);
        System.out.println(listTwo);
        
        different.addAll( listOne );
        different.addAll( listTwo );

        similar.retainAll( listTwo );
        different.removeAll( similar );
		
        System.out.println(different + " ");
		return different.size()==0;
	}
	
	
	public static void main(String[] args) {
		
//		Collection<String> similar = new HashSet<String>( );
//		Collection<String> different = new HashSet<String>();
//		similar.add("Ä");
//		similar.add("B");
//		similar.add("B");
//		similar.add("D");
//		similar.add("E");
//		
//		different.add("Ä");
//		different.add("B");
//		different.add("B");
//		different.add("D");
//		different.add("E");
		
		
		
	}
	
}
