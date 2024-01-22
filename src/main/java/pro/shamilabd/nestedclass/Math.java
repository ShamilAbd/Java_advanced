package pro.shamilabd.nestedclass;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 14.05.2023
 */
public class Math {
    public static void getResult() {
        class Division {
            private int delimoe;
            private int delitel;

            public void setDelimoe(int delimoe) {
                this.delimoe = delimoe;
            }

            public int getDelimoe() {
                return delimoe;
            }

            public void setDelitel(int delitel) {
                this.delitel = delitel;
            }

            public int getDelitel() {
                return delitel;
            }

            public int getChastnoe() {
                return delimoe / delitel;
            }

            public int getOstatok() {
                return delimoe % delitel;
            }
        }

        Division div = new Division();
        div.setDelimoe(57);
        div.setDelitel(7);
        System.out.println(div.getDelimoe());
        System.out.println(div.getDelitel());
        System.out.println(div.getChastnoe());
        System.out.println(div.getOstatok());
    }
}

class MathTest {
    public static void main(String[] args) {
        Math.getResult();
    }
}