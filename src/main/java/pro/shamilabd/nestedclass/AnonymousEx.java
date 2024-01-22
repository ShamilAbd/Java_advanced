package pro.shamilabd.nestedclass;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 14.05.2023
 */
public class AnonymousEx {
    public static void main(String[] args) {
        MathActions actions = new MathActions() {
            @Override
            public int someAction(int first, int second) {
                return first + second;
            }
        };
        System.out.println(actions.someAction(5, 7));

        MathActions actions2 = new MathActions() {
            @Override
            public int someAction(int first, int second) {
                return first * second;
            }
        };
        System.out.println(actions2.someAction(5, 7));

        MathActions actions3 = new MathActions() {
            @Override
            public int someAction(int first, int second) {
                return first % second;
            }
        };
        System.out.println(actions3.someAction(5, 7));
    }
}

interface MathActions {
    int someAction(int first, int second);
}
