package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dto.GameStateDTO;
import com.example.accessingdatamysql.dto.PlayerGamePanelDTO;
import com.example.accessingdatamysql.model.Game;

public interface GamerService {

    String createGame(int numberOfPlayers, int numberOfCards);

    void setLeader(String gameCode, String playerCode);

    String enterGame(short numericCode, String gameCode, String nickName);

    void setTrump(short trump, String gameCode, String playerCode);

    void openTrump(String gameCode, String playerCode);

    void distributeCards(Integer numberOfCardsPerPlayer, String gameCode);

    void moveCard(short card, String playerCode, String gameCode);

    void chooseWinner(String adminPlayerCode, short winnerPlayerNumericCode, String gameCode);

    GameStateDTO getGameState(String gameCode, String playerCode);

    PlayerGamePanelDTO getPlayerStat(String playerCode);
}
