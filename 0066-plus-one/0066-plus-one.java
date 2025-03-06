class Solution {
    public int[] plusOne(int[] digits) {
        int remainder = 1;
		int lastDigit = digits[digits.length-1];
		if (lastDigit+1<10) {
			digits[digits.length-1] = lastDigit+1;
			return digits;
		}
		
		digits[digits.length-1] = lastDigit+1-10;
		for (int i = digits.length-2; i >= 0; i--) {
			if (digits[i]+1>=10) {
				digits[i] = digits[i]+remainder-10;
			} else {
				digits[i] = digits[i]+remainder;
				remainder = 0;
				break;
			}
		}
		
		if (remainder==1) {
			int[] newDigits = new int[digits.length+1];
			newDigits[0]=remainder;
			for (int i = 0; i < digits.length; i++) {
				newDigits[i+1] = digits[i];
			}
			return newDigits;
			
		}
		
		return digits;  }
        }
    
