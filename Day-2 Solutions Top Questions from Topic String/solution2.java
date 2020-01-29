public int myAtoi(String str) {

	long num = 0; /* used long to check out of range*/
	char sign = ' ';
	boolean foundAlready = false; /* tracks whether atleast one digit has been found by now or not */

	for(int i = 0; i < str.length(); i++){
		char c = str.charAt(i);
		if(Character.isDigit(c)) {
			if(!foundAlready) foundAlready = true;
			num = (num * 10) + (c - '0');
		}
		else {
			if(foundAlready){ /* if number already found, no need to continue */
				break;
			}
			if(sign == ' ' && c == ' '){ /* if prefixes are spaces (before any sign) then skip and continue */
				continue;
			}
			if(c == '+' || c == '-') {
			
				if(sign == ' ') { /*if sign not found yet*/
					sign = c;
				}
				else { /* if more than 1 sign occurs before the number start --> invalid */
					return 0;
				}
			}
			else { /* if any random character before number start --> invalid */
				return 0;
			}
		}
		if(num > Integer.MAX_VALUE){ /* no need to continue for out of range number */
			break;
		}
	}

	if(sign == '-') num = -num;
	if(num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
	if(num < Integer.MIN_VALUE) return Integer.MIN_VALUE;

	return (int)num;
}