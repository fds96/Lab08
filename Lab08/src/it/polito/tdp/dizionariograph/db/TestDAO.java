package it.polito.tdp.dizionariograph.db;

public class TestDAO {
	
	public static void main(String[] args) {
		
		WordDAO wd = new WordDAO();
		
		System.out.println(wd.getAllWordsFixedLength(4).size());
		System.out.println(wd.getAllWordsFixedLength(10).size());
		System.out.println(wd.getAllWordsFixedLength(3).size());
		System.out.println(wd.getAllWordsFixedLength(15).size());
	}

}
