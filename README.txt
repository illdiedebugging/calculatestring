
 e88~-_       e      888      e88~-_  888   | 888          e      ~~~888~~~ 888~~  
d888   \     d8b     888     d888   \ 888   | 888         d8b        888    888___ 
8888        /Y88b    888     8888     888   | 888        /Y88b       888    888    
8888       /  Y88b   888     8888     888   | 888       /  Y88b      888    888    
Y888   /  /____Y88b  888     Y888   / Y88   | 888      /____Y88b     888    888    
 "88_-~  /      Y88b 888____  "88_-~   "8__/  888____ /      Y88b    888    888___

                           ,d88~~\ ~~~888~~~ 888~-_   888 888b    |  e88~~\  
                           8888       888    888   \  888 |Y88b   | d888     
                            `Y88b     888    888    | 888 | Y88b  | 8888 __  
                              `Y88b,  888    888   /  888 |  Y88b | 8888   | 
                              8888    888    888_-~   888 |   Y88b| Y888   | 
                           \__88P'    888    888 ~-_  888 |    Y888  "88__/  
                                                  
           | |__ _  _  (_| | |__| (_)___ __| |___| |__ _  _ __ _ __ _(_)_ _  __ _ 
           | '_ | || | | | | / _` | / -_/ _` / -_| '_ | || / _` / _` | | ' \/ _` |
           |_.__/\_, | |_|_|_\__,_|_\___\__,_\___|_.__/\_,_\__, \__, |_|_||_\__, |
                 |__/                                      |___/|___/       |___/ 


This is a Java library that can calculate complex mathematical expression that are in String format.
Here is an is an example of how to use it : 
	
	import com.illdiedebugging.calculatestring.*;
	.
	.
	.
		String str = null;
		try{
		str = Calculate.getResult("1-((100.5443/5+4.12333*2)+5)*√3(-100)-(10*10^2)"); 
		//Result must be -6714.767664977295
		//str = Calculate.getResult("(3.345+4.567)(2+5)"); 
		//Result must be 55.38400000000001
		}catch(UnableToCalculateException e) {
			System.out.println(e);
		}
		System.out.println(str);
This Java library is licensed under GNU General Public License v3.0. Read more on LICENSE.txt.




