package sii.maroc;

public class Vehicles {
	
	private int diesel;
	private int fuel;
	private int hybrid;

	public Vehicles(String string) {
		// TODO Auto-generated constructor stub
        String[] arrOfStr = string.split(",", 5); 
        String[] res = new String[3];
        
        if (arrOfStr.length == 3) {
        	int k=0;
	        for (String a : arrOfStr) {
	        	System.out.println(a);
	            String[] arr = a.split(":", 5); 
	            System.out.println(arr[0]);
	            
	            res[k] = arr[1].substring(0,1);
	            k++;
	        }
	    this.diesel = Integer.parseInt(res[0]);
	    this.fuel = Integer.parseInt(res[1]);
	    this.hybrid = Integer.parseInt(res[2]);
	}}
	
	public int[] doors(String str) {
        String[] arr = str.split(" ", 5); 
        int[] doors = new int[4];
        int k = 0;
        for (String s : arr) {
        	doors[k] = Integer.parseInt(s);
        	k++;
        }
        
        return doors;

		
	}
	
	public int[] missing_doors(int[] doors) {
		int[] car = {1,2,3,4};
		int[] missing = new int[4];
		int k = 0;
		
		for (int i=0; i<4 ; i++) {
			int nb = 0;

			for(int j=0; j<doors.length; j++) {
				if(car[i] == doors[j])
					nb++;
			}
			if(nb == 0) {
				missing[k] = car[i];
				k++;
			}
				
			
		}
		
		return missing;
	}
	
	public boolean search(int value, int[] tab) {
		for(int i=0; i< tab.length; i++) {
			if(tab[i] == value)
				return true;
		}
		return false;
	}
	
	public String generate_patterns(int[] missing_doors) {
		String frontRight;
		String frontLeft;
		String backRight;
		String backLeft;
		if (this.search(1, missing_doors) == true)
			frontLeft = "/";
		else
			frontLeft = "|";
		if (this.search(2, missing_doors) == true)
			frontRight = "\\";
		else
			frontRight = "|";
		if (this.search(3, missing_doors) == true)
			backLeft = "/";
		else
			backLeft = "|";
		if (this.search(4, missing_doors) == true)
			backRight = "\\";
		else
			backRight = "|";
		String res = "  _\n"+
                " "+ frontLeft + " " + frontRight + "\n"+
                " "+ backLeft + "_" + backRight;
		return res;
	}
	
	public String move(String arg1, String arg2, String arg3, String arg4) {
		int[] doors = this.doors(arg3);
		if(arg1.toLowerCase().equals("car") && doors.length != 4) {
			int[] missing_doors = this.missing_doors(doors);
			String report = "DOORS KO, BLOCKED \n" + this.generate_patterns(missing_doors);
			return report;
		}
		int type = 0;
		switch(arg2.toLowerCase()) {
		case "diesel":
			type = this.getDiesel();
			break;
		case "fuel":
			type = this.getFuel();
			break;
		case "hybrid":
			type = this.getHybrid();
		}
		String[] nm = arg4.split(" ",3);
		double con = Integer.parseInt(nm[0])*type/100;
		String report = "DOORS OK, MOVING. The " + arg1 + " will consume " + String.format("%.2d", con) + " L";
		System.out.println(report);
		
		return report;
		
	}
	
	public int getDiesel() {
		return this.diesel;
	}
	
	public int getFuel() {
		return this.fuel;
	}
	
	public int getHybrid() {
		return this.hybrid;
	}
	
	public void setDiesel(int diesel) {
		this.diesel = diesel;
	}
	
	public void setFuel(int fuel) {
		this.fuel = fuel;
	}
	
	public void setHybrid(int hybrid) {
		this.hybrid = hybrid;
	}

}
