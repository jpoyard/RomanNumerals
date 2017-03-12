package org.oxiane.roman;

/**
 * Hello world!
 *
 */
public class App 
{
	public boolean doSomething(boolean value){
        return value;
    }
	
    public static void main( String[] args )
    {
    	App myApp = new App();
        boolean success = myApp.doSomething(true);
        if (!success) {
            throw new RuntimeException("Houston, we have a problem !");
        }
    }
}
