class Solution {
    class Pair{
        int pos;
        int speed;
        public Pair(int pos, int speed){
            this.pos = pos;
            this.speed = speed;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        List<Pair> cars = new ArrayList<>();
        for(int i=0;i<position.length;i++){
            cars.add(new Pair(position[i],speed[i]));
        }
        Collections.sort(cars,(a,b)->a.pos-b.pos);

        double [] timeTakenToreachTarget =new double[position.length];
        for(int i=0;i<cars.size();i++){
            Pair car = cars.get(i);
            int currPosition = car.pos;
            int currSpeed = car.speed;
            timeTakenToreachTarget[i] = (double)(target-currPosition)/currSpeed;
             
        }

        Stack<Double> fleetStack = new Stack<>();
        for(int i=timeTakenToreachTarget.length-1;i>=0;i--){
            if(fleetStack.isEmpty()){
                fleetStack.push(timeTakenToreachTarget[i]);
            }
            else if(fleetStack.peek()>=timeTakenToreachTarget[i]){
                continue;
            }
            else{
                fleetStack.push(timeTakenToreachTarget[i]);
            }
        }
        return fleetStack.size();
    }
}

// 10

// 6,3,1,8
// 8,5,2,9
// 10,7,3,10

// (10 - 4)/2 =3
// (9)/2 =5;
// (10-0)/1 =10;
// (10-3)/1=3

// 3,5,10,3