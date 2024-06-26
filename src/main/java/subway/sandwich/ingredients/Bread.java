package subway.sandwich.ingredients;

import java.util.Scanner;

public class Bread extends Ingredient {

    private static final String[] breadTypes = {"화이트", "하티", "파마산오레가노", "위트", "플랫브레드", "허니오트"};

    public Bread() {
    }

    @Override
    public void select(String type) {
        super.select(type);
    }

    public String getName() {
        return super.type;
    }

    public void selectBread() {
        System.out.println("============== KAKAOWAY ==============");
        System.out.println("=   [2]  샌드위치 빵을 선택해주세요. (1~6)  =");
        System.out.println("=                                    =");

        int i = 1;
        for (String bread : breadTypes) {
            String formattedString = String.format("%1$-25s", bread);
            System.out.println("=      " + i + ". " + formattedString + " =");
            i++;
        }
        System.out.println("======================================");

        int selectedNum;
        Scanner sc = new Scanner(System.in);

        do {
            String input = sc.nextLine().trim(); // 공백 제거

            // 입력값이 숫자가 아니라면 다시 입력받기
            if (input.isEmpty() || !input.matches("^[0-9]*$")) {
                System.out.println("============== KAKAOWAY ==============");
                System.out.println("=         ❗️ 숫자를 입력해주세요.         =");
                System.out.println("======================================");
            } else if (Integer.parseInt(input) > breadTypes.length || Integer.parseInt(input) < 1) {
                System.out.println("============== KAKAOWAY ==============");
                System.out.println("=   ❗잘못된 입력입니다. 다시 입력해주세요.   =");
                System.out.println("======================================");
            } else {
                selectedNum = Integer.parseInt(input);
                break;
            }
        }
        while (true);

        String selectedType = breadTypes[selectedNum - 1];
        this.select(selectedType);
    }
}
