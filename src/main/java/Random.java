public class Random {

    public static String getRandomNumber(int lenghtOfNumber) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lenghtOfNumber; i++) {
            sb.append(String.valueOf((int) (Math.random() * 10)));
        }

        return sb.toString();
    }

    public static String getRandomUserEmail() {
        return "myEmail" + getRandomNumber(10) + "@gmail.com";
    }

    public static void main(String[] args) {
        String ran = getRandomUserEmail();
        System.out.println(ran);
    }
}