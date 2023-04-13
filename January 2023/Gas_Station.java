class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Initialize totalGas and totalCost to 0
        int totalGas = 0, totalCost = 0;
        // Iterate through all the gas stations
        for(int i = 0 ; i<gas.length; i++){
            // Add the gas and cost at each station to the total
            totalGas += gas[i];
            totalCost += cost[i];
        }
        // If totalCost is greater than totalGas, it is not possible to complete the circuit
        if(totalGas < totalCost) return -1;
        
        // Initialize remainsGas and start to 0
        int remainsGas = 0, start = 0;
        // Iterate through all the gas stations
        for(int i = 0 ; i < gas.length; i++){
            // Add the difference between gas and cost at each station to remainsGas
            remainsGas = remainsGas +(gas[i] - cost[i]);
            // If remainsGas becomes negative, set start to the next station and reset remainsGas to 0
            if(remainsGas < 0 ){
                start = i+1;
                remainsGas = 0;
            }
        }
        // Return the starting station
        return start;
    }
}
