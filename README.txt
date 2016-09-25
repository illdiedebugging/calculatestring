
 e88~-_       e      888      e88~-_  888   | 888          e      ~~~888~~~ 888~~  ,d88~~\ ~~~888~~~ 888~-_   888 888b    |  e88~~\  
d888   \     d8b     888     d888   \ 888   | 888         d8b        888    888___ 8888       888    888   \  888 |Y88b   | d888     
8888        /Y88b    888     8888     888   | 888        /Y88b       888    888    `Y88b      888    888    | 888 | Y88b  | 8888 __  
8888       /  Y88b   888     8888     888   | 888       /  Y88b      888    888     `Y88b,    888    888   /  888 |  Y88b | 8888   | 
Y888   /  /____Y88b  888     Y888   / Y88   | 888      /____Y88b     888    888       8888    888    888_-~   888 |   Y88b| Y888   | 
 "88_-~  /      Y88b 888____  "88_-~   "8__/  888____ /      Y88b    888    888___ \__88P'    888    888 ~-_  888 |    Y888  "88__/  
                                                                                                                                     

           | |__ _  _  (_| | |__| (_)___ __| |___| |__ _  _ __ _ __ _(_)_ _  __ _ 
           | '_ | || | | | | / _` | / -_/ _` / -_| '_ | || / _` / _` | | ' \/ _` |
           |_.__/\_, | |_|_|_\__,_|_\___\__,_\___|_.__/\_,_\__, \__, |_|_||_\__, |
                 |__/                                      |___/|___/       |___/ 


This is a Java library that can calculate complex mathematical expression that are in String format.
Here is an is an example of how to use it : 
	
		String str = null;
		try{
			str = Calculator.getResult("1-((100/5+4*2)+5)*3*(100)-(10*10^2)");
		}catch(UnableToCalculateException e) {
			System.out.println(e);
		}
		
		System.out.println(str);  //It will print -10899
		
This Java library is licensed under GNU General Public License v3.0. Read more on LICENSE.txt.




