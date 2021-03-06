package com.cardsGame.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum  CardType {
    HEART((short) 0), DIAMOND((short) 1), SPADE((short) 2), CLUB((short) 3);
    private short cardIndex;

    public static CardType getFromIndex(short index) {
        return Arrays.stream(CardType.values()).filter(cardType -> index == cardType.getCardIndex()).findFirst().orElse(null);
    }
}
