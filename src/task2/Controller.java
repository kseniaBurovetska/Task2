package task2;

import java.util.Arrays;
import java.util.Scanner;

public class Controller {

    private View view;
    private Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    /**
     * Starts initial game
     */
    public void startGame() {
        Scanner sc = new Scanner(System.in);

        setCustomRange(sc);
        model.setTargetValue(model.generateValue());

        while (model.checkForTarget(validateValueWithRange(sc))) ;

        view.printMessage(View.WON_STRING + model.getTargetValue());
        view.printMessage(View.TRIES_STRING + model.getTries());
    }

    /**
     * Validates value.
     * Check if value is int.
     * Check if value is in range.
     *
     * @param sc
     * @return
     */
    public int validateValueWithRange(Scanner sc) {
        int res;
        view.printMessage(View.INPUT_STRING);
        view.printRange(model.getRangeLow(), model.getRangeTop());

        while (true) {
            /* validate number */
            while (!sc.hasNextInt()) {
                view.printMessage(View.WRONG_INPUT_STRING + View.INPUT_STRING);
                view.printRange(model.getRangeLow(), model.getRangeTop());
                sc.next();
            }

            /* check range */
            res = sc.nextInt();
            if ((res <= model.getRangeLow()) || (res >= model.getRangeTop())) {
                view.printMessage(View.WRONG_RANGE_STRING + View.INPUT_STRING);
                view.printRange(model.getRangeLow(), model.getRangeTop());
                continue;
            }
            break;
        }

        return res;
    }


    /**
     * Set user range. If q - quit
     * @param scanner
     */
    private void setCustomRange(Scanner scanner) {
        String res = "";
        view.printMessage(View.INPUT_RANGE+ View.EXIT_STRING);

        while (!(scanner.hasNext() && (res = scanner.nextLine()).matches(Consts.REGEX_RANGE))) {
            if (res.equals("q")) {
                model.setRange(Consts.RANGE_LOW, Consts.RANGE_TOP);
                return;
            }
            view.printMessage(View.WRONG_INPUT_STRING + View.INPUT_RANGE);
        }

        int[] r = Arrays.stream(res.split(";"))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (r[0] > r[1]) {
            model.setRange(r[1], r[0]);
        } else {
            model.setRange(r[0], r[1]);
        }

    }

}
