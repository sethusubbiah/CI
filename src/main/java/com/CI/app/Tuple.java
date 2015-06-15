package com.CI.app;

public class Tuple {

		String val1;
		String val2;
		
		public Tuple(String s1, String s2) {
			this.val1 = s1;
			this.val2 = s2;
		}
		
		public String getv1() { return val1; }
		public String getv2() { return val2; }
		
		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((val1 == null) ? 0 : val1.hashCode());
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Tuple other = (Tuple) obj;
			if (val1 == null) {
				if (other.val1 != null)
					return false;
			} else if (!val1.equals(other.val1))
				return false;
			return true;
		}
}
