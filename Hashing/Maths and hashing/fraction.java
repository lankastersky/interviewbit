/*
Fraction

Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

Example :

Given numerator = 1, denominator = 2, return "0.5"
Given numerator = 2, denominator = 1, return "2"
Given numerator = 2, denominator = 3, return "0.(6)"

https://www.interviewbit.com/problems/fraction/
*/

    public class Solution {
        
        // assertEquals("-0.5", solution.fractionToDecimal(-1, 2));
        // assertEquals("-0.5", solution.fractionToDecimal(1, -2));
        // assertEquals("0.5", solution.fractionToDecimal(-1, -2));
        // assertEquals("0.5", solution.fractionToDecimal(1, 2));
        // assertEquals("1", solution.fractionToDecimal(2, 2));
        // assertEquals("-2147483647", solution.fractionToDecimal(2147483647, -1));
        // assertEquals("2147483648", solution.fractionToDecimal(-2147483648, -1));
        // assertEquals("1", solution.fractionToDecimal(-2147483648, -2147483648));
        // assertEquals("0.000(000000465661289042462740251655654056577585848337359161441621040707904997124914069194026549138227660723878669455195477065427143370461252966751355553982241280310754777158628319049732085502639731402098131932683780538602845887105337854867197032523144157689601770377165713821223802198558308923834223016478952081795603341592860749337303449725)",
        //         solution.fractionToDecimal(1, 2147483640));
        // assertEquals("0.0000000004656612873077392578125", solution.fractionToDecimal(-1, -2147483648));
        // assertEquals("-0.0000000004656612873077392578125", solution.fractionToDecimal(1, -2147483648));
        // assertEquals("", solution.fractionToDecimal(1, 2147483647)); // invalid input
        // assertEquals("0.(6)", solution.fractionToDecimal(2, 3));
        // assertEquals("0.8", solution.fractionToDecimal(16, 20));
        // assertEquals("10.(3)", solution.fractionToDecimal(31, 3));
        // assertEquals("0.(09)", solution.fractionToDecimal(1, 11));
        // assertEquals("2.(27)", solution.fractionToDecimal(50, 22));
        // assertEquals("0.0(45)", solution.fractionToDecimal(1, 22));
        // assertEquals("5.8(144)", solution.fractionToDecimal(3227, 555));
        
        public String fractionToDecimal(int A, int B) {
            long a = A;
            long b = B;
            if (a % b == 0) {
                return String.valueOf(a / b);
            }
            // fractional part
            StringBuilder builder = new StringBuilder();
            if ((a > 0 && b < 0) || (a < 0 && b > 0)) {
                builder.append("-");
            }
            a=Math.abs(a);
            b=Math.abs(b);            
            builder.append(String.valueOf(a / b));
            builder.append(".");
            Map<Long, Integer> map = new HashMap<>();
            a = (a % b) * 10;
            while (!map.containsKey(a)) {
                map.put(a, builder.length());
                long val = a / b;
                builder.append(String.valueOf(val));
                a = (a % b) * 10;
                if(a==0) return builder.toString();
            }
            if (a != 0) {
                // repeating part detected
                int r = map.get(a);
                builder = builder.insert(r, "(").append(")");
            }
            return builder.toString();
        }

    }
