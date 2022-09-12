class SnakeGame {
    LinkedList<int[]> snake;
    LinkedList<int[]> foodItems;
    int[] snakeHead;
    int height, width;
    
    public SnakeGame(int width, int height, int[][] food) {
        snake = new LinkedList<>();
        foodItems = new LinkedList<>(Arrays.asList(food));
        snakeHead = new int[]{0,0};
        this.height = height;
        this.width = width;
        snake.add(snakeHead);
        
    }
    
    public int move(String direction) {
        if(direction.equals("U")){
            snakeHead[0]--;
        }
        else if(direction.equals("D")){
            snakeHead[0]++;
        }
        else if(direction.equals("L")){
            snakeHead[1]--;
        }
        else if(direction.equals("R")){
            snakeHead[1]++;
        }
        if(snakeHead[0] <0 || snakeHead[0] == height || snakeHead[1]<0 || snakeHead[1]==width)
            return -1;
        for(int i = 1; i<snake.size(); i++){
            int[] curr = snake.get(i);
            if(snakeHead[0] == curr[0] && snakeHead[1] == curr[1])
                return -1;
        }
        if(foodItems.size()>0){
            int[] food = foodItems.peek();
            if(snakeHead[0] == food[0] && snakeHead[1] == food[1]){
                snake.add(new int[] {snakeHead[0], snakeHead[1]});
                foodItems.remove();
                return snake.size()-1;
            }
        }
        snake.add(new int[] {snakeHead[0], snakeHead[1]});
        snake.remove();
        return snake.size()-1;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */