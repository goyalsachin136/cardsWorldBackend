package com.cardsGame.service.impl;

import com.cardsGame.util.CommonUtil;
import com.cardsGame.model.Player;
import com.cardsGame.repository.PlayerRepository;
import com.cardsGame.service.GamerService;
import com.cardsGame.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private GamerService gamerService;

    @Override
    public void createPlayersInGame(String gameCode, short numberOfPlayers) {
        List<Player> playerList = new ArrayList();
        for (int i = 1; i <= numberOfPlayers; i++) {
            playerList.add(Player.builder().numericCode((short) i).gameCode(gameCode).build());
        }
        this.playerRepository.saveAll(playerList);
    }

    @Override
    public List<Player> getByGameCode(String gameCode) {
        return playerRepository.findByGameCode(gameCode);
    }

    @Override
    public Player updatePlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player getByGameCodeAndNumericCode(String gameCode, short numericCode) {
        return this.playerRepository.findByGameCodeAndNumericCode(gameCode, numericCode);
    }

    @Override
    public void updatePlayers(List<Player> players) {
        if (CollectionUtils.isEmpty(players)) {
            return;
        }
        this.playerRepository.saveAll(players);
    }

    @Override
    public Player getByCode(String code) {
        return this.playerRepository.findByCode(code);
    }

    @Override
    public void removeCard(String code, short card) {
        Player player = this.playerRepository.findByCode(code);
        if (null == player) {
            throw new RuntimeException("Invalid player code");
        }
        List<Short> allCards = player.getAllCards();
        if (allCards.isEmpty()) {
            throw new RuntimeException("No cards left to move for player " + player.getNumericCode());
        }
        if (! allCards.contains(card)) {
            throw new RuntimeException("card " + CommonUtil.getDisplayStringForCard(card) +
                    " not present in deck of player " + player.getNumericCode());
        }
        allCards.remove(allCards.indexOf(card));
        player.setCardsLeftFromList(allCards);
        this.playerRepository.save(player);
    }
}
