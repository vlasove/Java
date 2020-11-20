package task13;

public class Solution {
    public static void main(String[] args) {
        DrinkMaker latte = new LatteMaker();
        latte.makeDrink();

        DrinkMaker tea = new TeaMaker();
        tea.makeDrink();
    }
}
