package lotto;

import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController controller = new LottoController();
        controller.getUserMoney();
        controller.generateUserLottoTicket();
        controller.getWinningLotto();
    }
}
