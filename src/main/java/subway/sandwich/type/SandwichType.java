package subway.sandwich.type;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class SandwichType {

    static LinkedHashMap<String, Integer> sandwich15cm = new LinkedHashMap<>() {{
        put("에그마요", 5500);
        put("햄", 5800);
        put("참치", 5800);
        put("BLT", 6600);
        put("이탈리안 BMT", 6700);
        put("베지", 4900);
        put("로티세리 바비큐 치킨", 7300);
        put("로스트 치킨", 7300);
        put("스테이크 & 치즈", 8300);
        put("치킨 데리야끼", 7300);
        put("써브웨이 클럽", 7100);
        put("폴드포크 바비큐", 7200);
        put("치킨 베이컨 아보카도", 7900);
        put("쉬림프", 7600);
        put("K-바비큐", 7300);
        put("스파이시 쉬림프", 7900);
        put("스파이시 이탈리안", 6900);
    }};
    static LinkedHashMap<String, Integer> sandwich30cm = new LinkedHashMap<>() {{
        put("에그마요", 10400);
        put("햄", 10900);
        put("참치", 10900);
        put("BLT", 12200);
        put("이탈리안 BMT", 12400);
        put("베지", 9100);
        put("로티세리 바비큐 치킨", 13500);
        put("로스트 치킨", 13500);
        put("스테이크 & 치즈", 14700);
        put("치킨 데리야끼", 12900);
        put("써브웨이 클럽", 13100);
        put("폴드포크 바비큐", 13300);
        put("치킨 베이컨 아보카도", 14700);
        put("쉬림프", 14100);
        put("K-바비큐", 13500);
        put("스파이시 쉬림프", 14700);
        put("스파이시 이탈리안", 12700);
    }};

    private String type;
    private int price;
    private String size;

    public SandwichType() {
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public String getSize() {
        return size;
    }

    public void selectSize() {
        Scanner sc = new Scanner(System.in);

        System.out.println("============== KAKAOWAY ==============");
        System.out.println("=     샌드위치 크기를 선택해주세요. (1/2)   =");
        System.out.println("=                                    =");
        System.out.println("=          1. 15cm 샌드위치            =");
        System.out.println("=          2. 30cm 샌드위치            =");
        System.out.println("======================================");

        do {
            String input = sc.nextLine().trim(); // 공백 제거

            // 입력값이 숫자가 아니라면 다시 입력받기
            if (input.isEmpty() || !input.matches("^[0-9]*$")) {
                System.out.println("============== KAKAOWAY ==============");
                System.out.println("=         ❗️ 숫자를 입력해주세요.         =");
                System.out.println("======================================");
                continue;
            }

            if (input.equals("1")) {
                this.size = "15cm";
                selectType(sandwich15cm);
                break;
            } else if (input.equals("2")) {
                this.size = "30cm";
                selectType(sandwich30cm);
                break;
            } else {
                System.out.println("============== KAKAOWAY ==============");
                System.out.println("=   ❗️ 잘못된 입력입니다. 다시 입력해주세요.  =");
                System.out.println("======================================");
            }
        } while (true);
    }

    public void selectType(LinkedHashMap<String, Integer> sandwichSize) {
        System.out.println("============== KAKAOWAY ==============");
        System.out.println("=     [1]  샌드위치 종류를 선택해주세요.     =");
        System.out.println("=                                    =");

        int i = 1;
        for (String type : sandwichSize.keySet()) {
            String formattedString = String.format("%1$-25s",
                type + " (" + sandwichSize.get(type) + "원)");
            System.out.println("=   " + i + ". " + formattedString + " =");
            i++;
        }
        System.out.println("======================================");

        int selectedNum = 0;
        Scanner sc = new Scanner(System.in);

        do {
            String input = sc.nextLine().trim(); // 공백 제거

            // 입력값이 숫자가 아니라면 다시 입력받기
            if (input.isEmpty() || !input.matches("^[0-9]*$")) {
                System.out.println("============== KAKAOWAY ==============");
                System.out.println("=         ❗️ 숫자를 입력해주세요.         =");
                System.out.println("======================================");
            } else if (Integer.parseInt(input) > sandwichSize.size()
                || Integer.parseInt(input) < 1) {
                System.out.println("============== KAKAOWAY ==============");
                System.out.println("=   ❗️ 잘못된 입력입니다. 다시 입력해주세요.  =");
                System.out.println("======================================");
            } else {
                selectedNum = Integer.parseInt(input);
                break;
            }
        }
        while (true);

        this.type = sandwichSize.keySet().toArray()[selectedNum - 1].toString();
        this.price = sandwichSize.get(this.type);
    }
}
