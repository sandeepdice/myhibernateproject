package batch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import standalone.beans.Category;
import standalone.dao.CategoryDao;

public class BatchCategory {
	public void basicTestCategory(CategoryDao categoryDao)
	{
        int rowsAffected = categoryDao.addCategory(101, "testCategory2", "testCategory2");
        System.out.println("records inserted: " + rowsAffected);
        Category result = categoryDao.getCategory(101, "testCategory2");
        System.out.println("Retrieved value: " + result.getCategoryId());        
        rowsAffected = categoryDao.deleteCategory(101);
        System.out.println("records deleted: " + rowsAffected);
	}
	public void batchTestCategory(CategoryDao categoryDao)
	{
		/**
		 * Batch delete
		 */
		categoryDao.deleteAll();
		Scanner scanner = null;
		
		File fFile = new File("C:\\Documents and Settings\\Lenovo User\\workspace\\myhibernateproject\\resources\\category.data");
		try {
			scanner = new Scanner(fFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
	        //first use a Scanner to get each line
	        while ( scanner.hasNextLine() ){
	          processLine( scanner.nextLine() );
	        }
	      }
	      finally {
	        //ensure the underlying stream is always closed
	        scanner.close();
	      }


	}
}
