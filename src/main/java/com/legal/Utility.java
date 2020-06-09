package com.legal;

public class Utility {
	private Utility() {
	}
	public static boolean equals(Object obj1, Object ob2)
	{
		if (obj1 == null) {
			if (ob2 != null)
				return false;
		} else if (!obj1.equals(ob2))
					return false;
		
		return true;
	}
}
