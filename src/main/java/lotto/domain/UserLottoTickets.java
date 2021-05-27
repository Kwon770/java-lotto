package lotto.domain;
import java.util.ArrayList;
import java.util.List;

public class UserLottoTickets {
    private List<LottoTicket> lottoTickets = new ArrayList<>();

    public void addLottoTicket(LottoTicket lottoTicket) {
        lottoTickets.add(lottoTicket);
    }

    public UserLottoTicketsDto getDto() {
        return new UserLottoTicketsDto(lottoTickets);
    }

    public void setLottosResult(WinningLotto winningLotto) {
        for (LottoTicket ticket : lottoTickets) {
            ticket.setLottoResult(winningLotto);
        }
    }

    public Long getTotalPrice() {
        Long total = 0L;
        for (LottoTicket ticket : lottoTickets) {
            total += getLottoPrice(ticket);
        }

        return total;
    }

    private Long getLottoPrice(LottoTicket ticket) {
        if (ticket.getResult() == LottoResult.FIFTH) return LottoResult.FIFTH_LOTTO_PRICE;
        if (ticket.getResult() == LottoResult.FORTH) return LottoResult.FORTH_LOTTO_PRICE;
        if (ticket.getResult() == LottoResult.THIRD) return LottoResult.THIRD_LOTTO_PRICE;
        if (ticket.getResult() == LottoResult.SECOND) return LottoResult.SECOND_LOTTO_PRICE;
        if (ticket.getResult() == LottoResult.FIRST) return LottoResult.FIRST_LOTTO_PRICE;
        return 0L;
    }

    public int getSpecificResultCount(LottoResult result) {
        int count = 0;
        for(LottoTicket ticket : lottoTickets) {
            count += ticket.getOneIfResult(result);
        }

        return count;
    }
}