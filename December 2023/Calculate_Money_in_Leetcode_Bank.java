public class Calculate_Money_in_Leetcode_Bank {
    public int totalMoney(int n) {
        int weeks = n / 7;
        int extraDays = n % 7;
        int totalMoney = 0;
        
        for (int i = 0; i < weeks; i++) {
            totalMoney += (i + 1) * 7 + 21;
        }
        
        for (int i = 0; i < extraDays; i++) {
            totalMoney += weeks + i + 1;
        }
        
        return totalMoney;
    }
}
